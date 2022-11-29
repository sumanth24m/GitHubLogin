package utilities.qz.common.utilities;

public class ExcelReadClass {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        ExcelReader excel = new ExcelReader(projectPath+ "/TestData/testData.xlsx", "Sheet1");

        excel.getRowCount();
        excel.getStringData(0,0);
        excel.getNumericData(1,1);
    }

}
