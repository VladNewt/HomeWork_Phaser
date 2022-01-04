package example;

import java.util.concurrent.Phaser;

public class ControlPhaser extends Thread {
    private final Phaser phaser;
    public ControlPhaser() {
        phaser = new Phaser(1);
    }

    private static void sleepThread(int time) {
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//логика работает в течении 3-х фаз
        for (int n = 0; n < 3; n++) {
//запуск потоков по количеству зарегистрированных мест

            for (int i = 0; i < phaser.getRegisteredParties(); i++) {
                new CreateThread(String.format("T%s P%s", i, phaser.getPhase()), phaser).start();
            }
//ожидание всех потоков
            sleepThread(2000);
//прибытие участников по количеству зарегистрированных мест
            for (int i = 0; i < phaser.getRegisteredParties(); i++)
                phaser.arrive();
//после перехода на новую фазу увеличивается количество мест
            System.out.println("Количество мест" + phaser.getRegisteredParties());
            phaser.register();
            System.out.println("Количество мест" + phaser.getRegisteredParties());
            sleepThread(2000);
            System.out.println();
        }
    }
}


