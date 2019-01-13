package ru.job4j.threads.pingpong;
//
//import javafx.scene.shape.Circle;
//
//public class CircleMove implements Runnable {
//    private final Circle circ;
//    private final int wallX;
//    private final int wallY;
//    private int countX = 5;
//    private int countY = 3;
//
//    public CircleMove(Circle circ, int x, int y) {
//        this.circ = circ;
//        this.wallX = x;
//        this.wallY = y;
//    }
//
//
//    @Override
//    public void run() {
//        while (true) {
//            this.circ.setCenterX(this.circ.getCenterX() + countX);
//            this.circ.setCenterY(this.circ.getCenterY() + countY);
//            if (this.circ.getCenterX() >= this.wallX - countX + 1 || this.circ.getCenterX() <= 10) {
//                countX = -countX;
//            }
//            if (this.circ.getCenterY() >= this.wallY - countY + 1 || this.circ.getCenterY() <= 10) {
//                countY = -countY;
//            }
//            try {
//                Thread.sleep(25);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}