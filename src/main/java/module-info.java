module com.butterworth.superautoneanderthals {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.butterworth.superautoneanderthals to javafx.fxml;
    exports com.butterworth.superautoneanderthals;
    exports com.butterworth.superautoneanderthals.controller;
    opens com.butterworth.superautoneanderthals.controller to javafx.fxml;
}