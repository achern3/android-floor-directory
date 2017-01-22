package com.alanchern.floordirectory.floors;

import com.alanchern.floordirectory.models.Unit;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/15/17.
 */

public class FourthFloor {

    public static ArrayList<Unit> getFloor() {
        ArrayList<Unit> list = new ArrayList<>();

        /*** TODO This is where you add new units with associated detail
         Unit unit1 = new Unit();
         unit1.setXXX("YYY");
         list.add(unit1);
         ***/

        // Start here
        Unit unit1 = new Unit(4, "411B", "Tesla", "7777777", "Great place to work");
        list.add(unit1);

        Unit unit2 = new Unit(5, "530D", "Facebook", "8888888", "Great place to work");
        list.add(unit2);

        /*** End of adding info ***/

        return list;
    }
}
