/*******************************************************************************
 * Copyright (c) 2005, 2011 Andrea Bittau, University College London, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Andrea Bittau - initial API and implementation from the PsychoPath XPath 2.0
 *     Mukul Gandhi - bug 273719 - String Length does not work with Element arg.
 *     Mukul Gandhi - bug 273795 - improvements to function, substring (implemented
 *                                 numeric type promotion).
 *     Jesper Steen Moeller - bug 285145 - implement full arity checking
 *     Jesper Steen Moeller - bug 281159 - implement xs:anyUri -> xs:string promotion
 *     Jesper Steen Moller  - bug 281938 - undefined context should raise error
 *     Jesper Steen Moller  - bug 340933 - Migrate to new XPath2 API
 *******************************************************************************/

package info.fingo.xactus.processor.internal.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import info.fingo.xactus.api.EvaluationContext;
import info.fingo.xactus.api.Item;
import info.fingo.xactus.api.ResultBuffer;
import info.fingo.xactus.api.ResultSequence;
import info.fingo.xactus.api.typesystem.TypeDefinition;
import info.fingo.xactus.processor.DynamicError;
import info.fingo.xactus.processor.internal.SeqType;
import info.fingo.xactus.processor.internal.types.AnyAtomicType;
import info.fingo.xactus.processor.internal.types.AnyType;
import info.fingo.xactus.processor.internal.types.NumericType;
import info.fingo.xactus.processor.internal.types.QName;
import info.fingo.xactus.processor.internal.types.XSAnyURI;
import info.fingo.xactus.processor.internal.types.XSDouble;
import info.fingo.xactus.processor.internal.types.XSString;
import info.fingo.xactus.processor.internal.types.XSUntypedAtomic;
import info.fingo.xactus.processor.internal.types.builtin.BuiltinTypeLibrary;

/**
 * Support for functions.
 */
public abstract class Function implements info.fingo.xactus.api.Function {

	protected static final DatatypeFactory _datatypeFactory;
	static {
		try {
			_datatypeFactory = DatatypeFactory.newInstance();
		}
		catch (DatatypeConfigurationException e) {
			throw new RuntimeException("Cannot initialize XML datatypes", e);
		}
	}

	protected final QName name;
	/**
	 * if negative, need to have "at least"
	 */
	protected final int min_arity;

	/**
	 * If "at least", this speci, unlimited if -1
	 */
	protected final int max_arity;

	/**
	 * Constructor for Function.
	 *
	 * @param name
	 *            QName.
	 * @param arity
	 *            the arity of a specific function.
	 */
	public Function(QName name, int arity) {
		
		this.name = name;
		if (arity < 0) {
			throw new RuntimeException("We want to avoid this!");
		}
		this.min_arity = arity;
		this.max_arity = arity;
	}

	/**
	 * Constructor for Function.
	 *
	 * @param name
	 *            QName.
	 * @param arity
	 *            the arity of a specific function.
	 */
	public Function(QName name, int min_arity, int max_arity) {
		
		this.name = name;
		if (min_arity < 0 || max_arity < 0 || max_arity < min_arity) {
			throw new RuntimeException("We want to avoid this!");
		}
		this.min_arity = min_arity;
		this.max_arity = max_arity;
	}

	/**
	 * Support for QName interface.
	 *
	 * @return Result of QName operation.
	 */
	public QName name() {
		return name;
	}

	/**
	 * Minimal number of allowed arguments.
	 *
	 * @return The smallest number of erguments possible
	 */
	public int min_arity() {
		return min_arity;
	}

	/**
	 * Maximum number of allowed arguments.
	 *
	 * @return The highest number of erguments possible
	 */
	public int max_arity() {
		return max_arity;
	}

	/**
	 * Checks if this function has an to the
	 *
	 * @param actual_arity
	 * @return
	 */
	public boolean matches_arity(int actual_arity) {
		if (actual_arity < min_arity()) return false;
		if (actual_arity > max_arity()) return false;
		return true;
	}

	/**
	 * Default constructor for signature.
	 *
	 * @return Signature.
	 */
	public String signature() {
		return signature(this);
	}

	/**
	 * Obtain the function name and arity from signature.
	 *
	 * @param f
	 *            current function.
	 * @return Signature.
	 */
	public static String signature(Function f) {
		return signature(f.name(), f.is_vararg() ? -1 : f.min_arity());
	}

	/**
	 * Apply the name and arity to signature.
	 *
	 * @param name
	 *            QName.
	 * @param arity
	 *            arity of the function.
	 * @return Signature.
	 */
	public static String signature(QName name, int arity) {
		String n = name.expanded_name();
		if (n == null)
			return null;

		n += "_";

		if (arity < 0)
			n += "x";
		else
			n += arity;

		return n;
	}

