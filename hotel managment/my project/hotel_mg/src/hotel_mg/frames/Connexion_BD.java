
package hotel_mg.frames;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion_BD {
    Connection conn=null;
    
    public static Connection connect_BD(){
        
        try{
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mg_hotel?serverTimezone=UTC","root","password");
                if(conn!=null){
            System.out.println("connection done !");return conn;
                }
        }catch(Exception e){
            System.out.print("there is an exception:"+e);
                    
        }
        return null;
    }
}
