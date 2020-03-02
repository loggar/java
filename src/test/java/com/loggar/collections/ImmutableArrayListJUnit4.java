package com.loggar.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ImmutableArrayListJUnit4 {
    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add("four");
    }
}
