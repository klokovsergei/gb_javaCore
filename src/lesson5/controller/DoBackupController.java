package lesson5.controller;

import lesson5.service.DoBackupService;

public class DoBackupController {
    private final String OK = "Backup успешно создан";
    private final String FAIL = "ОШИБКА!!! Backup НЕ создан.";
    public void doBackup(String path){
        boolean result = new DoBackupService().startBackup(path);
        if (result)
            System.out.println(OK);
        else
            System.out.println(FAIL);
    }
}
