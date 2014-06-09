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

public class CadPessoaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        request.getSession().invalidate();
        
        out.println("Sessão encerrada.<BR><BR> <a href='index.html'>Voltar para Cadastro</a>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List pessoas = (ArrayList) request.getSession().getAttribute("pessoas");

        if (pessoas == null) {
            pessoas = new ArrayList();
        }

        if (pessoas.size() < 5) {
            Pessoa p = new Pessoa();
            p.setNome(request.getParameter("nome"));
            p.setIdade(request.getParameter("idade"));
            p.setCpf(request.getParameter("cpf"));
            p.setRg(request.getParameter("rg"));

            pessoas.add(p);
            request.getSession().setAttribute("pessoas", pessoas);
            out.println(p.getNome() + " cadastrado(a) com sucesso!<BR><BR>");
        } else {
            out.println("Número máximo de pessoas cadastradas.<BR><BR>");
        }
        out.println("<a href='index.jsp'>Voltar para Cadastro</a>");

    } 

}
