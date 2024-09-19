package src.java.data;


import src.java.business.User;

import java.io.*;


public class UserIO {
    
    public static void add(User user, String filepath) throws IOException {

        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.println(user.getEmailAddress() + "|" + user.getFirstName() + "|" + user.getLastName());
        out.close();
        
    }


}

