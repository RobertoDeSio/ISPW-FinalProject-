module it.torvergata.ispw.realfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens org.ispw.eventi to javafx.fxml, javafx.graphics;
    opens org.ispw.eventi.controller.viewcontroller to javafx.fxml;

    exports org.ispw.eventi;
    exports org.ispw.eventi.controller.viewcontroller;
    exports org.ispw.eventi.navigation;
}