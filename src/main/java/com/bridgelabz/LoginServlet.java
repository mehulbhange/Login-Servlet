package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get request parameters for username and password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (isNameValid(username) && isPasswordValid(password)){
            req.setAttribute("username", username);
            req.getRequestDispatcher("loginSuccess.jsp").forward(req,resp);
        }else{
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.write("<font color=red> User name or password is wrong!.</font>");
            requestDispatcher.include(req, resp);
            out.close();
        }
    }

    public boolean isNameValid(String name){
        return Pattern.compile("[A-Z][a-z]{2,}").matcher(name).matches();
    }

    public boolean isPasswordValid(String password){
        return Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&*+=]*[@#$%^&*+=][^@#$%^&*+=]*$).{8,}$").matcher(password).matches();
    }

}
