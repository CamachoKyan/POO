import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class P1 extends JFrame{
    private JButton btn2;
    private JButton btn3;
    private JPanel P1Frame;

    private JFrame Parent;

    public P1(){

    }

    public P1(JFrame P){
        setTitle("P1");
        setContentPane(P1Frame);
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

                if(Parent instanceof P1){
                    Parent.dispose();
                    dispose();
                }else{
                    Parent.setVisible(true);
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

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parent instanceof P3){
                    dispose();
                    Parent.setVisible(true);
                }else{
                    P3 p3 = new P3(self);
                    setVisible(false);
                    p3.setVisible(true);
                    try {
                        Parent.dispose();
                    } catch (Exception ex) {
                        System.out.println("No tiene papa");
                    }


                }
            }
        });
    }

    void Init(){
        new P1(this);
        dispose();
    }

    public static void main(String[] args) {
        new P1().Init();

    }
}
