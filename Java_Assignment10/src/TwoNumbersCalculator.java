import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TwoNumbersCalculator extends JFrame{

	private JPanel panel;
	private JLabel label,label1,label2,label3,result ;
	private JTextField number1,number2;
	private JButton calculate,reset;
	private JComboBox comboBox;

	public TwoNumbersCalculator(){
		//setting the JFrame ready
		super("Calculator");
		setSize(450,300);
		setLocation(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		panel = new JPanel();
		getContentPane().add(panel);

		label = new JLabel("Add, subtract, multiply or divide 2 numbers");
		label1 = new JLabel("Enter first number:   ");
		label2 = new JLabel("Enter second number:   ");
		label3 = new JLabel("Result:   ");
		result = new JLabel();
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(result);

		number1 = new JTextField(5);
		number2 = new JTextField(5);
		panel.add(number1);
		panel.add(number2);
		panel.add(result);

		calculate = new JButton("Calculate");
		reset = new JButton("Reset");
		panel.add(calculate);
		panel.add(reset);

		String[] calc = {"  +  ","  -  ","  *  ","  /  "};
		comboBox = new JComboBox(calc);
		panel.add(comboBox);

		calculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				double output = 0;
				try{
					double n1 = Double.parseDouble(number1.getText());
					double n2 = Double.parseDouble(number2.getText());
					if(comboBox.getSelectedItem().equals("  +  ")){
						output = n1+n2;
					}
					if(comboBox.getSelectedItem().equals("  -  ")){
						output = n1-n2;
					}
					if(comboBox.getSelectedItem().equals("  *  ")){
						output = n1*n2;
					}
					if(comboBox.getSelectedItem().equals("  /  ")){
						output = n1/n2;
					}
					if(String.valueOf(output).matches("(.*).0") || String.valueOf(output).matches("(.*).00")){
						result.setText(String.valueOf(Math.round(output)));
					}
					else{
						result.setText(String.valueOf(output));
					}
				}catch(NumberFormatException num){
					JOptionPane.showMessageDialog(null, "Please type numbers for calculations");
				}
			}	
		});

		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				number1.setText("");
				number2.setText("");
				result.setText("");
			}
		});

		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(label,gc);

		gc.gridy = 2;
		panel.add(label1,gc);

		gc.gridy = 3;
		panel.add(label2,gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		panel.add(number1,gc);

		gc.gridy = 3;
		panel.add(number2,gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 4;
		panel.add(comboBox,gc);

		gc.gridy = 5;
		panel.add(calculate,gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		panel.add(reset,gc);

		gc.weighty =5;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.gridx = 0;
		gc.gridy = 6;
		panel.add(label3,gc);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		panel.add(result,gc);

		setVisible(true);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new TwoNumbersCalculator();
			}
		});
	}

}
