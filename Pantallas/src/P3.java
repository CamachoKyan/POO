import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class P3 extends JFrame {
    private JButton btn1;
    private JButton btn2;
    private JPanel P3Frame;

    private JFrame Parent;
    public P3(JFrame P){
        setTitle("P3");
        setContentPane(P3Frame);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(350,250);

        Parent = P;
        JFrame self = this;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("CHAOS");

                dispose();

                Parent.setVisible(true);

            }
        });
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parent instanceof P1){
                    dispose();
                    Parent.setVisible(true);
                }else{
                    P1 p1 = new P1(self);
                    setVisible(false);
                    p1.setVisible(true);
                    try {
                        Parent.dispose();
                    } catch (Exception ex) {
                        System.out.println("No tiene papa");
                    }

                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parent instanceof P2){
                    dispose();
                    Parent.setVisible(true);
                }else{
                    P2 p2 = new P2(self);
                    setVisible(false);
                    p2.setVisible(true);
                    try {
                        Parent.dispose();
                    } catch (Exception ex) {
                        System.out.println("No tiene papa");
                    }
                }
            }
        });
    }
}
