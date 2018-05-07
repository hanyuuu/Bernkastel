package com.hanyuuu.reglamentcreator;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Components {
	protected JFrame CreateMainFrame(String FrameName, JPanel PanelToBeAdded, int x, int y, int h, int w) {
		JFrame mainFrame = new JFrame(FrameName);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(x, y, h, y);
		mainFrame.setContentPane(PanelToBeAdded);
		mainFrame.setResizable(false);
		return mainFrame;
	};

	protected void makeFrameVisible(JFrame InvisibleFrame) {
		InvisibleFrame.setVisible(true);
	}

	protected void frameDespawn(JFrame VisibleFrame) {
		VisibleFrame.setVisible(false);
	}

	protected void addcontent(JFrame Frame, JPanel Panel) {
		Frame.setContentPane(Panel);
	}

	protected void addComponentToFrame(JFrame Frame, JComponent GUIComponent) {
		Frame.add(GUIComponent);
	}

	protected JLabel CreateLabel(String LabelContent, int x, int y, int w, int h) {
		JLabel Label = new JLabel(LabelContent);
		Label.setBounds(x, y, w, h);
		return Label;
	}

	protected JPanel CreateMainPanel() {
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPanel.setLayout(null);
		return MainPanel;
	}

	protected JButton CreateButton(String ButtonContent, int x, int y, int h, int w) {
		JButton a = new JButton(ButtonContent);
		a.setBounds(x, y, h, w);
		return a;
	}
}
