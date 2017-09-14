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

import html5.br.com.everton.TagBr;
import html5.br.com.everton.TagDiv;
import html5.br.com.everton.TagSection;

/**
 *
 * @author evertonramos
 */
public class Main {
    public static void main(String [] args) {
        // <section>
        TagSection section = new TagSection();
        
        // set id
        section.setIdAttribute("id_section");
        
        // add class
        section.addClassName("class1");
        section.addClassName("class2");
        
        // add style
        section.addStyle("background-color", "green");
        section.addStyle("color", "yellow");
        
        // hidden
        section.setHiddenAttribute(true);
        
        // data-*
        section.addDataAttribute("animal-type", "bird");
        section.addDataAttribute("animal-color", "orange");
        
        // content
        section.append("section content");
        
        System.out.println(section);
        
        // <div>
        TagDiv div = new TagDiv();
        
        div.setIdAttribute("id_div");
        div.append("content");
        div.appendBr();
        div.appendComment("comment test");
        
        System.out.println(div);
        
        // <br>
        TagBr br = new TagBr();
        
        br.setIdAttribute("id_br");
        br.appendComment("comentário");
        System.out.println(br);
        
    }
}
