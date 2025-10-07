package io.djalexspark.converter_xlsx_to_csv;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.poi.hssf.usermodel.*;
public class ConverterExcelToCSV  {
    Path pathToExcelFile, pathToCsvFile;

    public ConverterExcelToCSV() {
    }
    public void convert(){
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(pathToExcelFile.toFile()));
            //todo foreach cell in sheet make quotes and write to csv
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                HSSFSheet sheet = workbook.getSheetAt(0);
                for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                    HSSFRow row = sheet.getRow(j);
                    for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                        HSSFCell cell = row.getCell(k);//неправильно
            Files.createFile(pathToCsvFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path getPathToExcelFile() {
        return pathToExcelFile;
    }

    public void setPathToExcelFile(Path pathToExcelFile) {
        this.pathToExcelFile = pathToExcelFile;
    }

    public Path getPathToCsvFile() {
        return pathToCsvFile;
    }

    public void setPathToCsvFile(Path pathToCsvFile) {
        this.pathToCsvFile = pathToCsvFile;
    }

    public ConverterExcelToCSV(Path pathToExcelFile, Path pathToCsvFile) {
        this.pathToExcelFile = pathToExcelFile;
        this.pathToCsvFile = pathToCsvFile;
    }
}
