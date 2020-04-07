package voids;

import composite.AbstractPageComposite;
import composite.HeaderSectionComposite;
import composite.SidebarComposite;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractPage extends AbstractPageComposite {
    protected SidebarComposite sidebar;
    protected HeaderSectionComposite headerSection;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        sidebar = new SidebarComposite(driver);
        headerSection = new HeaderSectionComposite(driver);
    }

    public void checkHeaderSection(SoftAssert sa) {
        headerSection.checkHeaderSection(sa);
    }

    public void checkItemsOnSideBarMenu(SoftAssert sa) {
        sidebar.checkItemsOnSideBarMenu(sa);
    }

    public void openDifferentElementsPage() {
        sidebar.openDifferentElementsPage();
    }
}
