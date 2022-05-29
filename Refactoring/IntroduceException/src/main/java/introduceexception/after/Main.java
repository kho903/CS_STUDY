package introduceexception.after;

public class Main {

	public static void main(String[] args) {
		Password passwordInstance = new Password();
		String password = null;
		try {
			passwordInstance.setPassword(password);
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		password = "abcd";
		try {
			passwordInstance.setPassword(password);
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		password = "abcde";
		try {
			passwordInstance.setPassword(password);
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
		password = "abcde+";
		try {
			passwordInstance.setPassword(password);
		} catch (PasswordException e) {
			System.out.println(e.getMessage());
		}
	}
}
