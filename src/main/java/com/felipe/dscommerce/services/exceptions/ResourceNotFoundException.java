package com.felipe.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { /*RuntimeException não exige o try cath*/

    public ResourceNotFoundException(String msg){
        super(msg);
    }


}
