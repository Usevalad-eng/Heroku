import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DragAndDropTest extends BaseTest{

    @Test
    public void testDrag() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        List<WebElement> columns = driver.findElements(By.xpath("//div[@id='columns']/div"));
        String text1 = columns.get(0).getText();
        String text2 = columns.get(1).getText();
        Assert.assertEquals(text1, "A", "not match");
        Assert.assertEquals(text2, "B", "not match");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columns.get(0), columns.get(1)).build().perform();
        String newText1 = columns.get(0).getText();
        String newText2 = columns.get(1).getText();

        Assert.assertEquals(newText2, "A", "not match");
        Assert.assertEquals(newText1, "B", "not match");
    }
}
