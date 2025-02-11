package pages;

import annotations.Path;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

@Path("/")
public class MianPage extends AbsBasePage {

    public MianPage (Page page) {
        super(page);
    }

    private Locator teachersList = page.locator("section div > a[href*='instructors']:not(a[class])");

    public String getTeacherName(int index) {
        return teachersList.all().get(--index).innerText().split("\n")[0];
    }

    public void clickTeacherItemByName(String name) {
        teachersList.filter(new Locator.FilterOptions().setHasText(name)).click();
    }

}
