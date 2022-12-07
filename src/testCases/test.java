package testCases;

import cucumber.api.java.hu.Ha;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static void main(String[] args){
        String str = "good looking";
        char[] ch = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch1 :ch){
            if(map.containsKey(ch1)){
                map.put(ch1, map.get(ch1)+1);
            }else {
                map.put(ch1, 1);
            }
            if(ch1!=' '){
                set.add(ch1);
            }
        }
        set.stream().sorted();
        System.out.println(set);
        System.out.println(map);
    }
}
