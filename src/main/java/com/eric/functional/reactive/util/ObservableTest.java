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
		
		Observable<Integer> it = Observable.create(subscriber -> {
			log("Starting");
			subscriber.onNext(37);
			subscriber.onNext(41);
			subscriber.onComplete();
		});
		
		System.out.println("-------------------------------------------");
		it.subscribe(a -> log("Element A :"+a));
		it.subscribe(a -> log("Element B :"+a));
	}
	
	private static void log(String message) {
		System.out.println(Thread.currentThread().getName()+":"+message);
	}

}

