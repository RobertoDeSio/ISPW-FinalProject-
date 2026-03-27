package org.ispw.eventi.controller.viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CardEventoController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(CardEventoController.class.getName());

    @FXML private Label labelPrezzo;
    @FXML private Label labelCategoria;
    @FXML private Label labelNome;
    @FXML private Label labelData;
    @FXML private Label labelLuogo;
    @FXML private Label labelPosti;

    private final String categoria;
    private final String nome;
    private final String data;
    private final String luogo;
    private final String posti;
    private final String prezzo;

    public CardEventoController(String categoria, String nome, String data,
                                String luogo, String posti, String prezzo) {
        this.categoria = categoria;
        this.nome      = nome;
        this.data      = data;
        this.luogo     = luogo;
        this.posti     = posti;
        this.prezzo    = prezzo;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelPrezzo.setText(prezzo);
        labelCategoria.setText(categoria);
        labelNome.setText(nome);
        labelData.setText("📅 " + data);
        labelLuogo.setText("📍 " + luogo);
        labelPosti.setText("👥 " + posti);
    }

    @FXML
    private void handleVediDettagli() {
        // da fare: navigare al dettaglio quando la view sarà pronta
        LOGGER.info("click: vedi dettagli — " + nome);
    }

}