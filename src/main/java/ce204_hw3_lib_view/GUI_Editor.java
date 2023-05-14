package ce204_hw3_lib_view;

import java.awt.EventQueue;
import ce204_hw3_lib_model.*;
import ce204_hw3_lib_controller.*;
import ce204_hw3_app.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.*;
import org.fife.ui.rtextarea.*;
import javax.swing.JTextField;



public class GUI_Editor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Editor frame = new GUI_Editor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UndoManager um = new UndoManager();
	SyntaxColor scr = new SyntaxColor();
	Copy copy = new Copy();
	Cut cut = new Cut();
	Paste paste = new Paste();
	Redo redo = new Redo(this);
	Undo undo = new Undo(this);
	RunAndCompile rac = new RunAndCompile ();
	private JTextField textField;
	public GUI_Editor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 136, 742, 326);
		contentPane.add(scrollPane);
		
		RSyntaxTextArea textArea = new RSyntaxTextArea();
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        scrollPane.setViewportView(textArea);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        textArea.setText("public class HelloWorld {\r\n"
                + "    public static void main(String[] args) {\r\n"
                + "        System.out.println(\"Hello,World!\");\r\n"
                + "    }\r\n"
                + "}");
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCopy.setBackground(new Color(192, 192, 192));
		btnCopy.setBounds(244, 23, 93, 41);
		contentPane.add(btnCopy);
		btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
                String selectedText = textArea.getSelectedText();
                copy.copy(selectedText);


        }
        });
		
		JButton btnPaste = new JButton("Paste");
		btnPaste.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnPaste.setBackground(Color.LIGHT_GRAY);
		btnPaste.setBounds(244, 74, 93, 41);
		contentPane.add(btnPaste);
		btnPaste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                    textArea.paste();

            }
        });
		
		JButton btnCut = new JButton("Cut");
		btnCut.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCut.setBackground(Color.LIGHT_GRAY);
		btnCut.setBounds(365, 23, 93, 41);
		contentPane.add(btnCut);
		btnCut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub


                String selectedText = textArea.getSelectedText();
                if (selectedText != null) {
                    textArea.replaceSelection("");
                }
                cut.Cut(selectedText);
            }
        });
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnUndo.setBackground(Color.LIGHT_GRAY);
		btnUndo.setBounds(365, 74, 93, 41);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                undo.undo();

            }
        });
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnRedo.setBackground(Color.LIGHT_GRAY);
		btnRedo.setBounds(482, 23, 93, 41);
		contentPane.add(btnRedo);
		btnRedo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                redo.redo();

            }
        });
		
		String arr[]= {"C#","Java","C++"};
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setBounds(36, 31, 176, 33);
		contentPane.add(comboBox);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnApply.setBackground(Color.LIGHT_GRAY);
		btnApply.setBounds(482, 74, 93, 41);
		contentPane.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Java")) {
                    scr.javaSyntax(textArea);
                }

                else if (comboBox.getSelectedItem().equals("C#")) {
                    scr.csSyntax(textArea);
                }


                else if (comboBox.getSelectedItem().equals("C++")) {
                    scr.cppSyntax(textArea);
                }
            }
        });
		
		
		JButton btnRun = new JButton("Run");
		btnRun.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnRun.setBackground(Color.LIGHT_GRAY);
		btnRun.setBounds(605, 23, 93, 41);
		contentPane.add(btnRun);
		btnRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Java")) {
                    String extention = ".java";
                    rac.runner(textField.getText(), extention);
                }

                else if (comboBox.getSelectedItem().equals("C#")) {
                    String extention = ".cs";
                    rac.runner(textField.getText(), extention);

                }

                else if (comboBox.getSelectedItem().equals("C++")) {
                    String extention = ".cpp";
                    rac.runner(textField.getText(), extention);
                }
            }
        });
		
		JButton btnCompile = new JButton("Compile");
		btnCompile.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCompile.setBackground(Color.LIGHT_GRAY);
		btnCompile.setBounds(605, 74, 93, 41);
		contentPane.add(btnCompile);
		btnCompile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Java")) {
                    String extention = ".java";
                    rac.file_create(textField.getText(),textArea.getText(),extention);
                    rac.compiler(textField.getText(), extention);
                }

                else if (comboBox.getSelectedItem().equals("C#")) {
                    String extention = ".cs";
                    rac.file_create(textField.getText(),textArea.getText(),extention);
                    rac.compiler(textField.getText(), extention);
                    String codeExtentionString = ".exe";
                }

                else if (comboBox.getSelectedItem().equals("C++")) {
                    String extention = ".cpp";
                    rac.file_create(textField.getText(),textArea.getText(),extention);
                   rac.compiler(textField.getText(), extention);
                    String codeExtentionString = ".exe";
                }
            }
        });
		textField = new JTextField("HelloWorld");
        textField.setBounds(430, 319, 174, 31);
        contentPane.add(textField);
        textField.setColumns(10);
	}
}
