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

public class BookReport extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtReport;
	static private JTextField txtBName;
	
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
	public BookReport() {
		setTitle("독후감 쓰기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(67, 42, 52, 15);
		contentPane.add(lblNewLabel);
		
		txtReport = new JTextField();
		txtReport.setBounds(67, 70, 292, 136);
		contentPane.add(txtReport);
		txtReport.setColumns(10);
		
		txtBName = new JTextField();
		txtBName.setBounds(131, 39, 228, 21);
		contentPane.add(txtBName);
		txtBName.setColumns(10);
		
		JButton btnCancel = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainmenu frame = new Mainmenu();		//돌아가기
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(67, 216, 118, 23);
		contentPane.add(btnCancel);
		
		JButton btnSave = new JButton("\uC800\uC7A5\uD558\uAE30");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("insert", "insert into bookreport values('"+txtBName.getText()+"','"+txtReport.getText()+"')");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				System.out.println("새항목 추가완료");
				dbDis();

				txtBName.setText("");
				txtReport.setText("");
				
				SaveSuccess frame = new SaveSuccess();		//저장하기
				frame.setVisible(true);
			}
		});
		btnSave.setBounds(241, 216, 118, 23);
		contentPane.add(btnSave);
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
        String sql = "Select * From bookreport";
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

//	public static void viewData() throws SQLException {
//		if(!rs.next()){
//			System.out.println("!rs.next()");
//		}
//		else{		
//				System.out.println("rs.next()");
//				txt.setText(String.valueOf(rs.getString("sname")));
//	
//				txtPName.setText(rs.getString("pname"));
//					
//				txtSubjectName.setText(rs.getString("subjectName"));
//		}
//	}

}
