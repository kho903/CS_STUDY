# 여러 인스턴스에서 공통으로 사용하는 변수 선언 - static 변수
## 공통으로 사용하는 변수가 필요한 겨웅
- 여러 인스턴스가 공유하는 기준 값이 필요한 겨웅
- 학생마다 새로운 학번 생성
- 카드 회사에서 카드를 새로 발급할때마다 새로운 카드 번호를 부여
- 회사에 사원이 입사할 때마다 새로운 사번이 필요함

## 데이터 영역 메모리
static 변수 (공유)
- 인스턴스 A
- 인스턴스 B
- 인스턴스 C

## static 변수 선언과 사용하기
`static int serialNum;`
- 인스턴스가 생성될 때 만들어지는 변수가 아닌, 처음 프로그램이 메모리에 로딩될 때, 메모리를 할당
- 클래스 변수, 정적변수라고도 함 (vs 인스턴스 변수)
- 인스턴스 생성과 상관 없이 사용 가능하므로 클래스 이름으로 직접 참조<br>
`Student.serialNum = 100;`

## static 변수 테스트 (Code)
Employee.java
```java
public class Employee {

	public static int serialNum = 1000;
	
	private int employeeId;
	private String employeeName;
	private String department;
		
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
```
EmployeeTest.java
```java
public class EmployeeTest {

	public static void main(String[] args) {
		Employee employeeLee = new Employee();
		employeeLee.setEmployeeName("이순신");
		System.out.println(employeeLee.serialNum);
		
		Employee employeeKim = new Employee();
		employeeKim.setEmployeeName("김유신");
		employeeKim.serialNum++;
		
		System.out.println(employeeLee.serialNum);
		System.out.println(employeeKim.serialNum);
		
	}
}
```
- static 변수는 인스턴스에서 공통으로 사용하는 영역임을 알 수 있음.<br>
데이터 영역 (serialNum : 1001)
  - studentLee (스택 메모리)
    - studentLee 인스턴스 (힙메모리)
  - studentKim (스택메모리)
    - studentKim 인스턴스 (힙메모리)

## 회사원 입사할 때마다 새로운 사번 부여하기
Employee.java 생성자 구현
```java
...

	public Employee()
	{
		serialNum++;
		employeeId = serialNum;
	}

...
```
EmployeeTest.java
```java
public class EmployeeTest {

	public static void main(String[] args) {
		Employee employeeLee = new Employee();
		employeeLee.setEmployeeName("이순신");
				
		Employee employeeKim = new Employee();
		employeeKim.setEmployeeName("김유신");
				
		System.out.println(employeeLee.getEmployeeName() + "," + employeeLee.getEmployeeId());
		System.out.println(employeeKim.getEmployeeName() + "," + employeeKim.getEmployeeId());
	}
}
```

## Static 변수와 메서드는 인스턴스 변수, 메서드가 아니므로 클래스 이름으로 직접 참조.
`System.out.println(Employee.serialNum);`