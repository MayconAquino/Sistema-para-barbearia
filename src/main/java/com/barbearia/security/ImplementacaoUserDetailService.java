package com.barbearia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.barbearia.model.Funcionario;
import com.barbearia.repository.FuncionarioRepositoy;

@Service
public class ImplementacaoUserDetailService implements UserDetailsService {

	@Autowired
	private FuncionarioRepositoy funcionarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Funcionario funcionario = funcionarioRepository.findByLogin(username);
		
		if (funcionario == null) {
			throw new UsernameNotFoundException("Usuário não foi encontrado");
		}

		return funcionario;
	}

}
