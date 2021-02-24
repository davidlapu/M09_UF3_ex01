package cat.itb.m09.uf3.ex01.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dniamblletra", urlPatterns = {"/dniAmbLletra"})
public class ServletDni extends HttpServlet {
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
        String dniAmbLletra;
        try {
            String sDni = req.getParameter("dni");
            if (sDni.length() == 8) {
                int dni = Integer.parseInt(sDni);
                dniAmbLletra = String.valueOf(dni) + calcularLetraArray(dni);
            } else {
                dniAmbLletra = "ERROR: Dni tiene que tener 8 caracteres";
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dni</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>DNI: "+ dniAmbLletra+" <h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private char calcularLetraArray(int dni){
        char[] caracteres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return caracteres[dni%23];
    }
}
