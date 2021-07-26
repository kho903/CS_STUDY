package Chap16;

public class Employee {
    private static int serialNum = 1000;

    private int employeeId;
    private String employeeName;
    private String department;

    public Employee() {
        serialNum++;
        employeeId = serialNum;
    }

    public static int getSerialNum() {
        int i = 0; // 지역변수 가능

        // employeeName = "Lee"; // 오류 instance 변수 사용 불가
        return serialNum; // static변수
    }

    public int getEmployeeId() {
//        serialNum = 1000; // 가능
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
