package dad.maven.adivin.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	private Label label1;
	private TextField textField1;
	private Button button1;
	private int tries= 0;
	private int numToGuess = (int) (Math.random()*100)+1;
	Alert alert;

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		label1 = new Label ("Introduce un número del 1 al 100");
		
		textField1 = new TextField();
		textField1.setMaxWidth(100);
		textField1.setAlignment(Pos.CENTER);
		
		button1 = new Button("Comprobar");
		button1.setDefaultButton(true);
		button1.setOnAction(e1 -> onButtonAction(e1));
		
		VBox root = new VBox(6, label1, textField1, button1);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 320, 200);	
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	private void onButtonAction(ActionEvent e1) {
		try {
			int inputNumber = Integer.parseInt(textField1.getText());
			if(inputNumber==numToGuess) {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado " +tries+ " intentos.\n\nVuelve a jugar y hazlo mejor.");
				numToGuess = (int) (Math.random()*100)+1;
				tries = 0;
				alert.showAndWait();
			}
			else if(inputNumber<numToGuess && inputNumber<100 && inputNumber > 0) {
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es mayor que " +inputNumber+ ".\n\nVuelve a intentarlo.");
				tries++;
				alert.showAndWait();
			}
			else if(inputNumber>numToGuess && inputNumber<100 && inputNumber > 0) {
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es menor que " +inputNumber+ ".\n\nVuelve a intentarlo.");
				tries++;
				alert.showAndWait();
			}
			else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Error");
				alert.setContentText("El número introducido no es válido.");
				alert.showAndWait();
			}
		} catch (NumberFormatException e2) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("No introduzcas texto o dejes el cuadro vacío");
			alert.showAndWait();	
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
