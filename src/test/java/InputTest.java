import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest extends BaseTest{

    @Test
    public void inputTest() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.xpath("//input"));
        input.sendKeys("12");
        input.sendKeys(Keys.ARROW_DOWN);
        String valueOne = input.getAttribute("value");
        Assert.assertEquals(valueOne,"11", "data does not match");
        input.sendKeys(Keys.ARROW_UP);
        String valueTwo = input.getAttribute("value");
        Assert.assertEquals(valueTwo,"12", "data does not match");
    }
}
