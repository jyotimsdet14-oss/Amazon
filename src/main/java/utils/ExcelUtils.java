package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ExcelUtils {

    public static List<Map<String, String>> getData(String path, String sheetName) {

        List<Map<String, String>> dataList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // Get header row
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                // Skip empty rows
                if (row == null) continue;

                Map<String, String> dataMap = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                    String key = headerRow.getCell(j).getStringCellValue();
                    Cell cell = row.getCell(j);

                    dataMap.put(key, getCellValue(cell));
                }

                // 🔥 RunMode filter
                if (dataMap.containsKey("RunMode") &&
                        dataMap.get("RunMode").equalsIgnoreCase("YES")) {

                    dataList.add(dataMap);
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    // 🔹 Utility method to handle all cell types
    private static String getCellValue(Cell cell) {

        if (cell == null) return "";

        switch (cell.getCellType()) {

            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case FORMULA:
                return cell.getCellFormula();

            default:
                return "";
        }
    }
}