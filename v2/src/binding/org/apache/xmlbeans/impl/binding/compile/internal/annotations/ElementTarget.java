/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.xmlbeans.impl.binding.compile.internal.annotations;

import javax.xml.namespace.QName;

/**
 * @author Patrick Calahan &lt;email: pcal-at-bea-dot-com&gt;
 */
public class ElementTarget extends NamedTarget {

  // ========================================================================
  // Variables

  private boolean mRequired;
  private boolean mAttribute;
  private boolean mNillable;
  private boolean mExclude;

  // ========================================================================
  // Constructors

  public ElementTarget(QName qn) { super(qn); }

  public ElementTarget(String ns, String local) { super(ns,local); }

  // ========================================================================
  // Public methods

  public boolean isRequired() { return mRequired; }

  public boolean isAttribute() { return mAttribute; }

  public boolean isNillable() { return mNillable; }

  public boolean isExclude() { return mExclude; }


}
