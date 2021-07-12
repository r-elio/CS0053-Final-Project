import java.sql.*;

public class AccessDB {
	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName = "gameDB";
		String connectionURL = "jdbc:derby:" + dbName + ";create=true";

		Connection conn = null;
		String createTable = "CREATE TABLE GAME "
        + "(ID VARCHAR(10) NOT NULL CONSTRAINT STUDENT_PK PRIMARY KEY,"
        + " NAME VARCHAR(20) NOT NULL,"
        + " DIFFICULTY VARCHAR(20),"
        + " TIME TIME NOT NULL,"
        + " ISDONE BOOLEAN NOT NULL)";

		try {
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("CONNECTED TO DATABASE: " + dbName);

			Statement stment = conn.createStatement();

			if (!(isGameTableExist(conn))){
				System.out.println("CREATING GAME TABLE...");
				stment.execute(createTable);
			}

			stment.close();
			conn.close();
			System.out.println("CLOSED CONNECTION");

			if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")){
                boolean isShutdown = false;
                try {
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");
                }
                catch (SQLException e){
                    if (e.getSQLState().equals("XJ015")){
                        isShutdown = true;
                    }
                }
                if (!(isShutdown)){
                    System.out.println("DATABASE DID NOT SHUTDOWN NORMALLY");
                }
                else {
                    System.out.println("DATABASE SHUTDOWN NORMALLY");
                }
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isGameTableExist(Connection conn) throws SQLException {
		try {
			Statement stment = conn.createStatement();
			stment.execute("SELECT * FROM GAME");
            stment.close();

		} catch (SQLException e){
            String sqlExption = e.getSQLState();
            if (sqlExption.equals("42X05")){
                return false;
            }
            else if (sqlExption.equals("42X14") || sqlExption.equals("42821")){
                System.out.println("SQLException:\nIncorrect Table Definition.");
                throw e;
            }
            else {
                e.printStackTrace();
                System.out.println("Unhandled SQLException:\n" + e.getMessage());
                throw e;
            }
        }

		return true;
	}
}
