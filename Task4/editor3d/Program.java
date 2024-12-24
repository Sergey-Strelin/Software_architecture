package editor3d;

import java.util.Scanner;

public class Program {
    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.

     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация .., в файловой системе компьютера).

     * Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере…
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        String fileName; // имя файла проекта
        while (f){
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Изменить параметры проекта");
            System.out.println("5. Отобразить все модели проекта");
            System.out.println("6. Отобразить все текстуры проекта");
            System.out.println("7. Выполнить рендеринг всех моделей");
            System.out.println("8. Выполнить рендеринг модели");
            System.out.println("9. Добавить 3D модель");
            System.out.println("10. Удалить 3D модель");
            System.out.println("11. Добавить текстуру");
            System.out.println("12. Удалить текстуру");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, введите нужный пункт меню: ");
            if (scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Укажите наименование файла проекта: ");
                            fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            break;
                        case 2:
                            System.out.print("Укажите наименование файла проекта для сохранения: ");
                            fileName = scanner.nextLine();
                            editor3D.saveProject(fileName);
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            System.out.print("Укажите новое имя файла проекта: ");
                            fileName = scanner.nextLine();
                            System.out.print("Укажите новое значение настройки 1(целое число): ");
                            int setting1=0;
                            if (scanner.hasNextInt()) {
                                setting1 = scanner.nextInt();
                                scanner.nextLine();
                            }
                            System.out.print("Укажите новое значение настройки 2(строка): ");
                            String setting2 = scanner.nextLine();
                            System.out.print("Укажите новое значение настройки 3(true / false): ");
                            String setting3 = scanner.nextLine();
                            editor3D.changeProgect(fileName, setting1, setting2, setting3);
                            break;
                        case 5:
                            editor3D.printAllModels();
                            break;
                        case 6:
                            editor3D.printAllTextures();
                            break;
                        case 7:
                            editor3D.renderAll();
                            break;
                        case 8:
                            System.out.print("Укажите номер модели для рендеринга : ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 9:
                            editor3D.addModel(new Model3D());
                            break;
                        case 10:
                            System.out.print("Укажите номер модели для удаления: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.removeModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 11:
                            editor3D.addTexture();
                            break;
                        case 12:
                            System.out.print("Укажите номер текстуры для удаления: ");
                            if (scanner.hasNextInt()) {
                                int textureNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.removeTexture(textureNo);
                            } else {
                                System.out.println("Номер текстуры указан некорректно.");
                            }
                            break;

                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }

}
