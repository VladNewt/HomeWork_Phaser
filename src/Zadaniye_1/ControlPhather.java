package Zadaniye_1;

import java.util.concurrent.Phaser;

public class ControlPhather extends Thread {

    private Phaser phaser;
    //private CreateThread[] createThreads;

    public ControlPhather(String name, Phaser phaser) {
        super(name);
        this.phaser = phaser;
        phaser.register();
    }


    @Override
    public void run() {
        //0 фаза
        new CreateThread("Thread_1 фаза "+phaser.getPhase()).start();
        Tools.sleepThread(3000);
        phaser.arriveAndAwaitAdvance();

        //1 фаза
        new CreateThread("Thread_2 фаза "+phaser.getPhase()).start();
        Tools.sleepThread(3000);
        phaser.arriveAndAwaitAdvance();

        //2 фаза
        new CreateThread("Thread_3 фаза "+phaser.getPhase()).start();
        Tools.sleepThread(3000);
        phaser.arriveAndAwaitAdvance();

    }

    public void control() {
        int p = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + p + " завершена");

        p = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + p + " завершена");

        p = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + p + " завершена");

        phaser.arriveAndDeregister();
    }
}
