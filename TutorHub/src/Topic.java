public class Topic extends Subject{

    private String myTopic;

    public Topic(){     //default constructor
        myTopic = "";
    }
    public Topic(String topic){     //fill constructor
        myTopic = topic;
    }

    //set
    public void setTopic(String topic){
        myTopic  = topic;
    }

    //get
    public String getTopic(){
        return myTopic;
    }

    //toString
    public String toString(){
        return myTopic;
    }
}
