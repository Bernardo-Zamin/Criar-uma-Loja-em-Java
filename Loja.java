public class Loja {
    // deve conter o estoque
    // conter informacoes sobre a movimentacao financeira
    // nao pode conter mecasnismo de entrada(e.g. Scanner).
    private int nProdutos;
    private Produto[] listaPC = new Produto[100];
    private int qtdVendas;
    private int qtdProdutosVendidos;
    private double valorTotalVendas;

    public boolean criarProduto(String name, double price, int quantity) {
        if (nProdutos < 100) {
            listaPC[nProdutos] = new Produto(name, price, quantity);
            nProdutos++;
            return true;
        } else
            return false;
    }

    public void listarProdutosDisponiveis() {
        for (int i = 0; i < nProdutos; i++) {
            if (listaPC[i].getQuantidade() > 0)
                System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n", listaPC[i].getQuantidade(), i,
                        listaPC[i].getnomeProduto(), listaPC[i].getPreco());
        }
    }

    public void listarProdutos() {
        if (nProdutos == 0)
            System.out.println("Nao há produtos cadastrados");
        else {
            System.out.println("Ha " + nProdutos + " produtos cadastrados");
            for (int i = 0; i < nProdutos; i++)
                System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n", listaPC[i].getQuantidade(), i,
                        listaPC[i].getnomeProduto(), listaPC[i].getPreco());
        }
    }

    public void adicionarProduto(String name1, int quantity1) {
        for (int i = 0; i < nProdutos; i++) {
            if (name1.equals(listaPC[i].getnomeProduto())) {
                int qtdExistente = listaPC[i].getQuantidade();
                qtdExistente = qtdExistente + quantity1;
                listaPC[i].setQuantidade(qtdExistente);
            }
        }
    }

    public void listagemProdutos(int opcao3) {
        switch (opcao3) {
            case 1:
                listarProdutos();
                break;
            case 2:
                for (int i = 0; i < nProdutos; i++) {
                    if (listaPC[i].getQuantidade() > 0)
                        System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n", listaPC[i].getQuantidade(), i,
                                listaPC[i].getnomeProduto(), listaPC[i].getPreco());
                }
                break;
            case 3:
                for (int i = 0; i < nProdutos; i++) {
                    if (listaPC[i].getQuantidade() == 0)
                        System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n", listaPC[i].getQuantidade(), i,
                                listaPC[i].getnomeProduto(), listaPC[i].getPreco());
                }
                break;
        }
    }

    // compra o produto, com loop para verificar todos
    public void compraProduto(String name2, int quantity2) {
        for (int i = 0; i < nProdutos; i++) {
            if (name2.equals(listaPC[i].getnomeProduto())) {

                int qtdExistente = listaPC[i].getQuantidade();
                if (quantity2 <= qtdExistente) {
                    qtdExistente = qtdExistente - quantity2;
                    listaPC[i].setQuantidade(qtdExistente);
                    valorTotalVendas = listaPC[i].getPreco() * quantity2 + valorTotalVendas;
                    qtdProdutosVendidos = qtdProdutosVendidos + quantity2;
                    qtdVendas++;
                    System.out.println("Compra confirmada");
                } else {
                    System.out.println("Estoque insuficiente para sua compra");
                }
            }
        }
    }

    // consultar quanttidade de produtos vendidos
    public int getProdutosVendidos() {
        return qtdProdutosVendidos;
    }

    // consultar qtd vendas
    public int getVendas() {
        return qtdVendas;
    }

    // consultar valor total das vendas
    public double getValorVendas() {
        return valorTotalVendas;
    }

}
