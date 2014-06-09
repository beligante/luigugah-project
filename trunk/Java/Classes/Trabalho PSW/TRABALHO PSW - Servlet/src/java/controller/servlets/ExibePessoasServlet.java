package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.Pessoa;

public class ExibePessoasServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Pessoa> pessoas = (ArrayList) request.getSession().getAttribute("pessoas");

        if (pessoas == null || pessoas.size() == 0) {
            out.println("Nenhuma pessoa cadastrada no momento.<BR><BR>");
        } else {
            for (Pessoa p : pessoas) {
                out.println(p.getNome() + ", " + p.getIdade() + 
                        " anos, RG: " + p.getRg() + ", CPF: " + p.getCpf() + 
                        "<BR><BR>");
            }
        }
        
        out.println("<BR><BR> <a href='index.html'>Voltar para Cadastro</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }

    

}
