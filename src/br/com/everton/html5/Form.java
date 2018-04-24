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
 * Defines an HTML form for user input
 *
 * @author evertonramos
 */
public class Form extends Html5 {

    private String action = "";

    public Form() {
        super("form");
    }

    /**
     * The method attribute specifies how to send form-data (the form-data is
     * sent to the page specified in the action attribute).
     */
    public enum Method {
        /**
         * Default. Appends the form-data to the URL in name/value pairs: URL?name=value&name=value
         */
        TGet,
        /**
         * Sends the form-data as an HTTP post transaction
         */
        TPost;

        @Override
        public String toString() {
            switch (this) {
                case TGet:
                    return "get";
                case TPost:
                    return "post";
                default:
                    return "get";
            }
        }
    }

    public void setMethod(Method method) {
        addCustomAttribute("method", method.toString());
    }

    public void setAction(String action) {
        this.action = action;

        addCustomAttribute("action", this.action);
    }
}
