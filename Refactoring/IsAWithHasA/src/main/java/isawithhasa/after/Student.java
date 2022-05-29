package isawithhasa.after;

import java.util.ArrayList;

public class Student {
	private String studentName;
	private String studentId;
	private Subject majorSubject;
	private ArrayList<Subject> subjectList = new ArrayList<>();

	public Student(
		String studentName,
		String studentId,
		String majorSubjectName,
		int majorCode
	) {
		this.studentName = studentName;
		this.studentId = studentId;
		majorSubject = new Subject(majorSubjectName, majorCode);
		subjectList.add(majorSubject);
	}

	public void addSubject(String subjectName, int subjectCode) {
		Subject subject = new Subject(subjectName, subjectCode);
		subjectList.add(subject);
	}

	public void setSubjectScore(int subjectCode, int score) {
		for (Subject subject : subjectList) {
			int code = subject.getSubjectCode();
			if (subjectCode == code) {
				subject.setScore(score);
				return;
			}
		}
		System.out.println("no subject");
	}

	public void getReport() {
		int total = 0;

		System.out.printf("%s님의 전공과목은 %s이고, 점수는 : %d입니다.\n",
			studentName, majorSubject.getSubjectName(), majorSubject.getSubjectCode());

		for (Subject subject : subjectList) {
			System.out.printf("%s : %d\n", subject.getSubjectName(), subject.getScore());
			total += subject.getScore();
		}

		System.out.printf("total : %d\n", total);
	}
}
