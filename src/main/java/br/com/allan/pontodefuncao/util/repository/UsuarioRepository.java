package br.com.allan.pontodefuncao.util.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allan.pontodefuncao.classes.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	public Optional<Usuario> findByUsername(String username);

}
