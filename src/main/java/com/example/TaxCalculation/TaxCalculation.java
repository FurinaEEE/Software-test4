package com.example.TaxCalculation;

import jakarta.jws.WebService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TaxCalculation", value = "/tax-calculation")
@WebService
public class TaxCalculation extends HttpServlet {
    private String message;

    public void init() {
        message = "计算个人所得税";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form action='" + request.getContextPath() + "/tax-calculation' method='post'>");
        out.println("<input type='text' name='userInput' placeholder='请输入您的年收入'>");
        out.println("<input type='submit' value='计算'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Double userInput = Double.valueOf(request.getParameter("userInput"));
        revenue number = new revenue();
        Double money=number.calculatePersonalTax(userInput);


        if (money != null ) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "应纳个人所得税为：" + "</h1>");
            out.println("<h1>" + money + "</h1>");
            out.println("</body></html>");
        } else {

        }
    }

    public void destroy() {
    }

}