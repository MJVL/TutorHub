import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

    ImWindow m = new ImWindow();
    LandingWindow l = new LandingWindow();
    SubjectWindow s = new SubjectWindow();

    public MainWindow() {
        setLayout(new CardLayout());
        add(l.MainPanel);
//        m.btnStudent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                remove(m.MainPanel);
////                add(s.MainGUI);
////                validate();
////                pack();
//                setVisible(true);
//            }
//        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


}
