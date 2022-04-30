package com.example.problemsolver.domains.farmer;

import com.example.problemsolver.framework.problem.State;
import java.util.Objects;

/**
 *
 * @author gideonokoroafor
 */
public class FarmerState extends State {
    public FarmerState(String fLocation, String wLocation, String gLocation, String cLocation){
        this.fLocation = fLocation;
        this.wLocation = wLocation;
        this.gLocation = gLocation;
        this.cLocation = cLocation;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        FarmerState other = (FarmerState) object;
        return (this.fLocation.equals(other.fLocation) &&
                this.wLocation.equals(other.wLocation) &&
                this.gLocation.equals(other.gLocation) &&
                this.cLocation.equals(other.cLocation));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fLocation);
        hash = 97 * hash + Objects.hashCode(this.wLocation);
        hash = 97 * hash + Objects.hashCode(this.gLocation);
        hash = 97 * hash + Objects.hashCode(this.cLocation);
        return hash;
    }

    @Override
    public String toString() {
        String sb = "   " + "|  " + "|   \n";
        if(fLocation.equals("West")){
            sb += " F " + "|  " + "|   \n";
        }
        else{
            sb += "   " + "|  " + "| F \n";
        }
        if(wLocation.equals("West")){
            sb += " W " + "|  " + "|   \n";
        }
        else{
            sb += "   " + "|  " + "| W \n";
        }
        if(gLocation.equals("West")){
            sb += " G " + "|  " + "|   \n";
        }
        else{
            sb += "   " + "|  " + "| G \n";
        }
        if(cLocation.equals("West")){
            sb += " C " + "|  " + "|   \n";
        }
        else{
            sb += "   " + "|  " + "| C \n";
        }
        sb += "   " + "|  " + "|   ";
        return sb;
    }

    public String getFlocation(){
        return fLocation;
    }
    public String getWlocation(){
        return wLocation;
    }

    public String getGlocation(){
        return gLocation;
    }

    public String getClocation(){
        return cLocation;
    }


    private final String fLocation;
    private final String wLocation;
    private final String gLocation;
    private final String cLocation;
}