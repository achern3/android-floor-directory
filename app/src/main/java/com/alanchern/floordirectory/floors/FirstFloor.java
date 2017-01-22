package com.alanchern.floordirectory.floors;

import com.alanchern.floordirectory.models.Unit;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/15/17.
 */

public class FirstFloor {

    public static ArrayList<Unit> getFloor() {
        ArrayList<Unit> list = new ArrayList<>();

        /*** TODO This is where you add new units with associated detail
         Unit unit1 = new Unit(XXX);
         unit1.setXXX("YYY");
         list.add(unit1);
         ***/

        // Start here
        Unit unit1 = new Unit(1, "102A", "Google", "12345", "Great place to work");
        list.add(unit1);

        Unit unit2 = new Unit(2, "218C", "Microsoft", "98765", "Great place to work");
        list.add(unit2);

        /*** End of adding info ***/

        return list;
    }
}
