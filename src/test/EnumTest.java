package test;

import domain.WeekDay;
import org.junit.Test;

import java.util.*;

/**
 * @author Mr MC
 */
public class EnumTest {

    @Test
    public void test1() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(66);
        vector.add(77);
        vector.add(88);
        vector.add(123);
        Enumeration<Integer> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }

    @Test
    public void test2() {
        Vector<Integer> vector = new Vector<>();
        vector.add(123);
        vector.add(88);
        vector.add(77);
        vector.add(66);
        vector.add(2);
        vector.add(1);
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Properties properties = new Properties();
        properties.setProperty("username", "admin");
        properties.setProperty("password", "123456");
        Enumeration<Object> elements = properties.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }

    @Test
    public void test4() {
        Properties properties = new Properties();
        properties.setProperty("username", "admin");
        properties.setProperty("password", "123456");
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    @Test
    public void test5() {
        /*Java中的每一个枚举都继承自java.lang.Enum类。
        当定义一个枚举类型时，每一个枚举类型成员都可以看作是Enum类的实例，这些枚举成员默认都被final、public, static修饰，
        当使用枚举类型成员时，直接使用枚举名称调用成员即可。*/
        // WeekDay male = WeekDay.male;

        // values()：以数组形式返回枚举类型的所有成员
        // WeekDay[] values = WeekDay.values();
        // for (WeekDay value : values) {
        // ordinal()：获取枚举成员的索引位置
        //     System.out.println(value + "---" + value.ordinal());
        // }

        // valueOf()：将普通字符串转换为枚举实例
        // WeekDay male = WeekDay.valueOf("male");

        // compareTo()：比较两个枚举成员在定义时的顺序
        // for (WeekDay value : WeekDay.values()) {
        //     System.out.println(WeekDay.valueOf("Thu").compareTo(value));
        // }

        System.out.println(WeekDay.Fri.getEnglishName());
        System.out.println(WeekDay.Fri.getChineseName());
        System.out.println(WeekDay.Fri.getShortName());
        System.out.println(WeekDay.Fri.getIndex());
    }
}
