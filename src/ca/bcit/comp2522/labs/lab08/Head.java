package ca.bcit.comp2522.labs.lab08;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


/**
 * Draws a Head of self-portrait.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Head extends Group {
    /**
     * Constructs Head to use for self-portrait.
     */
    public Head() {
        Circle face = new Circle(250.0, 250.0, 190.0);
        face.setStrokeWidth(15.0);
        face.setStroke(Color.BLACK);
        face.setFill(Color.BISQUE);


        Ellipse leftWhiteEye = new Ellipse(160.0, 280.0, 25.0, 15.0);
        leftWhiteEye.setFill(Color.WHITE);


        Ellipse rightWhiteEye = new Ellipse(340.0, 280.0, 25.0, 15.0);
        rightWhiteEye.setFill(Color.WHITE);


        Circle leftEye = new Circle(160.0, 280.0, 15.0);
        leftEye.setFill(Color.BLACK);


        Circle rightEye = new Circle(340.0, 280.0, 15.0);
        rightEye.setFill(Color.BLACK);


        Arc leftEyebrow = new Arc(160, 260, 40, 20, 0, 180);
        leftEyebrow.setFill(null);
        leftEyebrow.setStroke(Color.BLACK);
        leftEyebrow.setStrokeWidth(10.0);
        leftEyebrow.setType(ArcType.OPEN);


        Arc rightEyebrow = new Arc(340, 260, 40, 20, 0, 180);
        rightEyebrow.setFill(null);
        rightEyebrow.setStroke(Color.BLACK);
        rightEyebrow.setStrokeWidth(10.0);
        rightEyebrow.setType(ArcType.OPEN);


        Circle mouth = new Circle(250.0, 370.0, 30.0);
        mouth.setFill(Color.RED);


        Arc hair = new Arc(250.0, 250.0 - 30, 190, 160, 0, 180);
        hair.setFill(Color.BLACK);
        hair.setStroke(Color.BLACK);
        hair.setType(ArcType.ROUND);


        getChildren().addAll(face, leftWhiteEye, rightWhiteEye, leftEye, rightEye,
                leftEyebrow, rightEyebrow, mouth, hair);
    }
}

