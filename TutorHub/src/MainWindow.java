import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

   private int linenum;
   private ImWindow m = new ImWindow();
   private SignUpWindow u = new SignUpWindow();
   private LandingWindow l = new LandingWindow();
   private ActiveRequestsWindow ARW = new ActiveRequestsWindow();
   private StudentLandingWindow sl = new StudentLandingWindow();
   private SubjectWindow sj = new SubjectWindow();
   private TutorWindow tl = new TutorWindow();
   private LogInWindow x = new LogInWindow();
   private MesageWindow msg = new MesageWindow();
   private Topic UserTopic;
   private QuestionWindow q = new QuestionWindow();
   private ForeignLanguageWindow flang = new ForeignLanguageWindow();
   private ACTSATWindow astest = new ACTSATWindow();
   private LanguageArtsWindow english = new LanguageArtsWindow();
   private MathWindow math = new MathWindow();
   private ProgrammingWindow cs = new ProgrammingWindow();
   private ScienceWindow science = new ScienceWindow();
   private SocialStudiesWindow history = new SocialStudiesWindow();
   private Boolean FirstL = true;
   private Boolean FirstUser = true;
   private Boolean FirstCreate = true;
   private Boolean studentactive = false;
   private SubjectWindow s = new SubjectWindow();
   private Boolean Tutor = false;
   private Boolean Student = false;
   private Tutor UserT = null;
   private Student UserS = null;
   private javax.swing.Timer timer;
   private String Username = null;
   private String UPass = null;
   private String TempUsername, TempPassword, TempEmail;
   private DefaultListModel ActiveRequests = new DefaultListModel();
   private DefaultListModel Subjects = new DefaultListModel();
   private DefaultListModel Questions = new DefaultListModel();

    public MainWindow() {
        setTitle("TutorHub");
        setLayout(new CardLayout());
        add(l.MainPanel);
        l.Visible = true;
        x.Visible = false;
        u.Visible = false;
        timer = new javax.swing.Timer(50, new MoveListener());
        timer.start();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        u.btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new File("src/assets/data/" + u.txtUsername.getText() + ".txt").exists()) {
                    JOptionPane.showMessageDialog(null, "Username is taken.");
                    u.txtPassword.setText("");
                    u.txtEmail.setText("");
                    u.txtUsername.setText("");
                } else {
                    TempUsername = u.txtUsername.getText();
                    TempEmail = u.txtEmail.getText();
                    TempPassword = u.txtPassword.getText();
                    u.Visible = false;
                    m.Visible = true;
                    remove(u.MainPanel);
                    add(m.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                    FirstL = false;
                    JOptionPane.showMessageDialog(null, "Account created successfully.");
                }
            }
        });
        m.btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLogin("src/assets/data/logins.txt", 's');
                UserS = new Student();
                savestudent("src/assets/data/" + TempUsername + ".txt", UserS);
                m.Visible = false;
                x.Visible = true;
                remove(m.MainPanel);
                add(x.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        m.btnTutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLogin("src/assets/data/logins.txt", 't');
                UserT = new Tutor();
                savetutor("src/assets/data/" + TempUsername + ".txt", UserT);
                m.Visible = false;
                x.Visible = true;
                remove(m.MainPanel);
                add(x.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        x.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FirstUser) {
                    try {
                        Scanner Freader = new Scanner(new File("src/assets/data/logins.txt"));
                        while (Freader.hasNextLine()) {
                            String[] SplitArr = Freader.nextLine().split(",");
                            if (SplitArr[0].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText()) || SplitArr[2].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText())) {
                                UPass = x.txtPassword.getText();
                                TempUsername = SplitArr[0];
                                FirstUser = false;
                                if (SplitArr[3].equals("t")) { ;
                                    UserT = new Tutor("src/assets/data/" + TempUsername + ".txt");
                                    sl.Visible = true;
                                    x.Visible = false;
                                    remove(x.MainPanel);
                                    add(tl.MainPanel);
                                    validate();
                                    pack();
                                    setVisible(true);
                                    Tutor = true;
                                    for (int t = 0; t < UserT.getArrsub().size(); t++) {
                                        Subjects.addElement(UserT.getArrsub().get(t));
                                    }
                                    tl.lstSubjects.setModel(Subjects);
                                    try {
                                        Scanner Freader2 = new Scanner(new File("src/assets/data/questions.txt"));
                                        while (Freader2.hasNextLine()) {
                                            String[] SplitArr2 = Freader2.nextLine().split(",");
                                            if (SplitArr2[4].equals("n")) {
                                                Questions.addElement("Subject: " + SplitArr2[0] + ", Topic: " + SplitArr2[1]);
                                                Questions.addElement("Question: " + SplitArr2[3]);
                                                tl.lstQuestions.setModel(Questions);
                                            }
                                        }
                                    } catch (IOException e2) {
                                        System.err.println("File Error");
                                    }
                                    JOptionPane.showMessageDialog(null, "Login Successful");
                                    break;
                                } else {
                                    Student = true;
                                    UserS = new Student("src/assets/data/" + TempUsername + ".txt");
                                    sl.Visible = true;
                                    x.Visible = false;
                                    remove(x.MainPanel);
                                    add(sl.MainPanel);
                                    validate();
                                    pack();
                                    setVisible(true);
                                    JOptionPane.showMessageDialog(null, "Login Successful");
                                    break;
                                }
                            }
                        }
                        if (!Tutor && !Student) {
                            JOptionPane.showMessageDialog(null, "Failed");
                        }
                    } catch (IOException e1) {
                        System.err.println("File Error");
                    }
                }
            }
        });
        sl.btnActiveRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sl.Visible = false;
                ARW.Visible = true;
                remove(sl.MainPanel);
                add(ARW.MainPanel);
                validate();
                pack();
                setVisible(true);
                ActiveRequests.clear();
                try {
                    Scanner Freader2 = new Scanner(new File("src/assets/data/questions.txt"));
                    while (Freader2.hasNextLine()) {
                        String[] SplitArr = Freader2.nextLine().split(",");
                        if (SplitArr[2].equals(TempUsername)) {
                            UserTopic = new Topic(SplitArr[0],SplitArr[1]);
                            ActiveRequests.addElement(UserTopic.toString());
                            if (SplitArr[4].equals("n")) {
                                ActiveRequests.addElement("Question: " + SplitArr[3]);
                                ActiveRequests.addElement("Answer: None, unanswered.");
                            } else {
                                ActiveRequests.addElement("Question: " + SplitArr[3]);
                                ActiveRequests.addElement("Answer: " + SplitArr[5]);
                            }

                        }
                    }
                } catch (IOException e2) {
                    System.err.println("File Error");
                }
                ARW.lstRequests.setModel(ActiveRequests);
                ARW.scrlMain.setViewportView(ARW.lstRequests);
            }
        });
        ARW.btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARW.Visible = false;
                sl.Visible = true;
                remove(ARW.MainPanel);
                add(sl.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sl.btnGetHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sl.Visible = false;
                sj.Visible = true;
                remove(sl.MainPanel);
                add(sj.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        l.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FirstL) {
                    l.Visible = false;
                    x.Visible = true;
                    remove(l.MainPanel);
                    add(x.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                    FirstL = false;
                }
            }
        });
        l.btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FirstCreate) {
                    l.Visible = false;
                    u.Visible = true;
                    remove(l.MainPanel);
                    add(u.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                }
            }
        });

        sj.btnForeignLanguages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                flang.Visible = true;
                remove(sj.MainPanel);
                add(flang.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnTesting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                astest.Visible = true;
                remove(sj.MainPanel);
                add(astest.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnLanguageArts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                english.Visible = true;
                remove(sj.MainPanel);
                add(english.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnMath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                math.Visible = true;
                remove(sj.MainPanel);
                add(math.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnScience.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                science.Visible = true;
                remove(sj.MainPanel);
                add(science.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnSocialStudies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                history.Visible = true;
                remove(sj.MainPanel);
                add(history.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnProgramming.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                cs.Visible = true;
                remove(sj.MainPanel);
                add(cs.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        sj.btnOther.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sj.Visible = false;
                remove(sj.MainPanel);
                openQuestionWindow("Other", "");
            }
        });

        astest.btnACT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                astest.Visible = false;
                remove(astest.MainPanel);
                openQuestionWindow("ACT/SAT", "ACT");
            }
        });
        astest.btnSAT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                astest.Visible = false;
                remove(astest.MainPanel);
                openQuestionWindow("ACT/SAT", "SAT");
            }
        });

        flang.btnMandarin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "Mandarin");
            }
        });
        flang.btnFrench.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "French");
            }
        });
        flang.btnGerman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "German");
            }
        });
        flang.btnPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "Portuguese");
            }
        });
        flang.btnSpanish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "Spanish");
            }
        });
        flang.btnOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(flang.MainPanel);
                openQuestionWindow("Foreign Language", "Other");
            }
        });

        english.btnComposition.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (english.MainPanel);
                openQuestionWindow("Language Arts","Composition");
            }
        });
        english.btnLiterature.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (english.MainPanel);
                openQuestionWindow("Language Arts","Literature");
            }
        });
        english.btnSeminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (english.MainPanel);
                openQuestionWindow("Language Arts","Seminar");
            }
        });
        english.btnOther.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (english.MainPanel);
                openQuestionWindow("Language Arts","Other");
            }
        });

        math.btnAlgebra1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Algebra 1");
            }
        });
        math.btnAlgebra2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Algebra 2");
            }
        });
        math.btnAQR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "AQR");
            }
        });
        math.btnCalculus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Calculus");
            }
        });
        math.btnGeometry.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Geometry");
            }
        });
        math.btnPreC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "PreCalculus");
            }
        });
        math.btnStatistics.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Statistics");
            }
        });
        math.btnOther.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (math.MainPanel);
                openQuestionWindow("Math", "Other");
            }
        });

        cs.cBasedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (cs.MainPanel);
                openQuestionWindow("Computer Science","C Based");
            }
        });
        cs.webBasedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (cs.MainPanel);
                openQuestionWindow("Computer Science","Web Based");
            }
        });
        cs.otherButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (cs.MainPanel);
                openQuestionWindow("Computer Science","Other");
            }
        });

        science.btnAnatomy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Anatomy");
            }
        });
        science.btnBiology.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Biology");
            }
        });
        science.btnChemistry.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Chemistry");
            }
        });
        science.btnForensics.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Forensics");
            }
        });
        science.btnPhysics.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Physics");
            }
        });
        science.btnOther.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (science.MainPanel);
                openQuestionWindow("Science","Other");
            }
        });

        history.btnEuropeanHistory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","European History");
            }
        });
        history.btnGovernment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","Government");
            }
        });
        history.btnHumanGeography.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","Human Geography");
            }
        });
        history.btnPsychology.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","Psychology");
            }
        });
        history.btnUSHistory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","US History");
            }
        });
        history.btnOther.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                remove (history.MainPanel);
                openQuestionWindow("History","Other");
            }
        });

        q.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/assets/data/questions.txt"),true))){
                    pw.println(UserTopic.getSubject() + "," + UserTopic.getTopic() + "," + TempUsername + "," + q.txtQuestion.getText() + ",n");
                    pw.close();
                    remove(q.MainPanel);
                    add(sl.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                    JOptionPane.showMessageDialog(null,"Question Submitted");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        tl.btnAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Answer = JOptionPane.showInputDialog("Answer");
                linenum = tl.lstQuestions.getSelectedIndex();
                JOptionPane.showMessageDialog(null,"Your answer was submitted.");
            }
        });
    }



    public void Update() {
        if(studentactive){
            msg.Visible = true;
            sl.Visible = false;
            remove(sl.MainPanel);
            add(msg.MainPanel);
            validate();
            pack();
            setVisible(true);

        }
        //if (Tutor) {
      //      JOptionPane.showMessageDialog(null,UserT.toString());
       //     Tutor = false;
        //}
    }

    public void openmeetups(String path){
        ArrayList<String> arrin = new ArrayList<String>();
        ArrayList<Meetup> arrmeetings = new ArrayList<Meetup>();
        ArrayList<String> arrstudentnames = new ArrayList<String>();
        ArrayList<String> arrtutornames = new ArrayList<String>();
        Meetup temp = new Meetup();
        boolean detect = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrin.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<arrin.size();i++){
            String parts[] = arrin.get(i).split(",");
            temp.setType(parts[0]);
            temp.setLocation(parts[1]);
            for(int x = 2;x<parts.length;x++){
                if(parts[x].equals("+")){
                    detect = true;
                }
                else if(detect==false){
                    arrstudentnames.add(parts[x]);
                }
                else{
                    arrtutornames.add(parts[x]);
                }
            }
            temp.setArrstudents(arrstudentnames);
            temp.setArrtutors(arrtutornames);
            arrmeetings.add(temp);
        }
    }

    public void saveLogin(String path, char type) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(path),true))){
            pw.println(TempUsername + "," + TempPassword + "," + TempEmail + "," + type);
            pw.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void savestudent(String path, Student s){
        try(PrintWriter out = new PrintWriter(new File(path))  ){
            out.println(s.toString());
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void savetutor(String path, Tutor t){
        try(PrintWriter out = new PrintWriter(new File(path))  ){
            out.println(t.toString());
            out.close();
        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        }
    }

    public void savemeetings(String paths, ArrayList<Meetup> arrmeetings){
        try(PrintWriter out = new PrintWriter(new File(paths))){
            for(int i = 0;i<arrmeetings.size();i++) {
                out.println(arrmeetings.get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e1){
            e1.printStackTrace();
        }
    }

    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Update();
        }


    }

    public void openQuestionWindow(String subject, String topic){
        UserTopic = new Topic(subject,topic);
        add(q.MainPanel);
        validate();
        pack();
        setVisible(true);
        System.out.println(UserTopic.toString());
    }
}
