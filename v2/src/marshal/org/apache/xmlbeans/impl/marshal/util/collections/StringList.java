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

package org.apache.xmlbeans.impl.marshal.util.collections;

/**
 minimal, simplisitic typesafe version of ArrayList for Strings
 wraps String[]

 not syncronized.
 */


public final class StringList
    implements Accumulator
{
    private String[] store;
    private int size = 0;


    public StringList()
    {
        this(Accumulator.DEFAULT_INITIAL_CAPACITY);
    }

    public StringList(int initial_capacity)
    {
        store = new String[initial_capacity];
    }

    /**
     get array used as backing store.  do not modify this array.
     effeciency wins here vs. safety.
     */
    public String[] getStore()
    {
        return store;
    }

    public Object getFinalArray()
    {
        return getMinSizedArray();
    }

    /**
     get a new array just large enough to hold the items
     */
    public String[] getMinSizedArray()
    {
        String[] new_a = new String[size];
        System.arraycopy(store, 0, new_a, 0, size);
        //if (DEBUG) Debug.say("getMinSizedArray size="+size);
        return new_a;
    }

    public int getCapacity()
    {
        return store.length;
    }

    public int getSize()
    {
        return size;
    }

    public void append(Object o)
    {
        add((String)o);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param i element to be appended to this list.
     */
    public void add(String i)
    {
        ensureCapacity(size + 1);
        store[size++] = i;
    }

    public String get(int idx)
    {
        //let array do range checking.
        return store[idx];
    }


    /**
     * Increases the capacity of this <tt>StringList</tt> instance, if
     * necessary, to ensure  that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param   minCapacity   the desired minimum capacity.
     */
    public void ensureCapacity(int minCapacity)
    {
        int oldCapacity = store.length;
        if (minCapacity > oldCapacity) {
            String oldData[] = store;
            int newCapacity = (oldCapacity * 2) + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            store = new String[newCapacity];
            System.arraycopy(oldData, 0, store, 0, size);
        }
    }


}

