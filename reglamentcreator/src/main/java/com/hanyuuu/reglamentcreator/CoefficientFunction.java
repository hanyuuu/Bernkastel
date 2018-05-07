package com.hanyuuu.reglamentcreator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CoefficientFunction {
	public int getNumOfSymbols(int RegLevel) throws IOException {
		String Temp = new String(Files.readAllBytes(Paths.get("ReglamentForLevel " + RegLevel + ".reglament")));
		int TempLength = Temp.length();
		return TempLength;
	}

	public int takeSum(int RegLevel1, int RegLevel2, int RegLevel3) {
		int TotalSum = RegLevel1 + RegLevel2 * 2 + RegLevel3 * 3;
		return TotalSum;
	}
}
