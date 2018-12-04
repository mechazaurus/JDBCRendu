import java.sql.SQLException;

public class Main {
	
    public static void main(String [] args) {
    	
        try {
            BDD bdd = new BDD();
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
