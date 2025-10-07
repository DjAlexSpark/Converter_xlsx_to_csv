module io.djalexspark.converter_xlsx_to_csv {
    requires javafx.controls;
    requires javafx.fxml;
//    requires poi.ooxml.schemas;
    requires poi;

    opens io.djalexspark.converter_xlsx_to_csv to javafx.fxml;
    exports io.djalexspark.converter_xlsx_to_csv;
}