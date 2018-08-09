package com.automation.utility;

import static com.automation.utility.YamlReader.getYamlValue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static com.automation.utility.YamlReader.setYamlFilePath;


public class DataBase {

	static Connection dbConnection = null;
	public String host = getYamlValue("host");
	public String username = getYamlValue("user");
	public String password = getYamlValue("pass");
	public String database = getYamlValue("database");
	public String port = getYamlValue("port");
	public static String jdbcDriver = "com.mysql.jdbc.Driver";

	public void init() throws IOException {
		setYamlFilePath();
		makeConnection(jdbcDriver, host, username, password);
	}

	public DataBase() throws IOException {
		init();
	}

	public void makeConnection(String jdbcDriver, String db_url, String username, String password) {

		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {

			dbConnection = DriverManager.getConnection(db_url, username, password);
			System.out.println("connection established");
		} catch (SQLException e) {
			System.out.println("in catch ?");
			System.out.println(e.getMessage());
		}

	}

	public void executeUpdateQuery(String query) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		stmt.executeUpdate(query);
		dbConnection.close();
	}

	public ResultSet executeQuery(String query) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

		return rs;
	}

	public void closeDbConnection() throws SQLException {
		dbConnection.close();
	}

	@SuppressWarnings("unused")
	private List<HashMap<String, String>> readRows(ResultSet rs) throws SQLException {
		List<HashMap<String, String>> result = new ArrayList<>();
		while (rs.next()) {
			HashMap<String, String> row = new HashMap<>();
			for (int j = 1; j < rs.getMetaData().getColumnCount() + 1; j++) {
				row.put(rs.getMetaData().getColumnName(j), rs.getString(j));
			}
			result.add(row);
		}
		return result;
	}
}
