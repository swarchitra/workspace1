package com.visa.training.threadDemo;

public class Consumer extends Thread {
	Buffer buffer;
	
	public Consumer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			buffer.consume();
			
		}
	}

}
