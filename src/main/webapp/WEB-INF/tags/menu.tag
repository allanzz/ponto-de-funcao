<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">CPF</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Projeto
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/cadastra-projeto">Cadastrar Projeto</a></li>
            <li><a class="dropdown-item" href="/listar-projetos">Listar Projetos</a></li>            
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Usuario
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/cadastra-usuario">Cadastrar Usuário</a></li>
            <li><a class="dropdown-item" href="/listar-usuarios">Listar Usuários</a></li>            
          </ul>
        </li>
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Listagem
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/listagemFuncoes">Listar Funções</a></li>            
          </ul>
        </li>           
      </ul>
      <div class="text-right">
      <sec:authorize access="!isAuthenticated()">
  			Login
	  </sec:authorize>
	<sec:authorize access="isAuthenticated()">
            <a href="/logout">Sair</a>
	</sec:authorize>
      </div>     
    </div>
  </div>
</nav>