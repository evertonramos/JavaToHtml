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
import br.com.everton.html5.Input;
import br.com.everton.html5.Label;
import br.com.everton.html5.P;
import br.com.everton.html5.Textarea;

/**
 *
 * @author evertonramos
 */
public class BootstrapForm {

    private String formType = "form-vertical";
    private final Form form = new Form();
    private int labelColumnGrid = 0;
    private int inputColumnGrid = 0;
    private boolean screenReaderOnly = false;
    private boolean errors = true;
    private String errorClass = "erros";
    private String errorPrefix = "erro_";

    public void setInline() {
        this.form.addClassName("form-inline");
        this.formType = "form-inline";
        this.labelColumnGrid = 0;
        this.inputColumnGrid = 0;
        this.errors = false;
    }

    public void setHorizontal() {
        this.form.addClassName("form-horizontal");
        this.formType = "form-horizontal";
        this.labelColumnGrid = 2;
        this.inputColumnGrid = 10;
    }

    public boolean isVertical() {
        return this.formType.equals("form-vertical");
    }

    public boolean isInline() {
        return this.formType.equals("form-inline");
    }

    public boolean isHorizontal() {
        return this.formType.equals("form-horizontal");
    }

    public Form getForm() {
        return this.form;
    }

    public int getLabelColumnGrid() {
        return labelColumnGrid;
    }

    public void setLabelColumnGrid(int labelColumnGrid) {
        this.labelColumnGrid = labelColumnGrid;
    }

    public int getInputColumnGrid() {
        return inputColumnGrid;
    }

    public void setInputColumnGrid(int inputColumnGrid) {
        this.inputColumnGrid = inputColumnGrid;
    }

    public boolean isScreenReaderOnly() {
        return screenReaderOnly;
    }

    public void setScreenReaderOnly(boolean screenReaderOnly) {
        this.screenReaderOnly = screenReaderOnly;
    }

    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public String getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrorPrefix() {
        return errorPrefix;
    }

    public void setErrorPrefix(String errorPrefix) {
        this.errorPrefix = errorPrefix;
    }

    private void addFormGroup(Label label, Input input, P error) {
        Div formGroup = BootstrapFormControls.getFormGroup();

        formGroup.append(label);

        if (isHorizontal()) {
            Div div = BootstrapFormControls.getFormGroupDiv(getInputColumnGrid());

            div.append(input);

            if (isErrors()) {
                div.append(error);
            }

            formGroup.append(div);
        } else {
            formGroup.append(input);

            if (isErrors()) {
                formGroup.append(error);
            }
        }

        form.append(formGroup);
    }
    
    private void addFormGroup(Label label, Textarea textarea, P error) {
        Div formGroup = BootstrapFormControls.getFormGroup();

        formGroup.append(label);

        if (isHorizontal()) {
            Div div = BootstrapFormControls.getFormGroupDiv(getInputColumnGrid());

            div.append(textarea);

            if (isErrors()) {
                div.append(error);
            }

            formGroup.append(div);
        } else {
            formGroup.append(textarea);

            if (isErrors()) {
                formGroup.append(error);
            }
        }

        form.append(formGroup);
    }

    // button
    private void addButton(Button.Type type, String buttonId, String buttonValue, String buttonClass) {
        Button button = BootstrapFormControls.getButton(type, buttonId, buttonValue, buttonClass);

        if (isHorizontal()) {
            Div formGroup = BootstrapFormControls.getFormGroup();

            Div div = BootstrapFormControls.getFormGroupDiv(12 - getLabelColumnGrid());
            div.addClassName("col-sm-offset-" + getLabelColumnGrid());
            div.append(button);
            formGroup.append(div);

            form.append(formGroup);
        } else {
            form.append(button);
        }
    }
    
    // default
    public void addButton(Button.Type type, String buttonValue) {
        addButton(type, "", buttonValue);
    }
    
