import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by i.lapshinov on 03.09.2018.
 */
public class MainClass {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        method(TestClass.class);
    }

    public static void method(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] method = c.getDeclaredMethods();
        ArrayList<Method> arrayMethod = new ArrayList<Method>();
        for (Method m: method) {
            if (m.isAnnotationPresent(Test.class))
            {
                arrayMethod.add(m);
            }
        }


        arrayMethod.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        for (Method m: method) {
            if (m.isAnnotationPresent(BeforeSuite.class))
            {
                arrayMethod.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class))
            {
                arrayMethod.add(m);
            }
        }

        for (Method o: arrayMethod) {
            o.invoke(null);
            System.out.println(o);


        }

    }
}
