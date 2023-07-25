package com.felipe.dscommerce.services.exceptions;

public class DataBaseException extends RuntimeException { /*RuntimeException não exige o try cath*/

    public DataBaseException(String msg){
        super(msg);
    }


}
