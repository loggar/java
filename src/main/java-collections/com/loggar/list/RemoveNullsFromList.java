package com.loggar.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.junit.jupiter.api.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class RemoveNullsFromList {
    // Remove Nulls From a List Using Plain Java
    @Test
    public void givenListContainsNulls_whenRemovingNullsWithPlainJava_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, null);
        while (list.remove(null))
            ;

        assertThat(list, hasSize(1));
    }

    @Test
    public void givenListContainsNulls_whenRemovingNullsWithPlainJavaAlternative_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, null);
        list.removeAll(Collections.singleton(null));

        assertThat(list, hasSize(1));
    }

    // Remove Nulls From a List Using Lambdas (Java 8)
    @Test
    public void givenListContainsNulls_whenFilteringParallel_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls = list.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        assertThat(listWithoutNulls, hasSize(3));
    }

    @Test
    public void givenListContainsNulls_whenFilteringSerial_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        assertThat(listWithoutNulls, hasSize(3));
    }

    public void givenListContainsNulls_whenRemovingNullsWithRemoveIf_thenCorrect() {
        List<Integer> listWithoutNulls = Lists.newArrayList(null, 1, 2, null, 3, null);
        listWithoutNulls.removeIf(Objects::isNull);

        assertThat(listWithoutNulls, hasSize(3));
    }

    // Remove Nulls From a List Using Google Guava
    @Test
    public void givenListContainsNulls_whenRemovingNullsWithGuavaV1_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, null);
        Iterables.removeIf(list, Predicates.isNull());

        assertThat(list, hasSize(1));
    }

    @Test
    public void givenListContainsNulls_whenRemovingNullsWithGuavaV2_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, null, 2, 3);
        List<Integer> listWithoutNulls = Lists.newArrayList(Iterables.filter(list, Predicates.notNull()));

        assertThat(listWithoutNulls, hasSize(3));
    }

    // Remove Nulls From a List Using Apache Commons Collections
    @Test
    public void givenListContainsNulls_whenRemovingNullsWithCommonsCollections_thenCorrect() {
        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        CollectionUtils.filter(list, PredicateUtils.notNullPredicate());

        assertThat(list, hasSize(3));
    }
}
