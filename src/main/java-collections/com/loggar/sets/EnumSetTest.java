package com.loggar.sets;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.loggar.enumerations.Color;

public class EnumSetTest {
	@Test
	public void creation() {
		EnumSet<Color> colorSet0 = EnumSet.of(Color.BLACK, Color.WHITE);
		assertThat(colorSet0.size()).isEqualTo(2);

		EnumSet<Color> colorSet1 = EnumSet.allOf(Color.class);
		assertThat(colorSet1.size()).isEqualTo(6);

		EnumSet<Color> colorSet2 = EnumSet.noneOf(Color.class);
		assertThat(colorSet2.size()).isEqualTo(0);

		EnumSet<Color> colorSet3 = EnumSet.range(Color.YELLOW, Color.BLUE);
		assertThat(colorSet3.size()).isEqualTo(3); // [YELLOW, GREEN, BLUE]

		EnumSet<Color> colorSet4 = EnumSet.complementOf(EnumSet.of(Color.BLACK, Color.WHITE)); // exclude the elements passed
		assertThat(colorSet4.size()).isEqualTo(4); // [RED, YELLOW, GREEN, BLUE]

	}

	@Test
	public void copy_enumSet() {
		EnumSet<Color> colorSet = EnumSet.copyOf(EnumSet.of(Color.BLACK, Color.WHITE));
		assertThat(colorSet.size()).isEqualTo(2);
	}

	@Test
	public void copy_list() {
		List<Color> colorsList = new ArrayList<>();
		colorsList.add(Color.RED);
		EnumSet<Color> listCopy = EnumSet.copyOf(colorsList);

		assertThat(listCopy.size()).isEqualTo(1);
	}

	@Test
	public void add_contains() {
		EnumSet<Color> set = EnumSet.noneOf(Color.class);
		set.add(Color.RED);
		set.add(Color.YELLOW);

		assertThat(set.contains(Color.RED)).isTrue();
	}

	@Test
	public void remove_item() {
		EnumSet<Color> set = EnumSet.noneOf(Color.class);
		set.add(Color.RED);
		set.add(Color.YELLOW);

		assertThat(set.remove(Color.RED)).isTrue();
		assertThat(set.size()).isEqualTo(1);
	}

	@Test
	public void iterate() {
		EnumSet<Color> set = EnumSet.noneOf(Color.class);
		set.add(Color.RED);
		set.add(Color.YELLOW);

		// set.forEach(System.out::println);
		set.forEach(this::assertNotNull);
	}

	private void assertNotNull(Color c) {
		System.out.println(c);
		assertThat(c).isNotNull();
	}
}
