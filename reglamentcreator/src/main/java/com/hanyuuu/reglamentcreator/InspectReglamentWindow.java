package com.hanyuuu.reglamentcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InspectReglamentWindow extends ReglamentWindow {
	private JPanel MainPanel;
	private JScrollPane TextScrollPanel;
	private JTextArea MainTextPanel;
	private JFrame MainFrame;
	private JButton SaveButton;
	private JButton BackToPreviousFormButton;
	private int ReglamentLevel;
	private SelectWindow SelctWindow;
	private Reglament Reglament;
	private Saver FileSaver;
	private String TempDirHolder;

	public InspectReglamentWindow(int ReglamentLevel) {
		this.ReglamentLevel = ReglamentLevel;
	}

	public int getLevel() {
		return ReglamentLevel;
	}

	public void setLevel(int ReglamentLevel) {
		this.ReglamentLevel = ReglamentLevel;
	}

	private void spawn(final int ReglamentLevel) {
		MainPanel = CreateMainPanel();
		MainTextPanel = CreateMainTextPanel(false);
		SaveButton = CreateButton("Сохранить на диск", 20, 370, 150, 30);
		BackToPreviousFormButton = CreateButton("Назад", 180, 370, 120, 30);
		MainFrame = CreateMainFrame("Просмотр регламента для уровня ", ReglamentLevel, MainPanel);
		TextScrollPanel = createScrollPane(MainTextPanel);
		addComponentToFrame(MainFrame, TextScrollPanel);
		addComponentToFrame(MainFrame, SaveButton);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		Reglament = new Reglament(ReglamentLevel, "", "", MainTextPanel);
		SelctWindow = new SelectWindow();
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileSaver = new Saver();
					TempDirHolder = FileSaver.getDirectory();
					if (TempDirHolder != "") {
						Reglament.setReglamentPath(TempDirHolder);
						Reglament.setReglamentName("ReglamentForLevel " + ReglamentLevel);
						Reglament.setReglamentContent(MainTextPanel);
						Reglament.save();
					} else {
						createErrorMessage(MainFrame, "Отмена выбора директории. Сохранение произведено не будет.",
								"Сохранение отменено");
					}
				} catch (FileNotFoundException e1) {
					createErrorMessage(MainFrame, "Сохранение провести не удалось. Отказано в доступе.",
							"Сохранение отменено");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		BackToPreviousFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				SelctWindow.init();
			}
		});
		try {
			Reglament.setReglamentContent(MainTextPanel);
			Reglament.loadPermanently();
		} catch (FileNotFoundException e1) {
			createErrorMessage(MainFrame, "Отсутствует файл ReglamentForLevel " + ReglamentLevel
					+ ".reglament. Проверьте правильность установки программы", "Сохранение отменено");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		makeFrameVisible(MainFrame);
	}

	public void init() {
		spawn(ReglamentLevel);
	}
}
