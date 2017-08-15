package com.loggar.reflection.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loggar.pattern.singleton.HolderIdiomSingleton;

public class DestroySingltonByReflection {
	private static final Logger logger = LoggerFactory.getLogger(DestroySingltonByReflection.class);

	@Test
	public void destroySingleton() {
		HolderIdiomSingleton singletonInstance = HolderIdiomSingleton.getInstance();
		HolderIdiomSingleton singletonInstance2 = HolderIdiomSingleton.getInstance();
		logger.debug("(singletonInstance == singletonInstance2)={}", singletonInstance == singletonInstance2);

		try {
			@SuppressWarnings("rawtypes")
			Constructor constructor = HolderIdiomSingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			singletonInstance2 = (HolderIdiomSingleton) constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		logger.debug("(singletonInstance == singletonInstance2)={}", singletonInstance == singletonInstance2);

		assertThat(singletonInstance == singletonInstance2, is(false));
	}
}
