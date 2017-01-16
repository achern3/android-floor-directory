package com.alanchern.floordirectory.model;

import com.alanchern.floordirectory.floor.EighthFloor;
import com.alanchern.floordirectory.floor.FifthFloor;
import com.alanchern.floordirectory.floor.FirstFloor;
import com.alanchern.floordirectory.floor.FourthFloor;
import com.alanchern.floordirectory.floor.NinthFloor;
import com.alanchern.floordirectory.floor.SecondFloor;
import com.alanchern.floordirectory.floor.SeventhFloor;
import com.alanchern.floordirectory.floor.SixthFloor;
import com.alanchern.floordirectory.floor.ThirdFloor;

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
