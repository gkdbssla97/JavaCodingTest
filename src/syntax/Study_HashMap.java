package syntax;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Study_HashMap {
    public static void test1() {
        System.out.println("HashMap->");
        Map<String, Integer> map = new HashMap<>();
        map.put("월 ", 1);
        map.put("화 ", 2);
        map.put("수 ", 3);
        map.put("목 ", 4);
        map.put("금 ", 5);
        map.keySet().stream().forEach(System.out::print);
    }
    public static void test2() {
        System.out.println("LinkedHashMap->");
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("월 ", 1);
        map.put("화 ", 2);
        map.put("수 ", 3);
        map.put("목 ", 4);
        map.put("금 ", 5);
        map.keySet().stream().forEach(System.out::print);
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
