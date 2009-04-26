/*******************************************************************************
 * Copyright (c) 2009 Standards for Technology in Automotive Retail and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     David Carver - initial API and implementation
 *     Mukul Ghandi - bug 273719
 *******************************************************************************/
package org.eclipse.wst.xml.xpath2.processor.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllPsychoPathTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.wst.xml.xpath2.processor.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestXPath20.class);
		suite.addTestSuite(Bug269833.class);
		suite.addTestSuite(TestBugs.class);
		//$JUnit-END$
		return suite;
	}

}
