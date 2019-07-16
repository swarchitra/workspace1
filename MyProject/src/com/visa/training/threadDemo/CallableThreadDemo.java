package com.visa.training.threadDemo;

import java.util.concurrent.Callable;

public class CallableThreadDemo implements Callable<Integer> {
	long start, end;
	int count;
	volatile boolean resultReady;
	CallableThreadDemo(long start, long end){
		this.start = start;
		this.end = end;
		count = 0;
	}
	
	@Override
	public Integer call() {
		for(long i=start; i<= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(long num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if( num % i == 0 )
				return false;
		}
		resultReady = true;
		return true;
	
	}
}
