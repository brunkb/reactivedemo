package com.improving.reactivedemo;

public class Details {

    private Args args;

    public Args getArgs() {
        if (args == null) {
            return new Args();
        }
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }
}
