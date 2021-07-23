package Chap10;

public class BirthDay {
    private int day;
    private int month;
    private int year;

    private boolean isValid;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12)
            isValid = false;
        else
            this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showDate() {
        if (isValid)
            System.out.printf("%d년 %d월 %d일입니다.", year, month, day);
        else
            System.out.println("유효하지 않은 날짜 입니다.");
    }

    public boolean getIsValid() {
        return isValid;
    }
}
