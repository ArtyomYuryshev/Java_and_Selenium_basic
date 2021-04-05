package course1.lesson8TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestRunner {

    @BeforeMethod
    public void beforeTestMethods() {
        System.out.println("test started");
    }

    @AfterMethod
    public void afterTestMethods() {
        System.out.println("test finished");
    }

    @Test(groups = {"lessonGroup"})
    public void testMethod() {
        Assert.assertEquals(2, 5, "2 is not 5");
    }

    @Test(groups = {"lessonGroup"})
    public void testMethod2() {
        Assert.assertEquals(2, 3, "2 is not 3");
    }

    @Test(groups = {"lessonGroup"})
    public void testMethod3() {
        Assert.assertEquals(2, 2, "2 is not 2");
    }

    @Test(groups = {"lessonGroup"}, expectedExceptions = NullPointerException.class)
    public void testMethod4() {
        throw new NullPointerException();
    }

    @Test(groups = {"lessonGroup"}, expectedExceptions = NullPointerException.class)
    public void testMethod5() {
        System.out.println("null");
    }

    @Test(groups = {"lessonGroup"}, enabled = false)
    public void testMethod6() {
        System.out.println("null");
    }

    @Test(groups = {"lessonGroup"}, timeOut = 1000)
    public void testMethod7() throws InterruptedException {
        Thread.sleep(1001);
    }

    @Test()
    @Parameters({"somevar","somevar2"})
    public void testMEthod8(String somevar, String somevar2) {
        Assert.assertEquals(somevar, somevar2, somevar + " is not " + somevar2);
    }


}
