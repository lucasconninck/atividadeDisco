import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Artista> artistas = new ArrayList<>();
    static ArrayList<Disco> discos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Cadastrar artista");
            System.out.println("2. Cadastrar disco");
            System.out.println("3. Listar discos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarArtista(scanner);
                    break;
                case 2:
                    cadastrarDisco(scanner);
                    break;
                case 3:
                    listarDiscos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    static void cadastrarArtista(Scanner scanner) {
        System.out.print("Nome do artista: ");
        String nome = scanner.nextLine();
        System.out.print("Gênero musical: ");
        String genero = scanner.nextLine();

        artistas.add(new Artista(nome, genero));
        System.out.println("Artista cadastrado com sucesso!");
    }

    static void cadastrarDisco(Scanner scanner) {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado. Cadastre um artista primeiro.");
            return;
        }

        System.out.print("Título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        System.out.println("Escolha um artista:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i).nome);
        }
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir quebra de linha

        if (escolha >= 0 && escolha < artistas.size()) {
            discos.add(new Disco(titulo, ano, artistas.get(escolha)));
            System.out.println("Disco cadastrado com sucesso!");
        } else {
            System.out.println("Artista inválido.");
        }
    }
    static void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        for (Disco disco : discos) {
            System.out.println("Título: " + disco.titulo);
            System.out.println("Ano: " + disco.ano);
            System.out.println("Artista: " + disco.artista.nome);
            System.out.println();
        }
    }
}

