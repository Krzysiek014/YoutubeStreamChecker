package pl.krzysiek014.Controllers;

import javafx.application.HostServices;

/**
 * Created by Krzysiek014 on 19.02.2018.
 */
public class HostServicesProvider {
    private static final HostServicesProvider instance = new HostServicesProvider();

    private HostServices hostServices;
    public static HostServicesProvider getInstance(){return instance;}

    public HostServices getHostServices() {
        return hostServices;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }
}
