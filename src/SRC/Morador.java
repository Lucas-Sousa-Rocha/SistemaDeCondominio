package SRC;
import java.util.Scanner;
class Morador extends Usuario {
    String numeroApartamento;
    public static Scanner scanner = new Scanner(System.in);
    public Morador(String nome, String endereco, String contato, String senha, String numeroApartamento) {
        super(nome, endereco, contato, senha);
        this.numeroApartamento = numeroApartamento;
    }
    public String getNumeroApartamento() {
        return numeroApartamento;
    }
    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
    public void menuMorador() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Menu do Morador:");
            System.out.println("1. Visualizar Reclamações e Solicitações");
            System.out.println("2. Registrar Reclamações e Solicitações");
            System.out.println("3. Verificar Despesas/Débitos");
            System.out.println("4. Logout");
            System.out.print("Escolha uma opção: ");
            int opcao = SistemaCondominio.scanner.nextInt();
            SistemaCondominio.scanner.nextLine(); // Limpa o buffer
            switch (opcao) {
                case 1:
                	SistemaCondominio.visualizarReclamacoesESolicitacoes();
                    break;
                case 2:
                	SistemaCondominio.registrarReclamação();
                    break;
                case 3:
                	SistemaCondominio.verificarDespesas();
                    break;
                case 4:
                    continuar = false;
                    break;     
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
	}
