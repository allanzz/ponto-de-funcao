package br.com.allan.pontodefuncao.util.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.allan.pontodefuncao.classes.Usuario;
import br.com.allan.pontodefuncao.util.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioDetailService implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOpt = usuarioRepo.findByUsername(username);
		if (usuarioOpt.isPresent()) {
			return usuarioOpt.get();
		}
		throw new UsernameNotFoundException("Usuário não encontrado");

	}

}
