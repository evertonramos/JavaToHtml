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
 * HTML attributes give elements meaning and context.
 *
 * @author evertonramos
 */
public abstract class Html5 {

    private final StringBuilder sbContent = new StringBuilder();
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    private void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Html5(String tagName) {
        setTagName(tagName);
    }

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

    /**
     * add class name
     *
     * @param sClass class name
     */
    public void addClassName(String sClass) {
        classAttribute.add(sClass);
    }

    /**
     * get string with class names separated by spaces
     *
     * @return something like: class1 class2 classN
     */
    private String getClassAttribute() {
        return String.join(" ", classAttribute);
    }

    /**
     * add data attribute
     *
     * @param sAttribute attribute name
     * @param sValue attribute value
     */
    public void addDataAttribute(String sAttribute, String sValue) {
        dataAttribute.put("data-" + sAttribute, sValue);
    }

    /**
     * get string with data attributes separated by spaces
     *
     * @return something like: data-attribute1='value' data-attribute2='value'
     * data-attributeN='value'
     */
    private String getDataAttributes() {
        StringBuilder sb = new StringBuilder();

        dataAttribute.forEach((key, value) -> {
            sb.append(key).append("='").append(value).append("' ");
        });

        return sb.toString().trim();
    }

    /**
     * get hidden attribute value
     *
     * @return hidden attribute value
     */
    public boolean isHiddenAttribute() {
        return hiddenAttribute;
    }

    /**
     * set hidden attribute value
     *
     * @param hiddenAttribute hidden attribute value
     */
    public void setHiddenAttribute(boolean hiddenAttribute) {
        this.hiddenAttribute = hiddenAttribute;
    }

    /**
     * get id attribute value
     *
     * @return id attribute value
     */
    public String getIdAttribute() {
        return idAttribute;
    }

    /**
     * set id attribute value
     *
     * @param idAttribute id attribute value
     */
    public void setIdAttribute(String idAttribute) {
        this.idAttribute = idAttribute;
    }

    /**
     * add style
     *
     * @param sProperty property name
     * @param sValue property value
     */
    public void addStyle(String sProperty, String sValue) {
        styleAttribute.put(sProperty, sValue);
    }

    /**
     * get string with style properties separated by semicolons
     *
     * @return something like: property1:value;property2:value;propertyN:value;
     */
    private String getStyleAttribute() {
        StringBuilder sb = new StringBuilder();

        styleAttribute.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append(";");
        });

        return sb.toString();
    }

    /**
     * get title attribute value
     *
     * @return title attribute value
     */
    public String getTitleAttribute() {
        return titleAttribute;
    }

    /**
     * set title attribute value
     *
     * @param titleAttribute title attribute value
     */
    public void setTitleAttribute(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

    /**
     * get string with attributes
     *
     * @return something like: class='...' id='...' style='...' title='...'
     */
    public String getAttributes() {
        StringBuilder sb = new StringBuilder();

        // class
        if (!getClassAttribute().isEmpty()) {
            sb.append("class='").append(getClassAttribute()).append("' ");
        }

        // data-*
        if (!getDataAttributes().isEmpty()) {
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

    public StringBuilder append(Html5 html) {
        return sbContent.append(html);
    }

    public StringBuilder appendBr() {
        return sbContent.append(new TagBr());
    }

    public StringBuilder appendComment(String sComment) {
        return sbContent.append(new TagComment(sComment));
    }

    public StringBuilder append(String s) {
        return sbContent.append(s);
    }

    public StringBuilder append(StringBuilder sb) {
        return sbContent.append(sb);
    }

    public String getHtml5() {
        StringBuilder html5 = new StringBuilder();

        html5.append("<");
        html5.append(getTagName());
        html5.append(getAttributes().isEmpty() ? "" : (" " + getAttributes()));

        switch (getTagName()) {
            case "!--":
                // comment
                html5.append(">");
                html5.append(sbContent);
                html5.append("-->");
                break;
            case "br":
                // br
                html5.append(">");
                html5.append(sbContent);
                break;
            default:
                html5.append(">");
                html5.append(sbContent);
                html5.append("</").append(getTagName()).append(">");
                break;
        }

        return html5.toString();
    }

    @Override
    public String toString() {
        return getHtml5();
    }
}
