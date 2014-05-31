/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.util.Collection;

/**
 *
 * @author Gustavo
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }
}
