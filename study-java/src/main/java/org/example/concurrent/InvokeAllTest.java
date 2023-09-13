package org.example.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Instant start = Instant.now();

		Callable<String> hello = () -> {
			Thread.sleep(1000L);
			final String result = "Hello";
			System.out.println("result = " + result);
			return result;
		};

		Callable<String> java = () -> {
			Thread.sleep(4000L);
			final String result = "Java";
			System.out.println("result = " + result);
			return result;
		};

		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java));
		for (Future<String> f : futures) {
			System.out.println(f.get());
		}
		System.out.println("time = " + Duration.between(start, Instant.now()).getSeconds());
		executorService.shutdown();
	}
}
