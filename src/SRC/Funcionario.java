package SRC;
import java.util.ArrayList;
class Funcionario extends Usuario {
	public Funcionario(String nome, String endereco, String contato, String senha) {
		super(nome, endereco, contato, senha);
	}
	@Override
	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}
	public void menuFuncionario() {
		boolean continuar = true;
		while (continuar) {
			System.out.println("Menu do Funcionário:");
			System.out.println("1. Verificar valores em aberto por numero de apartamento");
			System.out.println("2. Verificar Chamados em aberto");
			System.out.println("3. Buscar morador");
			System.out.println("4. Logout");
			System.out.print("Escolha uma opção: ");
			int opcao = SistemaCondominio.scanner.nextInt();
			SistemaCondominio.scanner.nextLine(); // Limpa o buffer
			switch (opcao) {
			case 1:
				verificarDespesasPorMorador(SistemaCondominio.debitos);
				break;
			case 2:
				SistemaCondominio.visualizarReclamacoesESolicitacoes();
				break;
			case 3:
				SistemaCondominio.buscaMorador();
				break;
			case 4:
				continuar = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}
	public void verificarDespesasPorMorador(ArrayList<Debito> debitos) {
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
