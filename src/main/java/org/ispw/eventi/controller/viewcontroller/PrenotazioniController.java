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

public class PrenotazioniController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(PrenotazioniController.class.getName());
    private static final String STYLE_TRASPARENTE = "-fx-background-color: transparent; -fx-text-fill: #64748B;";
    private static final String STYLE_NAV_ATTIVO  = "-fx-background-color: transparent; -fx-text-fill: #2563EB; -fx-font-weight: BOLD;";

    @FXML private Button btnNavHome;
    @FXML private Button btnNavEsplora;
    @FXML private Button btnNavPrenotazioni;
    @FXML private Label labelNomeUtente;
    @FXML private VBox listaPrenotazioni;

    private final NavigationService nav;

    public PrenotazioniController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNavAttivo(btnNavPrenotazioni);
        // da fare:: caricare il nome utente dalla SessioneUtente
        //       es. labelNomeUtente.setText(SessioneUtente.getInstance().getUtenteLoggato().getNome());
        // da fare: caricare le prenotazioni dal DAO
        LOGGER.info("PrenotazioniController inizializzato");
    }

    // -------------------------------------------------------------------------
    // Navigazione
    // -------------------------------------------------------------------------

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
    private void handlePrenotazioni() {
        LOGGER.info("click: le mie prenotazioni");
        nav.goToPrenotazioni();
    }

    @FXML
    private void handleLogout() {
        LOGGER.info("click: logout");
        // da fare: pulizia SessioneUtente
        nav.goToHome();
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    private void setNavAttivo(Button bottoneAttivo) {
        for (Button b : List.of(btnNavHome, btnNavEsplora, btnNavPrenotazioni)) {
            b.setStyle(STYLE_TRASPARENTE);
        }
        bottoneAttivo.setStyle(STYLE_NAV_ATTIVO);
    }
}