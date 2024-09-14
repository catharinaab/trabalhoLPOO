// 1 – Implemente as classes a seguir
// a) Classe Assento que tem o seguinte atributo:
// • disponivel[ ][ ] → uma matriz booleana (5 filas e 4 lugares em cada fila) que
// armazena true se o assento está disponível e false se tiver sido vendido.


// No mínimo o método:
// • mostraLugares → que deve retornar um String contendo as informações da matriz
// disponivel da seguinte maneira: Se o assento estiver ocupado, coloque um X, se
// ele estiver vazio, deixe em branco, como mostrada abaixo:
// | | | |
// | X | | |



public class Assento {
    private boolean[][] disponivel = new boolean[5][4];

    //Construtor para percorrer a matriz que começa em true.
    public Assento() {
        for (int i = 0; i < disponivel.length; i++) {
            for (int j = 0; j < disponivel[j].length; j++) {
                disponivel[i][j] = true;
            }
        }

    }
    
    //Mostra os assentos ocupados em | X | e se tiver em branco | |
    public String mostraLugares() {
        StringBuilder lugares = new StringBuilder();

        for(int i = 0; i < disponivel.length; i++) {
            lugares.append("|");

            for(int j = 0; j < disponivel[i].length; j++) {
                if (disponivel[i][j] == true) {
                lugares.append("  "); //<-- Tem assento
                } else {
                    lugares.append(" X ");
                }
            }
            lugares.append("|\n");
        }
        return lugares.toString();

    }

    //Vende e marca como ocupado.
    public void venderAssento(int fila, int lugar) {
        if (disponivel[fila][lugar]) {
            disponivel[fila][lugar] = false;
        } else {
            System.out.println("Assento já vendido.");
        }
    }

    
}
