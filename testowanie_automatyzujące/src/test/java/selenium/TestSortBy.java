package selenium;

import selenium.framework.DriverProvider;
import selenium.framework.SetUp;
import selenium.page.FilteredResults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenium.page.NavBar;

public class TestSortBy {

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void testSB() {
        String order = "Price, high to low";
        NavBar.goToArt();
        FilteredResults.sorting(order);
        Assertions.assertEquals(order + "\n\uE5C5", FilteredResults.checkSortBy());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}