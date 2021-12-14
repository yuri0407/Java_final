import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SaveSuccess() {
		setTitle("저장 완료");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC800\uC7A5\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(142, 109, 147, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C5\uD6C4\uAC10\uC774");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(175, 77, 80, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCheck = new JButton("\uD655\uC778\uD558\uAE30");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyReport frame = new MyReport();		//확인하기
				frame.setVisible(true);
			}
		});
		btnCheck.setBounds(220, 150, 95, 23);
		contentPane.add(btnCheck);
		
		JButton btnMain = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainmenu frame = new Mainmenu();		//메인으로
				frame.setVisible(true);
			}
		});
		btnMain.setBounds(110, 150, 95, 23);
		contentPane.add(btnMain);
	}

}
