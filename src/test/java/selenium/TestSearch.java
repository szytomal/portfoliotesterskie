package selenium;

import selenium.framework.DriverProvider;
import selenium.framework.SetUp;
import selenium.page.FilteredResults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenium.page.NavBar;

public class TestSearch {

    @BeforeEach
    public void setUp() {
        SetUp.prepareDriverForTest();
    }

    @Test
    public void testSrch() {
        NavBar.searching("Mug");
        Assertions.assertEquals("SEARCH RESULTS", FilteredResults.checkPageName());
    }

    @AfterEach
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}