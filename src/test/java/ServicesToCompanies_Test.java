import com.google.inject.Inject;
import extensions.junit.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CatalogCoursesPage;
import pages.CustomCoursesPage;

@ExtendWith(UIExtensions.class)
public class ServicesToCompanies_Test {

    @Inject
    private CatalogCoursesPage catalogCoursesPage;

    @Inject
    private CustomCoursesPage customCoursesPage;


    @Test
    public void customCoursesTest() {
        customCoursesPage.open();
        customCoursesPage.clickMoreDetailsAndValidate("Подробнее", "Разработка индивидуальных программ обучения для бизнеса");
        customCoursesPage.clickCategory("testing");
        customCoursesPage.checkBoxIsChecked("Тестирование");
    }



}
