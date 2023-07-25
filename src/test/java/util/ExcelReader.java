package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;


    public static int getRowCount(String Xlfile, String Xlsheet) throws Exception {

        fi = new FileInputStream(Xlfile);
        wb= new XSSFWorkbook(fi);
        ws = wb.getSheet(Xlsheet);
       int rowcount=ws.getLastRowNum();
       wb.close();
       fi.close();
       return rowcount;

    }

    public static int getColCount(String Xlfile, String Xlsheet,int rownum) throws IOException {

        fi = new FileInputStream(Xlfile);
        wb= new XSSFWorkbook(fi);
        ws = wb.getSheet(Xlsheet);
        row=ws.getRow(rownum);
        int colcount=row.getLastCellNum();
        wb.close();
        fi.close();
        return colcount;


    }



    public static String getCellData(String Xlfile, String Xlsheet, int rownum, int col) throws IOException {

        fi = new FileInputStream(Xlfile);
        wb= new XSSFWorkbook(fi);
        ws = wb.getSheet(Xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(col);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            String celldata = formatter.formatCellValue(cell);
            return celldata;
        } catch (Exception e){
            data="";
        }

        wb.close();
        fi.close();
        return data;
    }
}
