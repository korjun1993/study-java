package org.example.stream;

public class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Student{" +
			"name='" + name + '\'' +
			", ban=" + ban +
			", totalScore=" + totalScore +
			'}';
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
