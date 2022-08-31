package com.barbearia;

import java.time.LocalDate;
import java.util.Arrays;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.barbearia.model.Agenda;
import com.barbearia.model.Cliente;
import com.barbearia.model.Fornecedor;
import com.barbearia.model.Funcionario;
import com.barbearia.model.Horario;
import com.barbearia.model.Produto;
import com.barbearia.model.Saida;
import com.barbearia.model.Servico;
import com.barbearia.repository.AgendaRepository;
import com.barbearia.repository.ClienteRepositoy;
import com.barbearia.repository.FornecedorRepository;
import com.barbearia.repository.FuncionarioRepositoy;
import com.barbearia.repository.HorarioRepository;
import com.barbearia.repository.ProdutoRepository;
import com.barbearia.repository.SaidaRepository;
import com.barbearia.repository.ServicoRepository;

@SpringBootApplication
public class BarbeariaMdApplication implements CommandLineRunner, WebMvcConfigurer { //WebMvcConfigurer

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaMdApplication.class, args);
		
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("1234");
		System.out.println(result);*/
	}
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login"); 
	}

	@Autowired
	AgendaRepository agendaRepository;
	@Autowired
	FuncionarioRepositoy funcionarioRepositoy;
	@Autowired
	HorarioRepository horarioRepository;
	@Autowired
	ServicoRepository servicoRepository;
	@Autowired
	ClienteRepositoy clienteRepository;
	@Autowired
	FornecedorRepository fornecedorRepository;
	@Autowired
	SaidaRepository saidaRepository;
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {

		Horario horario1 = new Horario("08:00");
		Horario horario2 = new Horario("08:30");
		Horario horario3 = new Horario("09:00");
		Horario horario4 = new Horario("09:30");
		horarioRepository.saveAll(Arrays.asList(horario1, horario2, horario3, horario4));

		Funcionario funcionario1 = new Funcionario(100.2, "Dinho", "barbeiro", LocalDate.of(2020, 10, 27), "dinho", "$2a$10$dzLrmfDpy5aY4Y/vYCNxtO9s8QLCEPm33RSXwn8aKuJCGheNM6KxO");
		Funcionario funcionario2 = new Funcionario(50.0, "Marcelo", "barbeiro", LocalDate.of(2020, 10, 30), "marcelo", "5678");
		funcionario1.getHorarios().addAll(Arrays.asList(horario1, horario2, horario3, horario4));
		funcionarioRepositoy.saveAll(Arrays.asList(funcionario1, funcionario2));

		Servico servico1 = new Servico("social", 20.00);
		servicoRepository.saveAll(Arrays.asList(servico1));

		Servico servico2 = new Servico("degradê", 20.00);
		servicoRepository.saveAll(Arrays.asList(servico2));

		Cliente cliente1 = new Cliente("Willian P", "Mora na facec", "44988888888", "willian@gmail.com");
		clienteRepository.saveAll(Arrays.asList(cliente1));

		Cliente cliente2 = new Cliente("Osvaldo pescador", "Cianorte", "44998765843", "Osvaldo@gmail.com");
		clienteRepository.saveAll(Arrays.asList(cliente2));

		Fornecedor fornecedor1 = new Fornecedor("Xaulim matador de porco", "Kotlin", "987848174", "xaulim@gmail.com");
		fornecedorRepository.saveAll(Arrays.asList(fornecedor1));
		
		Fornecedor fornecedor2 = new Fornecedor("Zezin do pneu", "Kotlin", "987848174", "Zezin@gmail.com");
		fornecedorRepository.saveAll(Arrays.asList(fornecedor2));

		Agenda agenda1 = new Agenda(funcionario1, cliente1, LocalDate.now(), horario1, servico1);
		Agenda agenda2 = new Agenda(funcionario1, cliente2, LocalDate.of(2021, 04, 24), horario2, servico1);
		Agenda agenda3 = new Agenda(funcionario2, cliente1, LocalDate.of(2021, 04, 24), horario3, servico1);
	    Agenda agenda4 = new Agenda(funcionario1, cliente2, LocalDate.now(), horario4, servico1);
		Agenda agenda5 = new Agenda(funcionario1, cliente1, LocalDate.of(2021, 04, 24), horario1, servico1);
		Agenda agenda6 = new Agenda(funcionario2, cliente2, LocalDate.now(), horario1, servico1);
		Agenda agenda7 = new Agenda(funcionario1, cliente1, LocalDate.of(2021, 04, 24), horario1, servico1);
		Agenda agenda8 = new Agenda(funcionario2, cliente1, LocalDate.now(), horario1, servico1);
		agendaRepository.saveAll(Arrays.asList(agenda1, agenda2, agenda3, agenda4, agenda5, agenda6, agenda7, agenda8));
		
		Produto produto1 = new Produto("Navalha");
		produtoRepository.saveAll(Arrays.asList(produto1));
		
		Produto produto2 = new Produto("Creme de barbear");
		produtoRepository.saveAll(Arrays.asList(produto2));

		Saida saida1 = new Saida(fornecedor1, produto1, 78.80, 3, (78.80 * 3), LocalDate.now());
		saidaRepository.saveAll(Arrays.asList(saida1));

		Saida saida2 = new Saida(fornecedor1, produto1, 20.80, 4, (20.80 * 4), LocalDate.now());
		saidaRepository.saveAll(Arrays.asList(saida2));

	}
}
