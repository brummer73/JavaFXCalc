package org.bredtmann;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FXCalc extends Application {

	private TextField displayField;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaFX Calculator");

		// Create the display field
		displayField = new TextField();
		displayField.setEditable(false);
		displayField.setStyle("-fx-font-size: 20px; -fx-alignment: center-right;");
		displayField.setPrefColumnCount(10);

		// Create the buttons
		Button btnClear = new Button("AC");
		btnClear.setOnAction(e -> clearDisplay());

		Button btnEquals = new Button("Execute");
		btnEquals.setOnAction(e -> evaluateExpression());

		Button[] digitButtons = new Button[10];
		for (int i = 0; i < 10; i++) {
			final int digit = i;
			digitButtons[i] = new Button(String.valueOf(i));
			digitButtons[i].setOnAction(e -> appendToDisplay(String.valueOf(digit)));
		}

		Button btnPlus = new Button("+");
		btnPlus.setOnAction(e -> appendToDisplay("+"));

		Button btnMinus = new Button("-");
		btnMinus.setOnAction(e -> appendToDisplay("-"));

		Button btnMultiply = new Button("*");
		btnMultiply.setOnAction(e -> appendToDisplay("*"));

		Button btnDivide = new Button("/");
		btnDivide.setOnAction(e -> appendToDisplay("/"));

		Button btnDummy = new Button("Dmy");
		btnDummy.setOnAction(e -> appendToDisplay(""));
		
		Button btnDecimalPoint = new Button(",");
		btnDecimalPoint.setOnAction(e -> appendToDisplay(","));

		Button btnPrefix = new Button("+/-");
		btnPrefix.setOnAction(e -> appendToDisplay(""));
		
		Button btnPercent = new Button("%");
		btnPercent.setOnAction(e -> appendToDisplay("%"));

		// Create the grid pane and add components
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10));
		gridPane.add(displayField, 0, 0, 4, 1);

		gridPane.add(btnClear, 0, 1);
		gridPane.add(btnPrefix, 1, 1);
        gridPane.add(btnPercent, 2, 1);
		gridPane.add(btnDivide, 3, 1);

		gridPane.add(digitButtons[7], 0, 2);
		gridPane.add(digitButtons[8], 1, 2);
		gridPane.add(digitButtons[9], 2, 2);
		gridPane.add(btnMultiply, 3, 2);

		gridPane.add(digitButtons[4], 0, 3);
		gridPane.add(digitButtons[5], 1, 3);
		gridPane.add(digitButtons[6], 2, 3);
		gridPane.add(btnMinus, 3, 3);

		gridPane.add(digitButtons[1], 0, 4);
		gridPane.add(digitButtons[2], 1, 4);
		gridPane.add(digitButtons[3], 2, 4);
		gridPane.add(btnPlus, 3, 4);

		gridPane.add(digitButtons[0], 0, 5);
        gridPane.add(btnDecimalPoint, 1, 5);
		gridPane.add(btnEquals, 2, 5, 2, 1);

		// Create the scene and set it on the stage
		Scene scene = new Scene(gridPane);
		primaryStage.setScene(scene);

		// Show the stage
		primaryStage.show();
	}

	private void appendToDisplay(String text) {
		displayField.appendText(text);
	}

	private void clearDisplay() {
		displayField.clear();
	}

	private void evaluateExpression() {
		String expression = displayField.getText();
		try {
			double result = evaluate(expression);
			displayField.setText(String.valueOf(result));
		} catch (NumberFormatException | ArithmeticException e) {
			displayField.setText("Error");
		}
	}

	private double evaluate(String expression) {
		// You can use any expression evaluation library or write your own
		// logic to evaluate the expression and return the result.
		// This example does not include the evaluation logic.
		Expression exp = new ExpressionBuilder(expression).build();
//    	        .variables("x", "y")
//    	        .build()
//    	        .setVariable("x", 2.3)
//    	        .setVariable("y", 3.14);
		double result = exp.evaluate();
		return result;
	}
}
