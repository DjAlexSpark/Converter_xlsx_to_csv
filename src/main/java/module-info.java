module io.djalexspark.converter_xlsx_to_csv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    requires java.desktop;


    opens io.djalexspark.converter_xlsx_to_csv to javafx.fxml;
    exports io.djalexspark.converter_xlsx_to_csv;
}