package org.example.concurrent;

import java.util.concurrent.Executor;

public class ExecutorTest {
	public static void main(String[] args) {
		final Runnable runnable = () -> System.out.println("Thread " + Thread.currentThread().getName());

		Executor executor = new RunExecutor();
		executor.execute(runnable);
	}

	static class RunExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}
}
