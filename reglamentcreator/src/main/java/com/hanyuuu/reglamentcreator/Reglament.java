package com.hanyuuu.reglamentcreator;

import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.text.JTextComponent;

public class Reglament {
	private FileWriter OutputWriter = null;
	private FileReader InputReader = null;
	private int Importance;
	private String ReglamentName;
	private String ReglamentPath;
	private JTextComponent ReglamentContent;

	public Reglament(int Importance, String ReglamentName, String ReglamentPath, JTextComponent ReglamentContent) {
		this.Importance = Importance;
		this.ReglamentName = ReglamentName;
		this.ReglamentPath = ReglamentPath;
		this.ReglamentContent = ReglamentContent;
	}

	public int getImportance() {
		return Importance;
	}

	public void setImportance(int importance) {
		this.Importance = importance;
	}

	public String getReglamentName() {
		return ReglamentName;
	}

	public void setReglamentName(String reglamentName) {
		this.ReglamentName = reglamentName;
	}

	public String getReglamentPath() {
		return ReglamentPath;
	}

	public void setReglamentPath(String reglamentPath) {
		this.ReglamentPath = reglamentPath;
	}

	public JTextComponent getReglamentContent() {
		return ReglamentContent;
	}

	public void setReglamentContent(JTextComponent reglamentContent) {
		this.ReglamentContent = reglamentContent;
	}

	public void save() throws Exception {
		OutputWriter = new FileWriter(ReglamentPath + "/" + ReglamentName + ".reglament");
		ReglamentContent.write(OutputWriter);
		OutputWriter.close();
	}

	public void savePermanently() throws Exception {
		OutputWriter = new FileWriter("ReglamentForLevel " + Importance + ".reglament");
		ReglamentContent.write(OutputWriter);
		OutputWriter.close();
	}

	public void loadPermanently() throws Exception {
		InputReader = new FileReader("ReglamentForLevel " + Importance + ".reglament");
		ReglamentContent.read(InputReader, "ReglamentForLevel " + Importance + ".reglament");
		InputReader.close();
	}

	public void loaddefault() throws Exception {
		InputReader = new FileReader("default.reglament");
		ReglamentContent.read(InputReader, "default.reglament");
		InputReader.close();
	}
}
