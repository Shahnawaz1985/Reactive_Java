package com.eric.functional.reactive.util;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

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
		
		System.out.println("-------------------------------------------");
		
		Observable<BigInteger> naturalNumbers = Observable.create(subscriber -> {
			Runnable runnable = () -> {
				BigInteger i = BigInteger.ONE;
				while(!subscriber.isDisposed()) {
					subscriber.onNext(i);
					i = i.add(BigInteger.ONE);
				}
			};
			Thread th = new Thread(runnable);
			th.setName("Natural Number printing thread -> ");
			th.start();
			
		});
		
		Disposable disposable = naturalNumbers.subscribe(x -> log("Number : "+x));
		
		try {			
			Thread.sleep(1000);			
		} catch (InterruptedException ex) {			
			
			ex.printStackTrace();
		}
		
		System.out.println("Thread Interruption triggered!");
		disposable.dispose();
		
		Observable<Long> obs_interval = Observable.interval(1_000_000/60, TimeUnit.MILLISECONDS);
		Disposable dispsble = obs_interval.subscribe(l -> log("long :"+l));
		
		try {			
			Thread.sleep(500);			
		} catch (InterruptedException ex) {			
			
			ex.printStackTrace();
		}
		
		dispsble.dispose();
		
	}
	
	private static void log(String message) {
		System.out.println(Thread.currentThread().getName()+":"+message);
	}
}

