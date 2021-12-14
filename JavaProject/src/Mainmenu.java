import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Mainmenu() {
		setTitle("메인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("\uB85C\uADF8\uC544\uC6C3");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuLogout = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		menuLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//로그아웃
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		mnNewMenu_3.add(menuLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB3C4\uC11C\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookList frame = new bookList();		//도서검색
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(115, 26, 200, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3C5\uD6C4\uAC10 \uC791\uC131");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookReport frame = new BookReport();		//독후감 작성
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(115, 79, 200, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB098\uC758 \uB3C5\uD6C4\uAC10");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyReport frame = new MyReport();		//나의 독후감
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(115, 132, 200, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("\uAC74\uC758\uD558\uAE30");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suggestion frame = new Suggestion();		//건의하기
				frame.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(115, 185, 200, 27);
		contentPane.add(btnNewButton_2_1);
	}
}
