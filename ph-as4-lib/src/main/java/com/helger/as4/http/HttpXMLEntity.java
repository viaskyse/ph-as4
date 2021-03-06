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
package com.helger.as4.http;

import javax.annotation.Nonnull;

import org.apache.http.entity.StringEntity;
import org.w3c.dom.Node;

import com.helger.as4.soap.ESOAPVersion;
import com.helger.as4.util.AS4XMLHelper;

/**
 * Special HTTP POST entity that contains a DOM Node as a serialized String.
 * 
 * @author Philip Helger
 */
public class HttpXMLEntity extends StringEntity
{
  public HttpXMLEntity (@Nonnull final Node Node, @Nonnull final ESOAPVersion eSoapVersion)
  {
    super (AS4XMLHelper.serializeXML (Node), AS4XMLHelper.XWS.getCharset ());
    // Required for AS4.NET
    setContentType (eSoapVersion.getMimeType ().getAsString ());
  }
}
