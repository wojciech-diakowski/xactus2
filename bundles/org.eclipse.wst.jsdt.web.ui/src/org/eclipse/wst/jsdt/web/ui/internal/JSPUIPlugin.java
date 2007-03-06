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
package org.eclipse.wst.jsdt.web.ui.internal;

import java.io.IOException;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.wst.jsdt.internal.corext.template.java.CodeTemplateContextType;
import org.eclipse.wst.jsdt.internal.ui.JavaPlugin;
import org.eclipse.wst.jsdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.wst.jsdt.web.ui.internal.preferences.JSPUIPreferenceNames;
import org.eclipse.wst.jsdt.web.ui.internal.templates.TemplateContextTypeIdsJSP;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.wst.sse.ui.internal.provisional.registry.AdapterFactoryRegistry;
import org.eclipse.wst.sse.ui.internal.provisional.registry.AdapterFactoryRegistryImpl;

/**
 * The main plugin class to be used in the desktop.
 */
public class JSPUIPlugin extends AbstractUIPlugin {
	public final static String ID = "org.eclipse.wst.jsdt.web.ui"; //$NON-NLS-1$

	protected static JSPUIPlugin instance = null;

	/**
	 * The template store for the jsp editor.
	 */
	private TemplateStore fTemplateStore;

	/**
	 * The template context type registry for the jsp editor.
	 */
	private ContextTypeRegistry fContextTypeRegistry;

	public JSPUIPlugin() {
		super();
		instance = this;
	}

	public static JSPUIPlugin getDefault() {
		return instance;
	}

	public synchronized static JSPUIPlugin getInstance() {
		return instance;
	}

	public AdapterFactoryRegistry getAdapterFactoryRegistry() {
		return AdapterFactoryRegistryImpl.getInstance();

	}

	/**
	 * Returns the template store for the jsp editor templates.
	 * 
	 * @return the template store for the jsp editor templates
	 */
	public TemplateStore getTemplateStore() {
		if (fTemplateStore == null) {
//			fTemplateStore = new ContributionTemplateStore(
//					getTemplateContextRegistry(), getPreferenceStore(),
//					JSPUIPreferenceNames.TEMPLATES_KEY);
			JavaPlugin jp = JavaPlugin.getDefault();
			fTemplateStore = jp.getTemplateStore();
			
			try {
				fTemplateStore.load();
			} catch (IOException e) {
				Logger.logException(e);
			}
		}
		return fTemplateStore;
	}

	/**
	 * Returns the template context type registry for the jsp plugin.
	 * 
	 * @return the template context type registry for the jsp plugin
	 */
	public ContextTypeRegistry getTemplateContextRegistry() {
		if (fContextTypeRegistry == null) {
//			ContributionContextTypeRegistry registry = new ContributionContextTypeRegistry();
//			registry.addContextType(TemplateContextTypeIdsJSP.ALL);
//			registry.addContextType(TemplateContextTypeIdsJSP.NEW);
//			registry.addContextType(TemplateContextTypeIdsJSP.TAG);
//			registry.addContextType(TemplateContextTypeIdsJSP.ATTRIBUTE);
//			registry.addContextType(TemplateContextTypeIdsJSP.ATTRIBUTE_VALUE);
			
			fContextTypeRegistry = JavaPlugin.getDefault().getCodeTemplateContextRegistry();
		}

		return fContextTypeRegistry;
	}
}
