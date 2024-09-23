package servlet;

import beans.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HandleForm", value = "/HandleForm")
public class HandleForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String eu = request.getParameter("eu");
        String options[] = request.getParameterValues("check");
        String comments = request.getParameter("comments");

        Customer c = new Customer();

        c.setName(name);
        c.setAddress(address);
        c.setCity(city);
        c.setCountry(country);
        c.setEmail(email);
        c.setPhone(phone);
        c.setEu(eu);
        c.setHearOptions(options);
        c.setComments(comments);

        HttpSession session = request.getSession();
        session.setAttribute("customer", c);
        request.setAttribute("name", c.getName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("displayName.jsp");
        dispatcher.forward(request, response);

    }
}
