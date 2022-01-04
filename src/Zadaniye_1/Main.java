package Zadaniye_1;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);

        new ControlPhather("Control Thread",phaser).start();

    }
}
