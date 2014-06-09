package com.controller.servlets;

import com.controller.ConsultaController;
import com.controller.PacienteController;
import com.controller.ProntuarioController;
import com.controller.UserController;
import com.domain.Constants;
import com.domain.Consulta;
import com.domain.Credencial;
import com.domain.Medico;
import com.domain.Paciente;
import com.domain.Prontuario;
import com.domain.Secretaria;
import com.domain.Usuario;
import com.enums.Sexo;
import com.enums.TipoAtendimento;
import com.repository.Repository;
import com.repository.UserRepository;
import com.security.UserManager;
import com.utils.StringUtils;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		Usuario user = (Usuario) request.getSession().getAttribute(Constants.USUARIO_SECAO);
		if(user != null){
			response.sendRedirect(Constants.HOME_AREA_LOGADA_ACTION);
		}else{
                        request.setCharacterEncoding(Constants.ENCODING);
			request.getRequestDispatcher(Constants.LOGIN_JSP).include(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
            Usuario user = (Usuario) request.getSession().getAttribute(Constants.USUARIO_SECAO);
		if(user != null){
			response.sendRedirect(Constants.HOME_AREA_LOGADA_ACTION);
		}else{
                    
                    String usuario = (String) request.getParameter("user");
                    String senha = (String) request.getParameter("password");
                    
                    if(StringUtils.isBlank(usuario) || StringUtils.isBlank(senha)){
                        response.sendRedirect(Constants.LOGIN_ACTION);
                        return;
                    }
                    
                    UserManager userManager = new UserManager();
                    userManager.setRepository(generateUserRepositoy());
                    UserController userControler = new UserController(userManager);
                    
                    Credencial credencial = new Credencial(usuario, senha);
                    user = userManager.login(credencial);
                    
                    if(user == null){
                        response.sendRedirect(Constants.LOGIN_ACTION);
                        return;
                    }
                    
                    ProntuarioController prontuarioController = new ProntuarioController();
                    prontuarioController.setRepository(new Repository<Prontuario>());

                    PacienteController pacienteController = new PacienteController(prontuarioController);
                    pacienteController.setRepository(new Repository<Paciente>());

                    Paciente p = new Paciente();
                    p.setNome("Luis");
                    p.setDataNascimento(new Date());
                    p.setCpf("00000000");
                    p.setEmail("abc@abc.com");
                    p.setIsAlcolatra(true);
                    p.setIsCardiaco(true);
                    p.setSexo(Sexo.MASCULINO);
                    p.setRg("000000000");
                    p.setTelefone("000000");
                    p.setTipoAtendimento(TipoAtendimento.PARTICULAR);
                    
                    pacienteController.save(p);
                    
                    ConsultaController consultaController = new ConsultaController();
                    consultaController.setRepository(new Repository<Consulta>());
                    
                    request.getSession().setAttribute(Constants.USUARIO_SECAO, user);
                    request.getSession()
                            .setAttribute(Constants.USUARIO_CONTROLLER_SECAO, userControler);
                    request.getSession()
                            .setAttribute(Constants.PACIENTE_CONTROLLER_SECAO, pacienteController);
                    request.getSession()
                            .setAttribute(Constants.PRONTUARIO_CONTROLLER_SECAO, prontuarioController);
                    request.getSession()
                            .setAttribute(Constants.CONSULTA_CONTROLLER_SECAO, consultaController);
                    
                    response.sendRedirect(Constants.HOME_AREA_LOGADA_ACTION);

                }
            
	}
        
        private static UserRepository generateUserRepositoy() {

        UserRepository userRepository = new UserRepository();

        Medico medico = new Medico();

        medico.setNome("Joao");
        medico.setCpf("0000000000");
        medico.setDataNascimento(new Date());
        medico.setSexo(Sexo.MASCULINO);
        medico.setUser("jao");
        medico.setPassword("a");

        Secretaria secretaria = new Secretaria();

        secretaria.setNome("Ariadine");
        secretaria.setCpf("0000000000");
        secretaria.setDataNascimento(new Date());
        secretaria.setSexo(Sexo.OUTROS);
        secretaria.setUser("ariadne");
        secretaria.setPassword("rihanna");

        userRepository.merge(medico);
        userRepository.merge(secretaria);

        return userRepository;
    }

}
