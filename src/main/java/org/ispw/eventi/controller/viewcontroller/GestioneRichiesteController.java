package org.ispw.eventi.controller.viewcontroller;

import org.ispw.eventi.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class GestioneRichiesteController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(GestioneRichiesteController.class.getName());
    private static final String STYLE_TRASPARENTE = "-fx-background-color: transparent; -fx-text-fill: #64748B;";
    private static final String STYLE_NAV_ATTIVO  = "-fx-background-color: transparent; -fx-text-fill: #2563EB; -fx-font-weight: BOLD;";

    @FXML private Button btnNavHome;
    @FXML private Button btnNavEsplora;
    @FXML private Button btnNavGestioneRichieste;
    @FXML private Label labelNomeUtente;
    @FXML private VBox listaRichieste;

    private final NavigationService nav;

    public GestioneRichiesteController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNavAttivo(btnNavGestioneRichieste);
        // da frare: caricare il nome organizzatore dalla SessioneUtente
        // da fare: caricare le richieste dal DAO
        LOGGER.info("GestioneRichiesteController inizializzato");
    }

    @FXML
    private void handleHome() {
        LOGGER.info("click: home");
        nav.goToHome();
    }

    @FXML
    private void handleEsploraAttivita() {
        LOGGER.info("click: esplora attività");
        nav.goToEsploraAttivita();
    }

    @FXML
    private void handleGestioneRichieste() {
        LOGGER.info("click: gestione richieste");
        nav.goToGestioneRichieste();
    }

    @FXML
    private void handleLogout() {
        LOGGER.info("click: logout");
        // da fare: pulizia SessioneUtente
        nav.goToHome();
    }

    private void setNavAttivo(Button bottoneAttivo) {
        for (Button b : List.of(btnNavHome, btnNavEsplora, btnNavGestioneRichieste)) {
            b.setStyle(STYLE_TRASPARENTE);
        }
        bottoneAttivo.setStyle(STYLE_NAV_ATTIVO);
    }
}