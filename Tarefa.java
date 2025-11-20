import java.time.LocalDate;

public class Tarefa {

    String titulo;
    String descricao;
    int prioridade;
    LocalDate prazo;
    boolean concluida;

    public Tarefa(String titulo, String descricao, int prioridade, LocalDate prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.prazo = prazo;
        this.concluida = false;
    }

    public void concluir() {
        this.concluida = true;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               " | Descrição: " + descricao +
               " | Prioridade: " + prioridade +
               " | Prazo: " + prazo +
               " | Concluída: " + (concluida ? "Sim" : "Não");
    }
}
