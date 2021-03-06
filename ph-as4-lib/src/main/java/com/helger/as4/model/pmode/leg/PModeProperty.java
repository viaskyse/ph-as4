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
package com.helger.as4.model.pmode.leg;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.name.IHasName;
import com.helger.commons.state.EMandatory;
import com.helger.commons.state.IMandatoryIndicator;
import com.helger.commons.text.IHasDescription;

/**
 * A property is a data structure that consists of four values: the property
 * name, which can be used as an identifier of the property (e.g. a required
 * property named "messagetype" can be noted as:
 * <code>Properties[messagetype].required="true"</code>); the property
 * description; the property data type; and a Boolean value, indicating whether
 * the property is expected or optional, within the User message. This parameter
 * controls the contents of the element
 * <code>eb:Messaging/eb:UserMessage/eb:MessageProperties.</code>
 *
 * @author Philip Helger
 */
public class PModeProperty implements IHasName, IHasDescription, IMandatoryIndicator, Serializable
{
  public static final String DATA_TYPE_STRING = "string";

  private static final Logger LOGGER = LoggerFactory.getLogger (PModeProperty.class);

  private final String m_sName;
  private final String m_sDescription;
  private final String m_sDataType;
  private final EMandatory m_eMandatory;

  private static void _checkDataType (@Nonnull final String sDataType)
  {
    if (!DATA_TYPE_STRING.equals (sDataType))
      LOGGER.warn ("A non-standard data type (everything besides 'string') is used: " + sDataType);
  }

  public PModeProperty (@Nonnull @Nonempty final String sName,
                        @Nullable final String sDescription,
                        @Nonnull @Nonempty final String sDataType,
                        @Nonnull final EMandatory eMandatory)
  {
    m_sName = ValueEnforcer.notEmpty (sName, "Name");
    m_sDescription = sDescription;
    m_sDataType = ValueEnforcer.notEmpty (sDataType, "DataType");
    m_eMandatory = ValueEnforcer.notNull (eMandatory, "Mandatory");
    _checkDataType (sDataType);
  }

  @Nonnull
  @Nonempty
  public String getName ()
  {
    return m_sName;
  }

  @Nullable
  public String getDescription ()
  {
    return m_sDescription;
  }

  @Nonnull
  @Nonempty
  public String getDataType ()
  {
    return m_sDataType;
  }

  public boolean isMandatory ()
  {
    return m_eMandatory.isMandatory ();
  }

  public boolean isOptional ()
  {
    return m_eMandatory.isOptional ();
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final PModeProperty rhs = (PModeProperty) o;
    return EqualsHelper.equals (m_sName, rhs.m_sName) &&
           EqualsHelper.equals (m_sDescription, rhs.m_sDescription) &&
           m_sDataType.equals (rhs.m_sDataType) &&
           m_eMandatory.equals (rhs.m_eMandatory);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sName)
                                       .append (m_sDescription)
                                       .append (m_sDataType)
                                       .append (m_eMandatory)
                                       .getHashCode ();
  }
}
