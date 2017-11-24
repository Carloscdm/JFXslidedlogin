package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import fxwindow.fxmove.FXMove;

	/**
	 * 
	 * @author 21651713
	 *
	 */


public class Controller implements Initializable {
	 @FXML private AnchorPane root;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;
    
    /**
     * Se crea FXMove para poder desplazar la ventana
     * Acompaņado de sus propiedades con eventos para que funcione correctamente
     * OnMouseDragged y OnMousePressed
     */
    
    private FXMove fxmove;
    
    @FXML
    void OnMouseDragged(MouseEvent event) {
    	fxmove.moveDragged(event);
    }

    @FXML
    void OnMousePressed(MouseEvent event) {
    	fxmove.movePressed(event);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pane1.setStyle("-fx-background-image: url(\"/sample/6.jpg\")");
        pane2.setStyle("-fx-background-image: url(\"/sample/2.jpg\")");
        pane3.setStyle("-fx-background-image: url(\"/sample/3.jpg\")");
        pane4.setStyle("-fx-background-image: url(\"/sample/4.jpg\")");
        
        fxmove = new FXMove(root);

        backgroundAnimation();

    }

    private void backgroundAnimation() {

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                   FadeTransition fadeTransition0 =new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition0.setToValue(1);
                    fadeTransition0.setFromValue(0);
                    fadeTransition0.play();

                    fadeTransition0.setOnFinished(event3 -> {

                        FadeTransition fadeTransition11 =new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {

                            FadeTransition fadeTransition22 =new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                                backgroundAnimation();
                            });

                        });

                    });

                });
            });

        });

    }
}
