import java.util.ArrayList;

public class tutor {
    private creditials c;
    private ArrayList<subject> arrsub = new ArrayList<subject>();

    tutor()
    {
        c = new creditals();
        arrsub = new ArrayList<subject>();
    }

    public creditials getC() {
        return c;
    }

    public ArrayList<subject> getArrsub() {
        return arrsub;
    }

    public void setC(creditials c)
    {
        this.c = c;
    }

    public void setArrsub(ArrayList<subject> arrsub)
    {
        this.arrsub = arrsub;
    }
}
