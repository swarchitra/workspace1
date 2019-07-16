package com.visa.training.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallablePrimeSearch {

		public static void main(String[] args) throws Exception {
			RunnableThreadDemo r1 = new RunnableThreadDemo(10000, 25000);
			RunnableThreadDemo r2 = new RunnableThreadDemo(1, 10000);
			
			/*Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			
			// Thread pools
			
			/*t1 = new Thread(new Runnable() {
				@Override public void run() {
					
				}
			})
			
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println("Primes btw 1 and 10000 are "+ r1.count);
			System.out.println("Primes btw 10000 and 25000 are " + r2.count);
			*/
			
			// we can submit tasks to the pool
			ExecutorService pool = Executors.newFixedThreadPool(4);
			pool.execute(r1);
			pool.execute(r2);
			
			while(!(r1.resultReady && r2.resultReady)) // flag usage is very essential
				Thread.sleep(100);
			System.out.println("Primes btw 1 and 10000 are "+ r1.count);
			System.out.println("Primes btw 10000 and 25000 are " + r2.count);
			pool.shutdown();
			
			//Industry usage
			//Since run() method cannot return value.. Callable interface is used
			
			
		}
}
