package atm;
import java.sql.* ;
public class Conn {

    Connection c ;
    Statement s ;

    public Conn(){

        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem" , "root" , "shashwatvishal100") ;
            s = c.createStatement() ;
        }
        catch (Exception e){
            e.printStackTrace() ;
        }
    }
}
