package com.app.features;

public class TextBasedProcessing {
	public static void main(String[] args) {
		System.out.print("hello this is a test");
		String details = "djslvs" + "kfbavb" + "skdjvbsk";

		String detailstext = """

				ascljabvjabv
				 bdfdbdf
				  fd dddb
				  bdbdb
				  """;

		String msg = """
				Hello %s, welcome to java %d""".formatted("abc", 10);
		System.out.println(msg);

//		switch expressions example 
		int day = 2;
		String res = switch (day) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		default -> "invalid";
		};
		return day;

		int value = 8;
		String type = switch (value) {
		case 1, 2, 3 -> "Small";
		case 4, 5, 6 -> "Medium";
		default -> "Large";
		};
		return value;
		
		
		
		String role = "admin";

		String permission = switch (role) {
		case "admin" -> "Full Access";
		case "manager" -> "Moderate Access";
		case "user" -> "Read Only";
		default -> "No Access";
		};

		System.out.println(permission);

	}

	public int getaccountDetails() {
		String name = "james";
		int balance = switch (name) {

		case "Robin", "Joy" -> {
			System.out.println("inside robin case");
			yield 1000;
		}
		case "James" -> 2000;

		default -> 20;
		};
		return balance;
	}
}
