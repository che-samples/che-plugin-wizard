/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.sample.ide.action.NewXFileAction;

/** */
@Extension(title = "Sample Wizard")
public class SampleWizardExtension {

  public static String X_CATEGORY = "Sample Category";

  @Inject
  public SampleWizardExtension(
      FileTypeRegistry fileTypeRegistry, @Named("XFileType") FileType xFile) {
    fileTypeRegistry.registerFileType(xFile);
  }

  @Inject
  private void prepareActions(NewXFileAction newXFileAction, ActionManager actionManager) {

    DefaultActionGroup newFileGroup = (DefaultActionGroup) actionManager.getAction(GROUP_FILE_NEW);

    actionManager.registerAction("newFileActon", newXFileAction);
    newFileGroup.add(newXFileAction, Constraints.FIRST);
  }
}
