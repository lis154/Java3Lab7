/**
 * Created by i.lapshinov on 03.09.2018.
 */
public class TestClass {




    public static void start()
    {
        System.out.println("Start");
    }

    @BeforeSuite
    public static void beforeSuite()
    {
        System.out.println("BeforeSuit");
    }

    @Test(priority = 2)
    public static void test1()
    {
        System.out.println("test1");
    }

    @Test(priority = 7)
    public static void test2()
    {
        System.out.println("test2");
    }

    @Test
    public static  void test3()
    {
        System.out.println("test3");
    }

    @AfterSuite
    public static void afterSuite()
    {
        System.out.println("AfterSuite");
    }

}
