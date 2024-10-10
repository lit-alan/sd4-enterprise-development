## Lab Exercise Five. Week :five:

### Amend the `displayAllCustomers` template from Lab Ex 4.
- Add a futher action/link to the `Actions` column in the `displayAllCustomers` template from [Lab Ex 4](https://github.com/lit-alan/SD4-Enterprise-App-Development/blob/master/Snippets/LabEx_4.md#amend-the-displayallcustomers-feature-from-lab-ex-3) called `Add`.
- When clicked, this link will dislay an `add_customer` template containing a form that will allow the end user to add a customer to the database.
- Use the `update_customer` template/form from [Lab Exercise 4](https://github.com/lit-alan/SD4-Enterprise-App-Development/blob/master/Snippets/LabEx_4.md#update-a-customer)  as a reference to create this new add_customer template.
</br> 

### Amend the `CustomerController`
- You will need to add  appropriate methods to your controller to faciliate the addition of a customer to the database.
  - A method to display the `add_customer` template.
  - A method to handle form submissions and save the new customer.

</br> 

### Test the application and ensure that the correct customer entity is added to the database.
- Verify that all navigation links and form submissions are functioning as expected.

</br> 

### Add a dependency for Spring Validation to your projects POM.
- Add the following dependency to your pom.xml file to enable Spring's validation features:
```xml
 <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
</br> 

### Add Validation to the application.
- Revisit the [Customer entity class](https://github.com/lit-alan/SD4-Enterprise-App-Development/blob/master/Snippets/LabEx_2.md#5-create-entity-classes)  and add validation annotations using Spring's built-in validators. Including appropriate error messages for each validation annotation. Examples include:
  - `@NotBlank` for non-empty fields.
  - `@Size` for controlling string length.
  - `@Email` for validating the email format.
- Update the `add_customer` template to ensure that all validation messages are displayed when applicable. Use Spring's form error handling (e.g., `th:if` and `th:errors`) to show validation feedback.
- Modify the method in your `CustomerController` that handles the `add_customer` form submission to validate the Customer object. Use `@Valid` and `BindingResult` to capture validation errors, and implement the necessary redirects.
- Refer to [Lecture 8](https://moodle.midwest.tus.ie/pluginfile.php/1263774/mod_resource/content/1/L8%20Validation.pdf) for detailed guidance on implementing validation.

</br> 

### Create a Custom Validator for the `Customer` Entity
Choose a custom validator to implement. Here are some suggestions:

1. **Email Domain Validation:**
    Ensure that all email addresses belong to the same domain (e.g., @tus.ie). _Extract the domain from the email using substring(), then compare it against a predefined array of allowed domains using a loop and equalsIgnoreCase()._

2. **Password Strength Validation:**
    Enforce strong password criteria such as a mix of uppercase, lowercase, digits, and special characters. _This will require using regular expressions_.

3. **Unique Email Validation:**
    Ensure that each email address is unique across all customers. _This will require a database query_.

4. **Review Count Limitation:**
    Limit the number of reviews a customer can have (e.g., no more than 5 reviews). _This will also require a database query_.

 </br> 

### Test the custom validator.
- Create test cases to verify that your custom validator functions correctly.
- Check edge cases to ensure that invalid inputs are caught, and appropriate error messages are displayed.
