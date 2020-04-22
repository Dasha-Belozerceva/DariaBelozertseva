package hw6.steps;

import hw6.utils.SingletonDriver;
import hw6.voids.DifferentElementsPage;
import hw6.voids.EpamUserIndexPage;
import hw6.voids.UserTablePage;

public abstract class BaseSteps {
    EpamUserIndexPage epamUserIndexPage;
    DifferentElementsPage differentElementsPage;
    UserTablePage userTablePage;

    protected BaseSteps(){
        epamUserIndexPage = new EpamUserIndexPage(SingletonDriver.INSTANCE.getDriver());
        differentElementsPage = new DifferentElementsPage(SingletonDriver.INSTANCE.getDriver());
        userTablePage = new UserTablePage(SingletonDriver.INSTANCE.getDriver());
    }
}
