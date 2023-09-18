import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public void emprestar() {
        if (!emprestado) {
            emprestado = true;
            System.out.println("Livro \"" + titulo + "\" emprestado com sucesso.");
        } else {
            System.out.println("Livro \"" + titulo + "\" já está emprestado.");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println("Livro \"" + titulo + "\" devolvido com sucesso.");
        } else {
            System.out.println("Livro \"" + titulo + "\" não está emprestado.");
        }
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | Autor: " + autor + " | Empréstimo: " + (emprestado ? "Sim" : "Não");
    }
}

class Usuario {
    private String nome;
    private int id;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Registrar novo livro");
            System.out.println("2 - Registrar novo usuário");
            System.out.println("3 - Empréstimo de livro");
            System.out.println("4 - Devolução de livro");
            System.out.println("5 - Listar livros emprestados");
            System.out.println("0 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    livros.add(new Livro(tituloLivro, autorLivro));
                    break;
                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o número de identificação do usuário: ");
                    int idUsuario = scanner.nextInt();
                    usuarios.add(new Usuario(nomeUsuario, idUsuario));
                    break;
                case 3:
                    System.out.print("Digite o ID do usuário: ");
                    int idEmprestimo = scanner.nextInt();
                    System.out.print("Digite o título do livro a ser emprestado: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String tituloEmprestimo = scanner.nextLine();
                    emprestarLivro(livros, usuarios, idEmprestimo, tituloEmprestimo);
                    break;
                case 4:
                    System.out.print("Digite o ID do usuário: ");
                    int idDevolucao = scanner.nextInt();
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String tituloDevolucao = scanner.nextLine();
                    devolverLivro(livros, usuarios, idDevolucao, tituloDevolucao);
                    break;
                case 5:
                    listarLivrosEmprestados(livros);
                    break;
                case 0:
                    System.out.println("Saindo do sistema de biblioteca.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void emprestarLivro(List<Livro> livros, List<Usuario> usuarios, int idUsuario, String tituloLivro) {
        Livro livro = buscarLivroPorTitulo(livros, tituloLivro);
        Usuario usuario = buscarUsuarioPorId(usuarios, idUsuario);

        if (livro != null && usuario != null) {
            if (!livro.isEmprestado()) {
                livro.emprestar();
                System.out.println("Livro emprestado para " + usuario.getNome());
            } else {
                System.out.println("Livro já está emprestado.");
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public static void devolverLivro(List<Livro> livros, List<Usuario> usuarios, int idUsuario, String tituloLivro) {
        Livro livro = buscarLivroPorTitulo(livros, tituloLivro);
        Usuario usuario = buscarUsuarioPorId(usuarios, idUsuario);

        if (livro != null && usuario != null) {
            if (livro.isEmprestado()) {
                livro.devolver();
                System.out.println("Livro devolvido por " + usuario.getNome());
            } else {
                System.out.println("Livro não está emprestado.");
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public static Livro buscarLivroPorTitulo(List<Livro> livros, String titulo) {
        for (Livro livro : livros) {
            if (livro.toString().contains(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public static Usuario buscarUsuarioPorId(List<Usuario> usuarios, int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static void listarLivrosEmprestados(List<Livro> livros) {
        System.out.println("Livros emprestados:");
        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                System.out.println(livro);
            }
        }
    }
}
