import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface GameDB {
	public static final String DATABASE_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DATABASE_NAME = "gameDB";
	public static final String DATABASE_CONNECTION_URL = "jdbc:derby:" + DATABASE_NAME + ";create=true";
	public static final String CREATE_GAME_TABLE = "CREATE TABLE GAME "
    + "(ID INT GENERATED ALWAYS AS IDENTITY NOT NULL CONSTRAINT ID_PK PRIMARY KEY,"
    + " NAME VARCHAR(20) NOT NULL,"
    + " DIFFICULTY VARCHAR(20) NOT NULL,"
    + " TIME TIME NOT NULL,"
    + " ISDONE BOOLEAN NOT NULL)";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(DATABASE_CONNECTION_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public static boolean isGameTableExist(Connection conn) throws SQLException {
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
