/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотеки описывающей шрифт
 */
import java.awt.Font;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
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
	/**
	 * Метод, создающий и возвращающий текстовую панель с заданными параметрами:
	 * @param IsPanelEditable Разрешение на изменение текста в панели
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JTextArea CreateMainTextPanel(boolean IsPanelEditable) {
		/**
		 * Объявление и инициализация текстовой панели
		 */
		JTextArea mainTextPanel = new JTextArea();
		/**
		 * Установка размеров текстовой панели и начальной позиции для размещения
		 */
		mainTextPanel.setBounds(0, 0, 800, 360);
		/**
		 * Запрет на выход текста за границу панели
		 */
		mainTextPanel.setLineWrap(true);
		/**
		 * Установка разрешения на изменение
		 */
		mainTextPanel.setEditable(IsPanelEditable);
		return mainTextPanel;
	};

	/**
	 * Метод, создающий и возвращающий панель с ползунком с заданными параметрами:
	 * @param TextArea Текстовая панель, которая будет прикреплена к панели с ползунком
	 */
	protected JScrollPane createScrollPane(JTextArea TextArea) {
		/**
		 * Объявление и инициализация панели с ползунком
		 */
		JScrollPane ScrollPanel = new JScrollPane(TextArea);
		/**
		 * Установка вертикального ползунка
		 */
		ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		/**
		 * Установка размеров панели с ползунком и начальной позиции для размещения
		 */
		ScrollPanel.setBounds(0, 0, 800, 350);
		/**
		 * Установка размеров панели с ползунком
		 */
		ScrollPanel.setSize(800, 360);
		return ScrollPanel;
	}
	/**
	 * Метод, создающий панель меню
	 * @return Возвращаемая панель меню
	 */
	protected JMenuBar createMenuBar() {
		JMenuBar MenuBar = new JMenuBar();
		return MenuBar;
	}
	/**
	 * Метод, создающий меню
	 * @param MenuName Название меню
	 * @return Возвращаемое меню
	 */
	protected JMenu createMenu(String MenuName) {
		JMenu Menu = new JMenu(MenuName);
		return Menu;
	}
	/**
	 * Метод, создающий окно с ошибкой
	 * @param ParentFrame Родительское окно
	 * @param MainMessage Текст сообщения ошибки
	 * @param MessageLabel Название окна ошибки
	 */
	protected void createErrorMessage(JFrame ParentFrame, String MainMessage, String MessageLabel) {
		JOptionPane.showMessageDialog(ParentFrame,
				MainMessage,
				MessageLabel,
				JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Метод, создающий элемент меню
	 * @param MenuItemName Название элемента меню
	 */
	protected JMenuItem createMenuItem(String MenuItemName) {
		JMenuItem MenuItem = new JMenuItem(MenuItemName);
		return MenuItem;
	}

	/**
	 * Метод, добавляющий элемент меню на меню
	 * @param MenuItem Элемент меню
	 * @param Menu Меню
	 */
	protected void addMenuItemToMenu(JMenuItem MenuItem, JMenu Menu) {
		Menu.add(MenuItem);
	}

	/**
	 * Метод, добавляющий меню на панель меню
	 * @param Menu Меню
	 * @param MenuBar Панель меню
	 */
	protected void addMenuToMenuBar(JMenu Menu, JMenuBar MenuBar) {
		MenuBar.add(Menu);
	}

	/**
	 * Метод, добавляющий панель меню на фрейм
	 * @param MenuBar Панель меню
	 * @param Frame Фрейм
	 */
	protected void addMenuBarToFrame(JMenuBar MenuBar, JFrame Frame) {
		Frame.setJMenuBar(MenuBar);
	}


	/**
	 * Метод, создающий и возвращающий фрейм с заданными параметрами:
	 * @param FrameName Название фрейма
	 * @param PanelForAddition Панель, к которой будет прикрепляться фрейм
	 * @param ReglamentLevel Уровень регламента
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JFrame CreateMainFrame(String FrameName, int ReglamentLevel, JPanel PanelForAddition) {
		/**
		 * Объявление и инициализация фрейма, привязка названия фрейма
		 */
		JFrame mainFrame = new JFrame(FrameName + ReglamentLevel);
		/**
		 * Установка размеров фрейма
		 */
		mainFrame.setSize(800, 530);
		/**
		 * Установка панели для фрейма
		 */
		mainFrame.setContentPane(PanelForAddition);
		/**
		 * Установка запрета на изменение размеров
		 */
		mainFrame.setResizable(false);
		return mainFrame;
	};

	/**
	 * Метод, добавляющий панель на фрейм
	 * @param Frame Фрейм
	 * @param Panel Панель
	 */
	protected void addcontent(JFrame Frame, JPanel Panel) {
		Frame.setContentPane(Panel);
	}
	/**
	 * Метод, устанавливающий стиль шрифта
	 * @param Font Изначальный шрифт
	 * @param FontStyle Новый стиль шрифта
	 * @param TextArea Текстовая панель, к который должен быть применен шрифт
	 */
	public void setFontStyle(Font Font, int FontStyle, JTextArea TextArea) {
		/**
		 * Сохранение названия предыдущего шрифта
		 */
		String TempFontName = Font.getName();
		/**
		 * Сохранение размера шрифта
		 */
		int TempFontSize = Font.getSize();
		/**
		 * Создание нового шрифта с заданным стилем
		 */
		Font = new Font(TempFontName, FontStyle, TempFontSize);
		/**
		 * Установка нового шрифта на текстовую панель
		 */
		TextArea.setFont(Font);
	}

	/**
	 * Метод, добавляющий элемент на фрейм
	 * @param Frame Фрейм
	 * @param GUIComponent Компонент, прикрепляемый на фрейм
	 */
	protected void addComponentToFrame(JFrame Frame, JComponent GUIComponent) {
		Frame.add(GUIComponent);
	}
	/**
	 * Метод, делающий фрейм видимым
	 * @param InvisibleFrame Фрейм, передаваемый методу как параметр
	 */
	protected void makeFrameVisible(JFrame InvisibleFrame) {
		InvisibleFrame.setVisible(true);
	}
	/**
	 * Метод, делающий фрейм невидимым
	 * @param VisibleFrame Фрейм, передаваемый методу как параметр
	 */
	protected void frameDespawn(JFrame VisibleFrame) {
		VisibleFrame.setVisible(false);
	}
	/**
	 * Метод создающий и возвращающий панель
	 * @return Возвращаемая панель
	 */
	protected JPanel CreateMainPanel() {
		/**
		 * Объявление и инициализация панели
		 */
		JPanel mainPanel = new JPanel();
		/**
		 * Установка границ для панели
		 */
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		/**
		 * Установка способа размещения элементов на панели
		 */
		mainPanel.setLayout(null);
		return mainPanel;
	}


	/**
	 * Метод, создающий и возвращающий кнопку с заданными параметрами:
	 * @param ButtonName Строка, используемая для установки надписи на кнопке
	 * @param x Начальная позиция X кнопки для размещения её на фрейме
	 * @param y Начальная позиция Y кнопки для размещения её на фрейме
	 * @param h Высота кнопки
	 * @param w Ширина кнопки
	 * @return Возвращаемая методом кнопка с примененными параметрами
	 */
	protected JButton CreateButton(String ButtonName, int x, int y, int h, int w) {
		/**
		 * Объявление и инициализация кнопки, установка названия
		 */
		JButton a = new JButton(ButtonName);
		/**
		 * Установка границ для кнопки
		 */
		a.setBounds(x, y, h, w);
		return a;
	}
}