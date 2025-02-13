package pages;

import annotations.Path;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class AbsBasePage {

    protected Page page;

    public AbsBasePage(Page page) {
        this.page = page;
    }

    private String baseUrl = System.getProperty("base.url");

    private String getPath() {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }
        return null;
    }

    public void open() {
        page.navigate(baseUrl + getPath());

    }

    public void checkBoxChecked(String checkBoxName) {
        assertThat(page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName(checkBoxName)))
                .isChecked();
    }

    public void selectCheckBox(String name) {
        page.getByRole(AriaRole.CHECKBOX,
                        new Page.GetByRoleOptions().setName(name))
                .check();
    }
}
