package com.loggar.collectors;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.partitioningBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

public class CollectorsGrouping {
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void summarizing() {
        // Collectors.summarizingDouble/Long/Int()
        DoubleSummaryStatistics result = givenList.stream()
                .collect(summarizingDouble(String::length));

        assertThat(result.getAverage()).isEqualTo(2);
        assertThat(result.getCount()).isEqualTo(4);
        assertThat(result.getMax()).isEqualTo(3);
        assertThat(result.getMin()).isEqualTo(1);
        assertThat(result.getSum()).isEqualTo(8);
    }

    @Test
    public void averaging() {
        // Collectors.averagingDouble/Long/Int()
        Double result = givenList.stream()
                .collect(averagingDouble(String::length));

        System.out.println(result);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void max_min() {
        // Collectors.maxBy()/minBy()
        Optional<String> result = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));

        System.out.println(result.get());
        assertThat(result.get()).isEqualTo("dd");
    }

    @Test
    public void grouping() {
        // Collectors.groupingBy()
        Map<Integer, Set<String>> result = givenList.stream()
                .collect(groupingBy(String::length, toSet()));

        System.out.println(result);

        assertThat(result).containsEntry(1, Sets.newLinkedHashSet("a"))
                .containsEntry(2, Sets.newLinkedHashSet("bb", "dd"))
                .containsEntry(3, Sets.newLinkedHashSet("ccc"));
    }

    @Test
    public void partitioning() {
        // Collectors.partitioningBy()
        Map<Boolean, List<String>> result = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));

        System.out.println(result);
        List<String> listTrue = result.get(true);
        List<String> listFalse = result.get(false);

        assertThat(listTrue.size()).isEqualTo(1);
        assertThat(listFalse.size()).isEqualTo(3);
    }
}
