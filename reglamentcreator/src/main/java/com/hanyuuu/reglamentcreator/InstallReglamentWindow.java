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
 * Импортирование ошибки ненайденного файла для обработки при загрузке регламента
 */
import java.io.FileNotFoundException;
/**
 * Импортирование библиотеки описывающей шрифт
 */
import java.awt.Font;
/**
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstallReglamentWindow extends ReglamentWindow {
	/**
	 * Объявление элементов:
	 * 
	 * MainTextPanel – Основное текстовое поле для ввода
	 * MainPanel – Основная панель
	 * MainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * TempContent – Строка для временного хранения содержимого регламента
	 * DelContent – Строка для временного хранения содержимого регламента, подлежащего удалению
	 * TempNumContent – Переменная для временного хранения размеров содержимого регламента
	 * MainTextSrollPanel – Панель с ползунком для текстового поля
	 * TextPanelFont – Шрифт для содержимого регламента
	 * MainMenuBar – Панель меню
	 * EditMenu, FontMenu – Меню действий и меню шрифта, устанавливаемые в панель
	 * MenuItem1, MenuItem2, MenuItem3, MenuItem4, MenuItem5 – Элементы меню действий
	 * FontMenuItem1, FontMenuItem2, FontMenuItem3, FontMenuItem4 – Элементы меню изменения шрифта
	 * ReglamentLevel – Переменная для хранения уровня регламента
	 * Reglament – Объект типа Reglament, определяющий регламент
	 * AdminWindow – Экземпляр окна администрирования
	 * SaveButton – Кнопка для сохранения регламента на жестком диске
	 * BackToPreviousFormButton – Кнопка для сохранения регламента на жестком диске
	 * LoadDefaultReglament – Кнопка для сохранения регламента на жестком диске
	 */
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
	private JMenuItem MenuItem1, MenuItem2, MenuItem3, MenuItem4, MenuItem5, FontMenuItem1, FontMenuItem2, FontMenuItem3, FontMenuItem4;
	private int ReglamentLevel;
	private Reglament Reglament;
	private AdminSelectWindow AdminWindow;
	private JButton SaveButton;
	private JButton BackToPreviousFormButton;
	private JButton LoadDefaultReglament;

	/**
	 * Создание конструктора для класса окна создания регламента
	 * @param reglamentLevel Уровень регламента, требуемый для создания отдельного экземпляра этого окна
	 */
	public InstallReglamentWindow(int reglamentLevel) {
		this.ReglamentLevel = reglamentLevel;
	}
	/**
	 * Сеттер уровня создаваемого регламента
	 */
	public void setLevel(int reglamentLevel) {
		this.ReglamentLevel = reglamentLevel;
	}
	/**
	 * Метод, инициализирующий граф. интерфейс
	 */
	private void spawn(int n) {
		/**
		 * Создания экземпляра окна администратора
		 */
		AdminWindow = new AdminSelectWindow();
		/**
		 * Создание основной панели
		 */
		MainPanel = CreateMainPanel();
		/**
		 * Создание основной текстовой панели с параметром false, недопускающим редактирование
		 */
		MainTextPanel = CreateMainTextPanel(true);
		/**
		 * Создание основного фрейма, задание названия, задания уровня регламента, прикрепление к панели
		 */
		MainFrame = CreateMainFrame("Создание регламента для уровня доступа ", ReglamentLevel, MainPanel);
		/**
		 * Создания панели с ползунком, прикрепление к текстовой панели
		 */
		MainTextScrollPanel = createScrollPane(MainTextPanel);
		/**
		 * Создания экземплеяра объекта типа Reglament, установка уровня,
		 * установка пустого названия, содержания и привязка к текстовой панели
		 */
		Reglament = new Reglament(n, "", "", MainTextPanel);
		/**
		 * Создание шрифта
		 */
		TextPanelFont = new Font("Monotype Corsiva", Font.PLAIN, 15);
		/**
		 * Установка шрифта на текстовую панель
		 */
		MainTextPanel.setFont(TextPanelFont);

		/**
		 * Создание кнопки сохранения регламента, задание названия, задание названия кнопки и ее размеров
		 */
		SaveButton = CreateButton("Сохранить", 20, 420, 120, 30);
		/**
		 * Создание кнопки возвращения к основному меню, задание названия, задание названия кнопки и ее размеров
		 */
		BackToPreviousFormButton = CreateButton("Назад", 150, 420, 120, 30);
		/**
		 * Создание кнопки загрузки структуры регламента, задание названия, задание названия кнопки и ее размеров
		 */
		LoadDefaultReglament = CreateButton("Создать структуру регламента", 20, 370, 250, 30);
		
		/**
		 * Создание элементов меню действий, задания им названия
		 */
		MenuItem1 = createMenuItem("Копировать (Ctrl + C)");
		MenuItem2 = createMenuItem("Вырезать (Ctrl + X)");
		MenuItem3 = createMenuItem("Вставить (Ctrl + V)");
		MenuItem4 = createMenuItem("Выбрать все (Ctrl + A)");
		MenuItem5 = createMenuItem("Удалить");

		/**
		 * Создание элементов меню изменяния шрифта, задания им названия
		 */
		FontMenuItem1 = createMenuItem("Обычный");
		FontMenuItem2 = createMenuItem("Жирный");
		FontMenuItem3 = createMenuItem("Курсив");
		FontMenuItem4 = createMenuItem("Жирный курсив");

		/**
		 * Задания названий для меню
		 */
		EditMenu = createMenu("Действия");
		FontMenu = createMenu("Шрифт");

		/**
		 * Содзание панели меню
		 */
		MainMenuBar = createMenuBar();

		/**
		 * Добавление элементов меню на меню
		 */
		addMenuItemToMenu(MenuItem1, EditMenu);
		addMenuItemToMenu(MenuItem2, EditMenu);
		addMenuItemToMenu(MenuItem3, EditMenu);
		addMenuItemToMenu(MenuItem4, EditMenu);
		addMenuItemToMenu(MenuItem5, EditMenu);
		addMenuItemToMenu(FontMenuItem1, FontMenu);
		addMenuItemToMenu(FontMenuItem2, FontMenu);
		addMenuItemToMenu(FontMenuItem3, FontMenu);
		addMenuItemToMenu(FontMenuItem4, FontMenu);

		/**
		 * Добавления меню на панель
		 */
		addMenuToMenuBar(EditMenu, MainMenuBar);
		addMenuToMenuBar(FontMenu, MainMenuBar);

		/**
		 * Добавление панели меню к фрейму
		 */
		addMenuBarToFrame(MainMenuBar, MainFrame);
		
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(MainFrame, MainTextScrollPanel);
		addComponentToFrame(MainFrame, SaveButton);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		addComponentToFrame(MainFrame, LoadDefaultReglament);



		/**
		 * Создание слушателей для кнопок меню
		 */
		/**
		 * Создание слушателя для кнопки копирования выделенного текста
		 */
		MenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				TempContent = MainTextPanel.getSelectedText();
			}
		});
		/**
		 * Создание слушателя для кнопки вырезания выделенного текста
		 */
		MenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				TempContent = MainTextPanel.getSelectedText();
				/**
				 * Если выделенный текст присутствует (Метод getSelectedText() возвращает null,
				 * если ничего не было выделено
				 */
				if (TempContent != null) {
					/**
					 * Запись расположения в основном тексте первого символа выделенного текста в переменную
					 */
					TempNumContent = MainTextPanel.getText().indexOf(TempContent);
					/**
					 * Замена выделенного текста пустой строкой
					 */
					MainTextPanel.replaceRange("", TempNumContent, TempNumContent + TempContent.length());
				}
			}
		});
		/**
		 * Создание слушателя для кнопки вставки сохраненного текста
		 */
		MenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись расположения каретки относительного основного текста в переменную
				 */
				TempNumContent = MainTextPanel.getCaretPosition();
				/**
				 * Вставка сохраненного текста в место расположения каретки
				 */
				MainTextPanel.insert(TempContent, TempNumContent);
			}
		});
		/**
		 * Создание слушателя для кнопки выделения всего текста
		 */
		MenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись длинны текста в переменную
				 */
				TempNumContent = MainTextPanel.getText().length();
				/**
				 * Выбор текста
				 */
				MainTextPanel.select(0,TempNumContent);
			}
		});

		/**
		 * Создание слушателя для кнопки удаления текста
		 */
		MenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				DelContent = MainTextPanel.getSelectedText();
				/**
				 * Если выделенный текст присутствует (Метод getSelectedText() возвращает null,
				 * если ничего не было выделено
				 */
				if (DelContent != null) {
					/**
					 * Запись расположения в основном тексте первого символа выделенного текста в переменную
					 */
					TempNumContent = MainTextPanel.getText().indexOf(DelContent);
					/**
					 * Замена выделенного текста пустой строкой
					 */
					MainTextPanel.replaceRange(" ", TempNumContent, TempNumContent + DelContent.length());
				}
			}
		});
		
		/**
		 * Создание слушателей для кнопки изменения стиля текста
		 */
		FontMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на обычный
				 */
				setFontStyle(TextPanelFont,Font.PLAIN,MainTextPanel);
			}
		});
		FontMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на жирный
				 */
				setFontStyle(TextPanelFont,Font.BOLD,MainTextPanel);
			}
		});
		FontMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на курсив
				 */ 
				setFontStyle(TextPanelFont,Font.ITALIC,MainTextPanel);
			}
		});
		FontMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на жирный курсив
				 */
				setFontStyle(TextPanelFont,Font.ITALIC | Font.BOLD,MainTextPanel);
			}
		});
		

		/**
		 * Создания слушателя для кнопки сохранения
		 */
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Установка содержимого регламента
					 */
					Reglament.setReglamentContent(MainTextPanel);
					/**
					 * Вызов метода, сохраняющего регламент на диск
					 */
					Reglament.savePermanently();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * Создания слушателя для загрузки структуры регламента
		 */
		LoadDefaultReglament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Установка содержимого регламента
					 */
					Reglament.setReglamentContent(MainTextPanel);
					/**
					 * Вызов метода, загружающего структуру регламента
					 */
					Reglament.loaddefault();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
				 * Вызов окна администрирования
				 */
				AdminWindow.init();
			}
		});

		/**
		 * Загрузка регламента при открытии окна
		 */
		try {
			/**
			 * Установка текстовой панели для записи в нее содержимого регламента
			 */
			Reglament.setReglamentContent(MainTextPanel);
			/**
			 * Метод, производящий загрузку регламента
			 */
			Reglament.loadPermanently();
			/**
			 * Вывод сообщения об ошибки отсутствия регламента на диске
			 */
		} catch (FileNotFoundException e1) {
			System.out.println("Невозможно загрузить регламент. Регламент ещё не был назначен.");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(MainFrame);
	}
	/**
	 * Публичный метод для вызова граф. интерфейса этого окна из других классов
	 */
	public void init() {
		spawn(ReglamentLevel);
	}
}
