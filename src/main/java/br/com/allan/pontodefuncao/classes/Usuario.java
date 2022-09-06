package br.com.allan.pontodefuncao.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
public class Usuario implements UserDetails {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String nome;
	private String funcao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	public Usuario() {}
	public Usuario(String nome, String funcao) {
		this.nome = nome;
		this.funcao = funcao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Override
	public String toString() {
		return "Recurso [id=" + id + ", nome=" + nome + ", funcao=" + funcao + ", dataInicio=" + dataInicio + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password ;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public void setPassword(String password) {
		this.password =new BCryptPasswordEncoder().encode(password);
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	} 
}