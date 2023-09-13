package org.example.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> callable = () -> {
			Thread.sleep(3000L);
			return "Thread " + Thread.currentThread().getName();
		};

		Future<String> future = executorService.submit(callable);
		System.out.println(future.get());

		executorService.shutdown();
	}
}
