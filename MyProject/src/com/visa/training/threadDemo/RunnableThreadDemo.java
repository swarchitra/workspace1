package com.visa.training.threadDemo;

public class RunnableThreadDemo implements Runnable {
	long start, end;
	int count;
	volatile boolean resultReady;
	RunnableThreadDemo(long start, long end){
		this.start = start;
		this.end = end;
		count = 0;
	}
	
	@Override
	public void run() {
		for(long i=start; i<= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
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
