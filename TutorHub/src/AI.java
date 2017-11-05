import java.util.ArrayList;

public class AI {
    private ArrayList<Question> arrallquestions = new ArrayList<Question>();

    public AI(){
        arrallquestions = new ArrayList<Question>();
    }

    public AI(ArrayList<Question> arrallquestions){
        this.arrallquestions = arrallquestions;
    }

    public ArrayList<Question> getArrallquestions() {
        return arrallquestions;
    }

    public void setArrallquestions(ArrayList<Question> arrallquestions) {
        this.arrallquestions = arrallquestions;
    }

    public Question findsimilarquestion(Question find){
        String arrwords[] = find.getQuestion().split(" ");
        int count = 0;
        double pmatch = 0.0;
        Question result = new Question();
        int pos = 0;
        for(int x = 0;x<arrwords.length;x++){
            String arrcomwords[] = arrallquestions.get(x).getQuestion().split(" ");
            count = 0;
            for(int y = 0;y<arrcomwords.length;y++){
                if(arrwords[x].equals(arrcomwords[y]) && arrallquestions.get(x).getMyAnswer()!= ""){
                    count++;
                }
            }
            if((count/arrcomwords.length)>pmatch){
                pmatch = count / arrcomwords.length;
                pos = x;
            }
        }
        result = arrallquestions.get(pos);
        return result;
    }
}
