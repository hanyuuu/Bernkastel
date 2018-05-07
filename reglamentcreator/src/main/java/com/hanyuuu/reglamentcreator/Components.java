/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Components {
	/**
	 * Метод, создающий и возвращающий фрейм с заданными параметрами:
	 * @param FrameName Название фрейма
	 * @param PanelToBeAdded Панель, к которой будет прикрепляться фрейм
	 * @param x Начальная позиция X на фрейме для размещения элементов
	 * @param y Начальная позиция Y на фрейме для размещения элементов
	 * @param h Высота фрейма
	 * @param w Ширина фрейма
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JFrame CreateMainFrame(String FrameName, JPanel PanelToBeAdded, int x, int y, int h, int w) {
		/**
		 * Объявление и инициализация фрейма, привязка названия фрейма
		 */
		JFrame mainFrame = new JFrame(FrameName);
		/**
		 * Установка действия при нажатии на кнопку выхода
		 */
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Установка размеров фрейма и начальной позиции для размещения элементов
		 */
		mainFrame.setBounds(x, y, h, y);
		/**
		 * Установка панели для фрейма
		 */
		mainFrame.setContentPane(PanelToBeAdded);
		/**
		 * Установка запрета на изменение размеров
		 */
		mainFrame.setResizable(false);
		return mainFrame;
	};
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
	 * Метод, устанавливающий панель на фрейм
	 * @param Frame Фрейм, передаваемый методу как параметр
	 * @param Panel Панель, передаваемая методу как параметр
	 */
	protected void addcontent(JFrame Frame, JPanel Panel) {
		Frame.setContentPane(Panel);
	}
	/**
	 * Метод, устанавливающий компонент на фрейм
	 * @param Frame Фрейм, передаваемый методу как параметр
	 * @param GUIComponent Элемент для установки на данный фрейм
	 */
	protected void addComponentToFrame(JFrame Frame, JComponent GUIComponent) {
		Frame.add(GUIComponent);
	}
	/**
	 * Метод, создающий и возвращающий лейбл с заданными параметрами:
	 * @param LabelContent Строка, используемая для установки надписи на лейбле
	 * @param x Начальная позиция X лейбла для размещения его на фрейме
	 * @param y Начальная позиция Y лейбла для размещения его на фрейме
	 * @param h Высота лейбла
	 * @param w Ширина лейбла
	 * @return Возвращаемый методом лейбл с примененными параметрами
	 */
	protected JLabel CreateLabel(String LabelContent, int x,int y,int w,int h) {
		/**
		 * Объявление и инициализация лейбла, привязка названия к лейблу
		 */
		JLabel Label = new JLabel(LabelContent);
		/**
		 * Установка размеров лейбла и начальной позиции для его размещения на фрейме
		 */
		Label.setBounds(x, y, w, h);
		return Label;
	}
	
	/**
	 * Метод создающий и возвращающий панель
	 * @return Возвращаемая панель
	 */
	protected JPanel CreateMainPanel() {
		/**
		 * Объявление и инициализация панели
		 */
		JPanel MainPanel = new JPanel();
		/**
		 * Установка границ для панели
		 */
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		/**
		 * Установка способа размещения элементов на панели
		 */
		MainPanel.setLayout(null);
		return MainPanel;
	}
	

	/**
	 * Метод, создающий и возвращающий кнопку с заданными параметрами:
	 * @param ButtonContent Строка, используемая для установки надписи на кнопке
	 * @param x Начальная позиция X кнопки для размещения её на фрейме
	 * @param y Начальная позиция Y кнопки для размещения её на фрейме
	 * @param h Высота кнопки
	 * @param w Ширина кнопки
	 * @return Возвращаемая методом кнопка с примененными параметрами
	 */
	protected JButton CreateButton(String ButtonContent, int x, int y, int h, int w) {
		/**
		 * Объявление и инициализация кнопки, установка названия
		 */
		JButton a = new JButton(ButtonContent);
		/**
		 * Установка границ для кнопки
		 */
		a.setBounds(x,y,h,w);
		return a;
	}
}

