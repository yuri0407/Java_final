import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suggestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtSug;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Suggestion() {
		setTitle("건의");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC74\uC758\uB0B4\uC6A9");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(65, 44, 61, 15);
		contentPane.add(lblNewLabel);
		
		txtSug = new JTextField();
		txtSug.setBounds(65, 67, 298, 135);
		contentPane.add(txtSug);
		txtSug.setColumns(10);
		
		JButton btnNext = new JButton("\uAC74\uC758\uD558\uAE30");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SugSuccess frame = new SugSuccess();		//건의하기
				frame.setVisible(true);
			}
		});
		btnNext.setBounds(273, 212, 90, 23);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainmenu frame = new Mainmenu();		//돌아가기
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(180, 212, 90, 23);
		contentPane.add(btnCancel);
	}

}
