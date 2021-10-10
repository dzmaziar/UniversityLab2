import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;


    private JTextField resultField;
    private JTextField dxField;
    private JTextField dyField;
    private JTextField dzField;
    private  int number_of_formula =1;

    private ButtonGroup radio = new ButtonGroup();
    private Box boxFormulaType = Box.createHorizontalBox();


    public double function1(double x, double y, double z) {
        return (Math.pow(Math.cos(Math.exp(x)) + Math.pow(Math.log(1 + y), 2) + Math.sqrt(Math.exp(Math.cos(x)) + Math.sin(Math.PI * z) * Math.sin(Math.PI * z)) + Math.sqrt(1 / x) + Math.cos(y * y),
                Math.sin(z)));
    }

    public double function2(double x, double y, double z) {
        return ((1 + Math.sqrt(z * x)) / (Math.pow(1 + x * x * x, 1 / y)));
    }


    private void addRadioButton(String name, final int number_of_formula)
    {
            JRadioButton button = new JRadioButton(name);
            button.addActionListener(new ActionListener() {
     @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.number_of_formula = number_of_formula;
                imagePane.updateUI();
         }
            });
            radio.add(button);
            boxFormulaType.add(button);
    }
    
}
