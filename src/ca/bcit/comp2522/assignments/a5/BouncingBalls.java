package ca.bcit.comp2522.assignments.a5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Jay Rim A01174716
 * @version 2020
 */

public class BouncingBalls extends Application {

    /**
     * Size 500 of Scene X.
     *
     */

    public static final int SCENE_X = 500;

    /**
     * Size 500 of Scene Y.
     *
     */

    public static final int SCENE_Y = 500;

    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */

    public void start(Stage primaryStage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many balls do you want?: ");
        int numberOfBalls = scanner.nextInt();
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, SCENE_X, SCENE_Y);
//        List<Ball> balls = new ArrayList<>();
//        List<Ball> synchronized_balls = Collections.synchronizedList(balls);
//        synchronized_balls.add(new Ball());
//        synchronized_balls.add(new Ball());
//        synchronized_balls.add(new Ball());
        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
//        canvas.getChildren().addAll(synchronized_balls);
        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball = new Ball();
            ArrayList<Ball> listOfBalls = new ArrayList<>();
            canvas.getChildren().add(ball);
            listOfBalls.add(ball);
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        }
    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
