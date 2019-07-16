package com.visa.training.threadDemo;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
public class FileSearch {
	
	
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		String folderName = args[1];
		File folder = new File(folderName);
		File[] fileArray = folder.listFiles();
//		Queue<File> filesQ = new LinkedList<>(); Non synchronised version
		Queue<File> filesQ = new ConcurrentLinkedQueue<>();
 		for ( File file: filesQ)
			System.out.println(file.getName());
		filesQ.addAll(Arrays.asList(fileArray));
//	    List<File> results = new ArrayList<>(); Non synchronised versiom
		List<File> results = Collections.synchronizedList(new ArrayList<>());
		SearchWorker w1 = new SearchWorker(fileName, filesQ, results);
		SearchWorker w2 = new SearchWorker(fileName, filesQ, results);
		SearchWorker w3 = new SearchWorker(fileName, filesQ, results);
		w1.start();
		w2.start();
		w3.start();
		w1.join();
		w2.join();
		w3.join();
		System.out.println("Matches found are "+results.size());
		results.forEach(f -> System.out.println(f.getAbsolutePath()));
}
}