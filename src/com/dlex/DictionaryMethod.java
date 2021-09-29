package com.dlex;

import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryMethod {
    public static void main(String[] args) {
        Dictionary dict = new Hashtable();
        dict.put("1", "HanSolo");
        dict.put("2", "BenSolo");

        System.out.print(dict.get("1"));
    }
}
