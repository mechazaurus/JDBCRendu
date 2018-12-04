import java.sql.SQLException;

public class main
{
    public static void main(String [] args)
    {
        try
        {
            BDD bdd = new BDD();

        }
        catch (SQLException sql)
        {
            System.out.println(sql);
        }

    }
}
