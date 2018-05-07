package com.hanyuuu.reglamentcreator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectWindow extends Components {
	private JPanel MainPanel;
	private JFrame MainFrame;
	private JButton GoToAdminWindowButton;
	private JButton GoToLevel1Button;
	private JButton GoToLevel2Button;
	private JButton GoToLevel3Button;
	private AdminSelectWindow AdminSelctWindow;
	private InspectReglamentWindow InspRegWindow;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SelectWindow StartPoint = new SelectWindow();
				StartPoint.init();
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void spawn() {
		InspRegWindow = new InspectReglamentWindow(0);
		AdminSelctWindow = new AdminSelectWindow();
		MainPanel = CreateMainPanel();
		MainFrame = CreateMainFrame("Формирование регламента", MainPanel, 300, 200, 366, 233);
		GoToAdminWindowButton = CreateButton("Администрирование", 10, 10, 330, 30);
		GoToLevel1Button = CreateButton("Уровень доступа 1", 10, 50, 330, 30);
		GoToLevel2Button = CreateButton("Уровень доступа 2", 10, 90, 330, 30);
		GoToLevel3Button = CreateButton("Уровень доступа 3", 10, 130, 330, 30);
		addComponentToFrame(MainFrame, GoToLevel1Button);
		addComponentToFrame(MainFrame, GoToLevel2Button);
		addComponentToFrame(MainFrame, GoToLevel3Button);
		addComponentToFrame(MainFrame, GoToAdminWindowButton);
		makeFrameVisible(MainFrame);
		GoToAdminWindowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				AdminSelctWindow.init();
			}
		});
		GoToLevel1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InspRegWindow.setLevel(1);
				InspRegWindow.init();
			}
		});
		GoToLevel2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InspRegWindow.setLevel(2);
				InspRegWindow.init();
			}
		});
		GoToLevel3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				InspRegWindow.setLevel(3);
				InspRegWindow.init();
			}
		});
	}

	public void init() {
		spawn();
	}
}
