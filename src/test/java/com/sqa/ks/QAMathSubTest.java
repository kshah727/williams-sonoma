package com.sqa.ks;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.ks.helpers.*;

public class QAMathSubTest {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, 4, -3 }, new Object[] { 2, 20, -18 },
				new Object[] { 15, 15, 0 }, new Object[] { 0, 4, -4 },
				new Object[] { -3, 3, -6 }, new Object[] { 34, 33, 1 } };
	}

	// test static
	@Test(dataProvider = "dp")
	public void test1(int num1, int num2, int expected) {
		int actual;
		actual = QAMath.subtractNumbers(num1, num2);
		Assert.assertEquals(expected, actual);
	}

	// test nonstatic
	@Test(dataProvider = "dp", enabled = false)
	public void test2(int num1, int num2, int expected) {
		int actual;
		QAMath math = new QAMath();
		math.addNumber(num1);
		math.subNumber(num2);
		actual = math.getTotal();
		Assert.assertEquals(expected, actual);
	}
}
