package mainpagetest;

import com.google.inject.Inject;
import extensions.junit.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MianPage;
import pages.TeacherPage;

@ExtendWith(UIExtensions.class)
public class TeacherBlockTest {

    @Inject
    private MianPage mianPage;

    @Inject
    private TeacherPage teacherPage;

    @Test
    public void clickTeacherItem() {
        mianPage.open();
        String teacherName = mianPage.getTeacherName(1);
        mianPage.clickTeacherItemByName(teacherName);
        teacherPage.checkHeaderPage("Преподаватели");
        teacherPage.checkTeacherNamePresent(teacherName);

    }
}
