package SRC;

class Administrador extends Usuario {
	public Administrador(String nome, String endereco, String contato, String senha) {
		super(nome, endereco, contato, senha);
	}

	@Override
	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}

	public void menuAdministrador() {
		boolean continuar = true;
		while (continuar) {
			System.out.println("Menu do Administrador:");
			System.out.println("1. Cadastrar Novo Usuário");
			System.out.println("2. Registrar Débito");
			System.out.println("3. Visualizar Débitos por Apartamento");
			System.out.println("4. Calcular Valor Total por Morador");
			System.out.println("5. Logout");
			System.out.print("Escolha uma opção: ");
			int opcao = SistemaCondominio.scanner.nextInt();
			SistemaCondominio.scanner.nextLine(); // Limpa o buffer

			switch (opcao) {
			case 1:
				SistemaCondominio.cadastrarUsuario();
				break;
			case 2:
				SistemaCondominio.registrarDebito();
				break;
			case 3:
				SistemaCondominio.visualizarDebitos();
				break;
			case 4:
				SistemaCondominio.calcularDebitosPorMorador();
				break;
			case 5:
				continuar = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
