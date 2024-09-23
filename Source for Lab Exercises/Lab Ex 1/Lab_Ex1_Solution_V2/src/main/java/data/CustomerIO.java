
package data;

import beans.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Alan.Ryan
 */
public class CustomerIO {
    
    public static void add(Customer c, String filepath) throws IOException {

        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.println(c.getName() + "|" + c.getAddress() + "|" + c.getCity() + "|" +c.getCountry() + "|" + c.getPhone() + "|" + c.getComments());
        out.close();
        
    }
    
}
