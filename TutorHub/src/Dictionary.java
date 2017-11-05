import java.util.ArrayList;

public class Dictionary {
    private ArrayList<String> arrdictword = new ArrayList<String>();

    public Dictionary(){
        arrdictword = new ArrayList<String>();
    }

    public Dictionary(ArrayList<String> arrdictword){
        this.arrdictword = arrdictword;
    }

    public ArrayList<String> getArrdictword() {
        return arrdictword;
    }

    public void setArrdictword(ArrayList<String> arrdictword) {
        this.arrdictword = arrdictword;
    }

    public boolean isaword(String word){
        boolean check = false;
        for(int i = 0;i<arrdictword.size();i++){
            if (word.equals(arrdictword.get(i))){
                check = true;
                break;
            }
        }
        return check;
    }
}
