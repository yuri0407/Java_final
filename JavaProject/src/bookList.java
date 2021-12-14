import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class bookList extends JFrame {

	static private JPanel contentPane;
	static private JTextField txtBNo;
	static private JTextField txtBName;
	static private JTextField txtWriter;
	static private JTextField txtPub;
	static private JTextField txtPDate;
	static private JTextField txtPCountry;
	static private JTextField txtBook;
	
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
	public bookList() {
		setTitle("도서검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 306);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uB3C4\uC11C");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuSearch = new JMenuItem("\uB3C4\uC11C\uAC80\uC0C9");
		mnNewMenu.add(menuSearch);
		
		JMenuItem menuReport = new JMenuItem("\uB3C5\uD6C4\uAC10 \uC791\uC131");
		menuReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BookReport frame = new BookReport();		//독후감작성
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(menuReport);
		
		JMenu mnNewMenu_1 = new JMenu("\uAC74\uC758");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuSug = new JMenuItem("\uAC74\uC758\uD558\uAE30");
		menuSug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Suggestion frame = new Suggestion();		//건의하기
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(menuSug);
		
		JMenu mnNewMenu_2 = new JMenu("\uB85C\uADF8\uC544\uC6C3");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuLogout = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		menuLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();		//로그아웃
				frame.setVisible(true);
			}
		});
		mnNewMenu_2.add(menuLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainmenu frame = new Mainmenu();		//메인으로
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(401, 203, 88, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 75, 72, 21);
		contentPane.add(lblNewLabel_1);
		
		txtBNo = new JTextField();
		txtBNo.setBounds(111, 75, 126, 21);
		contentPane.add(txtBNo);
		txtBNo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(27, 116, 72, 21);
		contentPane.add(lblNewLabel_1_1);
		
		txtBName = new JTextField();
		txtBName.setColumns(10);
		txtBName.setBounds(111, 116, 126, 21);
		contentPane.add(txtBName);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC800\uC790\uBA85");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(27, 160, 72, 21);
		contentPane.add(lblNewLabel_1_2);
		
		txtWriter = new JTextField();
		txtWriter.setColumns(10);
		txtWriter.setBounds(111, 160, 126, 21);
		contentPane.add(txtWriter);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(279, 75, 72, 21);
		contentPane.add(lblNewLabel_1_3);
		
		txtPub = new JTextField();
		txtPub.setColumns(10);
		txtPub.setBounds(363, 75, 126, 21);
		contentPane.add(txtPub);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uCD9C\uD310\uC77C");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(279, 116, 72, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtPDate = new JTextField();
		txtPDate.setColumns(10);
		txtPDate.setBounds(363, 116, 126, 21);
		contentPane.add(txtPDate);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\uCD9C\uD310\uAD6D");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(279, 160, 72, 21);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtPCountry = new JTextField();
		txtPCountry.setColumns(10);
		txtPCountry.setBounds(363, 160, 126, 21);
		contentPane.add(txtPCountry);
		
		JLabel lblNewLabel_3 = new JLabel("\uB3C4\uC11C \uAC80\uC0C9");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(27, 31, 78, 21);
		contentPane.add(lblNewLabel_3);
		
		txtBook = new JTextField();
		txtBook.setBounds(117, 31, 185, 21);
		contentPane.add(txtBook);
		txtBook.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\uAC80\uC0C9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnect();
				try {
					query("select", "select * from book where bName = '" + txtBook.getText() + "'");
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
		btnNewButton_2.setBounds(303, 30, 62, 23);
		contentPane.add(btnNewButton_2);
		
		
		
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
        String sql = "Select * From book";
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
				txtBNo.setText(String.valueOf(rs.getString("bNo")));
				
				txtBName.setText(rs.getString("bName"));
				
				txtWriter.setText(rs.getString("writer"));
				
				txtPub.setText(rs.getString("publisher"));
				
				txtPDate.setText(rs.getString("pDate"));
				
				txtPCountry.setText(rs.getString("pCountry"));
		}
	}
}
