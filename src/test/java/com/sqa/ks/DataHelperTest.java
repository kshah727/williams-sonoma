package com.sqa.ks;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.ks.helpers.*;

public class DataHelperTest {

	// @DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 3, 5, 4, 1 },
				new Object[] { 3.1, 5.55, 4.1, 1.3 }, new Object[] { "3", "5", "4", "1" },
				new Object[] { '3', '5', '4', '1' } };
	}

	@Test
	public void testNonStaticDisplayData() {
		String expected =
				"3	5	4	1	\n3.1	5.55	4.1	1.3	\n3	5	4	1	\n3	5	4	1	\n";
		DataHelper dh = new DataHelper(dp());
		String actual = dh.displayData();
		// System.out.println(actual);
		Assert.assertEquals(actual, expected, "does not work correctly");
	}

	@Test// (dataProvider = "dp")
	public void testStaticDisplayData() {
		Object[][] data = dp();
		String expected =
				"3	5	4	1	\n3.1	5.55	4.1	1.3	\n3	5	4	1	\n3	5	4	1	\n";
		String actual = DataHelper.displayData(data);
		Assert.assertEquals(actual, expected, "does not work correctly");
	}
}
