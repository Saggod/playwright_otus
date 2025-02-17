package factories;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

    private String browserNam = System.getProperty("browser");

    private Playwright playwright;

    public BrowserFactory(Playwright playwright){
        this.playwright = playwright;
    }

    public Browser create() {
        switch(browserNam) {
            case "chrome": {
                return this.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            }
        }
        return null;
    }
}
