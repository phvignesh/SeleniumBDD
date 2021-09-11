package automationTest.hooks;

import automationTest.common.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestInitialize {
    BaseTest baseTest = new BaseTest();
    @Before
    public void testStep(){
        baseTest.setup();
    }
    @After
    public void testTearDown(){
        baseTest.tearDown();
    }
}
