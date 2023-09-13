package org.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread().getName());
		executorService.execute(runnable);
		executorService.shutdown();
	}
}
