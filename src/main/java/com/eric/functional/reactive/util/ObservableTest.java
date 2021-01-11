package com.eric.functional.reactive.util;

import io.reactivex.Observable;

public class ObservableTest {
	
	public static void main(String[] args) {
		log("Before");
		Observable.range(5, 3).
		subscribe(i -> { log("Element : "+i); });
		log("After");
	}
	
	private static void log(String message) {
		System.out.println(Thread.currentThread().getName()+":"+message);
	}
	

}
