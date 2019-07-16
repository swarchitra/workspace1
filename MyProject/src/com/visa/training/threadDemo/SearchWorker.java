package com.visa.training.threadDemo;
import java.io.*;
import java.util.*;

public class SearchWorker extends Thread{

	String fileName;
	Queue<File> filesQ;
	List<File> results;
	
	public SearchWorker(String fileName, Queue<File> filesQ, List<File> results) {
		super();
		this.fileName = fileName;
		this.filesQ = filesQ;
		this.results = results;
	}
	@Override
	public void run() {
		while(true) {
			File aFile = filesQ.poll();
			if(aFile == null)
				break;
			if(aFile.isFile() && aFile.getName().equalsIgnoreCase(fileName))
				results.add(aFile);
			else if(aFile.isDirectory() && aFile.canRead()) {
				File[] contents = aFile.listFiles();
				filesQ.addAll(Arrays.asList(contents));
				
				
			}
		}
	}
}
