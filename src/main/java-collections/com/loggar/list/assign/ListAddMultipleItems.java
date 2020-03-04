package com.loggar.list.assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ListAddMultipleItems {
    public void addMultipleItems_addAll() {
        List<Integer> list = new ArrayList<>();
        List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);
        list.addAll(anotherList);
    }

    public void addMultipleItems_collections_addAll_1() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
    }

    public void addMultipleItems_collections_addAll_2() {
        List<Integer> list = new ArrayList<>();
        Integer[] otherList = new Integer[] { 1, 2, 3, 4, 5 };
        Collections.addAll(list, otherList);
    }

    public void addMultipleItems_stream_1() {
        List<Integer> source = Arrays.asList(5, 12, 9, 3, 15, 88);
        List<Integer> target = new ArrayList<>();

        source.stream()
                .forEachOrdered(target::add);
    }

    public void addMultipleItems_stream_2() {
        List<Integer> source = Arrays.asList(5, 12, 9, 3, 15, 88);
        List<Integer> target = new ArrayList<>();

        source.stream()
                .skip(1)
                .forEachOrdered(target::add);
    }

    public void addMultipleItems_stream_3() {
        List<Integer> source = Arrays.asList(5, 12, 9, 3, 15, 88);
        List<Integer> target = new ArrayList<>();

        source.stream()
                .filter(i -> i > 10)
                .forEachOrdered(target::add);
    }

    public void addMultipleItems_stream_4_nullSafe() {
        List<Integer> source = Arrays.asList(5, 12, 9, 3, 15, 88);
        List<Integer> target = new ArrayList<>();

        Optional.ofNullable(source)
                .ifPresent(target::addAll);
    }
}
