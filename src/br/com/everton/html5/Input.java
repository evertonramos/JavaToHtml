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
 * Defines an input control
 *
 * @author evertonramos
 */
public class Input extends Html5 {

    private String name = "";

    public Input() {
        super("input");
    }

    /**
     * The type attribute specifies the type of input element to display. The
     * default type is text.
     */
    public enum Type {
        /**
         * Defines a clickable button (mostly used with a JavaScript to activate
         * a script)
         */
        TButton,
        /**
         * Defines a checkbox
         */
        TCheckbox,
        /**
         * Defines a color picker
         */
        TColor,
        /**
         * Defines a date and time control (year, month, day, hour, minute,
         * second, and fraction of a second (no time zone)
         */
        TDate,
        /**
         * Defines a date control (year, month and day (no time))
         */
        TDatetimeLocal,
        /**
         * Defines a field for an e-mail address
         */
        TEmail,
        /**
         * Defines a file-select field and a "Browse..." button (for file
         * uploads)
         */
        TFile,
        /**
         * Defines a hidden input field
         */
        THidden,
        /**
         * Defines an image as the submit button
         */
        TImage,
        /**
         * Defines a month and year control (no time zone)
         */
        TMonth,
        /**
         * Defines a field for entering a number
         */
        TNumber,
        /**
         * Defines a password field (characters are masked)
         */
        TPassword,
        /**
         * Defines a radio button
         */
        TRadio,
        /**
         * Defines a control for entering a number whose exact value is not
         * important (like a slider control). Default range is from 0 to 100
         */
        TRange,
        /**
         * Defines a reset button (resets all form values to default values)
         */
        TReset,
        /**
         * Defines a text field for entering a search string
         */
        TSearch,
        /**
         * Defines a submit button
         */
        TSubmit,
        /**
         * Defines a field for entering a telephone number
         */
        TTel,
        /**
         * Default. Defines a single-line text field (default width is 20
         * characters)
         */
        TText,
        /**
         * Defines a control for entering a time (no time zone)
         */
        TTime,
        /**
         * Defines a field for entering a URL
         */
        TUrl,
        /**
         * Defines a week and year control (no time zone)
         */
        TWeek;

        @Override
        public String toString() {
            switch (this) {
                case TButton:
                    return "button";
                case TCheckbox:
                    return "checkbox";
                case TColor:
                    return "color";
                case TDate:
                    return "date";
                case TDatetimeLocal:
                    return "datetime-local";
                case TEmail:
                    return "email";
                case TFile:
                    return "file";
                case THidden:
                    return "hidden";
                case TImage:
                    return "image";
                case TMonth:
                    return "month";
                case TNumber:
                    return "number";
                case TPassword:
                    return "password";
                case TRadio:
                    return "radio";
                case TRange:
                    return "range";
                case TReset:
                    return "reset";
                case TSearch:
                    return "search";
                case TSubmit:
                    return "submit";
                case TTel:
                    return "tel";
                case TTime:
                    return "time";
                case TUrl:
                    return "url";
                case TWeek:
                    return "week";
                default:
                    return "text";
            }
        }
    }

    public void setType(Type type) {
        addCustomAttribute("type", type.toString());
    }

    public void setName(String name) {
        this.name = name;

        addCustomAttribute("name", this.name);
    }

    public String getFor() {
        return this.name;
    }

    public void setValue(String value) {
        addCustomAttribute("value", value);
    }

    public void setPlaceholder(String text) {
        addCustomAttribute("placeholder", text);
    }

    // https://www.w3schools.com/tags/tag_input.asp
}
