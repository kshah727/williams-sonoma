package com.sqa.ks.helpers;

public class DataHelper {

	// Static Method
	public static String displayData(Object[][] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private String dataString;

	// constructor
	public DataHelper(Object[][] data) {
		this.dataString = displayData(data);
	}

	// Instance Method (Will need a constructor that takes the Object[][])
	public String displayData() {
		return this.dataString;
	}
}
