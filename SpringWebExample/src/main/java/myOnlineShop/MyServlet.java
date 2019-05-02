//package myOnlineShop;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Controller
//@WebServlet (urlPatterns = "/myservlet")
//@RequestMapping("/myservlet")
//public class MyServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String temp = request.getParameter("bloha");
//
//        System.out.println("Servlet is triggered: " + temp);
//        TempClass.doSomething();
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String temp = request.getParameter("bloha");
//
//        System.out.println("Servlet is triggered: " + temp);
//        TempClass.doSomething();
//
//    }
//
//}
//
//
//
//
//
//
//
////        response.setContentType("text/html");
////                response.setCharacterEncoding("UTF-8");
////
////                // create HTML response
////                PrintWriter writer = response.getWriter();
////                writer.append("<!DOCTYPE html>\r\n")
////                .append("<html>\r\n")
////                .append("		<head>\r\n")
////                .append("			<title>Welcome message</title>\r\n")
////                .append("		</head>\r\n")
////                .append("		<body>\r\n")
////                .append("	Welcome " + temp + ".\r\n")
////                .append("	You successfully completed this javatutorial.net example.\r\n")
////                .append("	You did not entered a name!\r\n")
////                .append("		</body>\r\n")
////                .append("</html>\r\n");