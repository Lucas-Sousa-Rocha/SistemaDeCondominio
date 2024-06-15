package SRC;
import java.util.Scanner;
//import java.util.ArrayList;
class Morador extends Usuario {
    String numeroApartamento;
  //  public static ArrayList<ReclameESolicite> solicitacoes = new ArrayList<>();
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
    
   /* public static void visualizarReclamacoesESolicitacoes() {
        System.out.println("Visualizando reclamações e solicitações...");
        System.out.println("Digite o numero do apartamento: ");
        String numeroApartamento = scanner.nextLine();
        for (ReclameESolicite reclameesolicite : solicitacoes) {
        	if(reclameesolicite.getNumeroApartamento().equals(numeroApartamento)) {
        		System.out.println("Tipo da observação: "+reclameesolicite.getTipo());
        		System.out.println("Texto: "+reclameesolicite.getTexto());
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
    public void verificarDespesas(ArrayList<Debito> debitos) {
		System.out.print("Número do Apartamento: ");
		String numeroApartamento = SistemaCondominio.scanner.nextLine();
		double total = 0;

		for (Debito debito : debitos) {
			if (debito.getNumeroApartamento().equals(numeroApartamento)) {
				total += debito.getValor();
			}
		}
		System.out.println("Total a ser pago pelo apartamento " + numeroApartamento + ": R$ " + total);*/
	}
