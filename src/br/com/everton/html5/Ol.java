/*
 * The MIT License
 *
 * Copyright 2017 evertonramos.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.everton.html5;

/**
 * The ol tag defines an ordered list. An ordered list can be numerical or
 * alphabetical. Use the li tag to define list items.
 *
 * @author evertonramos
 */
public class Ol extends Html5 {

    private int items = 0;

    /**
     * get the quantity of li
     *
     * @return quantity of li
     */
    public int getItems() {
        return items;
    }

    public Ol() {
        super("ol");
    }

    /**
     * add li
     * @param li li
     */
    public void addLi(Li li) {
        items++;

        append(li);
    }

    /**
     * The start attribute specifies the start value of the first list item in
     * an ordered list.
     *
     * @param number Specifies the start value of the first list item in the
     * ordered list
     */
    public void setStart(int number) {
        addCustomAttribute("start", Integer.toString(number));
    }

    /**
     * The type attribute specifies the kind of marker to use in the list
     * (letters or numbers).
     */
    public enum Type {
        /**
         * Default. Decimal numbers (1, 2, 3, 4)
         */
        T1,
        /**
         * Alphabetically ordered list, lowercase (a, b, c, d)
         */
        Ta,
        /**
         * Alphabetically ordered list, uppercase (A, B, C, D)
         */
        TA,
        /**
         * Roman numbers, lowercase (i, ii, iii, iv)
         */
        Ti,
        /**
         * Roman numbers, uppercase (I, II, III, IV)
         */
        TI;

        @Override
        public String toString() {
            switch (this) {
                case Ta:
                    return "a";
                case TA:
                    return "A";
                case Ti:
                    return "i";
                case TI:
                    return "I";
                default:
                    return "1";
            }
        }
    }

    /**
     * The type attribute specifies the kind of marker to use in the list
     * (letters or numbers).
     *
     * @param type "1|a|A|i|I"
     */
    public void setType(Type type) {
        addCustomAttribute("type", type.toString());
    }
    
    // todo reversed
}
