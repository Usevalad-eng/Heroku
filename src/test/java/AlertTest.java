import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    public String getAlertText() {
        return driver.findElement(By.id("result")).getText();
    }


    @Test
    public void alertTest1() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsAlert()']")).click();
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(getAlertText(), "You successfully clicked an alert", "It doesn't match");
    }

    @Test
    public void alertTest2() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(getAlertText(), "You clicked: Ok", "It doesn't match");
    }

    @Test
    public void alertTest3() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("1234");
        alert.accept();
        Assert.assertEquals(getAlertText(), "You entered: 1234", "It doesn't match");
    }
}
