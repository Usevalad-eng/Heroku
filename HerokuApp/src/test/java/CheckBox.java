import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckBox extends BaseTest{
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    @Test
    public void isCheckBoxTwoSelected(){  //Should be - checkbox1 = unchecked, checkbox2 = checked.
        driver.get(URL);

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        boolean selected = checkbox2.isSelected();
        assertTrue(selected, "Error");

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        boolean selected2 = (!checkbox1.isSelected());
        assertTrue(selected2, "Error");
    }

    @Test
    public void isCheckBoxOneSelected(){ //Should be - checkbox1 = checked, checkbox2 = unchecked.
        driver.get(URL);

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        checkbox2.click();

        boolean selected1 = checkbox1.isSelected();
        assertTrue(selected1, "Error");

        boolean selected2 = (!checkbox2.isSelected());
        assertTrue(selected2, "Error");
    }

    @Test
    public void isCheckBoxOneSelectedV2(){ //Should be - checkbox1 = checked, checkbox2 = unchecked.
        driver.get(URL);

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        //if (!checkbox1.isSelected()){
            checkbox1.click();
        //}
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        //if (checkbox2.isSelected()){
            checkbox2.click();
        //}

        boolean selected1 = checkbox1.isSelected();
        assertTrue(selected1, "Error");

        boolean selected2 = (!checkbox2.isSelected());
        assertTrue(selected2, "Error");
    }
}
