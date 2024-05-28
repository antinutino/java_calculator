import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.BreakIterator;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JTextField resultField;
    Font myfont=new Font("Roboto Light",Font.BOLD,15);
    JButton[] numberButton=new JButton[10];
    JButton[] functionButton= new JButton[10];
    JButton addButton,subButton,mulButton,divButton,modButton,sqButton,decButton,equalButton,factButton,clrButton;
    JPanel panel;
    Double number1,number2,result;
    String number2str="";
    String button;
    boolean flg=true,flg1=false,flg2=true;
    Calculator(){
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(395,560);
        frame.setLayout(null);
        textField =new JTextField();
        resultField =new JTextField();
        textField.setBackground(Color.LIGHT_GRAY);
        resultField.setBackground(new Color(224,224,224));
        textField.setBounds(0,0,380,50);
        textField.setFont(myfont);
        resultField.setBounds(0,50,380,50);
        resultField.setFont(myfont);
        frame.add(textField);
        frame.add(resultField);
        textField.setEditable(false);
        resultField.setEditable(false);

        addButton =new JButton("+");
        subButton =new JButton("-");
        mulButton =new JButton("x");
        divButton =new JButton("/");
        decButton =new JButton(".");
        equalButton =new JButton("=");
        factButton =new JButton("!");
        clrButton =new JButton("AC");
        modButton=new JButton("mod");
        sqButton=new JButton("^");
        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=modButton;
        functionButton[7]=decButton;
        functionButton[5]=sqButton;
        functionButton[6]=factButton;
        functionButton[8]=equalButton;
        functionButton[9]=clrButton;
        for(int i=0;i<10;i++) {
       functionButton[i].addActionListener(this);
       functionButton[i].setFont(myfont);
       functionButton[i].setFocusable(false);
        }
        for(int i=0;i<10;i++) {
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(false);
        }
        panel =new JPanel();
        panel.setBounds(0,100,380,420);
        panel.setLayout(new GridLayout(5,4,0,0));
        panel.add(clrButton);
        panel.add(sqButton);
        panel.add(factButton);
        panel.add(modButton);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(divButton);
        panel.add(equalButton);

        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(flg2)
        for(int i=0;i<10;i++) {
            if (e.getSource() == numberButton[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));
            if(flg==false) {
                if(e.getSource()==numberButton[i])
                number2str+=String.valueOf(i);
            }
            }
        if(e.getSource()==decButton)
        {textField.setText(textField.getText().concat("."));
            if(flg==false)
                number2str+=".";}

        if(flg==true&&flg1==false)
            for(int j=0;j<=6;j++)
            {
                if(e.getSource()==functionButton[j])
                {  number1=Double.parseDouble(textField.getText());
                    button=functionButton[j].getText();
                    textField.setText(textField.getText().concat(String.valueOf(button)));
                    flg=false;
                }
            }
        if(flg&&flg1)
            for(int j=0;j<=6;j++)
            {
                if(e.getSource()==functionButton[j])
                {  textField.setText(String.valueOf(result));resultField.setText("");number2str="";
                    button=functionButton[j].getText();
                    textField.setText(textField.getText().concat(String.valueOf(button)));
                    flg=false;flg1=false;flg2=true;
                }
            }

        if(e.getSource()==equalButton)
        {   if(number2str!="")
            number2=Double.parseDouble(number2str);
            switch (button)
            {
                case "+":
                    result=number1+number2;
                    break;
                case "-":
                    result=number1-number2;
                    break;
                case "x":
                    result=number1*number2;
                    break;
                case "/":
                    result=number1/number2;
                    break;
                case "mod":
                    result=(number1%number2);
                    break;
                case "^":
                {  double num2=1;
                    for(int i=1;i<=number2;i++)
                        num2*=number1;
                    result=num2;
                    break;
                }
                case "!":
                {  double num2=1;
                    for(int i=1;i<=number1;i++)
                        num2*=i;
                    result=num2;
                    break;
                }

            }
            resultField.setText(String.valueOf(result));
            number1=result;flg=true;flg1=true;flg2=false;
        }
        if(e.getSource()==clrButton)
        {textField.setText("");
            resultField.setText("");
        number1=0.0;number2=0.0;
        flg=true;button="";number2str="";flg1=false;flg2=true;
        }
    }
}