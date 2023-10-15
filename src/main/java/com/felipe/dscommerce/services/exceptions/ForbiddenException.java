package com.felipe.dscommerce.services.exceptions;

public class ForbiddenException extends RuntimeException { /*RuntimeException não exige o try cath*/

    public ForbiddenException(String msg){
        super(msg);
    }


}
