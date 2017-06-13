package part2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class VennDiagramm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //get data first:

        List<String> listA = ListsLoader.loadListA();
        List<String> listB = ListsLoader.loadListB();

        /**
         * YOUR CODE HERE:
         * Given two lists of items, List-A and List-B, your task is
         * to draw a Venn diagramm and show what is the overlap of these Lists
         * and how many elements are unique for the List-A (respectively for List-B).
         *
         * Here is a description: http://www.datavizcatalogue.com/methods/venn_diagram.html
         * */

    }
}
