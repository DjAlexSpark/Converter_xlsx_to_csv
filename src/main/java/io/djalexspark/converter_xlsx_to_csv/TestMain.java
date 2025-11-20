package io.djalexspark.converter_xlsx_to_csv;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.StringJoiner;

public class TestMain {
    public static void main(String[] args) {
        Path pathToExcelFile = Path.of("qwel.xlsx");
        Path pathToCsvFile = Path.of("csvTextFile.csv");
//        convertXlsxToCsv(pathToExcelFile,pathToCsvFile);
    }
    static void convertXlsxToCsv(Path pathFrom, Path pathTo){

        try {
            Workbook book = new XSSFWorkbook(new FileInputStream(pathFrom.toFile()));
            Sheet sheet = book.getSheetAt(0);
            StringJoiner sb = new StringJoiner("\n");
            for (Row row :sheet) {
                StringJoiner joiner = new StringJoiner(",");
                for (Cell cell : row) {
                    joiner.add("\"" + cell + "\"");
                }
                sb.add(joiner.toString());
            }

            System.out.println(sb);
            Files.writeString(pathTo,sb.toString() , StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
