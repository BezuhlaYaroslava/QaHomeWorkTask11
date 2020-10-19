import help.DataProviderData;
import help.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task11Test
     //   extends BaseTest
{

  String actualResult;
  String expectedResult;
  private HomePage homePage;
  private WebDriver driver;

  /* При использовании extends BaseTest может возникнуть ошибка java.lang.NullPointerException*/

  @BeforeMethod
  public void canBe(){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("http://www.way2automation.com/angularjs-protractor/calc/");
  }

  @Test
  public void canOpenPage(){
    homePage = new HomePage(driver);

    expectedResult = "Angular Calculator";
    actualResult = homePage.getNamePage();

    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test(dataProvider = "dataProviderLogin", dataProviderClass = DataProviderData.class, groups = {"smoke"})
  public void canOperator(String a, String operator, String b, String expected){
    homePage = new HomePage(driver);
    Log.LOG.info(homePage.correctCalculator(a,operator, b));

    Assert.assertEquals(expected, homePage.getActualResult());
  }

}
