/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование ошибки ввода-вывода для обработки при загрузке регламента
 */
import java.io.IOException;
/**
 * Импортирование библиотек для считывания из файла
 */
import java.nio.file.Files;
import java.nio.file.Paths;

public class CoefficientFunction {
	/**
	 * Метод, считающий количество символов в регламенте определенного уровня
	 * @param RegLevel Значение уровня регламента
	 */
	public int getNumOfSymbols(int RegLevel) throws IOException {
		/**
		 * Считывание символов файла в строку Temp
		 */
		String Temp = new String(Files.readAllBytes(Paths.get("ReglamentForLevel " + RegLevel +".reglament")));
		/**
		 * Запись длинны данной строки
		 */
		int TempLength = Temp.length();
		return TempLength;
	}
	/**
	 * Функция расчета коэффициента регламента
	 * Входные значения:
	 * @param RegLevel1 – количество символов в регламенте уровня 1
	 * @param RegLevel2 – количество символов в регламенте уровня 2
	 * @param RegLevel3 – количество символов в регламенте уровня 3
	 */
	public int takeSum(int RegLevel1, int RegLevel2, int RegLevel3) {
		/**
		 * Расчет коэффициента регламента
		 */
		int TotalSum = RegLevel1 + RegLevel2*2 + RegLevel3*3;
		return TotalSum;
	}
}
