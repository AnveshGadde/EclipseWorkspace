
public class AddStringVal {

	public static void main(String[] args) {

		String a = "jklmn489pjro635ops";

		for (int i = 0; i < 5; i++) {
			System.out.println(i++);
		}

		int sum = 0;
		for (char c : a.replaceAll("\\D", "").toCharArray()) {
			sum += c - '0';
		}
		System.out.println(sum + "rows");

		String b = "5";
		String c = "7";
		String result = "";

		try {
			int value = Integer.parseInt(b) + Integer.parseInt(c);
			result = "" + value;
		} catch (NumberFormatException ex) {
			result = "Invalid input";
		}

		System.out.println("ResultVal: " + result);
	}

}