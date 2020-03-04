package com.loggar.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCopyUsingStream {
    List<Integer> list;

    public static void main(String[] args) {
        ListCopyUsingStream listCopy = new ListCopyUsingStream();
        listCopy.using_stream_1();
        listCopy.using_stream_2();
        listCopy.using_stream_3();
        listCopy.using_stream_4();
        listCopy.using_stream_5();
        listCopy.using_stream_6();
        listCopy.using_stream_7();
    }

    public ListCopyUsingStream() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
    }

    public void using_stream_1() {
        List<Integer> copy = list.stream()
                .collect(Collectors.toList());

        System.out.println(copy);
    }

    public void using_stream_2() {
        List<Integer> copy = list.stream()
                .collect(Collectors.toList());

        System.out.println(copy);
    }

    public void using_stream_3() {
        List<Integer> copy = list.stream()
                .skip(1)
                .collect(Collectors.toList());

        System.out.println(copy);
    }

    public void using_stream_4() {
        List<String> list = new ArrayList<>();
        list.add("asdfasd");
        list.add("sdfasdfasdfasdf");
        list.add("qwekjlqkeekekekekeek");

        List<String> copy = list.stream()
                .filter(s -> s.length() > 10)
                .collect(Collectors.toList());

        System.out.println(copy);
    }

    public void using_stream_5() {
        List<Flower> list = new ArrayList<>();
        list.add(new Flower(5));
        list.add(new Flower(6));
        list.add(new Flower(7));

        List<Flower> flowers = list.stream()
                .filter(f -> f.getPetals() > 5)
                .collect(Collectors.toList());

        System.out.println(flowers);
    }

    public void using_stream_6() {
        List<Flower> list = new ArrayList<>();
        list.add(new Flower(5));
        list.add(new Flower(6));
        list.add(new Flower(7));

        // work in a null-safe way
        List<Flower> flowers = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());

        System.out.println(flowers);
    }

    public void using_stream_7() {
        List<Flower> list = new ArrayList<>();
        list.add(new Flower(5));
        list.add(new Flower(6));
        list.add(new Flower(7));

        // skip an element
        List<Flower> flowers = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .skip(1)
                .collect(Collectors.toList());

        System.out.println(flowers);
    }

    class Flower {
        int petals;

        public Flower(int petals) {
            super();
            this.petals = petals;
        }

        public int getPetals() {
            return petals;
        }

        public void setPetals(int petals) {
            this.petals = petals;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Flower [petals=")
                    .append(petals)
                    .append("]");
            return builder.toString();
        }

    }

}
