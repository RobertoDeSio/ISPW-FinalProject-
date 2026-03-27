package org.ispw.eventi.controller.viewcontroller;

import org.ispw.eventi.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private static final String STYLE_TRASPARENTE = "-fx-background-color: transparent; -fx-text-fill: #64748B;";
    private static final String STYLE_NAV_ATTIVO  = "-fx-background-color: transparent; -fx-text-fill: #2563EB; -fx-font-weight: BOLD;";

    @FXML private Button btnNavHome;
    @FXML private Button btnNavEsplora;

    private final NavigationService nav;

    public HomeController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNavAttivo(btnNavHome);
    }

    @FXML
    private void handleHome() {
        nav.goToHome();
    }

    @FXML
    private void handleAccedi() {
        nav.goToLogin();
    }

    @FXML
    private void handleEsploraAttivita() {
        nav.goToEsploraAttivita();
    }

    @FXML
    private void handlePrenotaEvento() {
        nav.goToPrenotaEvento();
    }

    @FXML
    private void handleCreaEvento() {
        nav.goToGestioneRichieste();
    }

    private void setNavAttivo(Button bottoneAttivo) {
        for (Button b : List.of(btnNavHome, btnNavEsplora)) {
            b.setStyle(STYLE_TRASPARENTE);
        }
        bottoneAttivo.setStyle(STYLE_NAV_ATTIVO);
    }
}