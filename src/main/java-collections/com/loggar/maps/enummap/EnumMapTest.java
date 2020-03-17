package com.loggar.maps.enummap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.loggar.enumerations.DayOfWeek;

public class EnumMapTest {
	@Test
	public void creation() {
		EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
		activityMap.put(DayOfWeek.MONDAY, "Soccer");

		assertThat(activityMap.get(DayOfWeek.MONDAY)).isEqualTo("Soccer");
	}

	@Test
	public void enumMap_copy_constructor() {
		EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
		activityMap.put(DayOfWeek.MONDAY, "Soccer");
		activityMap.put(DayOfWeek.TUESDAY, "Basketball");

		EnumMap<DayOfWeek, String> activityMapCopy = new EnumMap<>(activityMap);

		assertThat(activityMapCopy.size()).isEqualTo(2);
		assertThat(activityMapCopy.get(DayOfWeek.MONDAY)).isEqualTo("Soccer");
		assertThat(activityMapCopy.get(DayOfWeek.TUESDAY)).isEqualTo("Basketball");
	}

	@Test
	public void map_copy_constructor() {
		Map<DayOfWeek, String> ordinaryMap = new HashMap<>();
		ordinaryMap.put(DayOfWeek.MONDAY, "Soccer");

		EnumMap<DayOfWeek, String> enumMap = new EnumMap<>(ordinaryMap);
		assertThat(enumMap.size()).isEqualTo(1);
		assertThat(enumMap.get(DayOfWeek.MONDAY)).isEqualTo("Soccer");
	}

	@Test
	public void contains_key_value() {
		Map<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);

		activityMap.put(DayOfWeek.WEDNESDAY, "Hiking");
		assertThat(activityMap.containsKey(DayOfWeek.WEDNESDAY)).isTrue();
		assertThat(activityMap.containsValue("Hiking")).isTrue();
	}

	@Test
	public void null_as_value() {
		Map<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);

		assertThat(activityMap.containsKey(DayOfWeek.SATURDAY)).isFalse();
		assertThat(activityMap.containsValue(null)).isFalse();

		activityMap.put(DayOfWeek.SATURDAY, null);

		assertThat(activityMap.containsKey(DayOfWeek.SATURDAY)).isTrue();
		assertThat(activityMap.containsValue(null)).isTrue();
	}

	@Test
	public void remove_item() {
		Map<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);

		activityMap.put(DayOfWeek.MONDAY, "Soccer");
		assertThat(activityMap.remove(DayOfWeek.MONDAY)).isEqualTo("Soccer");
		assertThat(activityMap.containsKey(DayOfWeek.MONDAY)).isFalse();

		activityMap.put(DayOfWeek.MONDAY, "Soccer");
		assertThat(activityMap.remove(DayOfWeek.MONDAY, "Hiking")).isEqualTo(false);
		assertThat(activityMap.size()).isEqualTo(1);

		assertThat(activityMap.remove(DayOfWeek.MONDAY, "Soccer")).isEqualTo(true);
		assertThat(activityMap.size()).isEqualTo(0);
	}
}
