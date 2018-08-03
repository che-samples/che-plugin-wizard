/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.file;

import org.eclipse.che.ide.api.mvp.View;

/**
 * The view of {@link NewXFilePresenter}.
 *
 * <p>* @author Vitalii Parfonov
 */
public interface NewXFileView extends View<NewXFileView.ActionDelegate> {

  String getName();

  String getHeader();

  /** Show dialog. */
  void showDialog();

  /** Close dialog. */
  void close();

  interface ActionDelegate {
    /** Performs any actions appropriate in response to the user having pressed the Ok button. */
    void onOkClicked();

    /**
     * Performs any actions appropriate in response to the user having pressed the Cancel button.
     */
    void onCancelClicked();
  }
}
