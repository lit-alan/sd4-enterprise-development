## Snippets for 'Introduction To Spring' Live Coding Session 20/9/2024: :point_down:

1. [Controller Method With Path Params](#controller-method-with-path-params)

2. [Messages For List](#messages-for-list)

3. [Greetings.html](#greetingshtml)

4. [Customer.java](#customerjava)

5. [addCustomer.html](#addcustomerhtml)

6. [REST Controller Methods Customers](#rest-controller-methods)




### Controller Method With Params
```java
@GetMapping("/nice/{fname}/{age}")
@ResponseBody
public String saySomethingNiceWithPathParams(@PathVariable String fname,
                               @PathVariable Integer age) {
    return "Hello " + fname + " you look well for someone aged " + age;
}

@GetMapping("/nice")
@ResponseBody
public String saySomethingNiceWithRequestParams(@RequestParam(required = false) String fname,
                             @RequestParam(required = false) Integer age) {
  // Handle cases where fname or age might be null
  String namePart = (fname != null) ? fname : "Guest";
  String agePart = (age != null) ? "you look well for someone aged " + age : "age is unknown";

  return "Hello " + namePart + ", " + agePart;
}

```

### Messages For List
```java
List<String> messages = new ArrayList();
messages.add("Dia duit domhan");
messages.add("Hello World");
messages.add("Hallo Welt");
messages.add("Bonjour le monde");
messages.add("Hola Mundo");
messages.add("Hej Verden");
messages.add("Привет, мир");
messages.add("Witaj świecie");
messages.add("Hallo Wereld");
messages.add("Olá Mundo");
```

### Greetings.html
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Welcome!</h1>
<tr th:each="message: ${hellolist}">
    <td th:text="${message}" /> <br>
</tr>
</body>
</html>
```


### Customer.java
```java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer  {

   private int customerId;
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private String address;
   private String city;
}


```

### addCustomer.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add New Customer</title>
</head>
<body>

<h2>Add New Customer</h2>

<form th:action="@{/customers/add}" th:object="${customer}" method="post">

    <table>
        <tr>
            <td><label for="firstName">First Name:</label></td>
            <td><input type="text" id="firstName" th:field="*{firstName}" required /></td>
        </tr>
        <tr>
            <td><label for="lastName">Last Name:</label></td>
            <td><input type="text" id="lastName" th:field="*{lastName}" required /></td>
        </tr>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><input type="email" id="email" th:field="*{email}" required /></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="password" id="password" th:field="*{password}" required /></td>
        </tr>
        <tr>
            <td><label for="address">Address:</label></td>
            <td><textarea id="address" th:field="*{address}" required></textarea></td>
        </tr>
        <tr>
            <td><label for="city">City:</label></td>
            <td><input type="text" id="city" th:field="*{city}" required /></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Add Customer</button>
            </td>
        </tr>
    </table>

</form>

</body>
</html>


```


### REST Controller Methods
```java

 @GetMapping("/")
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList();

        customers.add(new Customer(1, "Seán", "O'Brien", "sean.obrien@eir.ie", "password123", "123 Main Street", "Dublin"));
        customers.add(new Customer(2, "Aoife", "Murphy", "aoife.murphy@hotmail.com", "password456", "456 Elm Street", "Cork"));
        customers.add(new Customer(3, "Cian", "Ryan", "cian_ryan78@gmail.com", "password789", "789 Oak Avenue", "Limerick"));
        customers.add(new Customer(4, "Niamh", "O'Sullivan", "niamhosull1990@example.com", "password101", "101 Maple Road", "Galway"));
        customers.add(new Customer(5, "Liam", "Kelly", "liam.kelly@tus.ie", "password202", "202 Birch Lane", "Waterford"));

        return customers;
    }

    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
```

