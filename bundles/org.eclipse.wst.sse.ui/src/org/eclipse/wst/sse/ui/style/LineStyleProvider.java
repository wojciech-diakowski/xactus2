/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.wst.sse.ui.style;

import java.util.Collection;

import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.wst.sse.core.text.IStructuredDocument;

public interface LineStyleProvider {

	/**
	 * Initializes this provider for the given Highlighter and document. This
	 * method will be called at least once before prepareRegions is called.
	 * 
	 * @param document
	 * @param highlighter
	 */
	void init(IStructuredDocument document, Highlighter highlighter);

	/**
	 * Optionally appends StyleRanges to the styleRanges Collection, in order,
	 * and only covering the given range within the document.
	 * 
	 * @param currentRegion -
	 *            the current document partition
	 * @param start
	 * @param length
	 * @param styleRanges
	 * @return whether this LineStyleProvider handled the request; handling
	 *         includes not adding StyleRanges if that is still the correct
	 *         behavior
	 */
	boolean prepareRegions(ITypedRegion currentRegion, int start, int length, Collection styleRanges);

	/**
	 * Instructs this provider to free up any "resources" it might be holding
	 * on to (such as listening for preference changes). It is only called
	 * once in the lifetime of this provider.
	 */
	void release();
}
