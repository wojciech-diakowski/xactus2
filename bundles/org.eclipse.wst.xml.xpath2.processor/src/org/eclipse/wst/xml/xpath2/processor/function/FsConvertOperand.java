/*******************************************************************************
 * Copyright (c) 2005, 2009 Andrea Bittau and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andrea Bittau - initial API and implementation
 *******************************************************************************/

package org.eclipse.wst.xml.xpath2.processor.function;

import org.eclipse.wst.xml.xpath2.processor.*;
import org.eclipse.wst.xml.xpath2.processor.types.*;

import java.util.*;

/**
 * Function to convert a sequence of items to a sequence of atomic values.
 */
public class FsConvertOperand extends Function {

	public FsConvertOperand() {
		super(new QName("convert-operand"), 2);
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
	@Override
	public ResultSequence evaluate(Collection args) throws DynamicError {
		return convert_operand(args);
	}

	/**
	 * Convert-Operand operation.
	 * 
	 * @param args
	 *            Result from the expressions evaluation.
	 * @throws DynamicError
	 *             Dynamic error.
	 * @return Result of fs: operation.
	 */
	public static ResultSequence convert_operand(Collection args)
			throws DynamicError {

		assert args.size() == 2;

		Iterator iter = args.iterator();

		ResultSequence actual = (ResultSequence) iter.next();
		ResultSequence expected = (ResultSequence) iter.next();

		if (expected.size() != 1)
			DynamicError.throw_type_error();

		AnyType at = expected.first();

		if (!(at instanceof AnyAtomicType))
			DynamicError.throw_type_error();

		AnyAtomicType exp_aat = (AnyAtomicType) at;

		ResultSequence result = ResultSequenceFactory.create_new();

		// 1
		if (actual.empty())
			return result;

		// convert sequence
		for (Iterator i = actual.iterator(); i.hasNext();) {
			AnyType item = (AnyType) i.next();

			// 2
			if (item instanceof UntypedAtomic) {
				// a
				if (exp_aat instanceof UntypedAtomic)
					result.add(new XSString(item.string_value()));
				// b
				else if (exp_aat instanceof NumericType)
					result.add(new XSDouble(item.string_value()));
				// c
				else {
					assert exp_aat instanceof CtrType;

					CtrType cons = (CtrType) exp_aat;

					ResultSequence tmp = ResultSequenceFactory
							.create_new(new XSString(item.string_value()));

					ResultSequence converted = cons.constructor(tmp);
					result.concat(converted);

					tmp.release();
				}
			}
			// 4
			else
				result.add(item);

		}

		return result;
	}
}
