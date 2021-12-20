package Zadaniye_2;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

       // E:\JAVA\file.jpg

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите путь до исходного файла:");
        String sourcePath = sc.nextLine();

        System.out.println("Введите путь назначения нового файла:");
        String destinationPath = sc.nextLine();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> task = service.submit(new Copyer(sourcePath, destinationPath));

        System.out.println("Введите /q для выхода");
        String exit = sc.nextLine();


        try {
            while (!task.isDone()) {
                if (exit.equals("/q")) {
                    service.shutdown();
                    System.out.println("Копирование прервано");
                    break;
                }

            }
        }
        finally {
            service.shutdown();
        }




    }
}
