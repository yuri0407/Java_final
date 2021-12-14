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

public class MemJoin extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtName;
	static private JTextField txtID;
	static private JTextField txtPW;
	static private JTextField txtMail;
	
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
	public MemJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(174, 30, 80, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 156, 52, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(67, 215, 61, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uBA54\uC77C\uC8FC\uC18C");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(67, 275, 61, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC774\uB984");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(67, 97, 52, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();		//돌아가기
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(91, 333, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnJoin = new JButton("\uAC00\uC785\uD558\uAE30");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//가입버튼
				dbConnect();
				try {
					query("insert", "insert into member values('"+txtName.getText()+"','"+txtID.getText()+"','"+txtPW.getText()+"','"+txtMail.getText()+"')");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				System.out.println("새항목 추가완료");
				dbDis();
				
				JoinSuccess frame = new JoinSuccess();		//가입하기
				frame.setVisible(true);
			}
		});
		btnJoin.setBounds(242, 333, 95, 23);
		contentPane.add(btnJoin);
		
		txtName = new JTextField();
		txtName.setBounds(151, 94, 186, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(151, 153, 186, 21);
		contentPane.add(txtID);
		
		txtPW = new JTextField();
		txtPW.setColumns(10);
		txtPW.setBounds(151, 212, 186, 21);
		contentPane.add(txtPW);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(151, 272, 186, 21);
		contentPane.add(txtMail);
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
}
