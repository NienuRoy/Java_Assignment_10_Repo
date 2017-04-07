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

public class CelciusFarenheitConverter extends JFrame{

	private JPanel panel;
	private JLabel tempLabel,resultLabel,outputLabel;
	private JTextField tempField;
	private JButton convertBtn,reset;
	private JComboBox combo;

	public CelciusFarenheitConverter(){
		super("Celcius Farenheit Converter");
		setSize(500, 300);
		setLocation(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		tempLabel = new JLabel("Temperature:  ");
		resultLabel = new JLabel("Result:   ");
		outputLabel = new JLabel();

		panel.add(tempLabel);
		panel.add(resultLabel);
		panel.add(outputLabel);

		tempField = new JTextField(8);
		panel.add(tempField);

		String[] values = {"Celcius to Farenheit","Farenheit to Celcius"};
		combo = new JComboBox(values);

		convertBtn = new JButton("Convert");
		panel.add(convertBtn);
		reset = new JButton("Reset");
		panel.add(reset);

		add(panel);

		convertBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					if(combo.getSelectedItem().equals("Celcius to Farenheit")){
						double celtoFaren = Double.parseDouble(tempField.getText());
						double farenheit = (double)(celtoFaren *9.0/5.0)+32.0;
						outputLabel.setText(String.format("%.2f",farenheit));
					}
					else if(combo.getSelectedItem().equals("Farenheit to Celcius")){
						double farentocel = Double.parseDouble(tempField.getText());
						double celcius = (double)(farentocel - 32.0)*5.0/9.0; 
						outputLabel.setText(String.format("%.2f",celcius));
					}
				}catch(NumberFormatException num){
					JOptionPane.showMessageDialog(null, "Please type numbers for temperature conversions");
				}
			}
		});

		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				tempField.setText("");
			}
		});

		panel.setLayout(new GridBagLayout());		
		GridBagConstraints gc = new GridBagConstraints();

		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(tempLabel,gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 1;
		panel.add(tempField,gc);

		gc.gridx = 2;
		panel.add(combo,gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		panel.add(convertBtn,gc);

		gc.gridx = 2;
		panel.add(reset,gc);

		gc.weighty = 2.5;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 3;
		panel.add(resultLabel,gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		panel.add(outputLabel,gc);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new CelciusFarenheitConverter().setVisible(true);
			}
		});
	}
}
