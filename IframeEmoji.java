package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IframeEmoji extends TestBase {

    ////go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //       //maximize the web site
    //       //click on second emoji
    //       //click all second emoji's element
    //       //go back parent iframe
    //       //fill out the form,(Fill the form with the texts you want)
    //       //click on apply button

    @Test
    public void test() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));

        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement> emojiler=driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));
        emojiler.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();

        List<WebElement> inputSystem=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        //inputSystem.get(0).sendKeys("A");

        List<String> veri=new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","V","Z"));

        for (int i = 0; i <veri.size() ; i++) {

            inputSystem.get(i).sendKeys(veri.get(i));
        }

        driver.findElement(By.id("send")).click();
    }
}
