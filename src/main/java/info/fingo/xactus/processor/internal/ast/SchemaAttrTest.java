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
 *     Mukul Gandhi - bug 280798 - PsychoPath support for JDK 1.4
 *******************************************************************************/

package info.fingo.xactus.processor.internal.ast;

import info.fingo.xactus.api.ResultSequence;
import info.fingo.xactus.api.StaticContext;
import info.fingo.xactus.processor.internal.types.*;

/**
 * Support for Schema Attribute test.
 */
public class SchemaAttrTest extends KindTest {
	
	private final QName arg;

	/**
	 * Constructor for SchemaAttrTest.
	 *
	 * @param arg
	 *            QName argument.
	 */
	public SchemaAttrTest(QName arg) {
		this.arg = arg;
	}

	/**
	 * Support for QName interface.
	 *
	 * @return Result of QName operation.
	 */
	public QName arg() {
		return arg;
	}

	@Override
	public AnyType createTestType(ResultSequence rs, StaticContext sc) {
		// TODO review
		return null;
	}

	@Override
	public QName name() {
		return arg;
	}

	@Override
	public boolean isWild() {
		return false;
	}

	@Override
	public Class<AnyType> getXDMClassType() {
		// TODO review
		return null;
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
