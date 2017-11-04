import java.util.ArrayList;

public class student {
    private creditials c;
    private ArrayList<subject> arrsub = new ArrayList<subject>();

    student()
    {
        c = new creditials();
    }

    public creditials getC() {
        return c;
    }

    public ArrayList<subject> getArrsub() {
        return arrsub;
    }

    public void setArrsub(ArrayList<subject> arrsub) {
        this.arrsub = arrsub;
    }

    public void setC(creditials c) {
        this.c = c;
    }
}
