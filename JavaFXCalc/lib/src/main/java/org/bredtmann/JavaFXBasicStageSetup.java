package org.bredtmann;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class JavaFXBasicStageSetup extends Application {

    @Override
    public void start(Stage stage) {
    	// set window title
    	stage.setTitle("JavaFX Application");
    	
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        
        // Get the primary screen
        Screen screen = Screen.getPrimary();

        // Get the screen resolution
        Rectangle2D bounds = screen.getBounds();
        double screenWidth = bounds.getWidth();
        double screenHeight = bounds.getHeight();

        // Set the window dimensions based on the screen resolution
        double windowWidth = screenWidth; // Adjust this value as needed with (optional) factor
        double windowHeight = screenHeight; // Adjust this value as needed with (optional) factor

        // Create a Canvas with the calculated dimensions
        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Canvas canvas = new Canvas(windowWidth, windowHeight);
        StackPane pane = new StackPane(canvas);
        Scene scene = new Scene( pane, 1024, 720 );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
