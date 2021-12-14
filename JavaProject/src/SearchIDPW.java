import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchIDPW extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtMail;
	static private JTextField txtID;
	static private JTextField txtpID;
	static private JTextField txtPW;
	
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SearchIDPW() {
		setTitle("아이디/비밀번호 찾기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uC77C\uC8FC\uC18C");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 71, 61, 15);
		contentPane.add(lblNewLabel);
		
		txtMail = new JTextField();
		txtMail.setBounds(123, 68, 175, 21);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JButton btnIDSearch = new JButton("\uCC3E\uAE30");
		btnIDSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("select", "select * from member where eMail = '" + txtMail.getText() + "'");
				} catch (Exception ae) {
					System.out.println(ae.getMessage());
				}

				try {
					viewData();
				} catch (Exception ae) {
					System.out.println(ae.getMessage());
				}
				
				dbDis();
			}
		});
		btnIDSearch.setBounds(310, 67, 61, 23);
		contentPane.add(btnIDSearch);
		
		txtID = new JTextField();
		txtID.setBounds(110, 133, 124, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514\uB294");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(176, 108, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC785\uB2C8\uB2E4.");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(246, 136, 52, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(50, 263, 61, 15);
		contentPane.add(lblNewLabel_3);
		
		txtpID = new JTextField();
		txtpID.setColumns(10);
		txtpID.setBounds(123, 260, 175, 21);
		contentPane.add(txtpID);
		
		JButton btnPWSearch = new JButton("\uCC3E\uAE30");
		btnPWSearch.addActionListener(new ActionListener() {		//찾기버튼
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("select", "select * from member where ID = '" + txtpID.getText() + "'");
				} catch (Exception ae) {
					System.out.println(ae.getMessage());
				}

				try {
					viewData2();
				} catch (Exception ae) {
					System.out.println(ae.getMessage());
				}
				
				dbDis();
			}
		});
		btnPWSearch.setBounds(310, 259, 61, 23);
		contentPane.add(btnPWSearch);
		
		txtPW = new JTextField();
		txtPW.setColumns(10);
		txtPW.setBounds(110, 324, 124, 21);
		contentPane.add(txtPW);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638\uB294");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(176, 299, 70, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uC785\uB2C8\uB2E4.");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(246, 327, 52, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(166, 221, 100, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnCancel = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(176, 365, 95, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_5 = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(165, 33, 81, 15);
		contentPane.add(lblNewLabel_5);
	}
	
	public static void dbConnect() {
    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:prjLibrary";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/prjLibrary";
        String sql = "Select * From member";
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("데이터베이스 연결 성공!");            
         
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        }
	}
	
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		} 
		else {
			stmt.executeUpdate(sql);
		}
	}
	
	public static void dbDis(){
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			System.out.println("데이터베이스 연결 해제!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void viewData() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
		}
		else{		
				System.out.println("rs.next()");
				txtID.setText(String.valueOf(rs.getString("ID")));
		}
	}
	
	public static void viewData2() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
		}
		else{		
				System.out.println("rs.next()");
				txtPW.setText(rs.getString("PW"));
		}
	}
}
