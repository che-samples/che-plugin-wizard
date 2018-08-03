/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.che.sample.ide;

import com.google.gwt.i18n.client.Messages;

/**
 * Localization constants. Interface to represent the constants defined in resource bundle:
 * 'SampleWizardLocalizationConstant.properties'.
 *
 * @author Vitalii PArfonov
 */
public interface SampleWizardLocalizationConstant extends Messages {

  @Key("ok")
  @DefaultMessage("Ok")
  String buttonOk();

  @Key("cancel")
  @DefaultMessage("Cancel")
  String buttonCancel();

  @Key("title")
  @DefaultMessage("Enter file name and included header")
  String title();

  @Key("action.description")
  @DefaultMessage("Create new X file")
  String createXFileWithIncludedHeader();

  @Key("action.title")
  @DefaultMessage("New X file")
  String newXFile();
}
