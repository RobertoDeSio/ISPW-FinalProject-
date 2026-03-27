package org.ispw.eventi.controller.viewcontroller;

import org.ispw.eventi.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EsploraController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(EsploraController.class.getName());
    private static final String STYLE_TRASPARENTE = "-fx-background-color: transparent; -fx-text-fill: #64748B;";
    private static final String STYLE_NAV_ATTIVO  = "-fx-background-color: transparent; -fx-text-fill: #2563EB; -fx-font-weight: BOLD;";
    private static final String FXML_CARD         = "/org/ispw/eventi/fxml/cardEvento.fxml";

    // Navbar
    @FXML private Button btnNavHome;
    @FXML private Button btnNavEsplora;
    @FXML private Button btnNavPrenotazioni;
    @FXML private Label labelNomeUtente;

    // Filtri
    @FXML private FlowPane flowPaneEventi;
    @FXML private Button btnFiltroAll;
    @FXML private Button btnFiltroMoto;
    @FXML private Button btnFiltroBoat;
    @FXML private Button btnFiltroTrekking;

    private final NavigationService nav;

    public EsploraController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNavAttivo(btnNavEsplora);
        // TODO: caricare il nome utente dalla SessioneUtente
        // TODO: sostituire dati statici con dati reali dal DAO
        aggiungiCard("MOTO",     "Giro in Moto sulle Dolomiti", "15 giugno 2026", "Bolzano, IT",    "4/10 posti occupati",  "€45");
        aggiungiCard("BOAT",     "Giornata in Barca a Vela",    "20 luglio 2026",  "Portofino, IT",  "0/6 posti occupati",   "€120");
        aggiungiCard("TREKKING", "Trekking Monte Bianco",        "10 agosto 2026",  "Courmayeur, IT", "8/15 posti occupati",  "€30");
        LOGGER.info("EsploraController inizializzato");
    }

    // -------------------------------------------------------------------------
    // Navigazione
    // -------------------------------------------------------------------------

    @FXML
    private void tornaIndietro() {
        LOGGER.info("click: tornaIndietro");
        nav.goToHome();
    }

    @FXML
    private void handleEsplora() {
        LOGGER.info("click: handleEsplora");
        nav.goToEsploraAttivita();
    }

    @FXML
    private void vaiAPrenotazioni() {
        LOGGER.info("click: vaiAPrenotazioni");
        nav.goToPrenotazioni();
    }

    @FXML
    private void handleLogout() {
        LOGGER.info("click: handleLogout");
        nav.goToHome();
    }

    // -------------------------------------------------------------------------
    // Filtri
    // -------------------------------------------------------------------------

    @FXML
    private void handleFiltroAll() {
        setFiltroAttivo(btnFiltroAll);
        LOGGER.info("click: filtro ALL");
    }

    @FXML
    private void handleFiltroMoto() {
        setFiltroAttivo(btnFiltroMoto);
        LOGGER.info("click: filtro MOTO");

    }

    @FXML
    private void handleFiltroBoat() {
        setFiltroAttivo(btnFiltroBoat);
        LOGGER.info("click: filtro BOAT");
    }

    @FXML
    private void handleFiltroTrekking() {
        setFiltroAttivo(btnFiltroTrekking);
        LOGGER.info("click: filtro TREKKING");
    }

    @FXML
    private void handleVediDettagli() {
        LOGGER.info("click: vediDettagli");
    }

    // -------------------------------------------------------------------------
    // Card
    // -------------------------------------------------------------------------

    private void aggiungiCard(String categoria, String nome, String data,
                              String luogo, String posti, String prezzo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_CARD));
            loader.setController(new CardEventoController(categoria, nome, data, luogo, posti, prezzo));
            VBox card = loader.load();
            flowPaneEventi.getChildren().add(card);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e, () -> "Errore caricamento card: " + nome);
        }
    }

    // -------------------------------------------------------------------------
    // Helpers stile
    // -------------------------------------------------------------------------

    private void setNavAttivo(Button bottoneAttivo) {
        for (Button b : List.of(btnNavHome, btnNavEsplora, btnNavPrenotazioni)) {
            b.setStyle(STYLE_TRASPARENTE);
        }
        bottoneAttivo.setStyle(STYLE_NAV_ATTIVO);
    }

    private void setFiltroAttivo(Button bottoneAttivo) {
        for (Button b : List.of(btnFiltroAll, btnFiltroMoto, btnFiltroBoat, btnFiltroTrekking)) {
            b.getStyleClass().remove("filter-button-active");
            b.setStyle(STYLE_TRASPARENTE);
        }
        bottoneAttivo.getStyleClass().add("filter-button-active");
        bottoneAttivo.setStyle("");
    }
}