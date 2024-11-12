package com.sd4.L11.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    /**
     * Fetches profile information for a given username. Access is allowed only if the
     * requested profile belongs to the currently authenticated user.
     *
     * @param username The username of the profile to fetch.
     * @param authentication Automatically injected Authentication object to access the current user's details.
     * @return A simulated profile object.
     */
    @PostAuthorize("returnObject.username == authentication.name")
    //@PostAuthorize is used to enforce authorisation after the method has executed but before the result is returned
    //returnObject.username == authentication.name checks that the username in the path variable matches the authenticated 
    //user's username. This kind of check is useful for operations where users should only be allowed to modify their data.
    @GetMapping("/{username}")
    public UserProfile fetchUserProfile(@PathVariable String username, Authentication authentication) {
        // Simulate fetching the user profile. In a real application, this would query the database.
        UserProfile profile = new UserProfile(username, "User's bio here", "firstname.lastname@tus.ie");

        return profile;

        //if the expression #username == authentication.name evaluates to false Spring Security will throw an AccessDeniedException
        //and the method itself is not executed at all, so there is no return value from the method to consider.
    }

    /**
     * Creates a new user profile. This method is restricted to users with the MANAGER role.
     * @param profile A simplified representation of the UserProfile object to be created.
     * @return The created UserProfile object.
     */
    @PreAuthorize("hasRole('MANAGER')") // @PreAuthorize is used to check authorisation before entering the method.
    @PostMapping("/")
    public UserProfile createProfile(@RequestBody UserProfile profile) {
        // In a real application, insert the profile into the database.
        // For this example, we'll just simulate the creation and return the same profile.
        return profile;
    }

     // Inner class to represent a user profile. In a real application, this would be modelled as an Entity class.
    static class UserProfile {
        private String username;
        private String bio;
        private String email;

        public UserProfile(String username, String bio, String email) {
            this.username = username;
            this.bio = bio;
            this.email = email;
        }
        // Getters here and setters go here

    }

    /**
     * Updates the bio of a user profile. Before allowing the update, it checks if the
     * user is attempting to update their own profile.
     *
     * @param username The username of the profile to update.
     * @param bio The new bio to be set.
     * @param authentication Automatically injected Authentication object.
     * @return The updated UserProfile.
     */
    @PreAuthorize("#username == authentication.name")
    @PutMapping("/{username}/bio")
    public UserProfile updateBio(@PathVariable String username, @RequestBody String bio, Authentication authentication) {
        // Simulate fetching and updating the user profile. In a real application, this would involve database operations.
        return new UserProfile(username, bio, "updated-user@tus.ie");
    }

   
}


