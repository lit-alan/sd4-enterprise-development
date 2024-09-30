## Lab Exercise Three. Week :three:

### Amend the 'displayAllCustomers' Feature from Lab Ex 2.

![image](https://github.com/user-attachments/assets/b7efe0e3-6c70-4a56-9226-3e71604db5ab)


_Displaying only data from the `customers` table for each customer_

```html
<tr th:each="customer : ${customerList}">
        <td th:text="${customer.customerId}"></td>
        <td th:text="${customer.firstName} + ' ' + ${customer.lastName}"></td>
        <td th:text="${customer.email}"></td>
        <td th:text="${customer.address}"></td>
        <td th:text="${customer.city}"></td>
    </tr>
```

_Ensure that each `customerID` appears as a [link](https://www.thymeleaf.org/doc/articles/standardurlsyntax.html) that when clicked on will provide further information for each `customer`. This is in effect a data drill down_


![image](https://github.com/user-attachments/assets/f85bff7f-9d2b-43b7-9eda-cfea82ae6091)

_In the drill down page, for each `review` that the customer has made; display the the `name` of the product, the review `rating` and the `reviewText`_

If end user enters an invalid customer id (via the url): `customers/drilldown/333333` for example, the controller should be redirect to `/customers`





