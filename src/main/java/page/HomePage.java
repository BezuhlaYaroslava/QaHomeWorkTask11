package page;

import help.NewHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){this.driver = driver;}

    @FindBy(xpath = "//td[@class='ng-binding'][1]")
    private WebElement time;

    @FindBy(xpath = "//tr[@ng-repeat='result in memory']/td[2]")
    private WebElement expression;

    @FindBy(xpath = "//td[@class='ng-binding'][2]")
    private WebElement result;

    @FindBy(xpath = "//h2[@class='ng-binding']")
    private WebElement bigResult;


    public String getNamePage() {
        NewHelper.waitUnEl();
        WebElement namePage = driver.findElement(By.xpath("//div[@ng-controller='CalcCtrl']/div/h3"));
        namePage.getText();
        return namePage.toString();
    }
    public HomePage typeFieldFirst(String a){
        WebElement fieldFirst = driver.findElement(By.xpath("//input[@ng-model='first']"));
        fieldFirst.sendKeys(a);
        return this;
    }

    public HomePage typeFieldSecond(String b){
        WebElement fieldSecond = driver.findElement(By.xpath("//input[@ng-model='second']"));
        fieldSecond.sendKeys(b);
        return this;
    }

    public HomePage clickButton(){
        WebElement goButton = driver.findElement(By.xpath("//button[@id='gobutton']"));
        goButton.click();
        return this;
    }

    private void selectOperator(String operator) {
        if (operator.equals("+")) {
            driver.findElement(By.xpath("//option[@value='ADDITION']")).click();
        } else if (operator.equals("/")) {
            driver.findElement(By.xpath("//option[@value='DIVISION']")).click();
        }else if (operator.equals("%")) {
            driver.findElement(By.xpath("//option[@value='MODULO']")).click();
        }else if (operator.equals("*")) {
            driver.findElement(By.xpath("//option[@value='MULTIPLICATION']")).click();
        }else if (operator.equals("-"))  {
            driver.findElement(By.xpath("//option[@value='SUBTRACTION']")).click();
        }
    }

    public HomePage correctCalculator(String a, String operator, String b) {

        this.typeFieldFirst(a);
        this.selectOperator(operator);
        this.typeFieldSecond(b);
        this.clickButton();
        return new HomePage(driver);
    }

    public String getActualResult() {
        NewHelper.waitUnEl();
        WebElement element = driver.findElement(By.xpath("//h2[@class='ng-binding']"));
        element.getText();
        return element.getText();
    }

}
