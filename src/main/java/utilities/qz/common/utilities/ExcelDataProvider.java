package utilities.qz.common.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider {

    @Test(dataProvider="test1data")
    public void testLogin(String UserName, String Password){
        System.out.println(UserName);
    }

    @DataProvider(name = "test1data")
    public Object[][] getData(){
        String excelPath = "TestData/testData.xlsx";
        Object data[][] = testData(excelPath, "Sheet1");
        return data;
    }

    public Object[][] testData(String excelPath, String sheetName) {
        ExcelReader excel = new ExcelReader(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount-1];

        for(int i=1; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                String cellData = excel.getStringData(i,j);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }
}
