/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.as4server.message;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.annotation.Nonnull;

import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.helger.as4lib.soap.ESOAPVersion;
import com.helger.as4lib.xml.AS4XMLHelper;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xml.serialize.read.DOMReader;

@RunWith (Parameterized.class)
public class ReceiptMessageTests extends AbstractUserMessageTestSetUp
{

  @Parameters (name = "{index}: {0}")
  public static Collection <Object []> data ()
  {
    return CollectionHelper.newListMapped (ESOAPVersion.values (), x -> new Object [] { x });
  }

  private final ESOAPVersion m_eSOAPVersion;

  public ReceiptMessageTests (@Nonnull final ESOAPVersion eSOAPVersion)
  {
    m_eSOAPVersion = eSOAPVersion;
  }

  @Test
  public void testReceiptReceivedFromUserMessageWithoutWSSecurity () throws Exception
  {
    final Node aPayload = DOMReader.readXMLDOM (new ClassPathResource ("SOAPBodyPayload.xml"));
    final Document aDoc = TestMessages.testUserMessageSoapNotSigned (m_eSOAPVersion, aPayload, null);

    sendPlainMessage (new StringEntity (AS4XMLHelper.serializeXML (aDoc)), true, null);

    assertTrue (m_sResponse.contains ("UserMessage"));
  }

  @Test
  public void testReceiptReceivedFromUserMessageWithWSSecurity () throws Exception
  {
    final Node aPayload = DOMReader.readXMLDOM (new ClassPathResource ("SOAPBodyPayload.xml"));
    final Document aDoc = TestMessages.testSignedUserMessage (m_eSOAPVersion, aPayload, null);

    sendPlainMessage (new StringEntity (AS4XMLHelper.serializeXML (aDoc)), true, null);

    assertTrue (m_sResponse.contains ("NonRepudiationInformation"));
  }

}