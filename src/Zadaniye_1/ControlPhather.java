package Zadaniye_1;

import java.util.concurrent.Phaser;

public class ControlPhather extends Thread {

    private Phaser phaser;
    private int numPhase;

    {
        numPhase=3;
    }


    public ControlPhather(String name, Phaser phaser) {
        super(name);
        this.phaser = phaser;
    }

    public ControlPhather(String name, Phaser phaser, int numPhase) {
        super(name);
        this.phaser = phaser;
        this.numPhase=numPhase;
    }


    @Override
    public void run() {

        for (int i = 0; i < numPhase; i++) {
            System.out.println("Число мест: " + phaser.getRegisteredParties());
            for (int j = 0; j < phaser.getRegisteredParties(); j++) {
                new CreateThread("Thread_"+j+" фаза "  +phaser.getPhase()).start();
            }
            Tools.sleepThread(3000);
            System.out.println("--------------- Фаза "+phaser.getPhase()+" завершена -----------------");

            for (int j = 0; j < phaser.getRegisteredParties(); j++) {
                phaser.arrive();
            }

            phaser.register();

        }

    }
}
