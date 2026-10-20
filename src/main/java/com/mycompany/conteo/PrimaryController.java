package com.mycompany.conteo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtContador;
    @FXML private Button btnContar;
    @FXML private ProgressBar progressBar;
    @FXML private Button btnEsperar;
    private int numeroClicks = 0;

    @FXML
    private void clicContar() {
        numeroClicks++;
        txtContador.setText(String.valueOf(numeroClicks));
    }

    @FXML
    private void clicEsperar() {
        btnEsperar.setDisable(false); 
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);
       
        Thread hiloEspera = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(100); 
                    final double progresoActual = i / 100.0;

                    
                    Platform.runLater(() -> {
                        progressBar.setProgress(progresoActual);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                
                Platform.runLater(() -> {
                    btnEsperar.setDisable(false);
                });
            }
        });

        
        hiloEspera.start();
    }
}