import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@autocomplete = 'off']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@autocomplete = 'off']")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed(), "There is no message 'it's gone' - it must be seen");

        //WebElement checkbox = driver.findElement(By.id("checkbox")); //todo
        //Assert.assertFalse(checkbox.isDisplayed(), "There is checkbox - it must not be seen"); //todo

        WebElement input = driver.findElement(By.xpath("//input[@type = 'text']"));
        Assert.assertFalse(input.isEnabled(), "Input must be disabled");
        driver.findElement(By.xpath("//button[@onclick= 'swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@onclick= 'swapInput()']")));
        String text = driver.findElement(By.xpath("//p[@id= 'message']")).getText();
        Assert.assertEquals(text, "It's enabled!", "Text doesn't match!");
        Assert.assertTrue(input.isEnabled(), "Input must be enabled");
    }
}
