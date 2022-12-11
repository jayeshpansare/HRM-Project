package testCases;

import lib.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderTest {
    @Test(priority=1, dataProvider = "MainData")
    public void validateValidLoginCreds(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
    @DataProvider(name="MainData")
    public static Object[][] loginInvalidDataProviderMethod() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String fileURLPath = projectPath+"\\src\\data\\login.xlsx";
        XLUtils objxml = new XLUtils();
        int getRowCount = objxml.getRowCount(fileURLPath, "loginInvalid");
        Object[][] object = new Object[3][2];
        for(int i=0; i<=getRowCount; i++){
            object[i][0] = objxml.getCellData(fileURLPath, "loginInvalid", i,1).toString();
            object[i][1] = objxml.getCellData(fileURLPath, "loginInvalid", i,2).toString();
        }
        return object;
    }
}

