package lesson5.view;

import lesson5.controller.DoBackupController;
import lesson5.service.DoBackupService;

import java.util.Scanner;

public class Menu {

    private static final String WELCOME = """
                Добро пожаловать в систему создающую backup'ы файлов внутри указанной директории.
                Чтобы не допустить ошибку, укажите абсолютный путь, например, для Windows 'C:\\User\\Folder\\' и /home/user/folder/ для macOS и linux.
                -------------------""";
    private static final String PATH = "Путь: ";
    public static void start(){

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(WELCOME);
            System.out.println(PATH);
            String pathToDir = scanner.nextLine();
//            String pathToDir ="/Users/sergejklokov/Downloads/test";
            new DoBackupController().doBackup(pathToDir);
        }

    }

}



