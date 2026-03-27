package org.ispw.eventi.controller.viewcontroller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.ispw.eventi.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class RegistrazioneController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(RegistrazioneController.class.getName());

    private static final String BORDER_SELECTED   = "-fx-border-color: #2563EB; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 12; -fx-cursor: hand; -fx-background-color: white;";
    private static final String BORDER_UNSELECTED = "-fx-border-color: #E2E8F0; -fx-border-radius: 8; -fx-background-radius: 8; -fx-padding: 12; -fx-cursor: hand; -fx-background-color: white;";

    @FXML private VBox cardCliente;
    @FXML private VBox cardOrganizzatore;
    @FXML private TextField fieldEmail;
    @FXML private PasswordField fieldPassword;
    @FXML private PasswordField fieldConfermaPassword;


    private final NavigationService nav;

    public RegistrazioneController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Cliente selezionato di default
        cardCliente.setStyle(BORDER_SELECTED);
        cardOrganizzatore.setStyle(BORDER_UNSELECTED);
        LOGGER.info("RegistrazioneController inizializzato");
    }

    @FXML
    private void handleHome() {
        LOGGER.info("click: torna alla home");
        nav.goToHome();
    }

    @FXML
    private void handleSelezionaCliente() {
        LOGGER.info("click: seleziona cliente");
        cardCliente.setStyle(BORDER_SELECTED);
        cardOrganizzatore.setStyle(BORDER_UNSELECTED);
    }

    @FXML
    private void handleSelezionaOrganizzatore() {
        LOGGER.info("click: seleziona organizzatore");
        cardOrganizzatore.setStyle(BORDER_SELECTED);
        cardCliente.setStyle(BORDER_UNSELECTED);
    }

    @FXML
    private void handleRegistrazione() {
        LOGGER.info("click: registrati");
        // da fare: aggiungere logica di registrazione
        System.out.println(fieldEmail.getText() + " " + fieldPassword.getText() + " " + fieldConfermaPassword.getText());

    }

    @FXML
    private void handleAccedi() {
        LOGGER.info("click: accedi");
        nav.goToLogin();
    }
}