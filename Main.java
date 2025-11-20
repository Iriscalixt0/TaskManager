import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tarefa[] tarefas = new Tarefa[100];

        int totalTarefas = 0;

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== GESTOR DE TAREFAS ===");
            System.out.println("1 - Cadastrar tarefa");
            System.out.println("2 - Listar tarefas pendentes");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Filtrar por prioridade");
            System.out.println("5 - Alertar prazos próximos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                System.out.print("Título da tarefa: ");
                String titulo = sc.nextLine();

                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Prioridade (1 a 3): ");
                int prioridade = sc.nextInt();
                sc.nextLine();

                System.out.print("Prazo (AAAA-MM-DD): ");
                String dataStr = sc.nextLine();

                LocalDate prazo = LocalDate.parse(dataStr);

                Tarefa nova = new Tarefa(titulo, descricao, prioridade, prazo);

                tarefas[totalTarefas] = nova;
                totalTarefas++;

                System.out.println("Tarefa cadastrada com sucesso!");
            }

            else if (opcao == 2) {
                System.out.println("\n=== TAREFAS PENDENTES ===");

                boolean encontrou = false;

                for (int i = 0; i < totalTarefas; i++) {
                    if (!tarefas[i].isConcluida()) {
                        System.out.println((i + 1) + " - " + tarefas[i]);
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Nenhuma tarefa pendente.");
                }
            }

            else if (opcao == 3) {
                System.out.println("\n=== MARCAR COMO CONCLUÍDA ===");

                for (int i = 0; i < totalTarefas; i++) {
                    System.out.println((i + 1) + " - " + tarefas[i]);
                }

                System.out.print("Informe o número da tarefa: ");
                int num = sc.nextInt();
                sc.nextLine();

                if (num < 1 || num > totalTarefas) {
                    System.out.println("Número inválido.");
                } else {
                    tarefas[num - 1].concluir();
                    System.out.println("Tarefa concluída!");
                }
            }

            else if (opcao == 4) {

                System.out.print("Informe a prioridade (1 a 3): ");
                int p = sc.nextInt();
                sc.nextLine();

                System.out.println("\n=== TAREFAS COM PRIORIDADE " + p + " ===");
                boolean achou = false;

                for (int i = 0; i < totalTarefas; i++) {
                    if (tarefas[i].getPrioridade() == p) {
                        System.out.println(tarefas[i]);
                        achou = true;
                    }
                }

                if (!achou) {
                    System.out.println("Nenhuma tarefa com esta prioridade.");
                }
            }

            else if (opcao == 5) {

                LocalDate hoje = LocalDate.now();
                LocalDate limite = hoje.plusDays(3);

                System.out.println("\n=== TAREFAS COM PRAZOS PRÓXIMOS (até 3 dias) ===");
                boolean achou = false;

                for (int i = 0; i < totalTarefas; i++) {
                    if (!tarefas[i].isConcluida() &&
                        !tarefas[i].getPrazo().isAfter(limite)) {

                        System.out.println(tarefas[i]);
                        achou = true;
                    }
                }

                if (!achou) {
                    System.out.println("Nenhuma tarefa com prazo próximo.");
                }
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
