/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

/** @author Vitalii Parfonov */
public interface SampleWizardResources extends ClientBundle {
  SampleWizardResources INSTANCE = GWT.create(SampleWizardResources.class);

  @Source("svg/c_file.svg")
  SVGResource xFile();

  @Source("svg/category.svg")
  SVGResource category();
}
