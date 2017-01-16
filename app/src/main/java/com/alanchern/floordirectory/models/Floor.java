package com.alanchern.floordirectory.models;

import com.alanchern.floordirectory.floors.EighthFloor;
import com.alanchern.floordirectory.floors.FifthFloor;
import com.alanchern.floordirectory.floors.FirstFloor;
import com.alanchern.floordirectory.floors.FourthFloor;
import com.alanchern.floordirectory.floors.NinthFloor;
import com.alanchern.floordirectory.floors.SecondFloor;
import com.alanchern.floordirectory.floors.SeventhFloor;
import com.alanchern.floordirectory.floors.SixthFloor;
import com.alanchern.floordirectory.floors.ThirdFloor;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/15/17.
 */

public class Floor {

    public static ArrayList<Unit> getUnits(int floor) {
        ArrayList<Unit> list = null;
        switch (floor) {
            case 1:
                list = FirstFloor.getFloor();
                break;
            case 2:
                list = SecondFloor.getFloor();
                break;
            case 3:
                list = ThirdFloor.getFloor();
                break;
            case 4:
                list = FourthFloor.getFloor();
                break;
            case 5:
                list = FifthFloor.getFloor();
                break;
            case 6:
                list = SixthFloor.getFloor();
                break;
            case 7:
                list = SeventhFloor.getFloor();
                break;
            case 8:
                list = EighthFloor.getFloor();
                break;
            case 9:
                list = NinthFloor.getFloor();
                break;
        }
        return list;
    }
}
