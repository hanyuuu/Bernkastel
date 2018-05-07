package com.hanyuuu.reglamentcreator;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Saver {
	private JFileChooser FileChooser;
	private JPanel ParentPanel;

	public String getDirectory() {
		FileChooser = new JFileChooser();
		FileChooser.setCurrentDirectory(new java.io.File("."));
		FileChooser.setDialogTitle("Выбрать директорию для сохранения...");
		FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		FileChooser.setAcceptAllFileFilterUsed(false);
		if (FileChooser.showSaveDialog(ParentPanel) == JFileChooser.APPROVE_OPTION) {
			return FileChooser.getSelectedFile().getAbsolutePath();
		} else {
			return "";
		}
	}
}
