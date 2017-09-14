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

import html5.br.com.everton.Html;
import html5.br.com.everton.Br;
import html5.br.com.everton.Div;
import html5.br.com.everton.H1;
import html5.br.com.everton.Hr;
import html5.br.com.everton.Section;

/**
 *
 * @author evertonramos
 */
public class Main {
    public static void main(String [] args) {
        Html html = new Html();
        
        // <section>
        Section section = new Section();
        
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
        section.br();
        section.comment("comentário no section");
        
        // <div>
        Div div = new Div("tttttt");
        
        div.setIdAttribute("id_div");
        div.append("content");
        div.br();
        div.comment("comment test");
        
        section.append(div);
        
        // <br>
        Br br = new Br();
        
        br.setIdAttribute("id_br");
        br.comment("comentário");
        System.out.println(br);
     
        // <h1>
        H1 h1 = new H1("teste do H1");
        h1.addClassName("classH1");
        h1.addClassName(new String[]{"valor1", "valor2"});
        h1.addStyle("color", "red");
        h1.br();
        h1.comment("comentário do h1");
        
        System.out.println(h1);
        
        // <hr>
        Hr hr = new Hr();
        
        html.append(section);
        
        System.out.println(html);
        
        
    }
}
