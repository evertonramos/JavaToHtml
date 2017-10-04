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
package test;

import br.com.everton.html5.Body;
import br.com.everton.html5.Head;
import br.com.everton.html5.Html;
import br.com.everton.html5.Section;

/**
 *
 * @author evertonramos
 */
public class Main {
    public static void main(String [] args) {
        // head
        Head head = new Head();
        head.addTitle("Page title");
        head.addHttpEquiv("X-UA-Compatible", "IE=edge, chrome=1");
        head.addCharset("UTF-8");
        head.addViewport("width=device-width, initial-scale=1.0, maximum-scale=1.0");
        head.addDescription("description");
        head.addAuthor("author");
        head.addStylesheet("arquivo.css");
                
        // section1
        Section section1 = new Section();
        section1.setIdAttribute("section1");
        section1.append("content of section1");        
                
        // section2
        Section section2 = new Section();
        section2.setIdAttribute("section2");
        section2.append("content of section2");        

        // body
        Body body = new Body();
        body.append(section1);
        body.append(section2);

        // html
        Html html = new Html();
        html.append(head);        
        html.append(body);
        
        System.out.println(html.getHtml5(true));
        
    }
}
