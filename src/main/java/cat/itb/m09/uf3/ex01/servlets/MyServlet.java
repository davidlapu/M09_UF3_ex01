package cat.itb.m09.uf3.ex01.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myservlet",urlPatterns = {"/myservlet"})
public class MyServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
       procesarPeticio(req, resp);

   }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procesarPeticio(req, resp);
    }

    private void procesarPeticio(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException  {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            String nom=req.getParameter("nom");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Salutació Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hola "+nom+"! <h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
