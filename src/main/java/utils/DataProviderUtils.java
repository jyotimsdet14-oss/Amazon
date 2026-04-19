package utils;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.*;

public class DataProviderUtils {

    @DataProvider(name = "excelData", parallel = true)
    public static Object[][] getData(ITestContext context) {

        String sheetName = context.getCurrentXmlTest()
                                  .getParameter("sheetName");

        String path = "C:\\Users\\DELL\\Desktop\\FrameworkStructure\\Amazon\\testdata\\testdata.xlsx";

        List<Map<String, String>> list =
                ExcelUtils.getData(path, sheetName);

        Object[][] data = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }

        return data;
    }
}