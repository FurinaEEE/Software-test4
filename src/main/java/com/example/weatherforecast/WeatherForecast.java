package com.example.weatherforecast;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class WeatherForecast extends HttpServlet {
    private String message;

    public void init() {
        message = "天气预报系统";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form action='" + request.getContextPath() + "/hello-servlet' method='post'>");
        out.println("<input type='text' name='userInput' placeholder='请输入您要查阅的地方'>");
        out.println("<input type='submit' value='查询'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = String.valueOf(request.getParameter("userInput"));
        System.out.println(userInput);
        Weather weather = new Weather();
        List<String> weatherInfo = weather.getWeather(userInput);



        if (userInput != null ) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "该地的天气为：" + "</h1>");
            for (String info : weatherInfo) {
                out.println("<h1>" + info + "</h1>");
            }
            out.println("</body></html>");
        } else {

        }
    }

    public void destroy() {
    }
}