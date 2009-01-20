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

package org.eclipse.wst.xml.xpath2.processor;

import org.w3c.dom.*;
import org.eclipse.wst.xml.xpath2.processor.types.*;

/**
 * the parent axis contains the sequence returned by the dm:parent accessor in,
 * which returns the parent of the context node, or an empty sequence if the
 * context node has no parent
 */
public class ParentAxis extends ReverseAxis {

	/**
	 * returns parent accessors of the context node
	 * 
	 * @param node
	 *            is the node type.
	 * @throws dc
	 *             is the Dynamic context.
	 * @return the accessors.
	 */
	public ResultSequence iterate(NodeType node, DynamicContext dc) {
		ResultSequence rs = ResultSequenceFactory.create_new();

		Node n = node.node_value();
		Node parent = n.getParentNode();

		// special case attribute elements...
		// in this case... the parent is the element which owns the attr
		if (n.getNodeType() == Node.ATTRIBUTE_NODE) {
			Attr att = (Attr) n;

			parent = att.getOwnerElement();
		}

		// if a parent exists... add it
		if (parent != null)
			rs.add(NodeType.dom_to_xpath(parent, dc.node_position(parent)));

		return rs;
	}

}
