package Zadaniye_1;

import java.util.concurrent.Phaser;

public class CreateThread extends Thread{

    public CreateThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Поток " + getName() + " запущен ");
    }
}
