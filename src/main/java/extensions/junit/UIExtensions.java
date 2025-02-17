package extensions.junit;


import java.nio.file.Paths;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import extensions.GuicePageModule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback {

    private Injector injector;

    @Override
    public void beforeEach(ExtensionContext context) {
        injector = Guice.createInjector(new GuicePageModule());
        injector.injectMembers(context.getTestInstance().get());
    }


    @Override
    public void afterEach(ExtensionContext context) {
        injector.getProvider(BrowserContext.class).get().tracing().stop(new Tracing.StopOptions().setPath(Paths.get( "trace.zip")));
    }
}
