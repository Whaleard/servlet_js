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
        /*Java�е�ÿһ��ö�ٶ��̳���java.lang.Enum�ࡣ
        ������һ��ö������ʱ��ÿһ��ö�����ͳ�Ա�����Կ�����Enum���ʵ������Щö�ٳ�ԱĬ�϶���final��public, static���Σ�
        ��ʹ��ö�����ͳ�Աʱ��ֱ��ʹ��ö�����Ƶ��ó�Ա���ɡ�*/
        // WeekDay male = WeekDay.male;

        // values()����������ʽ����ö�����͵����г�Ա
        // WeekDay[] values = WeekDay.values();
        // for (WeekDay value : values) {
        // ordinal()����ȡö�ٳ�Ա������λ��
        //     System.out.println(value + "---" + value.ordinal());
        // }

        // valueOf()������ͨ�ַ���ת��Ϊö��ʵ��
        // WeekDay male = WeekDay.valueOf("male");

        // compareTo()���Ƚ�����ö�ٳ�Ա�ڶ���ʱ��˳��
        // for (WeekDay value : WeekDay.values()) {
        //     System.out.println(WeekDay.valueOf("Thu").compareTo(value));
        // }

        System.out.println(WeekDay.Fri.getEnglishName());
        System.out.println(WeekDay.Fri.getChineseName());
        System.out.println(WeekDay.Fri.getShortName());
        System.out.println(WeekDay.Fri.getIndex());
    }
}
