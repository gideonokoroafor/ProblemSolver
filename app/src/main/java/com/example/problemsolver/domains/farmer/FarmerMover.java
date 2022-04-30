package com.example.problemsolver.domains.farmer;

import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;

/**
 *
 * @author gideonokoroafor
 */
public class FarmerMover extends Mover {
    public static final String FARMER = "Farmer Goes Alone";
    public static final String FARMER_WOLF = "Farmer Takes Wolf";
    public static final String FARMER_GOAT = "Farmer Takes Goat";
    public static final String FARMER_CAB = "Farmer Takes Cabbage";

    public FarmerMover(){
        super.addMove(FARMER, s->goesAlone(s));
        super.addMove(FARMER_WOLF, s->takesWolf(s));
        super.addMove(FARMER_GOAT, s->takesGoat(s));
        super.addMove(FARMER_CAB, s->takesCabbage(s));
    }

    private State goesAlone(State st){
        FarmerState s = (FarmerState)st;
        String f = s.getFlocation();
        String w = s.getWlocation();
        String g = s.getGlocation();
        String c = s.getClocation();
        if(g.equals(c)){
            return null;
        } else if (g.equals(w)){
            return null;
        }
        if(f.equals("East")) {
            s = new FarmerState("West", w, g, c);
        } else {
            s = new FarmerState("East", w, g, c);
        }
        return s;
    }

    private State takesWolf(State st){
        FarmerState s = (FarmerState)st;
        String f = s.getFlocation();
        String w = s.getWlocation();
        String g = s.getGlocation();
        String c = s.getClocation();
        if(g.equals(c)){
            return null;
        } else if(f.equals("West") && w.equals("East")) {
            return null;
        } else if(f.equals("East") && w.equals("West")) {
            return null;
        }
        if(w.equals("East")) {
            s = new FarmerState("West", "West", g, c);
        } else {
            s = new FarmerState("East", "East", g, c);
        }
        return s;
    }

    private State takesGoat(State st){
        FarmerState s = (FarmerState)st;
        String f = s.getFlocation();
        String w = s.getWlocation();
        String g = s.getGlocation();
        String c = s.getClocation();
        if(f.equals("West") && w.equals("West") && g.equals("East") && c.equals("West")){
            return null;
        } else if(f.equals("West") && g.equals("East")) {
            return null;
        } else if(f.equals("East") && g.equals("West")) {
            return null;
        }
        if(g.equals("East")) {
            s = new FarmerState("West", w, "West", c);
        } else {
            s = new FarmerState("East", w, "East", c);
        }
        return s;
    }

    private State takesCabbage(State st){
        FarmerState s = (FarmerState)st;
        String f = s.getFlocation();
        String w = s.getWlocation();
        String g = s.getGlocation();
        String c = s.getClocation();
        if(g.equals(c) && f.equals(w)){
            return null;
        } else if(f.equals("West") && c.equals("East")) {
            return null;
        } else if(f.equals("East") && c.equals("West")) {
            return null;
        }
        if(c.equals("East")) {
            s = new FarmerState("West", w, g, "West");
        } else {
            s = new FarmerState("East", w, g, "East");
        }
        return s;
    }

}