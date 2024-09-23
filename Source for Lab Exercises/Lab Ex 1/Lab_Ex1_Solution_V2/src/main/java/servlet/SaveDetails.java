package servlet;

import beans.Customer;
import data.CustomerIO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveDetails", value = "/SaveDetails")
public class SaveDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ServletContext sc = request.getServletContext();
        String path = sc.getRealPath("/WEB-INF/CustomerList.txt");
        Customer c= (Customer) session.getAttribute("customer");
        CustomerIO.add(c, path);
        session.invalidate();

        RequestDispatcher dispatcher = request.getRequestDispatcher("thanks.jsp");
        dispatcher.forward(request, response);
    }
}
