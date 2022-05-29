package isawithhasa.after;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("Lee", "12345", "국어국문", 100);
		Student student1 = new Student("Kim", "67890", "영어영문", 200);

		student.addSubject("수학", 300);
		student.setSubjectScore(100, 90);
		student.setSubjectScore(300, 100);


		student1.addSubject("수학", 300);
		student1.setSubjectScore(200, 100);
		student1.setSubjectScore(300, 70);

		student.getReport();
		student1.getReport();
	}
}
