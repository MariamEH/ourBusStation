/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyGUI;

import java.util.HashMap;

/**
 *
 * @author hassi
 */
public class DriverValidation implements UserValidation {

    HashMap userDirectory;
    
    public DriverValidation(){
       userDirectory = new HashMap();
       userDirectory.put("Mona","1234");
       userDirectory.put("yasser","2345");
       userDirectory.put("Ahmed","3456");
       userDirectory.put("Mira","4567");
    }
    @Override
    public boolean validation(String username, String password) {
        
        String fetchedPassword = (String)userDirectory.get(username);
        return fetchedPassword!=null&&fetchedPassword.equals(password);
    }
    
}
