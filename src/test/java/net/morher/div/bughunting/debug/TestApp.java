package net.morher.div.bughunting.debug;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.some.silly.library.app.ApplicationConfiguration;
import org.some.silly.library.app.ApplicationContainer;
import org.some.silly.library.app.ApplicationInitializationListener;
import org.some.silly.library.app.ApplicationInstance;

public class TestApp {

    @Test
    public void testApp() {
        TestListener testListener = new TestListener();

        ApplicationContainer container = new ApplicationContainer(8080);

        ApplicationConfiguration config = new ApplicationConfiguration();
        config.setPortOffset(2);
        config.setInitializationListener(testListener);

        container.start(config);

        assertThat(testListener.isCallbackCalled(), is(true));
    }

    public static class TestListener implements ApplicationInitializationListener {
        private boolean callbackCalled = false;

        @Override
        public void onInit(ApplicationInstance instance) {
            callbackCalled = true;
            assertThat(instance, is(not(nullValue())));
            assertThat(instance.getPort(), is(equalTo(8082)));
        }

        public boolean isCallbackCalled() {
            return callbackCalled;
        }
    }
}
