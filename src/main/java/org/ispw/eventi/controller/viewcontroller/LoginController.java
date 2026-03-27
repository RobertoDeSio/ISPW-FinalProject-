package org.ispw.eventi.controller.viewcontroller;

import org.ispw.eventi.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LoginController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    private final NavigationService nav;

    public LoginController(NavigationService nav) {
        this.nav = nav;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LOGGER.info("LoginController inizializzato");
    }

    @FXML
    private void handleHome() {
        LOGGER.info("click: torna alla home");
        nav.goToHome();
    }

    @FXML
    private void handleLogin() {
        LOGGER.info("click: accedi");
    }

    @FXML
    private void handleRegistrati() {
        LOGGER.info("click: registrati");
        nav.goToRegistrazione();
    }
}