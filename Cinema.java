// c) Classe cinema que contém o método main e um menu:
// 1 – Cadastrar
// 2 – Vender
// 3 – Sair
// Cada opção do menu deve ser um método, exceto a opção 3. Assim, teremos pelo menos
// 2 métodos:
// • Cadastrar: vai pedir ao usuário as informações de 5 seções e cadastrá-las.
// • Venda: deve mostrar na tela todas as seções (nome do filme e horário). Assim, o
// usuário deve escolher a seção. Em seguida, deve mostrar na tela os lugares da
// seção, para que o usuário escolha a fila e o assento disponível para comprar.
// Então realiza a venda.
import java.util.Scanner;

public class Cinema {
    static Scanner ler = new Scanner(System.in);
    static Secao[] secao = new Secao[5];
    static int quantSecao = 0;

    public static void main(String[] args) {
        char opcao;
        
        do {
            System.out.println("MENU" + 
            "1- Cadastrar Seção" + 
            "2- Vender Seções" +
            "3- Sair do Programa" +
            "Escolha uma opção para prosseguir: ");
            
            opcao = ler.next().charAt(0);

            switch (opcao) {
                case '1':
                    cadastrarSecao(secao);
                    break;
                case '2':
                    venderSecao(secao);
                    break;
                case '3':
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Digite novamente!");
                    break;
            }
        } while (opcao != 3);
    
    }

    public static void cadastrarSecao(Secao[] secao) {
            if (quantSecao >= secao.length) {
                System.out.println("Número máximo de seções cadastradas.");
                return;
            }
    
            for (int i = quantSecao; i < secao.length; i++) {
                System.out.println("Cadastro da Seção " + (i + 1) + ":");
    
                System.out.print("Digite o nome do filme: ");
                String nomeFilme = ler.next();
    
                System.out.print("Digite o horário da seção (ex: 20:00): ");
                String horario = ler.next();
    
                // Cria uma nova seção com o nome do filme e horário fornecidos
                secao[i] = new Secao(nomeFilme, horario);
                quantSecao++;
            }
            System.out.println("Todas as seções foram cadastradas com sucesso!");
        }
    
    public static void venderSecao(Secao[] secao) {
        if (quantSecao == 0) {
            System.out.println("Nenhuma seção cadastrada. Cadastre seções primeiro.");
            return;
        }

        // Exibir todas as seções
        System.out.println("Escolha uma seção:");
        for (int i = 0; i < quantSecao; i++) {
            Secao secaos = secao[i];
            System.out.println((i + 1) + " – " + secaos.getNomeFilme() + " - " + secaos.getHorario());
        }

        // Escolher uma seção
        System.out.print("Escolha o número da seção: ");
        int escolha = ler.nextInt() - 1;
        ler.nextLine(); 

        if (escolha < 0 || escolha >= quantSecao) {
            System.out.println("Seção inválida.");
            return;
        }

        Secao secaoEscolhida = secao[escolha];
        secaoEscolhida.mostrarLugaresSecao();

        // Escolher fila e assento
        System.out.print("Escolha a fila (0 a " + (Assento - 1) + "): ");
        int fila = ler.nextInt();
        System.out.print("Escolha o assento (0 a " + (Assento.NUM_ASSENTOS - 1) + "): ");
        int assento = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Realizar a venda
        boolean sucesso = secaoEscolhida.venda(fila, assento);
        if (sucesso) {
            System.out.println("Compra realizada com sucesso! Preço: R$ " + Secao.getPrecoFilme());
        } else {
            System.out.println("Assento já vendido ou inválido.");
        }
    }
    
}
