package com.domain;

public abstract class Constants {

	//Keys Secao
	public static final String USUARIO_SECAO = "usuarioLogado";
        public static final String USUARIO_CONTROLLER_SECAO = "userController";
        public static final String PRONTUARIO_CONTROLLER_SECAO = "prontuarioController";
        public static final String PACIENTE_CONTROLLER_SECAO = "pacienteController";
        public static final String CONSULTA_CONTROLLER_SECAO = "consultaController";

	//Keys Action
	public static final String HOME_AREA_LOGADA_ACTION = "home";
	public static final String LOGIN_ACTION = "login";
        public static final String CADASTRO_PACIENTE_ACTION = "cadastroPaciente";
        public static final String BUSCA_PACIENTE_ACTION = "buscaPaciente";
        public static final String BUSCA_CONSULTA_ACTION = "buscaConsulta";
        public static final String CADASTRO_CONSULTA_ACTION = "cadastroConsulta";
        public static final String BUSCA_PRONTUARIO_ACTION = "buscaProntuario";
        public static final String CADASTRO_PRONTUARIO_ACTION = "cadastroProntuario";
        
	
	//Keys JSP
	public static final String LOGIN_JSP = "WEB-INF/jsp/login/login.jsp";
	public static final String HOME_JSP = "WEB-INF/jsp/comum/home.jsp";
        public static final String CADASTRO_PACIENTE_JSP = "WEB-INF/jsp/arealogada/cadastro-paciente.jsp";
        public static final String BUSCA_PACIENTE_JSP = "WEB-INF/jsp/arealogada/busca-paciente.jsp";
        public static final String CADASTRO_CONSULTA_JSP = "WEB-INF/jsp/arealogada/cadastro-consulta.jsp";
        public static final String BUSCA_CONSULTA_JSP = "WEB-INF/jsp/arealogada/busca-consulta.jsp";
        public static final String CADASTRO_PRONTUARIO_JSP = "WEB-INF/jsp/arealogada/cadastro-prontuario.jsp";
        public static final String BUSCA_PRONTUARIO_JSP = "WEB-INF/jsp/arealogada/busca-prontuario.jsp";
        
        public static final String ENCODING = "ISO-8859-1";
}
