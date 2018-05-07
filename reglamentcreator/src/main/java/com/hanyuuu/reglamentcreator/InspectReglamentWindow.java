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
 * Импортирование библиотек с графическим интерфейсом
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InspectReglamentWindow extends ReglamentWindow {
	/**
	 * Объявление элементов:
	 * 
	 * MainPanel – Основная панель
	 * MainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * TextScrollPanel – Панель с ползунком для текстового поля
	 * MainTextPanel – Основное текстовое поле для ввода
	 * SaveButton – Кнопка для сохранения регламента на жестком диске
	 * BackToPreviousFormButton – Кнопка для перехода в основное меню программы
	 * SelctWindow – Класс основного окна
	 * Reglament – Объект типа Reglament, определяющий регламент
	 * FileSaver – Объект типа Saver, используемый для выбора директории для сохранения
	 * TempDirHolder – Строка для временного хранения ссылки на используемую для сохранения директорию
	 */
	private JPanel MainPanel;
	private JScrollPane TextScrollPanel;
	private JTextArea MainTextPanel;
	private JFrame MainFrame;
	private JButton SaveButton;
	private JButton BackToPreviousFormButton;
	private int ReglamentLevel;
	private SelectWindow SelctWindow;
	private Reglament Reglament;
	private Saver FileSaver;
	private String TempDirHolder;
	/**
	 * Создание конструктора для класса окна просмотра регламента
	 * @param ReglamentLevel Уровень регламента, требуемый для создания отдельного экземпляра этого окна
	 */
	public InspectReglamentWindow(int ReglamentLevel) {
		this.ReglamentLevel = ReglamentLevel;
	}
	/**
	 * Геттер уровня создаваемого регламента
	 */
	public int getLevel() {
		return ReglamentLevel;
	}
	/**
	 * Сеттер уровня создаваемого регламента
	 */
	public void setLevel(int ReglamentLevel) {
		this.ReglamentLevel = ReglamentLevel;
	}
	/**
	 * Метод, инициализирующий граф. интерфейс
	 * @param ReglamentLevel
	 */
	private void spawn(final int ReglamentLevel) {
		/**
		 * Создание основной панели
		 */
		MainPanel = CreateMainPanel();
		/**
		 * Создание основной текстовой панели с параметром false, недопускающим редактирование
		 */
		MainTextPanel = CreateMainTextPanel(false);
		/**
		 * Создание кнопки сохранения регламента на диск, задание названия, задание названия кнопки и ее размеров
		 */
		SaveButton = CreateButton("Сохранить на диск", 20, 370, 150, 30);
		/**
		 * Создание кнопки возвращения к основному меню, задание названия, задание названия кнопки и ее размеров
		 */
		BackToPreviousFormButton = CreateButton("Назад", 180, 370, 120, 30);
		/**
		 * Создание основного фрейма, задание названия, задания уровня регламента, прикрепление к панели
		 */
		MainFrame = CreateMainFrame("Просмотр регламента для уровня ", ReglamentLevel, MainPanel);
		/**
		 * Создание панели с ползунком, привязка к текстовой панели
		 */
		TextScrollPanel = createScrollPane(MainTextPanel);
		
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(MainFrame, TextScrollPanel);
		addComponentToFrame(MainFrame, SaveButton);
		addComponentToFrame(MainFrame, BackToPreviousFormButton);
		/**
		 * Создания экземплеяра объекта типа Reglament, установка уровня,
		 * установка пустого названия, содержания и привязка к текстовой панели
		 */
		Reglament = new Reglament(ReglamentLevel, "", "", MainTextPanel);

		/**
		 * Создания экземпляра основного окна
		 */
		SelctWindow = new SelectWindow();
		/**
		 * Создание слушателей для кнопок
		 */
		/**
		 * Создания слушателя для кнопки сохранения
		 */
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Создание экземпляра объекта Saver, вызывающий интерфейс выбора директории на диске
					 */
					FileSaver = new Saver();
					/**
					 * Запись пути к выбранной директории в строку 
					 */
					TempDirHolder = FileSaver.getDirectory();
					/**
					 * Если директория выбрана, производится сохранение
					 */
					if (TempDirHolder != "") {
						/**
						 * Установка пути для сохранения регламенту
						 */
						Reglament.setReglamentPath(TempDirHolder);
						/**
						 * Установка названия регламента
						 */
						Reglament.setReglamentName("ReglamentForLevel " + ReglamentLevel);
						/**
						 * Установка содержимого регламента
						 */
						Reglament.setReglamentContent(MainTextPanel);
						/**
						 * Вызов метода, сохраняющего регламент на диск
						 */
						Reglament.save();
						/**
						 * Если директория не была выбрана, вывести сообщение о том,
						 * что сохранение не будет произведено
						 */
					} else {
						createErrorMessage(MainFrame,
								"Отмена выбора директории. Сохранение произведено не будет.",
								"Сохранение отменено");
					}
				} catch (FileNotFoundException e1) {
					createErrorMessage(MainFrame,
							"Сохранение провести не удалось. Отказано в доступе.",
							"Сохранение отменено");
				}catch (Exception e1) {
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
				 * Вызов метода инициализирующего граф. интерфейс основного окна
				 */
				SelctWindow.init();
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
			createErrorMessage(MainFrame,
					"Отсутствует файл ReglamentForLevel " + ReglamentLevel + ".reglament. Проверьте правильность установки программы",
					"Сохранение отменено");
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

