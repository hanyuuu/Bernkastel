/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Saver {
	/**
	 * Объявления экземпляра объекта типа JFileChooser
	 */
	private JFileChooser FileChooser;
	/**
	 * Объявление панели
	 */
	private JPanel ParentPanel;
	/**
	 * Метод возвращающий выбранную директорию
	 */
	public String getDirectory() {
		/**
		 * Инициализация экземпляра объекта типа JFileChooser
		 */
		FileChooser = new JFileChooser();
		/**
		 * Установка начальной директории
		 */
		FileChooser.setCurrentDirectory(new java.io.File("."));
		/**
		 * Установка названия для окна
		 */
		FileChooser.setDialogTitle("Выбрать директорию для сохранения...");
		/**
		 * Установка типа выбираемых объектов на директории
		 */
		FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		/**
		 * Установка выбора любых файлов
		 */
		FileChooser.setAcceptAllFileFilterUsed(false);
		/**
		 * Если нажата кнопка выбора, то будет возвращена ссылку на выбранную директорию
		 */
		if (FileChooser.showSaveDialog(ParentPanel) == JFileChooser.APPROVE_OPTION) {
			return FileChooser.getSelectedFile().getAbsolutePath();
			/**
			 * Если не выбрано ничего, то будет возвращена пустая строка
			 */
		} else {
			return "";
		}
	}
}

