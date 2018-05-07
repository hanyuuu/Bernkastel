package com.hanyuuu.reglamentcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminSelectWindow extends Components {
	private JPanel MainPanel;
	private JFrame MainFrame;
	private JLabel CoefNameLabel;
	private JLabel CoefInfoLabel;
	private JButton GoToLevel1Button;
	private JButton GoToLevel2Button;
	private JButton GoToLevel3Button;
	private JButton BackToPreviousFormButton;
	private InstallReglamentWindow InstRegWindow;
	private SelectWindow SelctWindow;
	private CoefficientFunction CoefResultFunction;
	private int CoefResult;

	private void spawn() {
		CoefResultFunction = new CoefficientFunction();
		try {
			CoefResult = CoefResultFunction.takeSum(CoefResultFunction.getNumOfSymbols(1),
					CoefResultFunction.getNumOfSymbols(2), CoefResultFunction.getNumOfSymbols(3));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		MainPanel = CreateMainPanel();
		MainFrame = CreateMainFrame("Привязка регламента", MainPanel, 300, 200, 366, 233);
		GoToLevel1Button = CreateButton("Уровень доступа 1", 10, 10, 330, 30);
		GoToLevel2Button = CreateButton("Уровень доступа 2", 10, 50, 330, 30);
		GoToLevel3Button = CreateButton("Уровень доступа 3", 10, 90, 330, 30);
		BackToPreviousFormButton = CreateButton("Назад", 10, 130, 80, 30);
		CoefNameLabel = CreateLabel("Коэф. регламентов:", 100, 135, 130, 20);
		CoefInfoLabel = CreateLabel(String.valueOf(CoefResult), 240, 135, 60, 20);
		addComponentToFrame(MainFrame, GoToLevel1Button);
		addComponentToFrame(MainFrame, GoToLevel2Button);
		addComponentToFrame(MainFrame, GoToLevel3Button);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		addComponentToFrame(MainFrame, CoefNameLabel);
		addComponentToFrame(MainFrame, CoefInfoLabel);
		InstRegWindow = new InstallReglamentWindow(0);
		SelctWindow = new SelectWindow();
		makeFrameVisible(MainFrame);
		BackToPreviousFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				SelctWindow.init();
			}
		});
		GoToLevel1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InstRegWindow.setLevel(1);
				InstRegWindow.init();
			}
		});
		GoToLevel2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InstRegWindow.setLevel(2);
				InstRegWindow.init();
			}
		});
		GoToLevel3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InstRegWindow.setLevel(3);
				InstRegWindow.init();
			}
		});
	}

	public void init() {
		spawn();
	}
}