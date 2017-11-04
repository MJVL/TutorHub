import javax.swing.*;

public class Question {

    String myQuestion;
    ImageIcon myImage;

    public Question() {
        myQuestion = null;
        myImage = null;
    }

    public Question(String myQuestion) {
        this.myQuestion = myQuestion;
    }

    public Question(String myQuestion, ImageIcon myImage) {
        this.myQuestion = myQuestion;
        this.myImage = myImage;
    }

    public void setQuestion(String myQuestion) {
        this.myQuestion = myQuestion;
    }

    public String getQuestion() {
        return myQuestion;
    }

    public void setImage(ImageIcon myImage) {
        this.myImage = myImage;
    }

    public ImageIcon getImage() {
        return myImage;
    }

    public String toString() {
        return myQuestion;
    }

}
