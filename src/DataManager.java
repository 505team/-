

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DataManager {
	JFrame mainFrame = new JFrame("查看数据");
	private JScrollPane scrollPane;
	private ResultSetTableModel model;
	private JComboBox tableNames = new JComboBox();
	private JTextArea changeMsg = new JTextArea(4, 60);
	private ResultSet rs;
	private Connection conn;
	private Statement stmt;
	
	public DataManager() {
		init();
	}

	private void init() {
		tableNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					if (scrollPane != null) {
						mainFrame.remove(scrollPane);
					}
					String tableName = (String) tableNames.getSelectedItem();
					if (rs != null) {
						rs.close();
					}
					String query = "select * from " + tableName;
					rs = stmt.executeQuery(query);
					model = new ResultSetTableModel(rs);
					model.addTableModelListener(new TableModelListener() {
						public void tableChanged(TableModelEvent evt) {
							int row = evt.getFirstRow();
							int column = evt.getColumn();
							changeMsg.append(
									"修改的列:" + column + " ，修改的行:" + row + " ，修改后的值:" + model.getValueAt(row, column));
						}
					});
					JTable table = new JTable(model);
					scrollPane = new JScrollPane(table);
					mainFrame.add(scrollPane, BorderLayout.CENTER);
					mainFrame.validate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		JPanel p = new JPanel();
		p.add(tableNames);
		mainFrame.add(p, BorderLayout.NORTH);
		mainFrame.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);
		try {
			conn = getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (tables.next()) {
				tableNames.addItem(tables.getString(3));
			}
			tables.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("conn.ini");
		System.out.println(props);
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		System.out.println(drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		Class.forName(drivers);
		return DriverManager.getConnection(url, username, password);
	}
	
	public void showFrame() {
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new DataManager().showFrame();
	}
}

class ResultSetTableModel extends AbstractTableModel {
	private ResultSet rs;
	private ResultSetMetaData rsmd;

	public ResultSetTableModel(ResultSet aResultSet) {
		rs = aResultSet;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getColumnName(int c) {
		try {
			return rsmd.getColumnName(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Object getValueAt(int r, int c) {
		try {
			rs.absolute(r + 1);
			return rs.getObject(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getRowCount() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void setValueAt(Object aValue, int row, int column) {
		try {
			rs.absolute(row + 1);
			rs.updateObject(column + 1, aValue);
			rs.updateRow();
			fireTableCellUpdated(row, column);
		} catch (SQLException evt) {
			evt.printStackTrace();
		}
	}
}
