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

package org.eclipse.wst.xml.xpath2.processor.ast;

/**
 * Path expression walks tries to walk the path specified in its argument
 */
public class XPathExpr extends Expr {
	private int _slashes;
	private StepExpr _expr;

	// single linked list
	private XPathExpr _next;

	/**
	 * @param slashes
	 *            is copied to _slashes
	 * @param expr
	 *            is copied to _expr _next is made null as a result.
	 */
	public XPathExpr(int slashes, StepExpr expr) {
		_slashes = slashes;
		_expr = expr;
		_next = null;
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

	/**
	 * Add to tail of path
	 */
	// XXX: keep ref to last
	public void add_tail(int slashes, StepExpr expr) {
		XPathExpr last = this;
		XPathExpr next = _next;

		while (next != null) {
			last = next;
			next = last.next();
		}

		XPathExpr item = new XPathExpr(slashes, expr);
		last.set_next(item);

	}

	/**
	 * @param count
	 *            is copied to _slashes
	 */
	public void set_slashes(int count) {
		_slashes = count;
	}

	/**
	 * @return XPath expression _next
	 */
	public XPathExpr next() {
		return _next;
	}

	/**
	 * an XPath expression, n is copied to _next
	 */
	public void set_next(XPathExpr n) {
		_next = n;
	}

	/**
	 * @return Step expression _expr
	 */
	public StepExpr expr() {
		return _expr;
	}

	/**
	 * @return int _slashes
	 */
	public int slashes() {
		return _slashes;
	}

}
