package com.dlex.OOC.Week2.Unit_Test;

import com.dlex.OOC.Week2.MyDate.MyDate;
import org.junit.Test;

public class Test_MyDate {

    @Test
    public void validDay() {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);
        // Wednesday 28 Feb 2012
        System.out.println(d1.nextDay());
        // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay());
        // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth());
        // Sunday 1 Apr 2012
        System.out.println(d1.nextYear());
        // Monday 1 Apr 2013
        System.out.println(d1.previousDay());
        // Sunday 31 Mar 2013
        System.out.println(d1.previousDay());
        // Saturday 30 Mar 2013
        System.out.println(d1.previousMonth());
        // Thursday 28 Feb 2013
        System.out.println(d1.previousYear());
        // Wednesday 29 Feb 2012
    }

    @Test
    public void invalidDay() {
        MyDate d1 = new MyDate(2019, 2, 29);
        System.out.println(d1);
    }
}
