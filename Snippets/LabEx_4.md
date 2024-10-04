## Lab Exercise Four. Week :four:

### Amend the 'displayAllCustomers' Feature from Lab Ex 3.

Add an _Actions_ column to the table displaying all customers. Each customer should have both a delete and an update link. For example:

![image](https://github.com/user-attachments/assets/27b5d9b3-2f4c-4cb0-a2ef-a59b6233cd0b)
<br><br>
### Delete a Customer
When the delete link is clicked for a specific customer, the corresponding customer record should be removed from the database. After a successful deletion, the user must be redirected to /customers, where a flash attribute will convey a message indicating the deletion was successful.

The delete link will generate a GET request, which you must handle in your `CustomerController`. Consider creating a method in the controller with the following signature:

```java
/**
 * Deletes a customer from the database based on the provided customer ID.
 *
 * @param id The unique identifier of the customer to be deleted.
 * @param redirectAttributes Used to add attributes to the redirect response,
 *                           including flash attributes for success messages.
 * @return A String representing the name of the view to redirect to after deletion.
 */
public String deleteCustomer(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Your implementation goes here
}

```

In the `Customer` class will need to set the Cascade type to All above the List of Reviews. For Example:


```java
@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
@ToString.Exclude
private List<Review> reviewList;

```
_Without setting the Cascade type, you will not be permitted to delete customers who have left a review(s) and the application will likely crash. This issue is due to a foreign key constraint in the `reviews` table that references the `customers` table. This means you cannot delete a customer if they have associated reviews because the reviews depend on the existence of that customer._
<br><br>
  
Once you have the delete feature fully working, consider using a Javascript alert to ask the user the confirm their intention to delete a record. For example:  

![image](https://github.com/user-attachments/assets/16a24a41-751a-498b-9000-e6a91fef3a38)


<br><br>
### Update a Customer
When the update link for a specific customer is clicked, the end user will be redirected to a form that allows them to edit the customer's details. The details of the selected customer will be pre-populated in the form fields. After a successful edit, the user will be redirected to `/customers`, where a flash attribute will convey a message indicating that the update was successful. For example: <br>.

![image](https://github.com/user-attachments/assets/6bdd659d-697a-4764-9cde-fcd1f91a0229)

![image](https://github.com/user-attachments/assets/34f296cf-daa1-4c2a-a17c-97c49cb7f6bf)
<br><br>

Firstly, create a method in your `CustomerController` to handle displaying the update form. Use the following method signature:

```java
/**
 * Displays the update form for a specific customer identified by the given ID.
 * If the customer is found, their details are pre-populated in the form. 
 * Otherwise, the user is redirected to the customer list with an error message.
 *
 * @param id The unique identifier of the customer to be updated.
 * @param model The Model object used to pass customer details to the view.
 * @return The name of the Thymeleaf template to render 
 *         if the customer is found (the update form), or a redirect to the customer list if not.
 */
@GetMapping("/update/{id}")
public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    // Your implementation goes here
}

```

Once the form is submitted, the changes should be saved to the database. You need to create another controller method to handle the form submission.


```java
/**
 * Processes the submission of the customer update form.
 * This method updates the customer details in the database 
 * based on the provided Customer object. After a successful update, 
 * the user is redirected to the customer list with a success message.
 *
 * @param customer The Customer object containing the updated details 
 *                 of the customer, populated from the form submission.
 * @param redirectAttributes The RedirectAttributes object used to 
 *                           pass flash attributes to the redirected page,
 *                           allowing for messages to be displayed to the user.
 * @return A redirect string to the customer list page, indicating 
 *         that the update was successful.
 */
@PostMapping("/update")
public String updateCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
    // Your implementation goes here
}

```
**JpaRepository does not provide a specific `update` method out of the box. However, it can still handle updates indirectly by using the save method. This method can be used to persist new entities and update existing ones because it checks if an entity already exists based on its primary key (customerId)**

The followng HTML form is provided as a starting point for quickly developing your Thymeleaf template to edit customer details. Note that the Customer ID is _Read-only_ and displays the unique identifier for the customer. Use this structure to create your Thymeleaf template, ensuring proper data binding and form handling.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Customer Details</title>
   
</head>
<body>

<h1>Edit Customer: [Customer First Name] [Customer Last Name]</h1>


<!-- Edit customer form -->
<form action="????" method="????">
    <div>
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" value="[Customer ID]" readonly />
    </div>

    <div>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="[First Name]" required />
    </div>

    <div>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="[Last Name]" required />
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="[Email]" required />
    </div>

    <div>
        <label for="password">Password:</label>
        <input type="text" id="password" name="password" value="[Password]" required />
    </div>

    <div>
        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="4" required>[Address]</textarea>
    </div>

    <div>
        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="[City]" required />
    </div>
    <div>
        <button type="submit">Save Changes</button>
    </div>
</form>

</body>
</html>

```

_For security reasons, password fields are typically not pre-populated in forms to prevent unintended exposure of the existing password. Instead, the usual approach is to allow users to enter a new password if they wish to change it while leaving the field blank if they want to keep the existing password unchanged. Once you have the update feature working, change the password field's input type to `password` and observe the change in behavior._   


_Again, once you have the update feature working, remove the `<div>` containing the input field for `customerId` and observe the change in behavior. How would you solve the problem that arises from the removal of this `<div>`?_

_When calling the `save` method in the repository the Product object is directly saved to the database (this is what I call a direct save). If it contains a valid primary key (id), JPA will consider it an existing entity and perform an update. If the `id` is null, it will attempt to create a new record (insert). There are some considerations when implemeting a direct save:_

1. **Risk of Overwriting Data:**
If the `Product` object you wish to save doesn't contain all fields (for example, if some fields are `null`), saving it directly will overwrite the existing values with `null` in the database.
For example, if you have a field like `description` that was not included in the form or request, it might be saved as null unless handled properly.

2. **Partial Updates:**
If you are performing an update, you need to ensure that all the fields in the `Product` object passed are populated with correct values (including unchanged fields). In many real-world scenarios, partial updates are common, where only a few fields are updated (e.g., updating the `price` but leaving the `stock quantity` unchanged). In this case, the following method (for inclusion in the `CustomerService`) would be preferable:


```java
/**
 * Updates the details of an existing customer in the database.
 * 
 * @param customer the customer object containing updated information
 * @return true if the customer was updated successfully, false if the customer was not found
 */
public boolean updateCustomer(Customer customer) {
    // Find the existing customer in the database by ID
    Optional<Customer> existingCustomerOptional = customerRepository.findById(customer.getCustomerId());

    if (existingCustomerOptional.isPresent()) {
        Customer existingCustomer = existingCustomerOptional.get();

        // Update the existing customer's details
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());

        // Save the updated customer back to the database
        customerRepository.save(existingCustomer);
        return true; // Indicate success
    } else {
        // Handle the case when the customer does not exist
        return false; // Indicate failure (customer not found)
    }
}
```
_The updateCustomer method retrieves an existing customer from the database using their ID. If the customer exists, it updates their details (first name, last name, email, password, address, and city) and saves the updated customer back to the database. If the customer is not found, it throws an EntityNotFoundException._


If you permanently remove the input field for `customerId` from the form, you'll need an alternative way to pass the `customerId` to the controller. Two common approaches are:

1. **Hidden Field:** You can pass the  `customerId` as a hidden field in the form. When using `@ModelAttribute("customer")`  in the controller, Spring automatically binds all form fields (including the hidden `customerId`) to the corresponding fields of the `Customer` object during form submission. This is the most straightforward approach. 

2. **URL Encoding:** Alternatively, you can encode the `customerId` directly into the action attribute of the form. For example: `<form th:action="@{/customers/update(id=${customer.customerId})}" th:object="${customer}" method="post">`. When the form is submitted, it generates a request like `http://localhost:8888/customers/update?id=15`, where 15 is the `customerId` of the object you want to update. In this case, you'll need to adjust your controller method to capture the `customerId` as a `@RequestParam`.
