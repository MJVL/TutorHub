import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Meetup {
    private String type, location;
    private ArrayList<String> arrstudents = new ArrayList<String>();
    private ArrayList<String> arrtutors = new ArrayList<String>();

    public Meetup()
    {
        type = "";
        location  = "";
        arrstudents = new ArrayList<String>();
        arrtutors = new ArrayList<String>();
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getArrstudents() {
        return arrstudents;
    }

    public ArrayList<String> getArrtutors() {
        return arrtutors;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setArrstudents(ArrayList<String> arrstudents)
    {
        this.arrstudents = arrstudents;
    }

    public void setArrtutors(ArrayList<String> arrtutors)
    {
        this.arrtutors = arrtutors;
    }

    public String toString(){
        String out = "";
        out = type + "," + location;
        for(int i = 0;i<arrstudents.size();i++){
            out += "," + arrstudents.get(i);
        }
        for(int i = 0;i<arrtutors.size();i++){
            out += "," + arrtutors.get(i);
        }
         return out;
    }
}
