package cat.itb.m09.uf3.ex01.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "isbnCalcular", urlPatterns = {"/isbnCalcular"})
public class ServletISBN extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            String isbn = req.getParameter("isbn");
            String control = clacularIsbn(isbn);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Isbn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Digit control: "+ control+" <h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private String clacularIsbn(String isbn) {
        int con = 0;
        for (int i = 0; i < isbn.length(); i++) {
            con = con + (Integer.parseInt(String.valueOf(isbn.charAt(i))) * (i + 1));
        }

        System.out.println(con);
        int res = con%11;

        return String.valueOf(res);
    }


}
