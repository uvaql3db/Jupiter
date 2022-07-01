package db;

import db.mongodb.MongoDBConnection;
import db.mysql.MySQLConnection;

public class DBConnectionFactory {
	//this should change based on pipeline
	private static final String DEFAULT_DB = "mysql";
//	private static final String DEFAULT_DB = "mongodb";
	
	public static DBConnection getConnection(String db) {
		switch(db) { //handle different cases
			case "mysql":
				//return new mysqlconnection()
				return new MySQLConnection();
			case "mongodb":
				return new MongoDBConnection();
			default:
				throw new IllegalArgumentException("Invalid db:" + db);
		}
	}
	
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
	}
	
}
