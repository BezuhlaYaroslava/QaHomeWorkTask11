package help;

import org.testng.annotations.DataProvider;

public class DataProviderData {

    @DataProvider
    public static Object[][] dataProviderLogin() {
        return new Object[][]{
                {"10", "+", "2", "12"},
                {"27", "/", "3", "9"},
                {"3", "*", "3", "9"},
                {"27", "-", "25", "1"}
        };
    }
}
