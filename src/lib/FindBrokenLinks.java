package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindBrokenLinks {
    public void findBrokenLink(WebDriver driver) throws IOException {
        List<WebElement> getAlllinks = driver.findElements(By.tagName("a"));
        if(!getAlllinks.isEmpty()){
            for (WebElement getAlllink : getAlllinks) {
                String getURL = getAlllink.getAttribute("href");

                URL url = new URL(getURL);
                HttpURLConnection ht = (HttpURLConnection) url.openConnection();
                ht.connect();
                int getResponseCode = ht.getResponseCode();
                if(getResponseCode>=400){
                    System.out.println(getURL + " Is a broken link");
                }else {

                }
            }
        }
    }
}
