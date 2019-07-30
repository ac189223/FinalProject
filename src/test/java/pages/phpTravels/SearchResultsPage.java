package pages.phpTravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


}
