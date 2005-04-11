/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.jsp.ui.tests.examples;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.jst.jsp.core.contenttype.ContentTypeIdForJSP;
import org.eclipse.wst.sse.core.IModelManager;
import org.eclipse.wst.sse.core.IStructuredModel;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.xml.core.document.IDOMElement;
import org.eclipse.wst.xml.core.document.IDOMModel;
import org.eclipse.wst.xml.core.internal.provisional.format.NodeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CreatingJSPExpression extends TestCase {

	/**
	 * 
	 */
	public CreatingJSPExpression() {
		super();
	}

	/**
	 * @param name
	 */
	public CreatingJSPExpression(String name) {
		super(name);
	}

	public void testCreateJSPExpression() throws IOException {
		// First make (empty) structuredDocument
		IModelManager modelManager = StructuredModelManager.getModelManager();
		IStructuredModel model = modelManager.createUnManagedStructuredModelFor(ContentTypeIdForJSP.ContentTypeID_JSP);
		assertTrue("model could not be created!", model != null);

		// Now, assigning use a page directive, but leaving embedded type the same as default
		model.getStructuredDocument().setText(this, "<%@ page contentType=\"text/html\" language=\"java\" %>");

		Document doc = ((IDOMModel) model).getDocument();

		Element jspexpression = doc.createElement("jsp:expression");
		((IDOMElement) jspexpression).setJSPTag(true);
		doc.appendChild(jspexpression);
		Text javacode = doc.createTextNode(" // some java code here; if (x <0) return new String(\"0\") else return new String (\"1\"); ");
		jspexpression.appendChild(javacode);


		Text cdatasection = doc.createCDATASection(" // some cdata java code here; if (x <0) return new String(\"0\") else return new String (\"1\"); ");
		doc.appendChild(cdatasection);

		// format's not needed, just prettier ... not sure why 
		// it won't work right on whole document.
		new NodeFormatter().format(jspexpression);
		new NodeFormatter().format(cdatasection);
		System.out.println("document text: ");
		System.out.println(model.getStructuredDocument().get());
	}

}