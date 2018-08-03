/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.wizard;

import com.google.inject.ImplementedBy;
import org.eclipse.che.ide.api.mvp.View;

@ImplementedBy(SamplePageViewImpl.class)
public interface SamplePageView extends View<SamplePageView.ActionDelegate> {

  String getCompilerVersion();

  void setCompilerVersion(String version);

  interface ActionDelegate {
    void onCompilerVersionChanged();
  }
}
