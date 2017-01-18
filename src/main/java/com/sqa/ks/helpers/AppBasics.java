/**
 * File Name: AppBasics.java<br>
 * Shah, Krishna<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 14, 2017
 */
package com.sqa.ks.helpers;

import java.util.*;

public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static void farewellUser(String userName, String appName) {
		// TODO Auto-generated method stub
		System.out.println("Thank you for using the " + appName + " application.");
		System.out.println("Good Bye " + userName + " and have a great day!");
	}

	public static String greetUserandGetName(String appName) {
		System.out.println("Hello, Welcome to the " + appName + " App.");
		System.out.print("Could I please get your name?");
		return scanner.nextLine();
	}

	public static String requestInfo(String question1) {
		String response;
		System.out.print(question1 + "");
		response = scanner.nextLine();
		return response;
	}

	public static String requestInfoFromUser(String question) {
		String response;
		System.out.print(question + " ");
		response = scanner.nextLine();
		return response;
	}
}
