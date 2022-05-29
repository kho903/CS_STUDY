package isawithhasa.before;

public class Subject {

	String subjectName;
	int subjectCode;
	int score;

	public Subject() {}

	public Subject(String subjectName, int subjectCode) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public String toString() {
		return subjectCode + ":" + subjectName;
	}
}
