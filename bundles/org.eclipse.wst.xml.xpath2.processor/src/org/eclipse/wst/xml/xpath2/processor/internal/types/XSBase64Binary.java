/*******************************************************************************
 * Copyright (c) 2009 Mukul Gandhi, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Mukul Gandhi - bug 281046 - initial API and implementation 
 *******************************************************************************/

package org.eclipse.wst.xml.xpath2.processor.internal.types;

import org.apache.xerces.impl.dv.util.Base64;
import org.eclipse.wst.xml.xpath2.processor.DynamicError;
import org.eclipse.wst.xml.xpath2.processor.ResultSequence;
import org.eclipse.wst.xml.xpath2.processor.ResultSequenceFactory;
import org.eclipse.wst.xml.xpath2.processor.internal.function.CmpEq;

/**
 * A representation of the base64Binary datatype
 */
public class XSBase64Binary extends CtrType implements CmpEq {

	private String _value;

	/**
	 * Initialises using the supplied String
	 * 
	 * @param x
	 *            The String to initialise to
	 */
	public XSBase64Binary(String x) {
		_value = x;
	}

	/**
	 * Initialises to null
	 */
	public XSBase64Binary() {
		this(null);
	}

	/**
	 * Retrieves the datatype's full pathname
	 * 
	 * @return "xs:base64Binary" which is the datatype's full pathname
	 */
	@Override
	public String string_type() {
		return "xs:base64Binary";
	}

	/**
	 * Retrieves the datatype's name
	 * 
	 * @return "base64Binary" which is the datatype's name
	 */
	@Override
	public String type_name() {
		return "base64Binary";
	}

	/**
	 * Retrieves a String representation of the base64Binary stored. This method is
	 * functionally identical to value()
	 * 
	 * @return The base64Binary stored
	 */
	@Override
	public String string_value() {
		return _value;
	}

	/**
	 * Retrieves a String representation of the base64Binary stored. This method is
	 * functionally identical to string_value()
	 * 
	 * @return The base64Binary stored
	 */
	public String value() {
		return _value;
	}

	/**
	 * Creates a new ResultSequence consisting of the base64Binary value
	 * 
	 * @param arg
	 *            The ResultSequence from which to construct base64Binary value 
	 * @return New ResultSequence representing base64Binary value 
	 * @throws DynamicError
	 */
	@Override
	public ResultSequence constructor(ResultSequence arg) throws DynamicError {
		ResultSequence rs = ResultSequenceFactory.create_new();

		if (arg.empty())
			return rs;

		AnyAtomicType aat = (AnyAtomicType) arg.first();
		
		String str_value = aat.string_value();
		byte[] decodedValue = Base64.decode(str_value);
		if (decodedValue != null) {
		  rs.add(new XSBase64Binary(str_value));
		}
		else {
		  // invalid base64 string
		  throw DynamicError.throw_type_error();	
		}

		return rs;
	}


	/**
	 * Equality comparison between this and the supplied representation which
	 * must be of type base64Binary
	 * 
	 * @param arg
	 *            The representation to compare with
	 * @return True if the two representation are same. False otherwise.
	 *         
	 * @throws DynamicError
	 */
	public boolean eq(AnyType arg) throws DynamicError {
      String valToCompare = arg.string_value();
      
      byte[] value1 = Base64.decode(_value);
      byte[] value2 = Base64.decode(valToCompare);
      if (value2 == null) {
    	return false;  
      }
      
      int len = value1.length;
      if (len != value2.length) {
        return false;
      }
      
      for (int i = 0; i < len; i++) {
        if (value1[i] != value2[i]) {
          return false;
        }
      }
      
      return true;
	}

}
