package com.visa.training.threadDemo;

public class Buffer {
	int data;
	boolean available = false;
	
	public 	synchronized void produce(int newData) {
		while(available)
			try {
				//Thread.sleep(100);
				this.wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		System.out.println("Produced data "+ data);
		data =  newData;
		available = true;
		this.notify();
		// Only wait and notify can be called from objects that hold lock
				
	}
	
	public synchronized int consume() {
		while(!available)
			try {
				//Thread.sleep(100);
				this.wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		System.out.println("Consuming data "+ data);
		available = false;
		this.notify();
		return data;
	}
	public static void main(String[] args) {
		
	}
}
