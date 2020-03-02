package com.loggar.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListUtil {
    private ArrayListUtil() {
        throw new AssertionError(ArrayListUtil.class.getName() + " cannot be instantiable.");
    }

    public static int getArrayListCapacity(ArrayList<?> list) throws Exception {

        // get the elementData field from ArrayList class
        Field arrayField = ArrayList.class.getDeclaredField("elementData");

        /*
         * Since the elementData field is private, we need to make it accessible first
         */
        arrayField.setAccessible(true);

        // now get the elementData Object array from our list
        Object[] internalArray = (Object[]) arrayField.get(list);

        // Internal array length is the ArrayList capacity!
        return internalArray.length;
    }
}
