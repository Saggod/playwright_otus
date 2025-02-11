package extensions.junit;


import com.google.inject.Guice;
import com.google.inject.Injector;
import extensions.GuicePageModule;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UIExtensions implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Injector injector = Guice.createInjector(new GuicePageModule());
        injector.injectMembers(context.getTestInstance().get());
    }
}
