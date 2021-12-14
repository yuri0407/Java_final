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

public class MyReport extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtBName;
	static private JTextField txtReport;
	
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
	public MyReport() {
		setTitle("나의 독후감 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85 \uC785\uB825");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(84, 56, 81, 19);
		contentPane.add(lblNewLabel);
		
		txtBName = new JTextField();
		txtBName.setBounds(177, 55, 156, 21);
		contentPane.add(txtBName);
		txtBName.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");		//검색버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("select", "select * from bookreport where bName = '" + txtBName.getText() + "'");
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
		
		btnSearch.setBounds(334, 54, 64, 23);
		contentPane.add(btnSearch);
		
		txtReport = new JTextField();
		txtReport.setBounds(84, 84, 314, 159);
		contentPane.add(txtReport);
		txtReport.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainmenu frame = new Mainmenu();		//메인으로
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(84, 253, 95, 23);
		contentPane.add(btnNewButton_1);
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

	public static void viewData() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
		}
		else{		
				System.out.println("rs.next()");
	
				txtReport.setText(rs.getString("report"));
		}
	}
}
