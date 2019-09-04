package org.some.silly.library.app;

public class ApplicationContainer {
    private final int basePort;

    public ApplicationContainer(int basePort) {
        this.basePort = basePort;
    }

    public void start(ApplicationConfiguration config) {
        int portOffset = 0;
        ApplicationInitializationListener listener = null;

        if (config == null) {
            portOffset = config.getPortOffset();
            listener = config.getInitializationListener();
        }

        ApplicationInstance instance = new ApplicationInstance(basePort - portOffset, listener);

        instance.init();
    }
}
