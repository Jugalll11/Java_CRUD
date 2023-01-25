package myDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;

public class dbFrame extends JFrame {

	private JPanel contentPane;
	private JTextField insert_name;
	private JTextField insert_age;
	private JTextField insert_dept;
	private JLabel InsAge;
	private JLabel InsDept;
	private JTextField update_id;
	private JLabel UpdID;
	private JTextField update_name;
	private JTextField update_age;
	private JTextField update_dept;
	private JTextArea ResultText;
	private JTextField delID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (Exception e5) {

		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					dbFrame frame = new dbFrame();
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
	public dbFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton Insertbtn = new JButton("Insert");

		Insertbtn.setBounds(79, 25, 102, 38);
		contentPane.add(Insertbtn);

		JButton Updatebtn = new JButton("Update");

		Updatebtn.setBounds(701, 25, 110, 38);
		contentPane.add(Updatebtn);

		JButton RefreshBtn = new JButton("View Database");

		RefreshBtn.setBounds(368, 466, 140, 27);
		contentPane.add(RefreshBtn);

		insert_name = new JTextField();
		insert_name.setBounds(115, 95, 152, 27);
		contentPane.add(insert_name);
		insert_name.setColumns(10);

		insert_age = new JTextField();
		insert_age.setColumns(10);
		insert_age.setBounds(115, 146, 152, 27);
		contentPane.add(insert_age);

		insert_dept = new JTextField();
		insert_dept.setColumns(10);
		insert_dept.setBounds(115, 198, 152, 27);
		contentPane.add(insert_dept);

		JLabel insName = new JLabel("Name");
		insName.setBounds(46, 102, 45, 13);
		contentPane.add(insName);

		InsAge = new JLabel("Age");
		InsAge.setBounds(46, 153, 45, 13);
		contentPane.add(InsAge);

		InsDept = new JLabel("Department");
		InsDept.setBounds(46, 205, 63, 13);
		contentPane.add(InsDept);

		update_id = new JTextField();
		update_id.setColumns(10);
		update_id.setBounds(686, 95, 152, 27);
		contentPane.add(update_id);

		UpdID = new JLabel("ID");
		UpdID.setBounds(612, 102, 45, 13);
		contentPane.add(UpdID);

		JLabel UpdName = new JLabel("Name");
		UpdName.setBounds(612, 153, 45, 13);
		contentPane.add(UpdName);

		update_name = new JTextField();
		update_name.setColumns(10);
		update_name.setBounds(689, 150, 152, 27);
		contentPane.add(update_name);

		update_age = new JTextField();
		update_age.setColumns(10);
		update_age.setBounds(689, 202, 152, 27);
		contentPane.add(update_age);

		update_dept = new JTextField();
		update_dept.setColumns(10);
		update_dept.setBounds(686, 251, 152, 27);
		contentPane.add(update_dept);

		JLabel UpdAge = new JLabel("Age");
		UpdAge.setBounds(612, 205, 45, 13);
		contentPane.add(UpdAge);

		JLabel UpdDept = new JLabel("Department");
		UpdDept.setBounds(612, 258, 64, 13);
		contentPane.add(UpdDept);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 304, 582, 133);
		contentPane.add(scrollPane);

		ResultText = new JTextArea();
		scrollPane.setViewportView(ResultText);

		JButton delBtn = new JButton("Delete");
		delBtn.setBounds(379, 25, 102, 38);
		contentPane.add(delBtn);

		JLabel UpdID_1 = new JLabel("ID");
		UpdID_1.setBounds(337, 102, 45, 13);
		contentPane.add(UpdID_1);

		delID = new JTextField();
		delID.setColumns(10);
		delID.setBounds(367, 95, 152, 27);
		contentPane.add(delID);

		RefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // Enter Your Database Driver
					Connection con = DriverManager.getConnection(
							"jdbc:ucanaccess://C://Eclipse//Eclipse Workspace//myDatabase//res//myTable.accdb"); // Enter
																													// Your
																													// Database
					Statement sat = con.createStatement();
					String result = "";
					String p = "SELECT * FROM Table2";
					sat.execute(p);
					ResultSet rs = sat.getResultSet();
					while (rs.next()) {
						result = result + "ID: " + rs.getString(1) + "\n" + "Name: " + rs.getString(2) + "\n" + "AGE: "
								+ rs.getInt(3) + "\n" + "Dept: " + rs.getString(4) + "\n" + "\n" + "\n";
					}

					ResultText.setText(result);
					con.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});

		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Inside");
				String name;
				String Dept;

				int age;

				name = insert_name.getText();

				age = Integer.parseInt(insert_age.getText());

				Dept = insert_dept.getText();

				insert_name.setText("");
				insert_age.setText("");
				insert_dept.setText("");

				try {

					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Enter Your Database Driver
					Connection con = DriverManager.getConnection(
							"jdbc:ucanaccess://C://Eclipse//Eclipse Workspace//myDatabase//res//myTable.accdb");//Enter Your Database with location
					PreparedStatement ps = con.prepareStatement("INSERT INTO Table2 values(?,?,?,?)");
					System.out.println("Query running");
					ps.setString(1, "2");
					ps.setString(2, name);
					ps.setInt(3, age);
					ps.setString(4, Dept);
					int i = ps.executeUpdate();
					System.out.println("Inserted " + i + " Records");
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				RefreshBtn.doClick();
			}
		});

		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name;
				String Dept;
				int age;
				String id;

				id = update_id.getText();

				name = update_name.getText();

				age = Integer.parseInt(update_age.getText());

				Dept = update_dept.getText();

				update_id.setText("");
				update_name.setText("");
				update_age.setText("");
				update_dept.setText("");

				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Enter Your Database Driver
					Connection con = DriverManager.getConnection(
							"jdbc:ucanaccess://C://Eclipse//Eclipse Workspace//myDatabase//res//myTable.accdb");// Enter
																												// Your
																												// Database
																												// with
																												// location
					PreparedStatement ps = con.prepareStatement("UPDATE Table2 SET Name=?, Age=?, Dept=? where ID=?");
					ps.setString(4, id);
					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3, Dept);
					int i = ps.executeUpdate();

					System.out.println("Updated" + i + " Rows");
					con.close();

				} catch (Exception e3) {
					System.out.print(e3);
				}
				RefreshBtn.doClick();

			}
		});

		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = delID.getText();
				delID.setText(id);

				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Enter Your Database Driver
					Connection con = DriverManager.getConnection(
							"jdbc:ucanaccess://C://Eclipse//Eclipse Workspace//myDatabase//res//myTable.accdb");// Enter
																												// Your
																												// Database
																												// with
																												// location
					PreparedStatement ps = con.prepareStatement("DELETE FROM Table2 where ID=?");
					ps.setString(1, id);
					int i = ps.executeUpdate();
					System.out.println("Deleted " + i + " Entry");

				} catch (Exception e4) {
					System.out.println(e);
				}
				RefreshBtn.doClick();
			}
		});
	}
}
