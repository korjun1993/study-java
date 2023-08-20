package org.example.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class StreamEx3 {
	public static void main(String[] args) {
		Student[] stuArr = {
			new Student("이자바", 3, 300),
			new Student("김자바", 1, 200),
			new Student("안자바", 2, 100),
			new Student("박자바", 2, 150),
			new Student("소자바", 1, 200),
			new Student("나자바", 3, 290),
			new Student("감자바", 3, 180),
		};

		// 반-성적-이름 순으로 출력
		Stream.of(stuArr)
			.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder())
				.thenComparing(Student::getName))
			.forEach(System.out::println);

		// 개수, 총합, 평균, 최소, 최대 출력
		IntSummaryStatistics stat = Stream.of(stuArr)
			.mapToInt(Student::getTotalScore)
			.summaryStatistics();

		System.out.println("count=" + stat.getCount());
		System.out.println("sum=" + stat.getSum());
		System.out.println("average=" + stat.getAverage());
		System.out.println("min=" + stat.getMin());
		System.out.println("max=" + stat.getMax());
	}

}
