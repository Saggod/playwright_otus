import com.google.inject.Inject;
import extensions.junit.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.SubscriptionPage;

import java.util.Arrays;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(UIExtensions.class)
public class Subscription_Test {
    List<String> subscriptionOptions = Arrays.asList("Trial", "Standard", "Professional");
    String paymentSumm = "160 000";

    String login = "login";
    String pass = "pass";

    @Inject
    SubscriptionPage subscriptionPage;

    @Test
    public void chechSubscriptionPageTest() {

        subscriptionPage.open();
        subscriptionPage.checkSubscriptionOptionsIsExist(subscriptionOptions);
        subscriptionPage.clickOpenMoreDetailsButton("Standard");
        subscriptionPage.checkAdditionalParamsIsPresent();
        subscriptionPage.clickCloseMoreDetailsButton("Standard");
        subscriptionPage.checkAdditionalParamsIsNotPresent();
        subscriptionPage.clickButtonOnSubscriptionSelectionSage();
        //ToDo После этоо шага идет логин в отус, после ввода логина и пароля открывается капча ) на этом конец))
        subscriptionPage.clickEnterToLogin();
        subscriptionPage.logAndPass(login, pass);
        subscriptionPage.checkSummOnPaymentPageIsPresent(paymentSumm);
        subscriptionPage.choseAnotherTypeSubs();
        subscriptionPage.checkSummIsChanged(paymentSumm);
    }

}
