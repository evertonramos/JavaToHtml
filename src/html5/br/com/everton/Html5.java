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
package html5.br.com.everton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author evertonramos
 */
public abstract class Html5 {

    /**
     * Specifies one or more classnames for an element (refers to a class in a
     * style sheet)
     */
    private final List<String> classAttribute = new ArrayList<>();
    
    /**
     * Used to store custom data private to the page or application
     */
    private final Map<String, String> dataAttribute = new HashMap<>();
    
    

    /**
     * Specifies that an element is not yet, or is no longer, relevant
     */
    private boolean hiddenAttribute = false;

    /**
     * Specifies a unique id for an element
     */
    private String idAttribute = "";

    /**
     * Specifies an inline CSS style for an element
     */
    private final Map<String, String> styleAttribute = new HashMap<>();

    /**
     * Specifies extra information about an element
     */
    private String titleAttribute = "";

    StringBuilder sbContent = new StringBuilder();

    public void addClassName(String sClass) {
        classAttribute.add(sClass);
    }

    /**
     * get a string with class names separated by spaces
     *
     * @return String - "class1 class2 classN"
     */
    private String getClassAttribute() {
        return String.join(" ", classAttribute);
    }
    
    public void addDataAttribute(String sAttribute, String sValue) {
        dataAttribute.put("data-" + sAttribute, sValue);
    }
    
    /**
     * get a string with data attributes separated by spaces
     * @return String - "data-attribute1='value' data-attribute2='value' data-attributeN='value'"
     */
    private String getDataAttributes() {
        StringBuilder sb = new StringBuilder();

        dataAttribute.forEach((key, value) -> {
            sb.append(key).append("='").append(value).append("' ");
        });

        return sb.toString().trim();
    }

    public boolean isHiddenAttribute() {
        return hiddenAttribute;
    }

    public void setHiddenAttribute(boolean hiddenAttribute) {
        this.hiddenAttribute = hiddenAttribute;
    }

    public String getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(String idAttribute) {
        this.idAttribute = idAttribute;
    }

    public void addStyle(String sProperty, String sValue) {
        styleAttribute.put(sProperty, sValue);
    }

    /**
     * get a string with style properties separated by semicolons
     *
     * @return String - "property1:value;property2:value;propertyN:value;"
     */
    private String getStyleAttribute() {
        StringBuilder sb = new StringBuilder();

        styleAttribute.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append(";");
        });

        return sb.toString();
    }

    public String getTitleAttribute() {
        return titleAttribute;
    }

    public void setTitleAttribute(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

    public String getAttributes() {
        StringBuilder sb = new StringBuilder();

        // class
        if (!getClassAttribute().isEmpty()) {
            sb.append("class='").append(getClassAttribute()).append("' ");
        }
        
        // data-*
        if(!getDataAttributes().isEmpty()) {
            sb.append(getDataAttributes()).append(" ");
        }

        // hidden
        if (isHiddenAttribute()) {
            sb.append("hidden ");
        }

        // id
        if (!getIdAttribute().isEmpty()) {
            sb.append("id='").append(getIdAttribute()).append("' ");
        }

        // style
        if (!getStyleAttribute().isEmpty()) {
            sb.append("style='").append(getStyleAttribute()).append("' ");
        }

        // title
        if (!getTitleAttribute().isEmpty()) {
            sb.append("title='").append(getTitleAttribute()).append("' ");
        }

        return sb.toString().trim();
    }

    public void append(String sContent) {
        sbContent.append(sContent);
    }

    @Override
    public String toString() {
        return sbContent.toString();
    }
}
