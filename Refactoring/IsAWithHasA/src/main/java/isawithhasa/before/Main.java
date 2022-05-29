package isawithhasa.before;

public class Main {

	public static void main(String[] args) {

		Student studentKim = new Student("Kim", "12345", "국어국문", 98765);
		Student studentLee = new Student("Lee", "12346", "영어영문", 54321);

		studentKim.majorSubject.setScore(100);
		studentLee.majorSubject.setScore(90);

		studentKim.addSubject("수학", 12345);
		studentLee.addSubject("수학", 12345);

		studentKim.setSubjectScore(12345, 100);
		studentLee.setSubjectScore(12345, 100);

		studentKim.getReport();
		studentLee.getReport();
	}

}
