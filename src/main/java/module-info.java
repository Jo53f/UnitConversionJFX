module com.mycompany.unitconversionjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.unitconversionjfx to javafx.fxml;
    exports com.mycompany.unitconversionjfx;
}
