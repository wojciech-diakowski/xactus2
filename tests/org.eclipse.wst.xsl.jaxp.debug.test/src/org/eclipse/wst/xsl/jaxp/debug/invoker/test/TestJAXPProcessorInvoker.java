package org.eclipse.wst.xsl.jaxp.debug.invoker.test;

import java.net.URL;

import javax.xml.transform.dom.DOMResult;

import org.eclipse.wst.xsl.jaxp.debug.invoker.PipelineDefinition;
import org.eclipse.wst.xsl.jaxp.debug.invoker.TransformDefinition;
import org.eclipse.wst.xsl.jaxp.debug.invoker.internal.JAXPSAXProcessorInvoker;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import static org.junit.Assert.*;


public class TestJAXPProcessorInvoker {
	JAXPSAXProcessorInvoker invoker = null;
	
	@Before
	public void setUp() throws Exception {
		invoker = new JAXPSAXProcessorInvoker();
	}
	
	@Test
	public void testSimpleTransform() throws Exception {
		URL surl = TestJAXPProcessorInvoker.class.getResource("1-input.xml");
		URL xslt = TestJAXPProcessorInvoker.class.getResource("1-transform.xsl");
		
		PipelineDefinition pipe = new PipelineDefinition();
		TransformDefinition tdef = new TransformDefinition();
		tdef.setStylesheetURL(xslt.toExternalForm());
		pipe.addTransformDef(tdef);
		pipe.configure(invoker);
		InputSource source = new InputSource(surl.openStream());
		DOMResult result =  new DOMResult();
		invoker.transform(source, result);
		Document node = (Document)result.getNode();
		assertNotNull("Did not get a result document.", node);
		assertEquals("Missing root-out node name.", "root-out", node.getDocumentElement().getLocalName());
	}
}