    public void addButton(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "default");
    }

    // primary
    public void addButtonPrimary(Button.Type type, String buttonValue) {
        addButtonPrimary(type, "", buttonValue);
    }
    
    public void addButtonPrimary(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "primary");
    }

    // secondary
    public void addButtonSecondary(Button.Type type, String buttonValue) {
        addButtonSecondary(type, "", buttonValue);
    }
    
    public void addButtonSecondary(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "secondary");
    }

    // success
    public void addButtonSuccess(Button.Type type, String buttonValue) {
        addButtonSuccess(type, "", buttonValue);
    }
    
    public void addButtonSuccess(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "success");
    }

    // info
    public void addButtonInfo(Button.Type type, String buttonValue) {
        addButtonInfo(type, "", buttonValue);
    }
    
    public void addButtonInfo(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "info");
    }

    // warning
    public void addButtonWarning(Button.Type type, String buttonValue) {
        addButtonWarning(type, "", buttonValue);
    }
    
    public void addButtonWarning(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "warning");
    }

    // danger
    public void addButtonDanger(Button.Type type, String buttonValue) {
        addButtonDanger(type, "", buttonValue);
    }
    
    public void addButtonDanger(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "danger");
    }

    // link
    public void addButtonLink(Button.Type type, String buttonValue) {
        addButtonLink(type, "", buttonValue);
    }
    
    public void addButtonLink(Button.Type type, String buttonId, String buttonValue) {
        addButton(type, buttonId, buttonValue, "link");
    }

    // email
    public void addInputEmail(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled, String errorMessage) {
        Label label = BootstrapFormControls.getFormGroupLabel(textLabel, inputId, getLabelColumnGrid(), isScreenReaderOnly());
        Input input = BootstrapFormControls.getInputEmail(inputId, inputPlaceholder, inputValue, disabled);
        P error = BootstrapFormControls.getFormGroupError(inputId, errorMessage, getErrorClass(), getErrorPrefix());

        addFormGroup(label, input, error);
    }
    
    public void addInputEmail(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled) {
        addInputEmail(inputId, textLabel, inputPlaceholder, inputValue, disabled, "");
    }
    
    // hidden
    public void addInputHidden(String inputId, String inputValue) {
        form.append(BootstrapFormControls.getInputHidden(inputId, inputValue));
    }
    
    // password
    public void addInputPassword(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled, String errorMessage) {
        Label label = BootstrapFormControls.getFormGroupLabel(textLabel, inputId, getLabelColumnGrid(), isScreenReaderOnly());
        Input input = BootstrapFormControls.getInputPassword(inputId, inputPlaceholder, inputValue, disabled);
        P error = BootstrapFormControls.getFormGroupError(inputId, errorMessage, getErrorClass(), getErrorPrefix());

        addFormGroup(label, input, error);
    }
    
    public void addInputPassword(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled) {
        addInputPassword(inputId, textLabel, inputPlaceholder, inputValue, disabled, "");
    }
    
    // text
    public void addInputText(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled, String errorMessage) {
        Label label = BootstrapFormControls.getFormGroupLabel(textLabel, inputId, getLabelColumnGrid(), isScreenReaderOnly());
        Input input = BootstrapFormControls.getInputText(inputId, inputPlaceholder, inputValue, disabled);
        P error = BootstrapFormControls.getFormGroupError(inputId, errorMessage, getErrorClass(), getErrorPrefix());

        addFormGroup(label, input, error);
    }

    public void addInputText(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled) {
        addInputText(inputId, textLabel, inputPlaceholder, inputValue, disabled, "");
    }
    
    // number
    public void addInputNumber(String inputId, String textLabel, String inputPlaceholder, double inputValue, boolean disabled, double minNumber, double maxNumber, double stepNumber, String errorMessage) {
        Label label = BootstrapFormControls.getFormGroupLabel(textLabel, inputId, getLabelColumnGrid(), isScreenReaderOnly());
        Input input = BootstrapFormControls.getInputNumber(inputId, inputPlaceholder, inputValue, disabled, minNumber, maxNumber, stepNumber); 
        P error = BootstrapFormControls.getFormGroupError(inputId, errorMessage, getErrorClass(), getErrorPrefix());

        addFormGroup(label, input, error);
    }
    
    public void addInputNumber(String inputId, String textLabel, String inputPlaceholder, double inputValue, boolean disabled, double minNumber, double maxNumber, double stepNumber) {
        addInputNumber(inputId, textLabel, inputPlaceholder, inputValue, disabled, minNumber, maxNumber, stepNumber, "");
    }

    // textarea
    public void addTextarea(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled, int rows, String errorMessage) {
        Label label = BootstrapFormControls.getFormGroupLabel(textLabel, inputId, getLabelColumnGrid(), isScreenReaderOnly());
        Textarea textarea = BootstrapFormControls.getTextarea(inputId, inputPlaceholder, inputValue, disabled, rows); 
        P error = BootstrapFormControls.getFormGroupError(inputId, errorMessage, getErrorClass(), getErrorPrefix());

        addFormGroup(label, textarea, error);
    }
    
    public void addTextarea(String inputId, String textLabel, String inputPlaceholder, String inputValue, boolean disabled, int rows) {
        addTextarea(inputId, textLabel, inputPlaceholder, inputValue, disabled, rows, "");
    }
    
    @Override
    public String toString() {
        return form.toString();
    }
}
