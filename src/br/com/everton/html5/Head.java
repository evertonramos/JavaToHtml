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
 * The div tag defines a division or a section in an HTML document. The div tag
 * is used to group block-elements to format them with CSS.
 *
 * @author evertonramos
 */
public class Head extends Html5 {

    public Head() {
        super("head");
    }

    public void addTitle(String title) {
        append("<title>" + title + "</title>");
    }
    
    // meta
    public void addCharset(String charset) {
        append("<meta charset='" + charset + "'>");
    }
    
    public void addHttpEquiv(String httpEquiv, String content) {
        append("<meta http-equiv='" + httpEquiv + "' content='" + content + "'>");
    }
    
    public void addContentType(String content) {
        addHttpEquiv("content-type", content);
    }
    
    public void addDefaultStyle(String content) {
        addHttpEquiv("default-style", content);
    }
    
    public void addRefresh(String content) {
        addHttpEquiv("refresh", content);
    }
    
    public void addName(String name, String content) {
        append("<meta name='" + name + "' content='" + content + "'>");
    }
    
    public void addApplicationName(String content) {
        addName("application-name", content);
    }
    
    public void addAuthor(String content) {
        addName("author", content);
    }
    
    public void addDescription(String content) {
        addName("description", content);
    }
    
    public void addGenerator(String content) {
        addName("generator", content);
    }
    
    public void addKeywords(String content) {
        addName("keywords", content);
    }
    
    public void addViewport(String content) {
        addName("viewport", content);
    }
}