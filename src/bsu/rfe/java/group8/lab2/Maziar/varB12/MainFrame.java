package bsu.rfe.java.group8.lab2.Maziar.varB12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
         }
            });
            radio.add(button);
            boxFormulaType.add(button);
    }

    public MainFrame()
    {
        super("Решение уравнений с тремя переменными");
        setSize(WIDTH,HEIGHT);
        Toolkit tool = Toolkit.getDefaultToolkit();
        setLocation(10,10);
        addRadioButton("function 1",1);
        addRadioButton("function 2",2);
        radio.setSelected(radio.getElements().nextElement().getModel(),true);
        boxFormulaType.setBorder(BorderFactory.createLineBorder(Color.RED));
        JLabel forX = new JLabel("X: ");
        dxField = new JTextField("0",10);
        dxField.setMaximumSize(dxField.getPreferredSize());
        JLabel forY = new JLabel("Y: ");
        dyField = new JTextField("0",10);
        dyField.setMaximumSize(dyField.getPreferredSize());
        JLabel forZ = new JLabel("Z: ");
        dzField = new JTextField("0",10);
        dzField.setMaximumSize(dzField.getPreferredSize());

        Box Variables = Box.createHorizontalBox();
       Variables.setBorder(
                BorderFactory.createLineBorder(Color.BLUE));
        Variables.add(Box.createHorizontalGlue());
        Variables.add(forX);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(dxField);

        Variables.add(Box.createHorizontalStrut(100));
        Variables.add(forY);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(dyField);
        Variables.add(Box.createHorizontalGlue());

        Variables.add(Box.createHorizontalStrut(100));
        Variables.add(forZ);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(dzField);
        Variables.add((Box.createHorizontalGlue()));

        JLabel forResult = new JLabel("Результат");
        resultField = new JTextField("0",10);
        resultField.setMaximumSize(resultField.getPreferredSize());
        Box boxResult = Box.createHorizontalBox();
        boxResult.add(Box.createHorizontalGlue());
        boxResult.add(forResult);
        boxResult.add(Box.createHorizontalStrut(10));
        boxResult.add(resultField);
        boxResult.add(Box.createHorizontalGlue());
        boxResult.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        JButton resultbutton = new JButton("result");
        resultbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Double x = Double.parseDouble(dxField.getText());
                    Double y = Double.parseDouble(dyField.getText());
                    Double z = Double.parseDouble(dzField.getText());
                    Double result;
                    if (number_of_formula==1)
                        result = function1(x, y,z);
                    else
                        result = function2(x, y,z);
                    resultField.setText(result.toString());
                }catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Floating point format error", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dxField.setText("0");
                dyField.setText("0");
                dzField.setText("0");
                resultField.setText("0");
            }
        });

        

    }
}
