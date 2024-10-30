package lesson5.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class DoBackupService {

    public boolean startBackup(String pathDir) {
        File[] files = getArrFiles(pathDir);
        return doBackup(pathDir, files);
    }

    private File[] getArrFiles(String in){
        File[] files = null;
        File file = new File(in);
        if (file.isDirectory())
            files = Arrays.stream(file.listFiles()).filter(x -> x.isFile()).toArray(File[]::new);
        return files;

    }

    private boolean doBackup(String pathDir, File[] files){
        if (files != null){
            Path backupPath = Paths.get(pathDir, "backup");
            try {
                Files.createDirectory(backupPath);
            } catch (FileAlreadyExistsException e){

            } catch (IOException e) {
                System.out.printf("Директорию \"backup\" не удалось создать.");
                e.printStackTrace();
                return false;
            }
            for (var file : files){
                try {
                    Files.copy(file.toPath(), Paths.get(backupPath.toString(), file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.printf("Файл %s не удалось скопировать." + System.lineSeparator(),file.getName());
                    e.printStackTrace();
                }
            }
            return true;
        } else {
            System.out.println("Нет списка для backup'а.");
        }
        return false;
    }

}
