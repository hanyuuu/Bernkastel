/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотек обработчика событий
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectWindow extends Components {
	/**
	 * Объявление элементов:
	 * 
	 * MainPanel – Основная панель
	 * MainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * GoToAdminWindowButton – Кнопка для перехода в окно администрирования
	 * GoToLevel1Button – Кнопка для перехода к просмотру регламента уровня доступа 1
	 * GoToLevel2Button – Кнопка для перехода к просмотру регламента уровня доступа 2
	 * GoToLevel3Button – Кнопка для перехода к просмотру регламента уровня доступа 3
	 * AdminSelctWindow – Экземпляр объекта окна администрирования
	 * InspRegWindow – Экземпляр объекта окна просмотра регламента
	 */
	private JPanel MainPanel;
	private JFrame MainFrame;
	private JButton GoToAdminWindowButton;
	private JButton GoToLevel1Button;
	private JButton GoToLevel2Button;
	private JButton GoToLevel3Button;
	private AdminSelectWindow AdminSelctWindow;
	private InspectReglamentWindow InspRegWindow;

	/**
	 * Метод, запускающий программу
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/**
				 * Создание экземпляра основного окна
				 */
				SelectWindow StartPoint = new SelectWindow();
				/**
				 * Запуск основного окна
				 */
				StartPoint.init();
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Метод запускающий основное окно
	 */
	private void spawn() {
		/**
		 * Инициализация окна просмотра регламента
		 */
		InspRegWindow = new InspectReglamentWindow(0);
		/**
		 * Инициализация окна администратора
		 */
		AdminSelctWindow = new AdminSelectWindow();
		/**
		 * Создание основной панели
		 */
		MainPanel = CreateMainPanel();
		/**
		 * Создание основного фрейма, задание названия, прикрепление к панели, задание начальных координат и размеров фрейма
		 */
		MainFrame = CreateMainFrame("Формирование регламента", MainPanel, 300, 200, 366, 233);
		/**
		 * Создание кнопки перехода к окну администратора, задание названия, задание названия кнопки и ее размеров
		 */
		GoToAdminWindowButton = CreateButton("Администрирование", 10, 10, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 1, задание названия кнопки и ее размеров
		 */
		GoToLevel1Button = CreateButton("Уровень доступа 1", 10, 50, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 2, задание названия кнопки и ее размеров
		 */
		GoToLevel2Button = CreateButton("Уровень доступа 2", 10, 90, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 3, задание названия кнопки и ее размеров
		 */
		GoToLevel3Button = CreateButton("Уровень доступа 3", 10, 130, 330, 30);
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(MainFrame, GoToLevel1Button);
		addComponentToFrame(MainFrame, GoToLevel2Button);
		addComponentToFrame(MainFrame, GoToLevel3Button);
		addComponentToFrame(MainFrame, GoToAdminWindowButton);
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(MainFrame);
		/**
		 * Создание слушателей для кнопок
		 */
		/**
		 * Создание слушателя для кнопки перехода к окну администратора
		 */
		GoToAdminWindowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна администратора
				 */
				AdminSelctWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 1
		 */
		GoToLevel1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 1 (уровень просматриваемого регламента)
				 */
				InspRegWindow.setLevel(1);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InspRegWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 2
		 */
		GoToLevel2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 2 (уровень просматриваемого регламента)
				 */
				InspRegWindow.setLevel(2);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InspRegWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 3
		 */
		GoToLevel3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 3 (уровень просматриваемого регламента)
				 */
				InspRegWindow.setLevel(3);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InspRegWindow.init();
			}
		});
	}
	/**
	 * Публичный метод для вызова граф. интерфейса этого окна из других классов
	 */
	public void init() {
		spawn();
	}
}
