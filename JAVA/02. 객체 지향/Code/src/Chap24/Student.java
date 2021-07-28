package Chap24;

import java.util.ArrayList;

public class Student {
    int studentNum;
    String studentName;
    ArrayList<Subject> subjectList;

    public Student(int studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;

        subjectList = new ArrayList<Subject>();
    }

    public void addSubject(String subName, int score) {
        Subject subject = new Subject();
        subject.setSubName(subName);
        subject.setScore(score);
        subjectList.add(subject);
    }

    public void showStudentInfo() {
        int total = 0;
        for (Subject sub : subjectList) {
            total += sub.getScore();
            System.out.printf("학생 %s의 %s 과목 성적은 %d입니다.\n", studentName, sub.getSubName(), sub.getScore());
        }
        System.out.printf("학생 %s의 총점은 %d입니다.\n", studentName, total);
    }
}
