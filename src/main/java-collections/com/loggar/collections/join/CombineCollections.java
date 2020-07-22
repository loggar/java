package com.loggar.collections.join;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineCollections {
	Collection<String> collectionA = Arrays.asList("A", "B");
	Collection<String> collectionB = Arrays.asList("C", "D");
	Collection<String> collectionC = Arrays.asList("E", "F");

	void using_concat() {
		@SuppressWarnings("unused") Stream<String> combinedStream = Stream.concat(collectionA.stream(), collectionB.stream());
	}

	void using_concat_moreThanTwo() {
		@SuppressWarnings("unused") Stream<String> combinedStream = Stream.concat(Stream.concat(collectionA.stream(), collectionB.stream()), collectionC.stream());
	}

	void using_flatMap() {
		Stream<String> combinedStream = Stream.of(collectionA, collectionB).flatMap(Collection::stream);
		@SuppressWarnings("unused") Collection<String> collectionCombined = combinedStream.collect(Collectors.toList());
	}
}
