package extensions;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.microsoft.playwright.*;
import pages.*;

public class GuicePageModule extends AbstractModule {
    private Page page;

    public GuicePageModule() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        this.page = context.newPage();
    }


    @Singleton
    @Provides
    public ClickhousePage getClickhousePage() {
        return new ClickhousePage(page);
    }

    @Singleton
    @Provides
    public CatalogCoursesPage catalogCoursesPage() {return new CatalogCoursesPage(page);}

    @Singleton
    @Provides
    public MianPage mianPage() {return new MianPage(page);}

    @Singleton
    @Provides
    public TeacherPage teacherPage() {return new TeacherPage(page);}



}
