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
package br.com.everton.bootstrap;

import br.com.everton.html5.Button;
import br.com.everton.html5.Div;
import br.com.everton.html5.Form;
import br.com.everton.html5.Html5;
import br.com.everton.html5.Input;
import br.com.everton.html5.Label;
import br.com.everton.html5.Option;
import br.com.everton.html5.P;
import br.com.everton.html5.Select;
import br.com.everton.html5.Textarea;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author evertonramos
 */
public class BootstrapFormControls {

    public static Form getFormVertical() {
        return new Form();
    }

    public static Form getFormInline() {
        Form form = new Form();
        form.addClassName("form-inline");

        return form;
    }

    public static Form getFormHorizontal() {
        Form form = new Form();
        form.addClassName("form-horizontal");

        return form;
    }

    public static Div getFormGroup() {
        Div div = new Div();
        div.addClassName("form-group");

        return div;
    }

    public static Label getFormGroupLabel(String textLabel, String forName, int columnGrid, boolean screenReaderOnly) {
        Label label = new Label(textLabel);

        if (screenReaderOnly) {
            label.addClassName("sr-only");
        }

        if (columnGrid > 0) {
            label.addClassName("control-label");
            label.addClassName("col-sm-" + columnGrid);
        }

        if (!forName.isEmpty()) {
            label.setFor(forName);
        }

        return label;
    }

    public static Div getFormGroupDiv(int columnGrid) {
        Div div = new Div();

        if (columnGrid > 0) {
            div.addClassName("col-sm-" + columnGrid);
        }

        return div;
    }

    public static P getFormGroupError(String id, String errorMessage, String errorClass, String errorPrefix) {
        P p = new P(errorMessage);

        p.addClassName(errorClass);
        p.setIdAttribute(errorPrefix + id);
        p.addStyle("display", "none");
        p.addStyle("color", "red");
        p.addStyle("font-size", "1em");

        return p;
    }

    private static Input getInput(Input.Type type, String inputId, String inputPlaceholder, String inputValue, boolean disabled, double minNumber, double maxNumber, double stepNumber) {
        // input
        Input input = new Input();
        input.setType(type);
        input.addClassName("form-control");

        if (!inputId.isEmpty()) {
            input.setIdAttribute(inputId);
            input.setName(inputId);
        }

        if (!inputPlaceholder.isEmpty()) {
            input.setPlaceholder(inputPlaceholder);
        }

        if (!inputValue.isEmpty()) {
            input.setValue(inputValue);
        }

        if (disabled) {
            input.setDisabled();
        }

        if (type.equals(Input.Type.TNumber)) {
            input.setMin(minNumber);
            input.setMax(maxNumber);
            input.setStep(stepNumber);

            input.setTextAlign(Html5.TextAlign.RIGHT);
        }

        return input;
    }

    // checkbox
    public static Input getInputCheckbox(String checkboxId, boolean checked, boolean disabled) {
        // input
        Input input = new Input();
        input.setType(Input.Type.TCheckbox);

        if (!checkboxId.isEmpty()) {
            input.setIdAttribute(checkboxId);
            input.setName(checkboxId);
        }

        if (checked) {
            input.setChecked();
        }

        if (disabled) {
            input.setDisabled();
        }

        return input;
    }

    // email
    public static Input getInputEmail(String inputId, String inputPlaceholder, String inputValue, boolean disabled) {
        return getInput(Input.Type.TEmail, inputId, inputPlaceholder, inputValue, disabled, 0, 0, 0);
    }

    // hidden
    public static Input getInputHidden(String inputId, String inputValue) {
        Input input = new Input();
        input.setType(Input.Type.THidden);

        if (!inputId.isEmpty()) {
            input.setIdAttribute(inputId);
            input.setName(inputId);
        }

        if (!inputValue.isEmpty()) {
            input.setValue(inputValue);
        }

        return input;
    }

    // password
    public static Input getInputPassword(String inputId, String inputPlaceholder, String inputValue, boolean disabled) {
        return getInput(Input.Type.TPassword, inputId, inputPlaceholder, inputValue, disabled, 0, 0, 0);
    }

    // text
    public static Input getInputText(String inputId, String inputPlaceholder, String inputValue, boolean disabled) {
        return getInput(Input.Type.TText, inputId, inputPlaceholder, inputValue, disabled, 0, 0, 0);
    }

    // number
    public static Input getInputNumber(String inputId, String inputPlaceholder, double inputValue, boolean disabled, double minNumber, double maxNumber, double stepNumber) {
        return getInput(Input.Type.TNumber, inputId, inputPlaceholder, Double.toString(inputValue), disabled, minNumber, maxNumber, stepNumber);
    }

    // select (Map)
    // todo https://silviomoreto.github.io/bootstrap-select/
    public static Select getSelect(String selectId, boolean blankOption, Map<String, String> selectOptions, String selectValue, boolean disabled) {
        Select select = new Select();
        select.addClassName("form-control");

        if (!selectId.isEmpty()) {
            select.setIdAttribute(selectId);
            select.setName(selectId);
        }

        if (blankOption) {
            select.addOption(new Option());
        }
        
        if(disabled) {
            select.setDisabled();
        }

        // options
        if (selectOptions != null) {
            selectOptions.forEach((k, v) -> {
                Option o = new Option(v);

                o.setValue(k);

                if (k.equals(selectValue)) {
                    o.setSelected();
                }

                select.addOption(o);
            });
        }

        return select;
    }

    // select (ResultSet)
    public static Select getSelect(String selectId, boolean blankOption, ResultSet selectOptions, String selectValue, boolean disabled) throws Exception {
        Map<String, String> options = new LinkedHashMap<String, String>();

        if (selectOptions != null) {
            while (selectOptions.next()) {
                options.put(selectOptions.getString(1), selectOptions.getString(2));
            }
        }

        return getSelect(selectId, blankOption, options, selectValue, disabled);
    }

    // select (ArrayList)
    public static Select getSelect(String selectId, boolean blankOption, ArrayList<String> selectOptions, String selectValue, boolean disabled) {
        Map<String, String> options = new LinkedHashMap<String, String>();

        if (selectOptions != null) {
            selectOptions.forEach((v) -> {
                options.put(v, v);
            });
        }

        return getSelect(selectId, blankOption, options, selectValue, disabled);
    }

    // textarea
    public static Textarea getTextarea(String textareaId, String textareaPlaceholder, String textareaValue, boolean disabled, int rows) {
        Textarea textarea = new Textarea();
        textarea.addClassName("form-control");
        textarea.addStyle("resize", "none");

        if (!textareaId.isEmpty()) {
            textarea.setIdAttribute(textareaId);
            textarea.setName(textareaId);
        }

        if (!textareaPlaceholder.isEmpty()) {
            textarea.setPlaceholder(textareaPlaceholder);
        }

        if (!textareaValue.isEmpty()) {
            textarea.setValue(textareaValue);
        }

        if (disabled) {
            textarea.setDisabled();
        }

        if (rows > 0) {
            textarea.setRows(rows);
        }

        return textarea;
    }

    // button
    public static Button getButton(Button.Type type, String buttonId, String buttonValue, String buttonClass) {
        Button button = new Button(buttonValue);
        button.setType(type);

        if (!buttonId.isEmpty()) {
            button.setIdAttribute(buttonId);
        }

        button.addClassName("btn");
        button.addClassName("btn-" + buttonClass);

        return button;
    }

}
