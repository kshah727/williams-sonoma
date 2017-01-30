package com.sqa.ks.helpers;

public class QAMath {

	public static int addNumbers(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public static int square(int num, int pow) {
		int result = num;
		for (int i = 0; i < pow - 1; i++) {
			result *= num;
		}
		return result;
	}

	public static int subtractNumbers(int num1, int num3) {
		int result3 = num1 - num3;
		return result3;
	}

	private int total;

	public int addNumber(int num) {
		// total += num;
		// return total;
		setTotal(getTotal() + num);
		return getTotal();
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int square(int pow) {
		this.total = QAMath.square(getTotal(), pow);
		return this.total;
	}

	public int subNumber(int num) {
		setTotal(getTotal() + num);
		return getTotal();
	}
}
