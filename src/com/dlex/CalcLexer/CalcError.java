package com.dlex.CalcLexer;

abstract class CalcError extends Exception {
    protected String errorMessage = null;

    public CalcError() {
        this.errorMessage = null;
    }

    protected CalcError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    protected String getErrorMessage() {
        return errorMessage;
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}