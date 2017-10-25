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
 * Defines a multiline input control (text area)
 *
 * @author evertonramos
 */
public class Textarea extends Html5 {
    private String name = "";
    
    public Textarea() {
        super("textarea");
    }
    
    public void setRows(int rows) {
        addCustomAttribute("rows", Integer.toString(rows));
    }
    
    public void setCols(int cols) {
        addCustomAttribute("cols", Integer.toString(cols));
    }
    
    public void setName(String name) {
        this.name = name;

        addCustomAttribute("name", this.name);
    }

    public String getFor() {
        return this.name;
    }

    public void setValue(String value) {
        append(value);
    }

    public void setPlaceholder(String text) {
        addCustomAttribute("placeholder", text);
    }

    public void setDisabled() {
        addSpecialAttribute("disabled");
    }
    
    public void setReadonly() {
        addSpecialAttribute("readonly");
    }
    
    public void setRequired() {
        addSpecialAttribute("required");
    }
    
    //https://www.w3schools.com/tags/tag_textarea.asp
}
