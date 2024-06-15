package SRC;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCondominio {
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	public static ArrayList<Debito> debitos = new ArrayList<>();
	public static ArrayList<ReclameESolicite> solicitacoes = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		inicializarUsuariosPadrao();
		inicializarDebitos();
		inicializarReclamacoesSolicitacoes();
		while (true) {
			login();
		}
	}

	private static void login() {
		System.out.println("Sistema de Login:");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Senha: ");
		String senha = scanner.nextLine();

		Usuario usuario = autenticarUsuario(nome, senha);
		if (usuario != null) {
			if (usuario instanceof Administrador) {
				((Administrador) usuario).menuAdministrador();
			} else if (usuario instanceof Morador) {
				((Morador) usuario).menuMorador();
			} else if (usuario instanceof Funcionario) {
				((Funcionario) usuario).menuFuncionario();
			}
		} else {
			System.out.println("Usuário ou senha inválidos!");
		}
	}

	private static Usuario autenticarUsuario(String nome, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.autenticar(senha)) {
				return usuario;
			}
		}
		return null;
	}

	public static void cadastrarUsuario() {
		System.out.println("Tipos de Usuários: 1. Morador 2. Funcionario 3. Administrador");
		System.out.print("Escolha o tipo de usuário para cadastrar: ");
		int tipo = scanner.nextInt();
		scanner.nextLine(); // Limpa o buffer

		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();
		System.out.print("Contato E-mail/Telefone: ");
		String contato = scanner.nextLine();
		System.out.print("Senha: ");
		String senha = scanner.nextLine();

		switch (tipo) {
		case 1:
			System.out.print("Número do Apartamento: ");
			String numeroApartamento = scanner.nextLine();
			usuarios.add(new Morador(nome, endereco, contato, senha, numeroApartamento));
			break;
		case 2:
			usuarios.add(new Funcionario(nome, endereco, contato, senha));
			break;
		case 3:
			usuarios.add(new Administrador(nome, endereco, contato, senha));
			break;
		default:
			System.out.println("Tipo de usuário inválido!");
		}
	}

	public static void inicializarUsuariosPadrao() {
		// Login/Nome , Endereço , E-mail, Senha.
		usuarios.add(new Administrador("Admin", "Admin Endereco", "admin@condominio.com", "admin"));
		// Login/Nome, Endereço, E-mail, Senha, Numero Do Apartamento.
		usuarios.add(new Morador("Lucas", "Morador Endereco 1", "morador1@condominio.com", "lucas", "100"));
		usuarios.add(new Morador("Joao", "Morador Endereco 2", "morador2@condominio.com", "Joao", "110"));
		usuarios.add(new Morador("Flavia", "Morador Endereco 3", "morador3@condominio.com", "flavia", "120"));
		usuarios.add(new Morador("Paula", "Morador Endereco 4", "morador4@condominio.com", "paula", "130"));
		usuarios.add(new Morador("Pryscilla", "Morador Endereco 5", "morador5@condominio.com", "pryscilla", "140"));
		// Login/Nome, Endereço, E-mail, Senha.
		usuarios.add(
				new Funcionario("Funcionario", "Funcionario Endereco 1", "funcionario1@condominio.com", "funcionario"));
	}

	public static void inicializarDebitos() {
		debitos.add(new Debito("Agua - 01/24", 15.000, "100"));
		debitos.add(new Debito("Agua - 01/24", 15.000, "110"));
		debitos.add(new Debito("Agua - 01/24", 15.000, "120"));
		debitos.add(new Debito("Agua - 01/24", 15.000, "130"));
		debitos.add(new Debito("Agua - 01/24", 15.000, "140"));
	}

	public static void inicializarReclamacoesSolicitacoes() {
		solicitacoes.add(new ReclameESolicite("Reclamação", "Falta de agua do condominio", "100"));
		solicitacoes.add(new ReclameESolicite("Reclamação", "Muito barrulho do vizinho de cima", "110"));
		solicitacoes.add(new ReclameESolicite("Duvidas", "Gostaria de falar com ADM sobre minhas contas", "120"));
		solicitacoes.add(new ReclameESolicite("Elogios", "Muito obrigado por ter resolvido meu problema", "130"));
		solicitacoes
				.add(new ReclameESolicite("Solicitação", "Enviar boletos em aberto para o E-mail, cadastrado", "140"));
	}

	public static void registrarDebito() {
		System.out.print("Descrição do Débito: ");
		String descricao = scanner.nextLine();
		System.out.print("Valor: ");
		double valor = scanner.nextDouble();
		scanner.nextLine(); // Limpa o buffer
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = scanner.nextLine();

		debitos.add(new Debito(descricao, valor, numeroApartamento));
	}

	public static void visualizarDebitos() {
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = scanner.nextLine();

		for (Debito debito : debitos) {
			if (debito.getNumeroApartamento().equals(numeroApartamento)) {
				System.out.println("Descrição: " + debito.getDescricao() + " | Valor: R$ " + debito.getValor());
			}
		}
	}
	public static void buscaMorador() {
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = scanner.nextLine();
		for(Usuario morador : usuarios) {
			if(morador.getNumeroApartamento().equals(numeroApartamento)) {
				System.out.println("Nome:  "+morador.nome+"Contato:  "+morador.getContato()+"Endereço:  "+morador.endereco);
			}
		}
	}
	public static void calcularDebitosPorMorador() {
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = scanner.nextLine();
		double total = 0;

		for (Debito debito : debitos) {
			if (debito.getNumeroApartamento().equals(numeroApartamento)) {
				total += debito.getValor();
			}
		}
		System.out.println("Total a ser pago pelo apartamento " + numeroApartamento + ": R$ " + total);
	}

	public static void visualizarReclamacoesESolicitacoes() {
		System.out.println("Visualizando reclamações e solicitações...");
		System.out.println("Digite o numero do apartamento: ");
		String numeroApartamento = scanner.nextLine();
		for (ReclameESolicite reclameesolicite : solicitacoes) {
			if (reclameesolicite.getNumeroApartamento().equals(numeroApartamento)) {
				System.out.println("Tipo da observação: " + reclameesolicite.getTipo());
				System.out.println("Texto: " + reclameesolicite.getTexto());
			}
		}
	}

	public static void registrarReclamação() {
		System.out.println("Digite o tipo de seu recado Sugestão/Reclamação");
		String tipo = scanner.nextLine();
		System.out.println("Digite sua reclamação");
		String texto = scanner.nextLine();
		System.out.println("Número do Apartamento: ");
		String numeroApartamento = scanner.nextLine();
		solicitacoes.add(new ReclameESolicite(tipo, texto, numeroApartamento));
	}

	public static void verificarDespesas() {
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = SistemaCondominio.scanner.nextLine();
		double total = 0;

		for (Debito debito : debitos) {
			if (debito.getNumeroApartamento().equals(numeroApartamento)) {
				total += debito.getValor();
			}
		}
		System.out.println("Total a ser pago pelo apartamento " + numeroApartamento + ": R$ " + total);
	}

	
	}


