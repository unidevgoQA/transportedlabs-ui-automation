/***
 * DataReader is a helper class which helps to read data from external data source.
 * <p>
 *  @use {@link #getdataFromDataSource(String[][])} method to read data and store in two-dimensional array object.
 *  </p>
 */
package helper;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileNotFoundException;


public class DataReader {

    /***
     * Implementing get data from data source functionality
     * @return two-dimensional array object
     */
    public static String[][] getDataFromStorage(String FileName, String WorkSheet, String TableName)
    {
        String[][] loanData = null;
        try
        {
            Workbook workbook = Workbook.getWorkbook(new File(FileName));
            Sheet sheet = workbook.getSheet(WorkSheet);

            int startRow,startCol, endRow, endCol;
            int ci = 0, cj;

            Cell tableStart=sheet.findCell(TableName);

            startRow=tableStart.getRow();
            startCol= tableStart.getColumn();
            startCol = startCol + 1;

            Cell tableEnd= sheet.findCell(TableName, startCol,startRow, 200, 64000,  false);
            endRow=tableEnd.getRow();

            endCol = tableEnd.getColumn();
            endCol = endCol - 1;

            loanData = new String[(endRow-startRow)+1][endCol];

            for (int i= startRow; i <= endRow ; i++, ci++)
            {
                System.out.println("ci: "+ ci);
                cj = 0;
                for (int j= startCol; j <= endCol; j++, cj++)
                {
                    loanData[ci][cj] = sheet.getCell(j, i).getContents().trim();
                    System.out.println(loanData[ci][cj]);
                }
            }
        } catch (Exception ex)
        {
            System.out.print(ex.getMessage());

        }

        return loanData;

    }


}

