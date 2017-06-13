package part1;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NaiveCalculator extends Application {

    /**
     * Declaring Controls elements for the Calculator application.
     */
    private TextField firstNumber, secondNumber;
    private Button addBtn, substractBtn, divBtn, multiplyBtn, clearBtn;
    private Label answerLabel;

    @Override
    public void start(Stage primaryStage) {
        /** First step: Initialise required Controls. */
        initControls();
        /** 3rd step: Add event processing for each Button Click. */
        addEventProcessingToButtons();

        /** Second step: Create a container for all Controls objects. */
        GridPane root = createRoot();
        /** Add to root: Cell by Cell*/
        addControlsToRoot(root);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Naive Calculator v0.1");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void addEventProcessingToButtons() {

        EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> processButtonClick(event);

        addBtn.setOnAction(eventHandler);
        substractBtn.setOnAction(eventHandler);
        divBtn.setOnAction(eventHandler);
        multiplyBtn.setOnAction(eventHandler);
        clearBtn.setOnAction(eventHandler);
    }

    private void processButtonClick(ActionEvent event) {
        String displayText = "";

        if (event.getSource() == clearBtn) {
            firstNumber.clear();
            secondNumber.clear();
            answerLabel.setText("?");
            firstNumber.requestFocus();
            return;
        }

        int num1 = Integer.parseInt(firstNumber.getText());
        int num2 = Integer.parseInt(secondNumber.getText());

        if (event.getSource() == addBtn) {
            int sum = num1 + num2;
            displayText = String.format("ANS: %d + %d = %d", num1, num2, sum);
        } else if (event.getSource() == substractBtn) {
            int substract = num1 - num2;
            displayText = String.format("ANS: %d - %d = %d", num1, num2, substract);

        } else if (event.getSource() == divBtn) {
            double division = num1 / Double.valueOf(num2);
            displayText = String.format("ANS: %d / %d = %.3f", num1, num2, division);

        } else if (event.getSource() == multiplyBtn) {
            int multiplication = num1 * num2;
            displayText = String.format("ANS: %d * %d = %d", num1, num2, multiplication);
        }

        answerLabel.setText(displayText);
    }

    private void addControlsToRoot(GridPane root) {
        /** Add to root: Cell by Cell*/
        root.add(firstNumber, 0, 0);
        root.add(secondNumber, 1, 0);
        root.add(addBtn, 0, 2);
        root.add(substractBtn, 1, 2);
        root.add(divBtn, 0, 3);
        root.add(multiplyBtn, 1, 3);

        /** Control elements that spans two columns in GridPlane. */
        root.add(answerLabel, 0, 1, 2, 1);
        root.add(clearBtn, 0, 4, 2, 1);
    }

    private GridPane createRoot() {
        /** Second step: Create a container for all Controls objects. */
        GridPane root = new GridPane();
        //root.setGridLinesVisible(true);
        /** Put the scene in the center */
        root.setAlignment(Pos.CENTER);
        /** Add some spacing between elements */
        root.setVgap(10);
        root.setHgap(10);
        return root;
    }

    private void initControls() {
        /** First step: Initialise required Controls. */


        /** Many developers requested a specific API to restrict input in the text field,
         * for example, to allow only number values.
         * To redefine the default implementation of the TextField class,
         * you must override the replaceText and replaceSelection methods
         * inherited from the TextInputControl class.
         * When the user tries to enter any letter in the text field, no symbols appear.*/
        firstNumber = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z, A-Z]")) {
                    super.replaceText(start, end, text);
                }
                //label.setText("Enter a numeric value");
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
                }
            }
        };
        firstNumber.setPrefWidth(70);

        secondNumber = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z, A-Z]")) {
                    super.replaceText(start, end, text);
                }
//                label.setText("Enter a numeric value");
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
                }
            }
        };
        secondNumber.setPrefWidth(70);

        addBtn = new Button("+");
        addBtn.setPrefWidth(70);

        substractBtn = new Button("-");
        substractBtn.setPrefWidth(70);

        divBtn = new Button("/");
        divBtn.setPrefWidth(70);

        multiplyBtn = new Button("*");
        multiplyBtn.setPrefWidth(70);

        clearBtn = new Button("clear");
        clearBtn.setPrefWidth(150);

        answerLabel = new Label("?");
        answerLabel.setAlignment(Pos.CENTER);
        answerLabel.setPrefWidth(150);
    }


    public static void main(String[] args) {
        launch(args);
    }


}

