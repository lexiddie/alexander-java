package com.dlex.Tutorial;

import java.util.ArrayList;
import java.util.Random;

public class RanLottery {
    ArrayList<Integer> arrayRan = new ArrayList<>();
    ArrayList<Integer> arrayInput = new ArrayList<>();

    public int setupValue(int value) {
        int count = 0;
        arrayRan.add(autoRandom());
        String intFormat = String.format("%06d", value);
        System.out.println(intFormat);
        arrayInput.add(Integer.valueOf(intFormat));

        for (int i = 0; i < arrayRan.size(); i++) {
            String value1 = arrayRan.get(i).toString();
            String value2 = arrayInput.get(i).toString();
            char[] valueCheck1 = value1.toCharArray();
            char[] valueCheck2 = value2.toCharArray();
            for (int j = 0; j < valueCheck1.length; j++) {
                if (valueCheck1[j] == valueCheck2[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private int autoRandom() {
        Random ran = new Random();
        return ran.nextInt(999999) + 1;
    }
}
