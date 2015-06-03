package com.andre.mvc.schedule;

import java.lang.reflect.Method;

/**
 * Created by Khemrayev A.K. on 20.05.2015.
 */
public class Task {
    private Method method;
    private Object argument;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
