package com.eric.functional.reactive.util;

import io.reactivex.Observable;

/**
 * 
 * @author Shahnawaz
 *
 */
public class ObservableTest {
	
	public static void main(String[] args) {
		log("Before");
		Observable.range(5, 3).
		subscribe(i -> { log("Element : "+i); });
		log("After");
		
		Observable<Integer> it = Observable.just(23);
		it.subscribe(a -> System.out.println("Testing Observable.just() : "+a));
	}
	
	private static void log(String message) {
		System.out.println(Thread.currentThread().getName()+":"+message);
	}

}

