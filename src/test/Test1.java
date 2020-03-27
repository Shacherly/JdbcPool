package test;

import com.duing.domain.Admin;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) throws IllegalAccessException {
        Admin admin = new Admin("acc", 1234);
        Class<?> aClass = admin.getClass();
        StringBuilder sql = new StringBuilder("insert into " + aClass.getSimpleName().toLowerCase() + " (");
        Field[] declaredFields = aClass.getDeclaredFields();
        Set<Field> fieldSet = new HashSet<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.get(admin) != null && declaredField.getModifiers() == Modifier.PRIVATE) {
                fieldSet.add(declaredField);
            }
        }
        Iterator<Field> iterator1 = fieldSet.iterator();
        do {
            sql.append(iterator1.next().getName());
            if (iterator1.hasNext()) {
                sql.append(", ");
            }
        } while (iterator1.hasNext());
        sql.append(") values(");
        Iterator<Field> iterator2 = fieldSet.iterator();
        do {
            iterator2.next();
            sql.append("?");
            if (iterator2.hasNext()) {
                sql.append(", ");
            }
        } while (iterator2.hasNext());
        System.out.println(sql.append(")"));
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收，了解一下？？？？");
    }
}
