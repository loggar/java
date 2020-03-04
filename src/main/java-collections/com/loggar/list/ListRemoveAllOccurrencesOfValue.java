package com.loggar.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListRemoveAllOccurrencesOfValue {
    List<Integer> list;
    List<Integer> list2;
    int valueToRemove = 1;

    @BeforeEach
    void beforeEach() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);

        list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(3);
    }

    void removeAllWrong(List<Integer> list, int element) {
        while (list.contains(element)) {
            list.remove(element);
        }
    }

    @Test
    public void removeAllWrongTest() {
        assertThatThrownBy(() -> removeAllWrong(list, valueToRemove)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    void removeAll(List<Integer> list, Integer element) {
        while (list.contains(element)) {
            list.remove(element);
        }
    }

    @Test
    public void removeAllTest() {
        removeAll(list, valueToRemove);
        assertThat(list).isEqualTo(list2);
    }

    void removeAllBetter(List<Integer> list, Integer element) {
        // Since List.contains() and List.remove() both have to find the first occurrence of the element, this code causes unnecessary element traversal.
        int index;
        while ((index = list.indexOf(element)) >= 0) {
            list.remove(index);
        }
    }

    @Test
    public void removeAllBetterTest() {
        removeAllBetter(list, valueToRemove);
        assertThat(list).isEqualTo(list2);
    }

    void removeAll_iterator(List<Integer> list, int element) {
        for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer number = i.next();
            if (Objects.equals(number, element)) {
                i.remove();
            }
        }
    }

    @Test
    public void removeAll_iterator_test() {
        removeAll_iterator(list, valueToRemove);
        assertThat(list).isEqualTo(list2);
    }

    List<Integer> removeAll_collecting1(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }
        return remainingElements;
    }

    @Test
    public void removeAll_collecting1_test() {
        List<Integer> result = removeAll_collecting1(list, valueToRemove);
        assertThat(result).isEqualTo(list2);
    }

    void removeAll_collecting2(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }

        list.clear();
        list.addAll(remainingElements);
    }

    @Test
    public void removeAll_collecting2_test() {
        removeAll_collecting2(list, valueToRemove);
        assertThat(list).isEqualTo(list2);
    }

    List<Integer> removeAll_streamAPI(List<Integer> list, int element) {
        return list.stream()
                .filter(e -> !Objects.equals(e, element))
                .collect(Collectors.toList());
    }

    @Test
    public void removeAll_streamAPI_test() {
        List<Integer> result = removeAll_streamAPI(list, valueToRemove);
        assertThat(result).isEqualTo(list2);
    }

    void removeAll_removeIf(List<Integer> list, int element) {
        list.removeIf(n -> Objects.equals(n, element));
    }

    @Test
    public void removeAll_removeIf_test() {
        removeAll_removeIf(list, valueToRemove);
        assertThat(list).isEqualTo(list2);
    }
}
