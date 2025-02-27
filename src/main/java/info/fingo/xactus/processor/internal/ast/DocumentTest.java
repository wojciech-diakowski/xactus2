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
 *     David Carver - bug 298535 - Attribute instance of improvements
 *     Mukul Gandhi - bug 280798 - PsychoPath support for JDK 1.4
 *******************************************************************************/

package info.fingo.xactus.processor.internal.ast;

import info.fingo.xactus.api.ResultSequence;
import info.fingo.xactus.api.StaticContext;
import info.fingo.xactus.processor.internal.types.AnyType;
import info.fingo.xactus.processor.internal.types.DocType;
import info.fingo.xactus.processor.internal.types.QName;

/**
 * Class for Document testing.
 */
public class DocumentTest extends KindTest {
	/**
	 * Set internal value for NONE.
	 */
	public static final int NONE = 0;
	/**
	 * Set internal value for ELEMENT.
	 */
	public static final int ELEMENT = 1;
	/**
	 * Set internal value for SCHEMA_ELEMENT.
	 */
	public static final int SCHEMA_ELEMENT = 2;

	// XXX: polymorphism
	private int _type;

	private AttrElemTest _etest;
	private SchemaElemTest _schema_etest;

	/**
	 * Constructor for DocumentTest.
	 *
	 * @param type
	 *            Type of element to test.
	 * @param arg
	 *            xpath object to test.
	 */
	public DocumentTest(int type, Object arg) {
		_etest = null;
		_schema_etest = null;

		_type = type;
		switch (_type) {
		case ELEMENT:
			_etest = (AttrElemTest) arg;
			break;
		case SCHEMA_ELEMENT:
			_schema_etest = (SchemaElemTest) arg;
			break;
		}
	}

	/**
	 * Default Constructor for DocumentTest.
	 */
	public DocumentTest() {
		this(NONE, null);
	}

	/**
	 * Get test type.
	 *
	 * @return Type of test.
	 */
	public int type() {
		return _type;
	}

	/**
	 * Element test.
	 *
	 * @return Element test.
	 */
	public AttrElemTest elem_test() {
		return _etest;
	}

	/**
	 * Schema element test.
	 *
	 * @return Schema element test.
	 */
	public SchemaElemTest schema_elem_test() {
		return _schema_etest;
	}

	@Override
	public AnyType createTestType(ResultSequence rs, StaticContext sc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWild() {
		return false;
	}

	@Override
	public Class<DocType> getXDMClassType() {
		return DocType.class;
	}

	/**
	 * Support for Visitor interface.
	 *
	 * @return Result of Visitor operation.
	 */
	@Override
	public Object accept(XPathVisitor v) {
		return v.visit(this);
	}

}
