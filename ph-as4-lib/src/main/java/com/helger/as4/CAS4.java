/**
 * Copyright (C) 2015-2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.as4;

import javax.annotation.concurrent.Immutable;

/**
 * AS4 constants
 *
 * @author Philip Helger
 */
@Immutable
public final class CAS4
{
  // XSD
  public static final String PATH_SCHEMATA = "/schemas/";
  public static final String XSD_EBMS_HEADER = PATH_SCHEMATA + "ebms-header-3_0-200704.xsd";
  public static final String XSD_EBBP_SIGNALS = PATH_SCHEMATA + "ebbp-signals-2.0.4.xsd";
  public static final String XSD_SOAP11 = PATH_SCHEMATA + "soap11.xsd";
  public static final String XSD_SOAP12 = PATH_SCHEMATA + "soap12.xsd";
  public static final String XSD_XML = PATH_SCHEMATA + "xml.xsd";

  // Namespaces
  public static final String EBMS_NS = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/";
  public static final String EBBP_NS = "http://docs.oasis-open.org/ebxml-bp/ebbp-signals-2.0";
  public static final String WSSE_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
  public static final String WSU_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
  public static final String DS_NS = "http://www.w3.org/2000/09/xmldsig#";
  public static final String XENC_NS = "http://www.w3.org/2001/04/xmlenc#";

  public static final String LIB_NAME = "ph-as4";

  // Constant Names
  public static final String FINAL_RECIPIENT = "finalRecipient";
  public static final String ORIGINAL_SENDER = "originalSender";

  // Defaults
  public static final String DEFAULT_ROLE = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/defaultRole";
  public static final String DEFAULT_RESPONDER_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/responder";
  public static final String DEFAULT_TO_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/defaultTo";
  public static final String DEFAULT_SENDER_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/sender";
  public static final String DEFAULT_FROM_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/defaultFrom";
  public static final String DEFAULT_ACTION_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/test";
  public static final String DEFAULT_SERVICE_URL = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/service";
  public static final String DEFAULT_MPC_ID = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/defaultMPC";

  private CAS4 ()
  {}
}
