package ru.inbox.savinov_vu.exel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import ru.inbox.savinov_vu.model.Street;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetAndHomeExcelReader {

    public List<Street> get() {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/улицы.xls");

        List<Street> contractors = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file)
        ) {

            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Get iterator to all cells of current row
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
//                    CellStreetype cellStreetype = cell.getCellStreetypeEnum();
                String nameAndDescription = cell.getStringCellValue();
                String utf8String = new String(nameAndDescription.getBytes("CP866"), "CP1251");
//                String convert= new String(nameAndDescription.getBytes(), "CP866");

                contractors.add(new Street(utf8String));
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println(contractors.size());

            return contractors;

        } catch (Exception e) {
        }
        return contractors;
    }
}
