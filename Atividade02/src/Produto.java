class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
    }

    public void vender(int quantidade) {
        if (quantidadeEmEstoque >= quantidade) {
            quantidadeEmEstoque -= quantidade;
            System.out.println(quantidade + " unidades de " + nome + " vendidas.");
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    public void exibirEstoque() {
        System.out.println("Estoque de " + nome + ": " + quantidadeEmEstoque + " unidades.");
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Camiseta", 25.0, 50);

        produto.exibirEstoque();
        produto.adicionarEstoque(10);
        produto.exibirEstoque();
        produto.vender(20);
        produto.exibirEstoque();
    }
}