	/**
	 * Evaluate arguments.
	 *
	 * @param args
	 *            argument expressions.
	 * @throws DynamicError
	 *             Dynamic error.
	 * @return Result of evaluation.
	 */
	public ResultSequence evaluate( Collection args )
			throws DynamicError {
		throw new UnsupportedOperationException();
	}

	// convert argument according to section 3.1.5 of xpath 2.0 spec
	/**
	 * Convert the input argument according to section 3.1.5 of specification.
	 *
	 * @param arg
	 *            input argument.
	 * @param expected
	 *            Expected Sequence type.
	 * @throws DynamicError
	 *             Dynamic error.
	 * @return Converted argument.
	 */
	public static info.fingo.xactus.api.ResultSequence convert_argument(info.fingo.xactus.api.ResultSequence arg,
                                                                        SeqType expected) throws DynamicError {
		ResultBuffer result = new ResultBuffer();

		// XXX: Should use type_class instead and use item.getClass().isAssignableTo(expected.type_class())
		AnyType expected_type = expected.type();

		// expected is atomic
		if (expected_type instanceof AnyAtomicType) {
			AnyAtomicType expected_aat = (AnyAtomicType) expected_type;

			// atomize
			info.fingo.xactus.api.ResultSequence rs = FnData.atomize(arg);

			// cast untyped to expected type
			for (Item i : rs) {
				AnyType item = (AnyType) i;

				if (item instanceof XSUntypedAtomic) {
					// create a new item of the expected
					// type initialized with from the string
					// value of the item
					info.fingo.xactus.api.ResultSequence converted = null;
					if (expected_aat instanceof XSString) {
					   XSString strType = new XSString(item.getStringValue());
						converted = strType;
					}
					else {
						converted = item;
					}

					result.concat(converted);
				}
				// xs:anyURI promotion to xs:string
				else if (item instanceof XSAnyURI && expected_aat instanceof XSString) {
					result.add(new XSString(item.getStringValue()));
				}
				// numeric type promotion
				else if (item instanceof NumericType) {
					if (expected_aat instanceof XSDouble) {
					  XSDouble doubleType = new XSDouble(item.getStringValue());
					  result.add(doubleType);
					}
					else {
					  result.add(item);
					}
				} else {
					result.add(item);
				}
			}
			// do sequence type matching on converted arguments
			return expected.match(result.getSequence());
		} else {
			// do sequence type matching on converted arguments
			return expected.match(arg);
		}
	}

	// convert arguments
	// returns collection of arguments
	/**
	 * Convert arguments.
	 *
	 * @param args
	 *            input arguments.
	 * @param expected
	 *            expected arguments.
	 * @throws DynamicError
	 *             Dynamic error.
	 * @return Converted arguments.
	 */
	public static Collection convert_arguments(Collection args, Collection expected) throws DynamicError {
		
		Collection result = new ArrayList();

		assert args.size() <= expected.size();

		Iterator argi = args.iterator();
		Iterator expi = expected.iterator();

		// convert all arguments
		while (argi.hasNext()) {
			result.add(convert_argument((info.fingo.xactus.api.ResultSequence) argi.next(),
					(SeqType) expi.next()));
		}

		return result;
	}

	protected static info.fingo.xactus.api.ResultSequence getResultSetForArityZero(EvaluationContext ec )
			throws DynamicError {
		
		Item contextItem = ec.getContextItem();
		if (contextItem != null) {
		  // if context item is defined, then that is the default argument
		  // to fn:string function
			return new XSString( contextItem.getStringValue() );
		} else {
			throw DynamicError.contextUndefined();
		}
	}

	public boolean is_vararg() {
		return min_arity != max_arity;
	}

	@Override
	public String getName() {
		return name().local();
	}

	@Override
	public int getMinArity() {
		return min_arity();
	}

	@Override
	public int getMaxArity() {
		return max_arity();
	}

	@Override
	public boolean isVariableArgument() {
		return is_vararg();
	}

	@Override
	public boolean canMatchArity(int actualArity) {
		return matches_arity(actualArity);
	}

	@Override
	public TypeDefinition getResultType() {
		return BuiltinTypeLibrary.XS_UNTYPED;
	}

	@Override
	public TypeDefinition getArgumentType(int index) {
		return BuiltinTypeLibrary.XS_UNTYPED;
	}

	@Override
	public String getArgumentNameHint(int index) {
		return "argument_"  + index;
	}

	public TypeDefinition computeReturnType(Collection args, info.fingo.xactus.api.StaticContext sc) {
		return BuiltinTypeLibrary.XS_UNTYPED;
	}

	@Override
	public info.fingo.xactus.api.ResultSequence evaluate(Collection<ResultSequence> args,
                                                         EvaluationContext evaluationContext) {

		ResultSequence result = evaluate( args );
		return result;
	}

}
