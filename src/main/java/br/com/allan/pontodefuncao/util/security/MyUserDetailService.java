package br.com.allan.pontodefuncao.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.allan.pontodefuncao.classes.Usuario;
import br.com.allan.pontodefuncao.util.repository.UsuarioRepository;
@Configuration
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Usuário não localizado");
		}
		return user;
	}

}
