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
 * The th tag defines a header cell in an HTML table.
 *
 * @author evertonramos
 */
public class Th extends Html5 {
    // todo abbr https://www.w3schools.com/TagS/tag_th.asp
    // todo headers
    // todo scope
    // todo sorted
    
    
    public Th() {
        super("th");
    }
    
    public Th(Html5 content) {
        super("th", content);
    }
    
    public Th(String content) {
        super("th", content);
    }
    
    public void setColspan(int colspan) {
        addCustomAttribute("colspan", Integer.toString(colspan));
    }

    public void setRowspan(int rowspan) {
        addCustomAttribute("rowspan", Integer.toString(rowspan));
    }
}
