package org.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx8 {
	public static void main(String[] args) {
		Student2[] stuArr = {
			new Student2("나자바", true, 1, 1, 300),
			new Student2("김지미", false, 1, 1, 250),
			new Student2("김자바", true, 1, 1, 200),
			new Student2("이지미", false, 1, 2, 150),
			new Student2("남자바", true, 1, 2, 100),
			new Student2("안지미", false, 1, 2, 50),
			new Student2("황지미", true, 1, 3, 100),
			new Student2("강지미", false, 1, 3, 150),
			new Student2("이자바", true, 1, 3, 200),

			new Student2("나자바", true, 2, 1, 300),
			new Student2("김지미", false, 2, 1, 250),
			new Student2("김자바", true, 2, 1, 200),
			new Student2("이지미", false, 2, 2, 150),
			new Student2("남자바", true, 2, 2, 100),
			new Student2("안지미", false, 2, 2, 50),
			new Student2("황지미", true, 2, 3, 100),
			new Student2("강지미", false, 2, 3, 150),
			new Student2("이자바", true, 2, 3, 200),
		};

		System.out.println("1. 단순그룹화(반별로 그룹화)");
		Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr).collect(Collectors.groupingBy(Student2::getBan));

		System.out.println("2. 단순그룹화(성적별로 그룹화)");
		Map<Student2.Level, List<Student2>> stuByLevel = Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
			if (s.getScore() >= 200) {
				return Student2.Level.HIGH;
			} else if (s.getScore() >= 100) {
				return Student2.Level.MID;
			} else {
				return Student2.Level.LOW;
			}
		}));

		System.out.println("3. 단순그룹화 + 통계(성적별 학생수)");
		Map<Student2.Level, Long> stuCntByLevel = Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
			if (s.getScore() >= 200) {
				return Student2.Level.HIGH;
			} else if (s.getScore() >= 100) {
				return Student2.Level.MID;
			} else {
				return Student2.Level.LOW;
			}
		}, Collectors.counting()));

		System.out.println("4. 다중그룹화(학년별, 반별)");
		Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr)
			.collect(Collectors.groupingBy(Student2::getHak, Collectors.groupingBy(Student2::getBan)));

		System.out.println("5. 다중그룹화 + 통계(학년별, 반별 1등)");
		Map<Integer, Map<Integer, Student2>> topStuByHakAndBan = Stream.of(stuArr)
			.collect(Collectors.groupingBy(Student2::getHak,
				Collectors.groupingBy(Student2::getBan, Collectors.collectingAndThen(Collectors.maxBy(
					Comparator.comparing(Student2::getScore)), Optional::get))));

		System.out.println("6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
		Stream.of(stuArr)
			.collect(Collectors.groupingBy(Student2::getHak,
				Collectors.groupingBy(Student2::getBan, Collectors.mapping(s -> {
					if (s.getScore() >= 200) {

						return Student2.Level.HIGH;
					} else if (s.getScore() >= 100) {
						return Student2.Level.MID;
					} else {
						return Student2.Level.LOW;
					}
				}, Collectors.toSet()))));
	}
}
