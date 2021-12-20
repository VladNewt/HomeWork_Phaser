package Zadaniye_2;

import Zadaniye_1.Tools;

import java.util.concurrent.Callable;

public class Copyer implements Callable<String> {

    private String sourcePath;
    private String destinationPath;


    public Copyer(String sourcePath, String destinationPath) {
        this.setSourcePath(sourcePath);
        this.setDestinationPath(destinationPath);
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath=sourcePath;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    @Override
    public String call() throws Exception {

        System.out.println("Выполняется копирование файла");
        //FileManager.copyFile(getSourcePath(),getDestinationPath());
        Tools.sleepThread(2000);

        return "Копирование завершено";
    }
}
