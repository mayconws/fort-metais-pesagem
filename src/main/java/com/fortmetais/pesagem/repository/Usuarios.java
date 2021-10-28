package com.fortmetais.pesagem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fortmetais.pesagem.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByLoginIgnoreCase(String login);

	@Query("from Usuario u where lower(u.login) = lower(?1) and u.ativo = true")
	public Optional<Usuario> porLoginEAtivo(String login);

	@Query(value = "select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u = :usuario")
	public List<String> permissoes(@Param("usuario") Usuario usuario);
	
}
