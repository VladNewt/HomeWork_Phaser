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

        System.out.println("Введите /y для начала копирования файла или /q для прерывания");
        String exit = sc.nextLine();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> task = service.submit(new Copyer(sourcePath, destinationPath));




        try {
            while (!task.isDone()) {
                if (exit.equals("/q")) {
                    System.out.println("Копирование прервано");
                    task.cancel(false);
                    service.shutdown();
                    break;
                }
                System.out.println(task.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            service.shutdown();
        }




    }
}
