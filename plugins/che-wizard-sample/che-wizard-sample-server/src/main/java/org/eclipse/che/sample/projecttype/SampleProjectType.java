/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.projecttype;

import static org.eclipse.che.sample.shared.Constants.COMPILER_VERSION_ATRIBUTE;
import static org.eclipse.che.sample.shared.Constants.C_LANG;
import static org.eclipse.che.sample.shared.Constants.LANGUAGE;
import static org.eclipse.che.sample.shared.Constants.X_PROJECT_TYPE_ID;

import com.google.inject.Inject;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;

/**
 * C wizard type
 *
 * @author Vitalii Parfonov
 */
public class SampleProjectType extends ProjectTypeDef {
  @Inject
  public SampleProjectType() {
    super(X_PROJECT_TYPE_ID, "Sample Project Type", true, false, true);
    addConstantDefinition(LANGUAGE, "language", C_LANG);
    addVariableDefinition(COMPILER_VERSION_ATRIBUTE, "GCC compiler version", false);
  }
}
