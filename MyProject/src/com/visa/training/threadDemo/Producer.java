package com.visa.training.threadDemo;

public class Producer extends Thread {
	Buffer buffer;
	
	public Producer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			buffer.produce(i);
			
		}
	}

}
