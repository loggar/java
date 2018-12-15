package com.loggar.pattern.singleton;

/**
 * 생성시기를 결정할 수 있는 싱글톤
 * enum 싱글톤, 혹은 private static instance 형태의 싱글톤의경우 시스템 구동시점에 인스턴스 생성이 이루어진다.
 * 아래 방법은 생성 시기를 늦추는 싱클톤 방법이다.
 * HolderIdiomSingleton 가 직접 static INSTANCE 를 가지고 있지 않기 때문에 시스템은 LazyHolder.INSTANCE 에 접근이 시도 될 떄까지 인스턴스 생성을 미룬다.
 * 
 */
public class HolderIdiomSingleton {
	private HolderIdiomSingleton() {}
	
	private static class LazyHolder {
		private static final HolderIdiomSingleton INSTANCE= new HolderIdiomSingleton();
	}
	
	public static HolderIdiomSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
