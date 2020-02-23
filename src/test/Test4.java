package test;

import com.duing.domain.TestDomain;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class Test4 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int in = 1;
        Integer in1 = 1;
        Class<Integer> aClass1 = int.class;
        Class<Integer> integerClass = Integer.class;
        Class<? extends Integer> aClass2 = in1.getClass();
        boolean a = integerClass == aClass2;

        Class<Object> objectClass = Object.class;
        Object obj = new Object();


        // Class<Object> aClass5 = obj.getClass();
        Class<Object> aClass3 = (Class<Object>) obj.getClass();
        Class<? extends Object> aClass4 = obj.getClass();
        boolean b = Object.class == obj.getClass();
        // aClass2 = aClass1;
        // aClass1 = aClass2;

        TestDomain testDomain = new TestDomain(1, "Jack");
        Class<TestDomain> testDomainClass = TestDomain.class;
        Class<? extends TestDomain> aClass = testDomain.getClass();
        Field field1 = aClass.getField("name");
        Field field2 = aClass.getField("integer");
        Field field3 = aClass.getField("I1");

        Class<?> field2Type = field2.getType();
        System.out.println(field2.getType().getName());
        System.out.println(Double.class.getField("TYPE"));
        System.out.println(field3.get(null));
        System.out.println(int.class.getName());

        System.out.println(field3.getType().isPrimitive());

        // Double
    }
}
