/**
 * Установка принадлежности к основному пакету
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование библиотек обработчика событий
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Импортирование ошибки ввода-вывода для обработки при загрузке регламента
 */
import java.io.IOException;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminSelectWindow extends Components {
	/**
	 * Объявление элементов:
	 * 
	 * MainPanel – Основная панель
	 * MainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * CoefNameLabel – Лейбл для отображения надписи "Коэф. регламентов:"
	 * CoefInfoLabel – Лейбл для отображения значения коэффициента регламентов
	 * GoToLevel1Button – Кнопка для перехода к созданию регламента уровня доступа 1
	 * GoToLevel2Button – Кнопка для перехода к созданию регламента уровня доступа 2
	 * GoToLevel3Button – Кнопка для перехода к созданию регламента уровня доступа 3
	 * BackToPreviousFormButton – Кнопка для перехода в основное меню программы
	 * InstRegWindow – Экземпляр класса окна создания регламента
	 * SelctWindow – Экземпляр класса основного окна
	 * CoefResultFunction – Экземпляр класса, содержащего расчеты коэффициента регламента
	 * CoefResult – Переменная, в которой будет храниться коэффициент регламента
	 */
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

	/**
	 * Метод запускающий окно администрирования
	 */
	private void spawn() {
		/**
		 * Инициализация функции расчет коэффициента регламента
		 */
		CoefResultFunction = new CoefficientFunction();
		/**
		 * Расчет коэффициента регламента и запись результата в переменную f
		 */
		try {
			CoefResult = CoefResultFunction.takeSum(CoefResultFunction.getNumOfSymbols(1), CoefResultFunction.getNumOfSymbols(2), CoefResultFunction.getNumOfSymbols(3));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/**
		 * Создание основной панели
		 */
		MainPanel = CreateMainPanel();
		/**
		 * Создание основного фрейма, задание названия, прикрепление к панели, задание начальных координат и размеров фрейма
		 */
		MainFrame = CreateMainFrame("Привязка регламента", MainPanel, 300, 200, 366, 233);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 1, задание названия кнопки и ее размеров
		 */
		GoToLevel1Button = CreateButton("Уровень доступа 1", 10, 10, 330, 30);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 2, задание названия кнопки и ее размеров
		 */
		GoToLevel2Button = CreateButton("Уровень доступа 2", 10, 50, 330, 30);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 3, задание названия кнопки и ее размеров
		 */
		GoToLevel3Button = CreateButton("Уровень доступа 3", 10, 90, 330, 30);
		/**
		 * Создание кнопки возвращения к основному меню, задание названия, задание названия кнопки и ее размеров
		 */
		BackToPreviousFormButton = CreateButton("Назад", 10, 130, 80, 30);
		/**
		 * Создание лейбла для отображения надписи "Коэф. регламентов:", задание названия кнопки и ее размеров
		 */
		CoefNameLabel = CreateLabel("Коэф. регламентов:", 100, 135, 130, 20);
		/**
		 * Создание лейбла для отображения значения коэффициента регламентов, задание названия кнопки и ее размеров
		 */
		CoefInfoLabel = CreateLabel(String.valueOf(CoefResult), 240, 135, 60, 20);

		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(MainFrame, GoToLevel1Button);
		addComponentToFrame(MainFrame, GoToLevel2Button);
		addComponentToFrame(MainFrame, GoToLevel3Button);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		addComponentToFrame(MainFrame, CoefNameLabel);
		addComponentToFrame(MainFrame, CoefInfoLabel);

		/**
		 * Инициализация окна создания регламента
		 */
		InstRegWindow = new InstallReglamentWindow(0);
		/**
		 * Инициализация основного окна
		 */
		SelctWindow = new SelectWindow();
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(MainFrame);
		/**
		 * Создание слушателей для кнопок
		 */
		/**
		 * Создание слушателя для кнопки возврата
		 */
		BackToPreviousFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Вызов метода инициализирующего граф. интерфейс основного окна
				 */
				SelctWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 1
		 */
		GoToLevel1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну создания регламента аргумент 1 (уровень создаваемого регламента)
				 */
				InstRegWindow.setLevel(1);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				InstRegWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 2
		 */
		GoToLevel2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну создания регламента аргумент 2 (уровень создаваемого регламента)
				 */
				InstRegWindow.setLevel(2);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				InstRegWindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 3
		 */
		GoToLevel3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(MainFrame);
				/**
				 * Передача окну создания регламента аргумент 3 (уровень создаваемого регламента)
				 */
				InstRegWindow.setLevel(3);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				InstRegWindow.init();
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