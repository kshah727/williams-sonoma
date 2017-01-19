/**
 * File Name: AppBasics.java<br>
 * Shah, Krishna<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 14, 2017
 */
package com.sqa.ks.helpers;

import java.util.*;

import com.sqa.ks.helpers.exceptions.*;

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

	public static int requestIntFromUser(String question) {
		return requestIntFromUser(question, 0, 0);
	}

	public static int requestIntFromUser(String question, int min, int max) {
		String input;
		int result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				System.out.print(question + " ");
				input = scanner.nextLine();
				result = Integer.parseInt(input);
				if (min != 0 && max != 0) {
					if (result <= max && result >= min) {
						isNotValid = false;
					} else {
						throw new NumberNotInRangeException();
					}
				}
				isNotValid = false;
			} catch (NumberFormatException e) {
				// TODO Give an error message
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number witihin the range of " + min + " and " + max + ".");
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		return result;
	}

	public static void tellUserWhatDayIsToday() {
		Calendar now = Calendar.getInstance();
		System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE) + "-"
				+ now.get(Calendar.YEAR));
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };
		// Day_OF_WEEK starts from 1 while array index starts from 0
		System.out.println("Current day is : " + strDays[now.get(Calendar.DAY_OF_WEEK) - 1]);
	}
}
