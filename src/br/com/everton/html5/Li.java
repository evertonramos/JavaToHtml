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
 * The li tag defines a list item. The li tag is used in ordered lists(ol),
 * unordered lists (ul), and in menu lists (menu).
 *
 * @author evertonramos
 */
public class Li extends Html5 {

    public Li() {
        super("li");
    }

    public Li(String content) {
        super("li", content);
    }

    /**
     * The value attribute sets the value of a list item. The following list
     * items will increment from that number. The value must be a number and can
     * only be used in ordered lists (ol).
     *
     * @param value The value attribute sets the value of a list item
     */
    public void setValue(int value) {
        addCustomAttribute("value", Integer.toString(value));
    }
}
