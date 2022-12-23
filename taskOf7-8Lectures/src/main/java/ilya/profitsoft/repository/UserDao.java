package ilya.profitsoft.repository;

import java.util.Map;
import java.util.Set;


/**
 * This class is only a simulation of DAO
 * to get access to the users in fake DB
 *
 * @author ilyaPanteleychuk
 * */
public class UserDao {
    
    private static final Map<String, String> users =
            Map.of("Ilya", "Ilya", "Vika", "Vika");
    
    public static Map<String, String> getUsersCredentials(){
        return users;
    }
    
    public static Set<String> getUsersLogins(){
        return users.keySet();
    }
}
