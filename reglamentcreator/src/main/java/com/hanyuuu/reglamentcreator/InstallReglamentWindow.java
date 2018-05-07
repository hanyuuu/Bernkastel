package com.hanyuuu.reglamentcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstallReglamentWindow extends ReglamentWindow {
	private JTextArea MainTextPanel;
	private JPanel MainPanel;
	private JFrame MainFrame;
	private String TempContent = "";
	private String DelContent;
	private int TempNumContent;
	private JScrollPane MainTextScrollPanel;
	private Font TextPanelFont;
	private JMenuBar MainMenuBar;
	private JMenu EditMenu, FontMenu;
	private JMenuItem MenuItem1, MenuItem2, MenuItem3, MenuItem4, MenuItem5, FontMenuItem1, FontMenuItem2,
			FontMenuItem3, FontMenuItem4;
	private int ReglamentLevel;
	private Reglament Reglament;
	private AdminSelectWindow AdminWindow;
	private JButton SaveButton;
	private JButton BackToPreviousFormButton;
	private JButton LoadDefaultReglament;

	public InstallReglamentWindow(int reglamentLevel) {
		this.ReglamentLevel = reglamentLevel;
	}

	public void setLevel(int reglamentLevel) {
		this.ReglamentLevel = reglamentLevel;
	}

	private void spawn(int n) {
		AdminWindow = new AdminSelectWindow();
		MainPanel = CreateMainPanel();
		MainTextPanel = CreateMainTextPanel(true);
		MainFrame = CreateMainFrame("Создание регламента для уровня доступа ", ReglamentLevel, MainPanel);
		MainTextScrollPanel = createScrollPane(MainTextPanel);
		Reglament = new Reglament(n, "", "", MainTextPanel);
		TextPanelFont = new Font("Monotype Corsiva", Font.PLAIN, 15);
		MainTextPanel.setFont(TextPanelFont);
		SaveButton = CreateButton("Сохранить", 20, 420, 120, 30);
		BackToPreviousFormButton = CreateButton("Назад", 150, 420, 120, 30);
		LoadDefaultReglament = CreateButton("Создать структуру регламента", 20, 370, 250, 30);
		MenuItem1 = createMenuItem("Копировать (Ctrl + C)");
		MenuItem2 = createMenuItem("Вырезать (Ctrl + X)");
		MenuItem3 = createMenuItem("Вставить (Ctrl + V)");
		MenuItem4 = createMenuItem("Выбрать все (Ctrl + A)");
		MenuItem5 = createMenuItem("Удалить");
		FontMenuItem1 = createMenuItem("Обычный");
		FontMenuItem2 = createMenuItem("Жирный");
		FontMenuItem3 = createMenuItem("Курсив");
		FontMenuItem4 = createMenuItem("Жирный курсив");
		EditMenu = createMenu("Действия");
		FontMenu = createMenu("Шрифт");
		MainMenuBar = createMenuBar();
		addMenuItemToMenu(MenuItem1, EditMenu);
		addMenuItemToMenu(MenuItem2, EditMenu);
		addMenuItemToMenu(MenuItem3, EditMenu);
		addMenuItemToMenu(MenuItem4, EditMenu);
		addMenuItemToMenu(MenuItem5, EditMenu);
		addMenuItemToMenu(FontMenuItem1, FontMenu);
		addMenuItemToMenu(FontMenuItem2, FontMenu);
		addMenuItemToMenu(FontMenuItem3, FontMenu);
		addMenuItemToMenu(FontMenuItem4, FontMenu);
		addMenuToMenuBar(EditMenu, MainMenuBar);
		addMenuToMenuBar(FontMenu, MainMenuBar);
		addMenuBarToFrame(MainMenuBar, MainFrame);
		addComponentToFrame(MainFrame, MainTextScrollPanel);
		addComponentToFrame(MainFrame, SaveButton);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		addComponentToFrame(MainFrame, LoadDefaultReglament);
		MenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempContent = MainTextPanel.getSelectedText();
			}
		});
		MenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempContent = MainTextPanel.getSelectedText();
				if (TempContent != null) {
					TempNumContent = MainTextPanel.getText().indexOf(TempContent);
					MainTextPanel.replaceRange("", TempNumContent, TempNumContent + TempContent.length());
				}
			}
		});
		MenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempNumContent = MainTextPanel.getCaretPosition();
				MainTextPanel.insert(TempContent, TempNumContent);
			}
		});
		MenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempNumContent = MainTextPanel.getText().length();
				MainTextPanel.select(0, TempNumContent);
			}
		});
		MenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelContent = MainTextPanel.getSelectedText();
				if (DelContent != null) {
					TempNumContent = MainTextPanel.getText().indexOf(DelContent);
					MainTextPanel.replaceRange(" ", TempNumContent, TempNumContent + DelContent.length());
				}
			}
		});
		FontMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFontStyle(TextPanelFont, Font.PLAIN, MainTextPanel);
			}
		});
		FontMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFontStyle(TextPanelFont, Font.BOLD, MainTextPanel);
			}
		});
		FontMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFontStyle(TextPanelFont, Font.ITALIC, MainTextPanel);
			}
		});
		FontMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFontStyle(TextPanelFont, Font.ITALIC | Font.BOLD, MainTextPanel);
			}
		});
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reglament.setReglamentContent(MainTextPanel);
					Reglament.savePermanently();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		LoadDefaultReglament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reglament.setReglamentContent(MainTextPanel);
					Reglament.loaddefault();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		BackToPreviousFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDespawn(MainFrame);
				AdminWindow.init();
			}
		});
		try {
			Reglament.setReglamentContent(MainTextPanel);
			Reglament.loadPermanently();
		} catch (FileNotFoundException e1) {
			System.out.println("Невозможно загрузить регламент. Регламент ещё не был назначен.");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		makeFrameVisible(MainFrame);
	}

	public void init() {
		spawn(ReglamentLevel);
	}
}
