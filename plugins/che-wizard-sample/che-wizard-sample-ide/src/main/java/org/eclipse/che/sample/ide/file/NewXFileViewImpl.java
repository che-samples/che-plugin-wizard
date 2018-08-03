/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.file;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.eclipse.che.ide.ui.window.Window;
import org.eclipse.che.sample.ide.SampleWizardLocalizationConstant;

/**
 * Implementation of {@link NewXFileView}.
 *
 * @author Artem Zatsarynnyi
 */
public class NewXFileViewImpl extends Window implements NewXFileView {
  final Button btnOk;
  @UiField TextBox nameField;
  @UiField TextBox headerField;
  private ActionDelegate delegate;

  @Inject
  public NewXFileViewImpl(
      NewJavaSourceFileViewImplUiBinder uiBinder, SampleWizardLocalizationConstant constant) {
    setTitle(constant.title());

    addFooterButton(constant.buttonCancel(), "dialog-cancel", event -> delegate.onCancelClicked());
    btnOk = addFooterButton(constant.buttonOk(), "dialog-ok", event -> delegate.onOkClicked());

    Widget widget = uiBinder.createAndBindUi(this);
    this.setWidget(widget);
  }

  @Override
  public String getName() {
    return nameField.getText();
  }

  @Override
  public String getHeader() {
    return headerField.getText();
  }

  @Override
  public void close() {
    hide();
  }

  @Override
  public void showDialog() {
    show(nameField);
  }

  @Override
  protected void onShow() {
    nameField.setText("");
    headerField.setText("");
  }

  @Override
  public void setDelegate(ActionDelegate delegate) {
    this.delegate = delegate;
  }

  interface NewJavaSourceFileViewImplUiBinder extends UiBinder<Widget, NewXFileViewImpl> {}
}
