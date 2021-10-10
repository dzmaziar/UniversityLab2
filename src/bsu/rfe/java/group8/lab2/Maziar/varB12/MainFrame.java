package bsu.rfe.java.group8.lab2.Maziar.varB12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;


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



    // задание 2+3

        private int number_of_variable = 1;
    private JTextField result_fieldM;
    private ButtonGroup radio_variable = new ButtonGroup();
    private Box box_of_variable = Box.createHorizontalBox();

    Double mem1=0.0;
    Double mem2=0.0;
    Double mem3=0.0;

    private void addRadioVariable(String name, int number_of_variable)
    {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.number_of_variable = number_of_variable;
            }
        });
        radio_variable.add(button);
        box_of_variable.add(button);
    }


//




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

        //задание 2,3
setLocation(60,60);
        addRadioVariable("x", 1);
        addRadioVariable("y",2);
        addRadioVariable("z",3);
        radio_variable.setSelected(radio_variable.getElements().nextElement().getModel(),true);
        box_of_variable.setBorder(BorderFactory.createLineBorder(Color.green));



        JLabel forResultM = new JLabel("Результат M: ");
        result_fieldM = new JTextField("0",20);
        result_fieldM.setMaximumSize(result_fieldM.getPreferredSize());
        Box boxResultM = Box.createHorizontalBox();
        boxResultM.add(Box.createHorizontalGlue());
        boxResultM.add(forResultM);
        boxResultM.add(Box.createHorizontalStrut(10));
        boxResultM.add(result_fieldM);
        boxResultM.add(Box.createHorizontalGlue());
        boxResultM.setBorder(BorderFactory.createLineBorder(Color.CYAN));



        //

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

        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(forZ);
        Variables.add(Box.createHorizontalStrut(10));
        Variables.add(dzField);
        Variables.add((Box.createHorizontalGlue()));

        JLabel forResult = new JLabel("Результат: ");
        resultField = new JTextField("0",30);
        resultField.setMaximumSize(resultField.getPreferredSize());
        Box boxResult = Box.createHorizontalBox();
        boxResult.add(Box.createHorizontalGlue());
        boxResult.add(forResult);
        boxResult.add(Box.createHorizontalStrut(10));
        boxResult.add(resultField);
        boxResult.add(Box.createHorizontalGlue());
        boxResult.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        JButton resultbutton = new JButton("result");
        resultbutton.addActionListener(new ActionListener() {

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


        //2-3
        JButton M = new JButton("M+");
        M.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try{
                    Double x = Double.parseDouble(dxField.getText());
                    Double y = Double.parseDouble(dyField.getText());
                    Double z = Double.parseDouble(dzField.getText());

                    if (number_of_variable==1) {
                        mem1 += x;
                        result_fieldM.setText(mem1.toString());
                    }
                    if (number_of_variable==2) {
                        mem2+=y;
                        result_fieldM.setText(mem2.toString());
                    }
                        if (number_of_variable==3) {
                            mem3 += z;
                            result_fieldM.setText(mem3.toString());
                        }

                }catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Floating point format error", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });



        JButton MC_clear = new JButton("MC");
        MC_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(number_of_variable ==1)
                {
                    dxField.setText("0");
                }
                if(number_of_variable ==2) {
                    dyField.setText("0");
                }
                if(number_of_variable ==3) {
                    dzField.setText("0");
                }
            }
        });
        //


        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dxField.setText("0");
                dyField.setText("0");
                dzField.setText("0");
                resultField.setText("0");
                result_fieldM.setText("0");
            }
        });

        Box boxbuttons= Box.createHorizontalBox();
        boxbuttons.add(Box.createHorizontalGlue());
        boxbuttons.add(resultbutton);
        boxbuttons.add(Box.createHorizontalStrut(30));
        boxbuttons.add(clear);
        //2-3
        boxbuttons.add(M);
        boxbuttons.add(MC_clear);
        //
        boxbuttons.add(Box.createHorizontalGlue());
        boxbuttons.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(boxFormulaType);
        //2-3
        contentBox.add(Box.createHorizontalGlue());
        contentBox.add(box_of_variable);
        contentBox.add(result_fieldM);
        contentBox.add(M);
       // contentBox.add(MC_clear);

        //
        contentBox.add(Variables);
        contentBox.add(resultbutton);
        contentBox.add(boxbuttons);
        contentBox.add(resultField);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);

    }
}
