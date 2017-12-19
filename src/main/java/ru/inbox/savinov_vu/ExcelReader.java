package ru.inbox.savinov_vu;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<Contractor> get() {
        try (FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/Контрагенты Прогресс сервис.xls"));
        ) {

            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            List<Contractor> contractors = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Get iterator to all cells of current row
                Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell = cellIterator.next();
//                    CellType cellType = cell.getCellTypeEnum();
                    String nameAndDescription = cell.getStringCellValue();
                    contractors.add(new Contractor(nameAndDescription, nameAndDescription));
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println(contractors.size());

            return contractors;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
