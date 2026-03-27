package org.ispw.eventi.navigation;

import org.ispw.eventi.controller.viewcontroller.HomeController;
import org.ispw.eventi.controller.viewcontroller.EsploraController;
import org.ispw.eventi.controller.viewcontroller.PrenotazioniController;
import org.ispw.eventi.controller.viewcontroller.LoginController;
import org.ispw.eventi.controller.viewcontroller.RegistrazioneController;
import org.ispw.eventi.controller.viewcontroller.GestioneRichiesteController;
import org.ispw.eventi.exception.NavigationException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NavigationService {

    private static final String ERRORE_NAVIGAZIONE = "Errore di navigazione";

    private static final Logger LOGGER = Logger.getLogger(NavigationService.class.getName());

    private static final String FXML_HOME             = "/org/ispw/eventi/fxml/home.fxml";
    private static final String FXML_LOGIN            = "/org/ispw/eventi/fxml/login.fxml";
    private static final String FXML_REGISTRAZIONE    = "/org/ispw/eventi/fxml/registrazione.fxml";
    private static final String FXML_ESPLORA_ATTIVITA = "/org/ispw/eventi/fxml/esplora.fxml";
    private static final String FXML_PRENOTAZIONI     = "/org/ispw/eventi/fxml/prenotazioni.fxml";
    private static final String FXML_GESTIONE_RICHIESTE = "/org/ispw/eventi/fxml/gestioneRichieste.fxml";


    private final Stage stage;

    public NavigationService(Stage stage) {
        this.stage = stage;
    }

    // -------------------------------------------------------------------------
    // Metodi pubblici di navigazione — gestiscono NavigationException
    // -------------------------------------------------------------------------

    public void goToHome() {
        try {
            loadView(FXML_HOME, new HomeController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }

    public void goToLogin() {
        try {
            loadView(FXML_LOGIN, new LoginController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }

    public void goToRegistrazione() {
        try {
            loadView(FXML_REGISTRAZIONE,  new RegistrazioneController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }

    public void goToEsploraAttivita() {
        try {
            loadView(FXML_ESPLORA_ATTIVITA, new EsploraController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }
    public void goToPrenotazioni() {
        try {
            loadView(FXML_PRENOTAZIONI, new PrenotazioniController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }
    public void goToGestioneRichieste() {
        try {
            loadView(FXML_GESTIONE_RICHIESTE, new GestioneRichiesteController(this));
        } catch (NavigationException e) {
            LOGGER.log(Level.SEVERE, e, e::getMessage);
            showError(ERRORE_NAVIGAZIONE, e.getMessage());
        }
    }


    public void goToPrenotaEvento() {
        showInfo("Schermata 'Prenota Evento' non ancora disponibile.");
    }

    // -------------------------------------------------------------------------
    // Metodo privato — lancia NavigationException (exception chaining)
    // -------------------------------------------------------------------------

    /**
     * Carica una view FXML e la imposta come root della scena corrente.
     *
     * Converte la IOException tecnica in una NavigationException
     * comprensibile dallo strato superiore, mantenendo traccia
     * dell'eccezione originale come cause (exception chaining).
     *
     * @throws NavigationException se il caricamento dell'FXML fallisce
     */
    private void loadView(String fxmlPath, Object controller) throws NavigationException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            if (controller != null) {
                loader.setController(controller);
            }
            Parent root = loader.load();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            // IOException tecnica → NavigationException comprensibile
            // La causa originale viene mantenuta (exception chaining)
            throw new NavigationException("Impossibile caricare la schermata: " + fxmlPath, e);
        }
    }

    // -------------------------------------------------------------------------
    // Utility UI
    // -------------------------------------------------------------------------

    private void showError(String header, String details) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(ERRORE_NAVIGAZIONE);
        alert.setHeaderText(header);
        alert.setContentText(details);
        alert.showAndWait();
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("In sviluppo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}