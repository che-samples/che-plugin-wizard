/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.wizard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SamplePageViewImpl implements SamplePageView {

  private ActionDelegate delegate;
  private final DockLayoutPanel rootElement;
  @UiField TextBox compilerVersion;

  private static SamplePageViewImplUiBinder uiBinder = GWT.create(SamplePageViewImplUiBinder.class);

  @Inject
  public SamplePageViewImpl() {
    rootElement = uiBinder.createAndBindUi(this);
    compilerVersion.setFocus(true);
  }

  @UiHandler({"compilerVersion"})
  void onKeyUp(KeyUpEvent event) {
    delegate.onCompilerVersionChanged();
  }

  @Override
  public void setDelegate(ActionDelegate delegate) {
    this.delegate = delegate;
  }

  /** Returns the {@link Widget} aspect of the receiver. */
  @Override
  public Widget asWidget() {
    return rootElement;
  }

  @Override
  public String getCompilerVersion() {
    return compilerVersion.getText();
  }

  @Override
  public void setCompilerVersion(String version) {
    compilerVersion.setText(version);
  }

  interface SamplePageViewImplUiBinder extends UiBinder<DockLayoutPanel, SamplePageViewImpl> {}
}
