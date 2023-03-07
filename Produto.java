public class Produto {
    // A classe produto deve conter tão somente os detalhes apontados anteriormente
    // nao pode conter mecasnismo de entrada(e.g. Scanner).
    private String nomeProduto;
    private double preco;
    private int quantidade;

    public Produto(String name, double price, int quantity) {
        // metodo construtor do produto
        nomeProduto = name;
        quantidade = quantity;
        if (price > 0)
            preco = price;
        else {
            System.out.println("Valor invalido. Preco foi inicalizado com zero");
            preco = 0;
        }
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getnomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
