/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.wizard;

import static org.eclipse.che.sample.shared.Constants.COMPILER_VERSION_ATRIBUTE;
import static org.eclipse.che.sample.shared.Constants.DEFAULT_CCC_COMPILER_VERSION;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.wizard.AbstractWizardPage;

public class SamplePagePresenter extends AbstractWizardPage<MutableProjectConfig>
    implements SamplePageView.ActionDelegate {

  protected final SamplePageView view;
  protected final EventBus eventBus;

  @Inject
  public SamplePagePresenter(SamplePageView view, EventBus eventBus) {
    this.view = view;
    this.eventBus = eventBus;
    view.setDelegate(this);
  }

  @Override
  public void init(MutableProjectConfig dataObject) {
    super.init(dataObject);
  }

  @Override
  public void go(AcceptsOneWidget container) {
    container.setWidget(view);
    view.setCompilerVersion(DEFAULT_CCC_COMPILER_VERSION);
    setAttribute(COMPILER_VERSION_ATRIBUTE, DEFAULT_CCC_COMPILER_VERSION);
  }

  @Override
  public void onCompilerVersionChanged() {
    setAttribute(COMPILER_VERSION_ATRIBUTE, view.getCompilerVersion());
  }

  /** Sets single value of attribute of data-object. */
  private void setAttribute(String attrId, String value) {
    Map<String, List<String>> attributes = dataObject.getAttributes();
    attributes.put(attrId, Arrays.asList(value));
    dataObject.setAttributes(attributes);
  }
}
