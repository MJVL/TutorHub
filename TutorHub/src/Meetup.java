import java.lang.reflect.Array;
import java.util.ArrayList;

public class Meetup {
    private String type, location;
    private ArrayList<Students> arrstudents = new ArrayList<Students>();
    private ArrayList<Tutors> arrtutors = new ArrayList<Tutors>();

    public Meetup()
    {
        type = "";
        location  = "";
        arrstudents = new ArrayList<Students>();
        arrtutors = new ArrayList<Tutors>();
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Students> getArrstudents() {
        return arrstudents;
    }

    public ArrayList<Tutors> getArrtutors() {
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

    public void setArrstudents(ArrayList<Students> arrstudents)
    {
        this.arrstudents = arrstudents;
    }

    public void setArrtutors(ArrayList<Tutors> arrtutors)
    {
        this.arrtutors = arrtutors;
    }

    public String toString(){
        String out = "";
        out = type + "," + location;
        for(int i = 0;i<arrstudents.size();i++){
            out += "," + arrstudents.get(i).toString();
        }
        for(int i = 0;i<arrtutors.size();i++){
            out += "," + arrtutors.get(i).toString();
        }
         return out;
    }
}
