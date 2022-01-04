package example;

import java.util.concurrent.Phaser;

public class CreateThread extends Thread {
    private final Phaser phaser;



    public CreateThread(String name, Phaser phaser) {
        super(name);
        this.phaser = phaser;
    }



    @Override
    public void run() {
        System.out.printf("start %s%n", getName());
//блокировка потока без прибытия
        phaser.awaitAdvance(phaser.getPhase());
        System.out.printf("end %s%n", getName());
    }
}
