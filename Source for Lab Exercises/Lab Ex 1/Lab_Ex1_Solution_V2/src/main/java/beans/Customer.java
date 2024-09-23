package beans;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String eu;
    private String comments;
    private String[] hearOptions;






    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.country = "";
        this.phone = "";
        this.email = "";
        this.eu = "";
        this.comments = "";

    }


     /**
     * @return the hearOptions as text separated by a space
     */
    public String getHearOptionsAsString() {
        
        String options = "";

         if (hearOptions == null || hearOptions.length == 0  )
           options = "You did not select any options";
         else {
             //iterating over options in array
            for (int i =0; i < hearOptions.length; i++) 
                options += hearOptions[i] + " ";
         }//end else
         
         return options;
             
    }
    
    
    
    
}
