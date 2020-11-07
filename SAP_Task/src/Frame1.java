import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Exceptions.EmptyStringException;
import Exceptions.NegativeNumberException;
import Exceptions.WrongPathException;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class Frame1 {

	private JFrame frame;
	private JTextField pathTextField;
	private JTextField writeTextField;
	private JTextField changeLinesFirstLine;
	private JTextField changeLineSecondLine;
	private JTextField changeWordsFirstLine;
	private JTextField changeWordsFirstIndex;
	private JTextField changeWordsSecondLine;
	private JTextField changeWordsSecondIndex;
	
	CreateFile createFile;
	WriteToFile writeToFile;
	ReadFromFile readFromFile;
	ChangeLines changeLines;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 506, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pathTextField = new JTextField();
		pathTextField.setText("filename.txt");
		pathTextField.setBounds(72, 22, 86, 20);
		frame.getContentPane().add(pathTextField);
		pathTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Path");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(16, 25, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Write");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(16, 63, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		writeTextField = new JTextField();
		writeTextField.setBounds(72, 60, 86, 20);
		frame.getContentPane().add(writeTextField);
		writeTextField.setColumns(10);
		
		JButton writeButton = new JButton("Write");
		writeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		writeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Validator.checkIfStringIsEmpty(writeTextField.getText()) == true){
						writeToFile.writeToFile(writeTextField.getText());
					}
				} catch (EmptyStringException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		writeButton.setBounds(185, 59, 89, 23);
		writeButton.setVisible(false);
		frame.getContentPane().add(writeButton);
		
		JLabel lblNewLabel_2 = new JLabel("Change lines");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 109, 74, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		changeLinesFirstLine = new JTextField();
		changeLinesFirstLine.setBounds(96, 134, 86, 20);
		frame.getContentPane().add(changeLinesFirstLine);
		changeLinesFirstLine.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("First line");
		lblNewLabel_3.setBounds(16, 137, 68, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Second lin\u0435");
		lblNewLabel_4.setBounds(218, 136, 67, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		changeLineSecondLine = new JTextField();
		changeLineSecondLine.setBounds(295, 134, 86, 20);
		frame.getContentPane().add(changeLineSecondLine);
		changeLineSecondLine.setColumns(10);
		
		JButton changeLinesButton = new JButton("Change");
		changeLinesButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		changeLinesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Validator.checkIfNegative(changeLinesFirstLine.getText()) && Validator.checkIfNegative(changeLineSecondLine.getText())) {
						changeLines.changeWholeLine(Integer.parseInt(changeLinesFirstLine.getText()), Integer.parseInt(changeLineSecondLine.getText()));
					}
				} catch (NumberFormatException | NegativeNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		changeLinesButton.setVisible(false);
		changeLinesButton.setBounds(391, 133, 89, 23);
		frame.getContentPane().add(changeLinesButton);
		
		JLabel lblNewLabel_5 = new JLabel("Change words");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 162, 86, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("First line");
		lblNewLabel_6.setBounds(16, 186, 68, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		changeWordsFirstLine = new JTextField();
		changeWordsFirstLine.setBounds(96, 183, 86, 20);
		frame.getContentPane().add(changeWordsFirstLine);
		changeWordsFirstLine.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("First index");
		lblNewLabel_7.setBounds(218, 187, 56, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		changeWordsFirstIndex = new JTextField();
		changeWordsFirstIndex.setBounds(295, 183, 86, 20);
		frame.getContentPane().add(changeWordsFirstIndex);
		changeWordsFirstIndex.setColumns(10);
		
		JButton changeWordsButton = new JButton("Change");
		changeWordsButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		changeWordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Validator.checkIfNegative(changeWordsFirstLine.getText()) && Validator.checkIfNegative(changeWordsFirstIndex.getText()) && Validator.checkIfNegative(changeWordsSecondLine.getText())&& Validator.checkIfNegative(changeWordsSecondIndex.getText())) {
						changeLines.changeWordsByIndex(Integer.parseInt(changeWordsFirstLine.getText()), Integer.parseInt(changeWordsFirstIndex.getText()), Integer.parseInt(changeWordsSecondLine.getText()), Integer.parseInt(changeWordsSecondIndex.getText()));
					}
				} catch (NumberFormatException | NegativeNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		changeWordsButton.setVisible(false);
		changeWordsButton.setBounds(391, 196, 89, 23);
		frame.getContentPane().add(changeWordsButton);
		
		JLabel lblNewLabel_8 = new JLabel("Second line");
		lblNewLabel_8.setBounds(16, 220, 68, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		changeWordsSecondLine = new JTextField();
		changeWordsSecondLine.setBounds(96, 217, 86, 20);
		frame.getContentPane().add(changeWordsSecondLine);
		changeWordsSecondLine.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Second index");
		lblNewLabel_9.setBounds(207, 220, 78, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		changeWordsSecondIndex = new JTextField();
		changeWordsSecondIndex.setBounds(295, 217, 86, 20);
		frame.getContentPane().add(changeWordsSecondIndex);
		changeWordsSecondIndex.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 371, 144);
		frame.getContentPane().add(scrollPane);
		
		JTextArea readTextArea = new JTextArea();
		scrollPane.setViewportView(readTextArea);
		readTextArea.setLineWrap(true);
		readTextArea.setWrapStyleWord(true);
		
		JButton read = new JButton("Read");
		read.setFont(new Font("Tahoma", Font.BOLD, 11));
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readTextArea.setText("");
				readFromFile.readFromFile(readTextArea);
			}
		});
		read.setVisible(false);
		read.setBounds(400, 304, 80, 23);
		frame.getContentPane().add(read);
		
		JButton newLineButton = new JButton("New line");
		newLineButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		newLineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				writeToFile.newLine();
				System.out.println("New line created");
			}
		});
		newLineButton.setVisible(false);
		newLineButton.setBounds(185, 93, 89, 23);
		frame.getContentPane().add(newLineButton);
		
		
		JButton btnNewButton = new JButton("Set Path");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Validator.checkPath(pathTextField.getText())==true) {
						createFile = new CreateFile(pathTextField.getText());
						writeToFile = new WriteToFile(pathTextField.getText());
						readFromFile = new ReadFromFile(pathTextField.getText());
						changeLines = new ChangeLines(pathTextField.getText());
						writeButton.setVisible(true);
						changeLinesButton.setVisible(true);
						changeWordsButton.setVisible(true);
						newLineButton.setVisible(true);
						read.setVisible(true);
					}	
					else {
						System.out.println("Wrong path");
					}
				} catch (WrongPathException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(185, 21, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
