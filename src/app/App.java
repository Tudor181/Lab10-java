package app;

import swing.MySwing;

public class App {
    static private void ping() {
        for (int i = 0; i < 20; i++) {
            System.out.println("ping");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

    static private void pong() {
        for (int i = 0; i < 20; i++) {
            System.out.println("pong");
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        MySwing mySwing = new MySwing();
        mySwing.initialize();

        Runnable pingT = () -> {
            ping();
        };
        MyThread ping = new MyThread(pingT);

        Runnable pongT = () -> pong();
        MyThread pong = new MyThread(pongT);
        ping.start();
        pong.start();

    }
}
