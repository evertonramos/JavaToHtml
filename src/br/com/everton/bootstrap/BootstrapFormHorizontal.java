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

import br.com.everton.html5.Div;
import br.com.everton.html5.Form;
import br.com.everton.html5.Input;
import br.com.everton.html5.Label;
import br.com.everton.html5.Option;
import br.com.everton.html5.P;
import br.com.everton.html5.Select;
import java.util.Map;

/**
 *
 * @author evertonramos
 */
public class BootstrapFormHorizontal {

    public static Form getForm() {
        Form form = new Form();
        form.addClassName("form-horizontal");

        return form;
    }

    private static String getInput(Input.Type type, String inputId, String inputLabel, String inputPlaceholder, String inputValue, int leftColumn, int rightColumn, boolean error, String errorMessage) {
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

        // divFormGroup
        Div divFormGroup = new Div();
        divFormGroup.addClassName("form-group");

        // div
        Div div = new Div();

        // label
        if (!inputLabel.isEmpty()) {
            Label label = new Label(inputLabel);
            label.addClassName("control-label");
            label.addClassName("col-sm-" + leftColumn);

            if (!inputId.isEmpty()) {
                label.setFor(inputId);
            }

            divFormGroup.append(label);
        } else {
            if (leftColumn > 0) {
                div.addClassName("col-sm-offset-" + leftColumn);
            }
        }

        // div        
        div.addClassName("col-sm-" + rightColumn);

        div.append(input);

        if ((error) && (!inputId.isEmpty())) {
            div.append(getError(inputId, errorMessage));
        }

        divFormGroup.append(div);

        return divFormGroup.toString();
    }

    private static String getError(String inputId, String errorMessage) {
        P p = new P(errorMessage);

        p.addClassName("errors");
        p.setIdAttribute("error_" + inputId);
        p.addStyle("display", "none");
        p.addStyle("color", "red");
        p.addStyle("font-size", "1em");

        return p.toString();
    }

    // button
    // checkbox
    public static String getInputCheckbox(String inputId, String inputLabel, boolean checked, int leftColumn, int rightColumn, boolean error, String errorMessage) {
        Div divFormGroup = new Div();
        divFormGroup.addClassName("form-group");

        Div div = new Div();
        div.addClassName("col-sm-offset-" + leftColumn);
        div.addClassName("col-sm-" + rightColumn);

        Div divCheckbox = new Div();
        divCheckbox.addClassName("checkbox");

        Label label = new Label();

        Input input = new Input();
        input.setType(Input.Type.TCheckbox);

        if (!inputId.isEmpty()) {
            input.setIdAttribute(inputId);
            input.setName(inputId);
        }

        label.append(input);

        if (!inputLabel.isEmpty()) {
            label.append(" " + inputLabel);
        }

        divCheckbox.append(label);

        div.append(divCheckbox);

        if ((error) && (!inputId.isEmpty())) {
            div.append(getError(inputId, errorMessage));
        }

        divFormGroup.append(div);

        return divFormGroup.toString();
    }
    // color
    // date
    // datetimelocal
    
    // email
    public static String getInputEmail(String inputId, String inputLabel, String inputPlaceholder, String inputValue, int leftColumn, int rightColumn, boolean error, String errorMessage) {
        return getInput(Input.Type.TEmail, inputId, inputLabel, inputPlaceholder, inputValue, leftColumn, rightColumn, error, errorMessage);
    }
    
    // file
    
    // hidden
    public static String getInputHidden(String inputId, String inputValue) {
        Input input = new Input();
        input.setType(Input.Type.THidden);

        if (!inputId.isEmpty()) {
            input.setIdAttribute(inputId);
            input.setName(inputId);
        }

        if (!inputValue.isEmpty()) {
            input.setValue(inputValue);
        }

        return input.toString();
    }

    // password
    public static String getInputPassword(String inputId, String inputLabel, String inputPlaceholder, String inputValue, int leftColumn, int rightColumn, boolean error, String errorMessage) {
        return getInput(Input.Type.TPassword, inputId, inputLabel, inputPlaceholder, inputValue, leftColumn, rightColumn, error, errorMessage);
    }

    // text
    public static String getInputText(String inputId, String inputLabel, String inputPlaceholder, String inputValue, int leftColumn, int rightColumn, boolean error, String errorMessage) {
        return getInput(Input.Type.TText, inputId, inputLabel, inputPlaceholder, inputValue, leftColumn, rightColumn, error, errorMessage);
    }
    
    // select
    public static String getSelect(String selectId, String selectLabel, Map<String, String> selectOptions, String selectValue, int leftColumn, int rightColumn, boolean error, String errorMessage) {
        // select
        Select select = new Select();
        select.addClassName("form-control");

        if (!selectId.isEmpty()) {
            select.setIdAttribute(selectId);
            select.setName(selectId);
        }
        
        // options
        selectOptions.forEach((k, v) -> {
            Option o = new Option(v);
            
            o.setValue(k);
            
            select.addOption(o);
        });

        // divFormGroup
        Div divFormGroup = new Div();
        divFormGroup.addClassName("form-group");

        // div
        Div div = new Div();

        // label
        if (!selectLabel.isEmpty()) {
            Label label = new Label(selectLabel);
            label.addClassName("control-label");
            label.addClassName("col-sm-" + leftColumn);

            if (!selectId.isEmpty()) {
                label.setFor(selectId);
            }

            divFormGroup.append(label);
        } else {
            if (leftColumn > 0) {
                div.addClassName("col-sm-offset-" + leftColumn);
            }
        }

        // div        
        div.addClassName("col-sm-" + rightColumn);

        div.append(select);

        if ((error) && (!selectId.isEmpty())) {
            div.append(getError(selectId, errorMessage));
        }

        divFormGroup.append(div);

        return divFormGroup.toString();
    }
}
