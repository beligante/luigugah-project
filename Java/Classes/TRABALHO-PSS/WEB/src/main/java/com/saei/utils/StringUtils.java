package com.saei.utils;

import java.util.Collection;

public class StringUtils {
    
    public static boolean isBlank(String string){
        return (string == null || string.isEmpty());
    }
    
    public static boolean isNotBlank(String string){
        return !(string == null || string.isEmpty());
    }
    
    public static boolean isAnyParamEmpty(Collection<String>  colecao){
        if(CollectionUtils.isEmpty(colecao)){return true;}
        
        for (String elemento : colecao) {
            if(isBlank(elemento)){return true;}
        }
        
        return false;
    }
}
