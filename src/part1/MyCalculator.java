package part1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MyCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        //root.setGridLinesVisible(true);
        /** Put the scene in the center */
        root.setAlignment(Pos.CENTER);
        /** Add some spacing between elements */
        root.setVgap(10);
        root.setHgap(10);


        /**
         * YOUR CODE HERE:
         * implement a sophisticated calculator.
         * you can use <code>part1.NaiveCalculator</code>
         * as a template.
         * */

        Scene scene = new Scene(root, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle(String.format("%s's Calculator", System.getProperty("user.name")));
        primaryStage.show();


    }
}
