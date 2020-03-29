package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/**
 * Draws a self-portrait.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class SelfPortrait extends Application {
    /**
     * Creates an self-portrait of Jay Rim A01174716.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {


        Group head = new Head();


        // use of rectangle + font/text practice //
        Rectangle rect = new Rectangle(80, 450, 300, 100);
        rect.setStroke(Color.RED);
        rect.setStrokeWidth(15);
        rect.setFill(null);


        Text wantedText = new Text(100, 500, "Jay Rim A01174716");
        Font bigBoldFont = new Font("Courier", 30);
        wantedText.setFont(bigBoldFont);

        Group label = new Group(rect, wantedText);
        // end of text + rectangle



        //Use of image + transformation
        Image logo = new Image("http://pngimg.com/uploads/whisky/whisky_PNG133.png");
        ImageView imageView = new ImageView(logo);
        imageView.setViewport(new Rectangle2D(30, 30, 500, 500));
        imageView.setTranslateX(250);
        imageView.setTranslateY(300);
        imageView.setScaleX(0.8);
        imageView.setScaleY(0.8);
        imageView.getTransforms().add(new Rotate(270, 45, 150));
        imageView.getTransforms().add(new Shear(0.6, 0.2));
        // end of image



        // background
        Rectangle sky = new Rectangle(0, 0, 700, 400);
        sky.setFill(Color.STEELBLUE);
        Rectangle ground = new Rectangle(0, 400, 700, 300);
        ground.setFill(Color.CHOCOLATE);
        Group background = new Group(sky, ground);
        // end of background



        Group root = new Group(background, head, label, imageView);
        Scene scene = new Scene(root, 700, 700);

        primaryStage.setTitle("Jay Rim A01174716");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

