package com.reddy.my_show.common;

/**
 * Created by varshini on 26/9/15.
 */
public class MyShowException extends Exception {

    private String  errorCode;
    private String  errorMessage;
    private String  additionalDetails;

    public MyShowException(){}


    public MyShowException(String errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



    public MyShowException(String errorCode,String errorMessage,String additionalDetails){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.additionalDetails = additionalDetails;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
