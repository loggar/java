package com.loggar.list.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;

public class ShuffleCollections {
	public void shufflingList() {
		List<String> students_1 = Arrays.asList("Foo", "Bar", "Baz", "Qux");
		List<String> students_2 = Arrays.asList("Foo", "Bar", "Baz", "Qux");

		int seedValue = 10;

		Collections.shuffle(students_1, new Random(seedValue));
		Collections.shuffle(students_2, new Random(seedValue));

		Assertions.assertThat(students_1).isEqualTo(students_2);
	}

	public void shufflingMap() {
		Map<Integer, String> studentsById = new HashMap<>();
		studentsById.put(1, "Foo");
		studentsById.put(2, "Bar");
		studentsById.put(3, "Baz");
		studentsById.put(4, "Qux");

		List<Map.Entry<Integer, String>> shuffledStudentEntries = new ArrayList<>(studentsById.entrySet());
		Collections.shuffle(shuffledStudentEntries);

		@SuppressWarnings("unused") List<String> shuffledStudents = 
				shuffledStudentEntries.stream()
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
	}

	public void shufflingSet() {
		Set<String> students = new HashSet<>(Arrays.asList("Foo", "Bar", "Baz", "Qux"));
		List<String> studentList = new ArrayList<>(students);
		Collections.shuffle(studentList);
	}
}
