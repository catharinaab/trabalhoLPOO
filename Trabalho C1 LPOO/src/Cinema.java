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
            System.out.println("    APLICATIVO CINEMA   \n" + 
            "\n1- Cadastrar Seção\n" + 
            "2- Vender Seções\n" +
            "3- Sair do Programa\n" +
            "\nEscolha uma opção para prosseguir: ");
            
            opcao = ler.next().charAt(0);

            switch (opcao) {
                case '1':
                    cadastrarSecao(secao);
                    break;
                case '2':
                    venderSecao(secao);
                    break;
                case '3':
                    System.out.println("\nSaindo do programa...\n");
                    System.exit(0);
                default:
                    System.out.println("\nCaractere incorreto! Favor digitar um  número de (1 a 3) para prosseguir!\n");
                    break;
            }
        } while (opcao != 3);
    
    }

    public static void cadastrarSecao(Secao[] secao) {
            if (quantSecao >= secao.length) {
                System.out.println("\nNúmero máximo de seções cadastradas.\n");
                return;
            }
    
            for (int i = quantSecao; i < secao.length; i++) {
                System.out.println("\n─ Cadastro da Seção " + (i + 1) + " ─\n");
    
                System.out.print("Digite o nome do filme: ");
                String nomeFilme = ler.next();
    
                System.out.print("\nDigite o horário da seção (ex: 20:00): ");
                String horario = ler.next();

                secao[i] = new Secao(nomeFilme, horario);
                quantSecao++;
            }
            System.out.println("\nTodas as seções foram cadastradas com sucesso!");
        }
    
    public static void venderSecao(Secao[] secao) {
        if (quantSecao == 0) {
            System.out.println("\nNenhuma seção cadastrada. Cadastre seções primeiro.");
            return;
        }
        //Exibição das Sessões:
        System.out.println("\nEscolha uma seção:");
        for (int i = 0; i < quantSecao; i++) {
            Secao secaos = secao[i];
            System.out.println((i + 1) + ": "  + "Filme em Cartaz: " + secaos.getNomeFilme() + "\n" + "─ " + "Horário: " + secaos.getHorario());
        }

        //Escolher uma Sessão cadastrada: 
        System.out.print("\nEscolha o número da seção: ");
        int escolha = ler.nextInt() - 1;
        ler.nextLine(); 

        System.out.println("  ");

        if (escolha < 0 || escolha >= quantSecao) {
            System.out.println("\nSeção inválida.");
            return;
        }

        Secao secaoEscolhida = secao[escolha];
        secaoEscolhida.mostrarLugaresSecao();

        //Escolher uma fila(0 a 4) e um assento(0 a 3):
        System.out.print("Escolha a fila (0 a " + (secaoEscolhida.getAssento().getNumFilas() - 1) + "): ");
        int fila = ler.nextInt();
        System.out.print("Escolha o assento (0 a " + (secaoEscolhida.getAssento().getNumAssentosPorFila() - 1) + "): ");
        int assento = ler.nextInt();
        ler.nextLine();

        //A venda doa sessão: 
        boolean sucesso = secaoEscolhida.venda(fila, assento);
        if (sucesso) {
            System.out.println("\nCompra realizada com sucesso! Preço: R$ " + Secao.getPrecoFilme() + "\n");
        } else {
            System.out.println("\nAssento já vendido ou inválido.");
        }
    }
    
}
