package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    //Dataprovider 1
    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {

        String path=".\\testData\\OpenCart.login.xlsx";
        ExcelUtility xlutil=new ExcelUtility(path);//creating an object for excelutility
        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);
        String loginData[][]=new String[totalrows][totalcols];//created a two dimensional array which can store the value
for(int i=1; i<=totalrows; i++){//1 read the data from xl storing in two dimensional array
    for(int j=0; j<totalcols; j++){//0 i is rows j is col
       loginData[i-1][j]= xlutil.getCellData("Sheet1", i, j);//1,0
    }
}
return loginData;//return two dimension array

    }
}
