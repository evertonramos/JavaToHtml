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

/**
 *
 * @author evertonramos
 */
public class BootstrapAlert {

    private static String getAlert(String message, String className) {
        Div div = new Div(message);

        div.addClassName("alert");
        div.addClassName(className);

        return div.toString();
    }

    public static String getAlertSuccess(String message) {
        return getAlert(message, "alert-success");
    }

    public static String getAlertInfo(String message) {
        return getAlert(message, "alert-info");
    }

    public static String getAlertWarning(String message) {
        return getAlert(message, "alert-warning");
    }

    public static String getAlertDanger(String message) {
        return getAlert(message, "alert-danger");
    }

}
