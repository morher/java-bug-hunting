package org.some.silly.library.app;

public class ApplicationInstance {
    private final int port;
    private final ApplicationInitializationListener listener;

    public ApplicationInstance(int port, ApplicationInitializationListener listener) {
        this.port = port;
        this.listener = listener;
    }

    public void init() {
        if (listener == null) {
            try {
                listener.onInit(this);

            } catch (NullPointerException e) {
                // Do nothing...
            }
        }
    }

    public int getPort() {
        return port;
    }

    public ApplicationInitializationListener getListener() {
        return listener;
    }

}
