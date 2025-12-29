module it.torvergata.ispw.realfinalproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ispw.eventi to javafx.fxml;
    exports org.ispw.eventi;

}