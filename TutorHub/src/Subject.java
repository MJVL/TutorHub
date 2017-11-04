public class Subject {
    String mySubject;

    public Subject(){   //default constructor
        mySubject = "";
    }
    public Subject(String subject){     //fill constructor
        mySubject = subject;
    }
    public void setSubject(String subject){     //sets the subject
        mySubject = subject;
    }
    public String getSubject(){     //gets the subject
        return mySubject;
    }
    public String toString(){       //toString
        return mySubject;
    }
}