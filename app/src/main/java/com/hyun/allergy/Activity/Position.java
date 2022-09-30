package com.hyun.allergy.Activity;
import java.util.ArrayList;


/**
 * Created by JayRyu on 2/6/16.
 */
public class Position {

    //Properties of Position
    public String position;
    public String image;
    public ArrayList<String> players = new ArrayList<String>();

    public Position(String position){
        this.position = position;
    }

    public String toString () {
        return position;
    }

}


