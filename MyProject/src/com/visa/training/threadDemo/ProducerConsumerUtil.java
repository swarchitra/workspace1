package com.visa.training.threadDemo;

public class ProducerConsumerUtil {
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Producer p = new Producer(b);
		Consumer c = new Consumer(b);
		p.start();
		c.start();
	}
}
