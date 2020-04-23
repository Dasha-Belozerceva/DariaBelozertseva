package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.JdiHomePage;
import hw7.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openHomePage() {
        jdiHomePage.open();
    }

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPage.open();
    }
}
