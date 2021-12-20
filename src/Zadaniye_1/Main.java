package Zadaniye_1;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);

        ControlPhather controlThread = new ControlPhather("Control Thread",phaser);
        controlThread.start();
        controlThread.control();
    }
}
