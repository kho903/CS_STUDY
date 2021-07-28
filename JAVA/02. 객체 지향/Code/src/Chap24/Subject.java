package Chap24;

public class Subject {
    String subName;
    int score;
    public Subject() {

    }
    public Subject(String subName, int score) {
        this.subName = subName;
        this.score = score;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
