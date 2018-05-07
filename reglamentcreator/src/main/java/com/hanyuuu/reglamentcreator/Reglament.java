/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотек считывания и записи файла
 */
import java.io.FileReader;
import java.io.FileWriter;
/**
 * Импортирование библиотеки, описывающей текстовый компонент
 */
import javax.swing.text.JTextComponent;

public class Reglament {
	/**
	 * Создание объекта типа FileWriter, используемого для записи в файл
	 */
	private FileWriter OutputWriter = null;
	/**
	 * Создание объекта типа FileWriter, используемого для чтения из файла
	 */
	private FileReader InputReader = null;
	/**
	 * Переменная для обозначения уровня регламента
	 */
	private int Importance;
	/**
	 * Переменная для обозначения названия регламента
	 */
	private String ReglamentName;
	/**
	 * Переменная для обозначения пути к регламенту
	 */
	private String ReglamentPath;
	/**
	 * Текстовый компонент с содержимым регламента
	 */
	private JTextComponent ReglamentContent;

	/**
	 * Конструктор объекта типа регламент
	 * @param Importance Уровень регламента
	 * @param ReglamentName Название регламента
	 * @param ReglamentPath Путь к регламенту
	 * @param ReglamentContent Текстовый компонент с содержимым регламента
	 */
	public Reglament(int Importance, String ReglamentName, String ReglamentPath, JTextComponent ReglamentContent) {
		this.Importance = Importance;
		this.ReglamentName = ReglamentName;
		this.ReglamentPath = ReglamentPath;
		this.ReglamentContent = ReglamentContent;
	}
	/**
	 * Геттер для уровня регламента
	 */
	public int getImportance() {
		return Importance;
	}
	/**
	 * Сеттер для уровня регламента
	 */
	public void setImportance(int importance) {
		this.Importance = importance;
	}
	/**
	 * Геттер для названия регламента
	 */
	public String getReglamentName() {
		return ReglamentName;
	}
	/**
	 * Сеттер для названия регламента
	 */
	public void setReglamentName(String reglamentName) {
		this.ReglamentName = reglamentName;
	}
	/**
	 * Геттер для пути регламента
	 */
	public String getReglamentPath() {
		return ReglamentPath;
	}
	/**
	 * Сеттер для пути регламента
	 */
	public void setReglamentPath(String reglamentPath) {
		this.ReglamentPath = reglamentPath;
	}
	/**
	 * Геттер для текстового компонента с содержимым регламента
	 */
	public JTextComponent getReglamentContent() {
		return ReglamentContent;
	}
	/**
	 * Сеттер для текстового компонента с содержимым регламента
	 */
	public void setReglamentContent(JTextComponent reglamentContent) {
		this.ReglamentContent = reglamentContent;
	}
	/**
	 * Метод для сохранения регламента на жестком диске в определенной директории
	 */
	public void save() throws Exception {
		/**
		 * Открытие считывателя в файл
		 */
		OutputWriter = new FileWriter(ReglamentPath + "/" + ReglamentName + ".reglament");
		/**
		 * Запись в файл
		 */
		ReglamentContent.write(OutputWriter);
		/**
		 * Закрытие считывателя в файл
		 */
		OutputWriter.close();
	}
	/**
	 * Метод для сохранения регламента на жестком диске в директории для обращения с ним программы
	 */
	public void savePermanently() throws Exception {
		/**
		 * Открытие считывателя в файл
		 */
		OutputWriter = new FileWriter("ReglamentForLevel " + Importance + ".reglament");
		/**
		 * Запись в файл
		 */
		ReglamentContent.write(OutputWriter);
		/**
		 * Закрытие считывателя в файл
		 */
		OutputWriter.close();
	}
	/**
	 * Метод для загрузки регламента в программу
	 */
	public void loadPermanently() throws Exception {
		/**
		 * Открытие считывателя из файла
		 */
		InputReader = new FileReader("ReglamentForLevel " + Importance + ".reglament");
		/**
		 * Считывание из файла
		 */
		ReglamentContent.read(InputReader, "ReglamentForLevel " + Importance + ".reglament");
		/**
		 * Закрытие считывателя из файла
		 */
		InputReader.close();
	}
	/**
	 * Метод для загрузки структуры регламента в программу
	 */
	public void loaddefault() throws Exception {
		/**
		 * Открытие считывателя из файла
		 */
		InputReader = new FileReader("default.reglament");
		/**
		 * Считывание из файла
		 */
		ReglamentContent.read(InputReader, "default.reglament");
		/**
		 * Закрытие считывателя из файла
		 */
		InputReader.close();
	}
}
