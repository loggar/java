package com.loggar.maps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.loggar.enumerations.DayOfWeek;

public class EnumMapCollectionViews {

	EnumMap<DayOfWeek, String> dayMap = new EnumMap<>(DayOfWeek.class);

	@BeforeEach
	public void before() {
		dayMap.put(DayOfWeek.THURSDAY, "Karate");
		dayMap.put(DayOfWeek.WEDNESDAY, "Hiking");
		dayMap.put(DayOfWeek.MONDAY, "Soccer");
	}

	@Test
	public void values() {
		Collection<String> values = dayMap.values();
		assertThat(values).containsExactly("Soccer", "Hiking", "Karate");
	}

	@Test
	public void keySet() {
		Set<DayOfWeek> keys = dayMap.keySet();
		assertThat(keys).containsExactly(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);
	}

	@Test
	public void entrySet() {
		System.out.println(dayMap);
		assertThat(dayMap.entrySet()).containsExactly(new SimpleEntry<DayOfWeek, String>(DayOfWeek.MONDAY, "Soccer"), new SimpleEntry<DayOfWeek, String>(DayOfWeek.WEDNESDAY, "Hiking"), new SimpleEntry<DayOfWeek, String>(DayOfWeek.THURSDAY, "Karate"));
	}

	@Test
	public void mutability() {
		Collection<String> values = dayMap.values();

		dayMap.put(DayOfWeek.TUESDAY, "Basketball");
		assertThat(values).containsExactly("Soccer", "Basketball", "Hiking", "Karate");

		// And vice-versa;
		values.remove("Hiking");
		assertThat(dayMap.containsKey(DayOfWeek.WEDNESDAY)).isFalse();
		assertThat(dayMap.size()).isEqualTo(3);
	}

}
