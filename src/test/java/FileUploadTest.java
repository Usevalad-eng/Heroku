import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest{
    @Test
    public void uploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/image.png");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());
    }
}
