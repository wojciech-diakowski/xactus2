/*******************************************************************************
 * Copyright (c) Standards for Technology in Automotive Retail and others
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     David Carver - STAR - intial API and implementation
 *******************************************************************************/

package org.eclipse.wst.xsl.ui.tests.contentassist;

import java.io.File;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.wst.sse.ui.internal.contentassist.ContentAssistUtils;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.sse.ui.internal.contentassist.CustomCompletionProposal;
import org.eclipse.wst.xsl.ui.tests.AbstractSourceViewerTest;

/**
 * Tests everything about code completion and code assistance.
 * 
 */
public class XSLCompletionTest extends AbstractSourceViewerTest {

	public void testGetNodeAtLine10() throws Exception {

		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		IDOMNode node = (IDOMNode) ContentAssistUtils.getNodeAt(sourceViewer,
				sourceViewer.getDocument().getLineOffset(9) + 1);
		assertEquals("Wrong node name returned:", "xsl:stylesheet", node
				.getNodeName());
	}

	public void testGetNodeAtLine12() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		IDOMNode node = (IDOMNode) ContentAssistUtils.getNodeAt(sourceViewer,
				sourceViewer.getDocument().getLineOffset(11) + 11);
		assertEquals("Wrong node name returned:", "xsl:template", node
				.getNodeName());
	}

	public void testGetNodeAtLine13() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		IDOMNode node = (IDOMNode) ContentAssistUtils.getNodeAt(sourceViewer,
				sourceViewer.getDocument().getLineOffset(12) + 14);
		assertEquals("Wrong node name returned:", "xsl:param", node
				.getNodeName());
	}

	public void testAttributeNotValueAvailable() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		ICompletionProposal[] proposals = getProposals(14, 42);

		assertTrue(proposals.length > 1);
		ICompletionProposal proposal = proposals[0];
		assertFalse("Found \"number(substring($date, 6, 2))\".", proposal
				.getDisplayString()
				.equals("\"number(substring($date, 6, 2))\""));
	}

	public void testSelectAttributeProposalsAvailable() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		int offset = sourceViewer.getDocument().getLineOffset(14) + 42;
		String s = sourceViewer.getDocument().get(offset - 1, 6);
		assertEquals("number", s);

		ICompletionProposal[] proposals = getProposals(14, 41);

		assertTrue(proposals.length > 1);
		ICompletionProposal proposal = proposals[3];
		assertEquals("Wrong select item returned: ", "..", proposal
				.getDisplayString());
	}

	/**
	 * Bug 240170
	 * 
	 * @throws Exception
	 */
	public void testSelectAttributeProposalsNarrow() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);
		Thread.sleep(6000);

		int offset = sourceViewer.getDocument().getLineOffset(14) + 42;
		String s = sourceViewer.getDocument().get(offset - 9, 9);
		assertEquals("select=\"n", s);

		ICompletionProposal[] proposals = getProposals(offset);
		assertEquals("Wrong xpath item returned: ", "name(node-set)",
				proposals[0].getDisplayString());
		assertEquals("Wrong Number of items returned: ", 6, proposals.length);
	}

	public void testTestAttributeProposalsAvailable() throws Exception {
		fileName = "simple.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		ICompletionProposal[] proposals = getXMLProposals(4, 30);
		assertTrue(proposals.length >= 1);
		ICompletionProposal proposal = proposals[0];
		assertEquals("Wrong attribute proposal returned:", "disable-output-escaping=\"no\"", proposal.getDisplayString());
	}

	public void testXSLElementProposalsAvailable() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		ICompletionProposal[] proposals = getXMLProposals(51, 20);
		assertTrue(proposals.length >= 2);

		ICompletionProposal proposal = proposals[1];
		assertTrue("Can't find XSL element proposals.", proposal
				.getDisplayString().equals("xsl:otherwise"));
	}

	/*
	 * Bug 259575
	 */
	public void testXPathProposalAvaialbleAfterComma() throws Exception {
		fileName = "utils.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		ICompletionProposal[] proposals = getProposals(861);
		assertTrue(proposals.length > 0);
	}

	// Bug 281420 - Variable inserts wrong.
	public void testVariableInsertPositionOffset() throws Exception {
		fileName = "bug281420.xsl";
		String xslFilePath = projectName + File.separator + fileName;
		loadFileForTesting(xslFilePath);

		ICompletionProposal[] proposals = getProposals(7, 29);
		assertTrue("Did not find any proposals.", proposals.length > 0);
		CustomCompletionProposal testprop = null;
		for (int cnt = 0; cnt < proposals.length; cnt++) {
			if (proposals[cnt].getDisplayString().equals("$test")) {
				testprop = (CustomCompletionProposal) proposals[cnt];
			}
		}

		if (testprop == null) {
			fail("Didn't find the $test proposal");
		}
		int startoffset = calculateOffset(7, 28);
		if (testprop.getReplacementOffset() != startoffset) {
			fail("Replacement Offset position worng expected " + startoffset
					+ "but received " + testprop.getReplacementOffset());
		}

	}

}