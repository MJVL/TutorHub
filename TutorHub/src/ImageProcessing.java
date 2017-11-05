import javax.swing.*;
import java.util.ArrayList;

public class ImageProcessing {
    private ImageIcon imgproblem = new ImageIcon();
    private String question = "";
    private ArrayList<Question> arrallquestion = new ArrayList<Question>();

    public ImageProcessing(){
        imgproblem = new ImageIcon();
        question = "";
        arrallquestion = new ArrayList<Question>();
    }

    public ArrayList<Question> getArrallquestion() {
        return arrallquestion;
    }

    public void setArrallquestion(ArrayList<Question> arrallquestion) {
        this.arrallquestion = arrallquestion;
    }

    public ImageIcon getImgproblem() {
        return imgproblem;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setImgproblem(ImageIcon imgproblem){
        this.imgproblem = imgproblem;
    }

    public Question getsimilaranswer(){
        AI result = new AI();
        Question ans = new Question();
        result.setArrallquestions(arrallquestion);
        ans = result.findsimilarquestion(new Question(question));
        return ans;
    }

    public String toString(){
        String out = "";
        out = question;
        return out;
    }
}