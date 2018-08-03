/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide.wizard;

import static org.eclipse.che.sample.shared.Constants.X_PROJECT_TYPE_ID;

import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;
import org.eclipse.che.sample.ide.SampleWizardExtension;

/**
 * Provides information for registering X_PROJECT_TYPE_ID wizard type into wizard wizard.
 *
 * @author Vitalii Parfonov
 */
public class SampleWizardRegistrar implements ProjectWizardRegistrar {

  private final List<Provider<? extends WizardPage<MutableProjectConfig>>> wizardPages;

  @Inject
  public SampleWizardRegistrar(Provider<SamplePagePresenter> samplePagePresenter) {
    wizardPages = new ArrayList<>();
    wizardPages.add(samplePagePresenter);
  }

  @NotNull
  public String getProjectTypeId() {
    return X_PROJECT_TYPE_ID;
  }

  @NotNull
  public String getCategory() {
    return SampleWizardExtension.X_CATEGORY;
  }

  @NotNull
  public List<Provider<? extends WizardPage<MutableProjectConfig>>> getWizardPages() {
    return wizardPages;
  }
}
