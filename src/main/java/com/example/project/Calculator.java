/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

public class Calculator {

    public String authorName = "John Doe";
    public String authorEmail = "john.doe@gmail.com";

    public double add(double... params) {
		checkArguments(params);
        double result = 0;
        for (int i = 0; i < params.length; i++) {
            result += params[i];
        }
        return result;
    }

    public double multiply(double... params) {
		checkArguments(params);
        double result = 1;
        for (int i = 0; i < params.length; i++) {
            result *= params[i];
        }
        return result;
    }

    public double subtract(double... params) {
		checkArguments(params);
        double result = params[0];
        for (int i = 1; i < params.length; i++) {
            result -= params[i];
        }
        return result;
    }

    public double divide(double... params) {
		checkArguments(params);
        double result = params[0];
        for (int i = 1; i < params.length; i++) {
            if (params[i] == 0) {
                throw new IllegalArgumentException("Cannot divide something by 0.");
            }
            result /= params[i];
        }
        return result;
    }

    private void checkArguments(double... params) {
		if (params.length < 2) {
			throw new IllegalArgumentException("At least two arguments must be provided!");
		}
	}

}
