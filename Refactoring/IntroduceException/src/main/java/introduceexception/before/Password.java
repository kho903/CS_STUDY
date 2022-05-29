package introduceexception.before;

public class Password {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) {
			System.out.println("null 일 수 없습니다.");
			return;
		} else if (password.length() < 5) {
			System.out.println("5자 이상이어야 합니다.");
			return;
		} else if (password.matches("[a-zA-Z]+")) {
			System.out.println("숫자나 특수 문자를 포함해야 합니다.");
			return;
		} else {
			System.out.println("오류가 발견되지 않았습니다.");
		}
		this.password = password;
	}
}
