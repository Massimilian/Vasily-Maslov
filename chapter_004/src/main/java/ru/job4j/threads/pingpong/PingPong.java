//
//package ru.job4j.threads.pingpong;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//
//
//public class PingPong extends Application {
//    private static final String JOB4J = "Пинг-понг www.job4j.ru - with few modifications";
//
//    @Override
//    public void start(Stage stage) {
//        int limitX = 510;
//        int limitY = 510;
//        Group group = new Group();
////        Rectangle rect = new Rectangle(50, 100, 10, 10);
////        group.getChildren().add(rect);
////        new Thread(new RectangleMove(rect, limitX)).start();
//        Circle circ = new Circle(20, 50, 10);
//        group.getChildren().add(circ);
//        new Thread(new CircleMove(circ, limitX, limitY)).start();
//        stage.setScene(new Scene(group, limitX, limitY));
//        stage.setTitle(JOB4J);
//        stage.setResizable(false);
//        stage.show();
//        stage.setOnCloseRequest(
//                event -> System.exit(0)// execute interrupt
//);
//    }
//}
