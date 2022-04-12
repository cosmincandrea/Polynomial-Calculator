package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PolynomView extends JPanel {

    private JTextField insertP1 = new JTextField(50);
    private JTextField insertP2 = new JTextField(50);
    private JTextField Result = new JTextField(50);
    private JButton addBtn = new JButton("Add P1 + P2");
    private JButton subBtn = new JButton("Subtract P1 - P2");
    private JButton mulBtn = new JButton("Multiply P1 * P2");
    private JButton integrate = new JButton("Integrate first polynom");
    private JButton derivate = new JButton("Derivate first polynom");
    private JButton clearBtn = new JButton("Clear");

    public void view(){

        JFrame frame = new JFrame ("Polynom Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 300);

        JPanel polynomial1 = new JPanel();
        polynomial1.setLayout(new FlowLayout());
        polynomial1.add(new JLabel("Polynom 1: "));
        polynomial1.add(insertP1);

        JPanel polynomial2 = new JPanel();
        polynomial2.setLayout(new FlowLayout());
        polynomial2.add(new JLabel("Polynom 2: "));
        polynomial2.add(insertP2);

        JPanel operations = new JPanel();
        operations.setLayout(new FlowLayout());
        operations.add(addBtn);
        operations.add(subBtn);
        operations.add(mulBtn);
        operations.add(integrate);
        operations.add(derivate);
        operations.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        JPanel result = new JPanel();
        result.setLayout(new FlowLayout());
        result.add(new JLabel("Result: "));
        result.add(Result);
        result.add(clearBtn);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(polynomial1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(polynomial2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(operations);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.add(result);

        final JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);
        finalPanel.add(panel4);

        frame.setContentPane(finalPanel);
        frame.setVisible(true);

    }


    public void clearResult(){
        Result.setText("");
    }

    public void clearAll() {
        clearResult();
        insertP1.setText("");
        insertP2.setText("");
    }

    public void displayResult(String result) {
        Result.setText(result);
    }

    public String getInputP1() {
        return insertP1.getText();
    }

    public String getinputP2() {
        return insertP2.getText();
    }

    public void addClearListener() {
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });
    }

    public void addAddListener(ActionListener add)
    {
        addBtn.addActionListener(add);
    }

    public void addSubListener(ActionListener sub) {
        subBtn.addActionListener(sub);
    }


    public void addMultListener(ActionListener mul) {
        mulBtn.addActionListener(mul);
    }

    public void addIntegrateListener(ActionListener intg){
        integrate.addActionListener(intg);
    }

    public void addDerivateListener(ActionListener deriv){
        derivate.addActionListener(deriv);
    }
}
