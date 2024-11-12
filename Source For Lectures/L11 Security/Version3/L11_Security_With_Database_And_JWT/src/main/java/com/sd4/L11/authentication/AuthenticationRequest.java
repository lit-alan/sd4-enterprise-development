package com.sd4.L11.authentication;

import lombok.Data;

/*  When a user tries to authenticate, they submit their username and password
    in a request body, which are then mapped to an object of this class.
 */
@Data
public class AuthenticationRequest {
    private String username;
    private String password;


}
