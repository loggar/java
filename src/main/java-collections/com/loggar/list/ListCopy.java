package com.loggar.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCopy {
    List<Integer> list;

    public static void main(String[] args) {
        ListCopy listCopy = new ListCopy();
        listCopy.using_collection_copy_1();
        listCopy.using_collection_copy_2();
    }

    public ListCopy() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
    }

    public void using_constructor() {
        List<Integer> copy = new ArrayList<>(list);
        System.out.println(copy.size());
    }

    public void using_addAll() {
        List<Integer> copy = new ArrayList<>();
        copy.addAll(list);
        System.out.println(copy.size());
    }

    public void using_collection_copy_1() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(4, 5, 6);
        Collections.copy(dest, source);

        System.out.println(dest);
    }

    public void using_collection_copy_2() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(5, 6, 7, 8, 9, 10);
        Collections.copy(dest, source);

        System.out.println(dest);
    }
}
