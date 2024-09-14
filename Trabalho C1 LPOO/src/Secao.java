// b) Classe Seção que tem os seguintes atributos:
// • de classe : preço (50,00)
// No mínimo os métodos:
// • de instância: nome do filme e horário da seção
// • venda: recebe a fila e o assento. Se esse assento estiver desocupado, deve alterar
// para ocupado e retornar true e, se o assento estiver ocupado retorna false.

public class Secao {
    private String nomeFilme;
    private String horario;
    private static double precoFilme = 50.00;
    private Assento assento; 
    

    public Secao(String nomeFilme, String horario) {
        this.nomeFilme = nomeFilme;
        this.horario = horario;
        this.assento = new Assento();
    }

    public Assento getAssento() {
        return assento;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getHorario() {
        return horario;
    }

    public static double getPrecoFilme() {
        return precoFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    //Mostra os lugares
    public void mostrarLugaresSecao() {
        System.out.println(assento.mostraLugares());
    }

    public boolean venda(int fila, int lugar) {
        return assento.venderAssento(fila, lugar); // Chama o método da classe Assento
    }
}
