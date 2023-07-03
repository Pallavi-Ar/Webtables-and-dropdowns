package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;

public class WebTable {
    public static void main(String[] args) {
        //giving path to where chrome driver is downloaded
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi.Arora\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximizing the window which opens
        driver.manage().window().maximize();
        //deleting all the cookies and cache
        driver.manage().deleteAllCookies();
        //adding pageLoadTimeout of 30secs so that the page is fully loaded before performing any action
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //opening assignment.html
        driver.get("C:\\Users\\Pallavi.Arora\\Downloads\\Assignment.html");
        //creating a web element for table
        WebElement table = driver.findElement(By.xpath("/html/body/table"));
        //storing all the rows of the table in a list
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        //creating hashset because hashset only contains unique elements
        HashSet<String> uniqueRows = new HashSet<>();
        //traversing the list of rows
        for(WebElement row:rows) {
            //creating a list of table columns
            List<WebElement> cells = row.findElements(By.tagName("td"));
            StringBuilder data = new StringBuilder();
            //traversing the columns
            for(WebElement cell : cells){
                //storing data in StringBuilder
                data.append(cell.getText()).append(" ");
            }
            //adding data to set so only unique data gets added
            uniqueRows.add(data.toString());
        }
        //printing the unique rows
        for(String row:uniqueRows) {
            System.out.println(row);
        }
    }
}
