package utilities.qz.common.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    static String excelPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReader(String excelPath, String sheetName) {
        try{
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    public static void main(String[] args) {
        getRowCount();
    }
    public static int getRowCount(){
        int rowCount = 0;
        try{
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println(rowCount);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return rowCount;
    }

    public static int getColCount(){
        int colCount = 0;
        try{
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return colCount;
    }

    public static String getStringData(int rowNum, int colNum){
        String cellData = null;
        try{
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//            System.out.println(cellData);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return cellData;
    }

    public static void getNumericData(int rowNum, int colNum){
        try{
            double cellNumericData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellNumericData);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
