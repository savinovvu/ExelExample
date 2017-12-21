package ru.inbox.savinov_vu.exel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import ru.inbox.savinov_vu.model.Apartment;
import ru.inbox.savinov_vu.model.Home;
import ru.inbox.savinov_vu.model.Street;
import ru.inbox.savinov_vu.to.DataContainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ExcelReader {


    public DataContainer get() {
        DataContainer container = new DataContainer();
        Map<String, Street> streetMap = container.streetMap;
        Map<String, Home> homeMap = container.homeMap;
        Map<String, Apartment> apartmentMap = container.apartmentMap;

        File file = getFile();

        try (FileInputStream fileInputStream = new FileInputStream(file)
        ) {
            Iterator<Row> rowIterator = getRowIterator(fileInputStream);

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                StringBuilder streetNameBuilder = new StringBuilder();
                StringBuilder homeNameBuilder = new StringBuilder();
                StringBuilder apartmentNameBuilder = new StringBuilder();
                StringBuilder managementCompanyNameBuilder = new StringBuilder();
                setEntitiesValues(cellIterator, streetNameBuilder, homeNameBuilder, apartmentNameBuilder, managementCompanyNameBuilder);
                if ("".equals(streetNameBuilder.toString())) {
                    break;
                }


                String streetName = streetNameBuilder.toString();
                String homeName = homeNameBuilder.toString();
                String apartmentName = apartmentNameBuilder.toString();
                String managementCompanyName = managementCompanyNameBuilder.toString();

                Street street = getStreet(streetMap, streetName);
                Home home = getHome(homeMap, homeName, street, managementCompanyName);
                getApartment(apartmentMap, apartmentName, home);

            }
        } catch (Exception e) {
            System.out.println("___________________________________________________________________________");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("___________________________________________________________________________");

            return container;
        }
        return container;
    }

    private Street getStreet(Map<String, Street> streetMap, String streetName) {
        Street street = null;
        if (streetMap.containsKey(streetName)) {
            street = streetMap.get(streetName);
        } else {
            street = new Street(streetName);
            streetMap.put(streetName, street);
        }
        return street;
    }

    private Home getHome(Map<String, Home> homeMap, String homeName, Street street, String managementCompanyName) {
        Home home = null;
        if (homeMap.containsKey(homeName)) {
            home = homeMap.get(homeName);
        } else {
            home = new Home(homeName, street, managementCompanyName);
            homeMap.put(homeName, home);
        }
        return home;
    }

    private Apartment getApartment(Map<String, Apartment> apartmentMap, String apartmentName, Home home) {
        Apartment apartment = null;
        if (apartmentMap.containsKey(apartmentName)) {
            apartment = apartmentMap.get(apartmentName);
        } else {
            apartment = new Apartment(apartmentName, home);
            apartmentMap.put(apartmentName, apartment);
        }
        return apartment;
    }


    private File getFile() {
        return new File(System.getProperty("user.dir") + "/src/main/resources/улицы.xls");
    }

    private void setEntitiesValues(Iterator<Cell> cellIterator, StringBuilder streetName,
                                   StringBuilder homeName, StringBuilder apartmentName, StringBuilder managementCompanyName) {
        int columnNumber = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String cellValue = cell.getStringCellValue();
            switch (columnNumber) {
                case 0:
                    if ("".equals(cellValue)) {
                        return;
                    }
                    streetName.append(cellValue);
                    break;
                case 1:
                    homeName.append(cellValue);
                    break;
                case 2:
                    apartmentName.append(cellValue);
                    break;
                case 3:
                    managementCompanyName.append(cellValue);
                    break;
                default:
                    return;
            }
            columnNumber++;
        }
    }

    private Iterator<Row> getRowIterator(FileInputStream fileInputStream) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        return sheet.iterator();
    }
}
