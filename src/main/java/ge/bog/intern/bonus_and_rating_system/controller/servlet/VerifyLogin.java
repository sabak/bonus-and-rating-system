package ge.bog.intern.bonus_and_rating_system.controller.servlet;

import ge.bog.intern.bonus_and_rating_system.manager.DAO;
import ge.bog.intern.bonus_and_rating_system.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerifyLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("password");


        HttpSession session = request.getSession();

        DAO dao = (DAO) getServletContext().getAttribute("DAO");

        if (dao.isUserValid(username, password)) {
            session.setAttribute("username", username);
            Employee employee = dao.getEmployeeByUsername(username);
            System.out.println(employee.getName());
            System.out.println(employee.getDateOfBirth());
            System.out.println(employee.getPos());
            request.setAttribute("employee", dao.getEmployeeByUsername(username));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homePage.jsp");
            requestDispatcher.forward(request, response);

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
