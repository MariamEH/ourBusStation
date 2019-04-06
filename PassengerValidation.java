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
public class PassengerValidation implements UserValidation{

    HashMap userDirectory;
    
    public PassengerValidation(){
       userDirectory = new HashMap();
       userDirectory.put("Ali","1234");
       userDirectory.put("Sami","2345");
       userDirectory.put("Ahmed","3456");
       userDirectory.put("Amira","4567");
    }
            
    @Override
    public boolean validation(String username , String password) {
        boolean validationResult=false;
        String fetchedPassword = (String) userDirectory.get(username);
        if(fetchedPassword!=null){
          validationResult= fetchedPassword.equals(password);
        }
        return validationResult;
    }
    
}
