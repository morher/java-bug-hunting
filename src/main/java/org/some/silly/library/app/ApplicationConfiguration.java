package org.some.silly.library.app;

public class ApplicationConfiguration {
    private int portOffset = 0;

    private ApplicationInitializationListener initializationListener = null;

    public int getPortOffset() {
        return portOffset;
    }

    public void setPortOffset(int portOffset) {
        this.portOffset = portOffset;
    }

    public ApplicationInitializationListener getInitializationListener() {
        return initializationListener;
    }

    public void setInitializationListener(ApplicationInitializationListener initializationListener) {
        this.initializationListener = initializationListener;
    }

}
