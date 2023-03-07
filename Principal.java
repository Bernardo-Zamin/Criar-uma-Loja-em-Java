import java.util.Scanner;

public class Principal {
    // deve conter o menu para atuacao sobre a loja
    // Nenhum produto pode ser manipulado diretamente a partir da classe principal
    // Toda entrada de dados deve vir da classe principal
    public static void main(String[] args) {
        Scanner usr = new Scanner(System.in);
        Loja xz = new Loja();
        int escolha;

        String name;
        double price;
        int quantity;

        do {
            escolha = menuLoja();
            switch (escolha) {
                case 1:
                    System.out.println(" --> 1 Cadastrar produto");
                    System.out.println(" --> 2 Entrada de produtos em estoque");
                    System.out.println(" --> 3 Visualização de produtos cadastrados e suas quantidades");
                    int opcao1 = usr.nextInt();
                    usr.nextLine();
                    switch (opcao1) {

                        case 1:
                            System.out.println(" --> Cadastrar produto");
                            System.out.println("   Declare o nome do produto a ser cadastrado: ");
                            name = usr.nextLine();
                            System.out.println("   Declare o preco do produto: ");
                            price = Double.parseDouble(usr.nextLine());
                            System.out.println("   Declare a quantidade do produto a ser registrada: ");
                            quantity = usr.nextInt();
                            xz.criarProduto(name, price, quantity);
                            break;
                        case 2:
                            System.out.println(" --> Listar produtos");
                            xz.listarProdutos();
                            System.out.println("Escolha um produto para adicionar estoque:");
                            String name1 = usr.nextLine();
                            System.out.println("Digite a quantidade de produto para adicionar ao estoque:");
                            int quantity1 = usr.nextInt();
                            xz.adicionarProduto(name1, quantity1);
                            break;
                        case 3:
                            System.out.println(" --> 1 Todos os produtos já cadastrados");
                            System.out.println(" --> 2 Só os produtos disponíveis");
                            System.out.println(" --> 3 Só os produtos que estão com estoque zerado");
                            int opcao3 = usr.nextInt();
                            xz.listagemProdutos(opcao3);
                    }
                    break;
                case 2:
                    System.out.println(" --> Selecionar produtos e definir a quantidade a ser comprada");
                    int opcao2 = 1;
                    usr.nextLine();
                    switch (opcao2) {
                        case 1:

                            System.out.println("Qual produto deseja? ");
                            xz.listarProdutosDisponiveis();
                            String name2 = usr.nextLine();
                            System.out.println("Quantidade de produto: ");
                            int quantity2 = usr.nextInt();
                            System.out.println("Deseja finalizar a compra?");
                            System.out.println("1 para sim e 2 para não.");
                            int confirmarCompra = usr.nextInt();

                            switch (confirmarCompra) {
                                case 1:
                                    xz.compraProduto(name2, quantity2);
                                    break;
                                case 2:
                                    System.out.println("Compra cancelada");
                                    break;
                            }

                            break;
                    }
                    break;
                case 3:
                    System.out.println("1- A quantidade de produtos vendidos");
                    System.out.println("2- A quantidade de vendas");
                    System.out.println("3- O valor total das vendas");
                    System.out.println("4- O valor médio das vendas");
                    int opcao3 = usr.nextInt();
                    switch (opcao3) {
                        case 1:
                            System.out.println("A quantidade de produtos vendidos foram: " + xz.getProdutosVendidos());
                            break;
                        case 2:
                            System.out.println("A quantidade de vendas executadas foram: " + xz.getVendas());
                            break;
                        case 3:
                            System.out.println("O valor total das vendas foi de:  " + xz.getValorVendas());
                            break;
                        case 4:
                            double x = xz.getValorVendas();
                            double y = xz.getVendas();
                            double mediaValorTotal = x / y;
                            System.out.println("O valor medio das vendas foi de: " + mediaValorTotal);
                            break;
                    }
                    break;
            }

        } while (escolha != 0);
    }

    public static int menuLoja() {
        int opcao;
        Scanner usr = new Scanner(System.in);
        do {
            System.out.println("----Sistema de loja----");
            System.out.println(" - 1 Gerenciamento de Estoque");
            System.out.println(" - 2 Registro de Compras");
            System.out.println(" - 3 Sistema de Controle da Loja");
            System.out.println(" - 0 Sair da Loja");
            System.out.println("Escolha a opcao: ");
            opcao = usr.nextInt();
            if (opcao == 0)
                System.out.println("Saindo...Volte sempre!");
        } while (opcao < 0 || opcao > 3);
        return opcao;
    }
}