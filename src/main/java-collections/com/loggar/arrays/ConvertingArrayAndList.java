package com.loggar.arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ConvertingArrayAndList {
    @Test
    public void givenUsingCoreJava_whenListConvertedToArray_thenCorrect() {
        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
        @SuppressWarnings("unused") Integer[] targetArray = sourceList.toArray(new Integer[sourceList.size()]);
    }

    @Test
    public void givenUsingCoreJava_whenArrayConvertedToList_thenCorrect() {
        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
        @SuppressWarnings("unused") List<Integer> targetList = Arrays.asList(sourceArray);
    }

    // Apache Commons Collections – CollectionUtils.addAll API
    /*
    @Test
    public void givenUsingCommonsCollections_whenArrayConvertedToList_thenCorrect() {
        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
        List<Integer> targetList = new ArrayList<>(6);
        CollectionUtils.addAll(targetList, sourceArray);
    }
    */
}
