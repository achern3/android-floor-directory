package com.alanchern.floordirectory.floors;

import com.alanchern.floordirectory.models.Unit;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/15/17.
 */

public class SecondFloor {

    public static ArrayList<Unit> getFloor() {
        ArrayList<Unit> list = new ArrayList<>();

        /*** TODO This is where you add new units with associated detail
         Unit unit1 = new Unit();
         unit1.setXXX("YYY");
         list.add(unit1);
         ***/

        // Start here
        Unit unit1 = new Unit(2, "999Z", "A company with a really long name", "0000000", "No idea what this is");
        list.add(unit1);

        Unit unit2 = new Unit(2, "301E", "Apple", "9999999", "Great place to work");
        list.add(unit2);

        /*** End of adding info ***/

        return list;
    }
}
