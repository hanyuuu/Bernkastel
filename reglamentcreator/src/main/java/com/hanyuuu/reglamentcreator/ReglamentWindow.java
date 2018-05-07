package com.hanyuuu.reglamentcreator;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ReglamentWindow {
	protected JTextArea CreateMainTextPanel(boolean IsPanelEditable) {
		JTextArea mainTextPanel = new JTextArea();
		mainTextPanel.setBounds(0, 0, 800, 360);
		mainTextPanel.setLineWrap(true);
		mainTextPanel.setEditable(IsPanelEditable);
		return mainTextPanel;
	};

	protected JScrollPane createScrollPane(JTextArea TextArea) {
		JScrollPane ScrollPanel = new JScrollPane(TextArea);
		ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		ScrollPanel.setBounds(0, 0, 800, 350);
		ScrollPanel.setSize(800, 360);
		return ScrollPanel;
	}

	protected JMenuBar createMenuBar() {
		JMenuBar MenuBar = new JMenuBar();
		return MenuBar;
	}

	protected JMenu createMenu(String MenuName) {
		JMenu Menu = new JMenu(MenuName);
		return Menu;
	}

	protected void createErrorMessage(JFrame ParentFrame, String MainMessage, String MessageLabel) {
		JOptionPane.showMessageDialog(ParentFrame, MainMessage, MessageLabel, JOptionPane.ERROR_MESSAGE);
	}

	protected JMenuItem createMenuItem(String MenuItemName) {
		JMenuItem MenuItem = new JMenuItem(MenuItemName);
		return MenuItem;
	}

	protected void addMenuItemToMenu(JMenuItem MenuItem, JMenu Menu) {
		Menu.add(MenuItem);
	}

	protected void addMenuToMenuBar(JMenu Menu, JMenuBar MenuBar) {
		MenuBar.add(Menu);
	}

	protected void addMenuBarToFrame(JMenuBar MenuBar, JFrame Frame) {
		Frame.setJMenuBar(MenuBar);
	}

	protected JFrame CreateMainFrame(String FrameName, int ReglamentLevel, JPanel PanelForAddition) {
		JFrame mainFrame = new JFrame(FrameName + ReglamentLevel);
		mainFrame.setSize(800, 530);
		mainFrame.setContentPane(PanelForAddition);
		mainFrame.setResizable(false);
		return mainFrame;
	};

	protected void addcontent(JFrame Frame, JPanel Panel) {
		Frame.setContentPane(Panel);
	}

	public void setFontStyle(Font Font, int FontStyle, JTextArea TextArea) {
		String TempFontName = Font.getName();
		int TempFontSize = Font.getSize();
		Font = new Font(TempFontName, FontStyle, TempFontSize);
		TextArea.setFont(Font);
	}

	protected void addComponentToFrame(JFrame Frame, JComponent GUIComponent) {
		Frame.add(GUIComponent);
	}

	protected void makeFrameVisible(JFrame InvisibleFrame) {
		InvisibleFrame.setVisible(true);
	}

	protected void frameDespawn(JFrame VisibleFrame) {
		VisibleFrame.setVisible(false);
	}

	protected JPanel CreateMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.setLayout(null);
		return mainPanel;
	}

	protected JButton CreateButton(String ButtonName, int x, int y, int h, int w) {
		JButton a = new JButton(ButtonName);
		a.setBounds(x, y, h, w);
		return a;
	}
}