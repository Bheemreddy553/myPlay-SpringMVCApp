package com.reddy.my_show.common;

/**
 * Created by varshini on 26/9/15.
 */
public class MyShowExceptionFactory {

    private static MyShowExceptionFactory instance = new MyShowExceptionFactory() ;

    private MyShowExceptionFactory(){}

    public static  MyShowExceptionFactory getInstance(){
        return instance;
    }



    public MyShowException getMyException(String errorCode,String errorMessage,String additionalDetails){
       MyShowException myShowException = new MyShowException();

        synchronized (this){
            myShowException.setErrorCode(errorCode);
            myShowException.setErrorMessage(errorMessage);
            myShowException.setAdditionalDetails(additionalDetails);
        }

        return myShowException;
    }


}
