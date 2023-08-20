package org.example.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
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

		// 학생 이름만 뽑아서 List<String>에 저장
		List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
		System.out.println("names = " + names);

		// 스트림을 배열로 변환
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
		for (Student student : stuArr2) {
			System.out.println(student);
		}

		// 스트림을 Map<String, Student>로 변환
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(Student::getName, s -> s));
		for (String name : stuMap.keySet()) {
			System.out.println(stuMap.get(name));
		}

		// 통계 정보
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore));
		System.out.println("count = " + count);
		System.out.println("totalScore = " + totalScore);

		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("totalScore = " + totalScore);

		Optional<Student> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		System.out.println("topStudent = " + topStudent);

		IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println("stat = " + stat);

		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "[", "]"));
		System.out.println("stuNames = " + stuNames);
	}
}
