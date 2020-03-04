package com.loggar.list.remove;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class ListRemoving {
    @Test
    public void removeIndex() {
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        Collections.reverse(list);

        list.remove(0);
        assertThat(list.get(0), equalTo(8));

        list.remove(Integer.valueOf(0));
        assertFalse(list.contains(0));

    }

    @Test
    public void removeIt() {
        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toCollection(ArrayList::new));

        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        System.out.println(stringsToSearch);

        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        Iterator<String> it = stringsToSearch.iterator();
        while (it.hasNext()) {
            if (matchingStrings.contains(it.next())) {
                it.remove();
            }
        }

        System.out.println(stringsToSearch);
        assertTrue(stringsToSearch.size() == 20);

    }
}
