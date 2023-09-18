import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        System.out.println("Bem-vindo ao Atendente Virtual da Loja!");

        while (!sair) {
            System.out.println("\nEscolha uma das opções abaixo:");
            System.out.println("1 - Comprar um item");
            System.out.println("2 - Solicitar o valor de um produto ou serviço");
            System.out.println("3 - Falar com um atendente");
            System.out.println("0 - Sair do Atendente Virtual");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Você escolheu comprar um item. Navegue em nosso catálogo online.");
                    break;
                case 2:
                    System.out.println("Você escolheu solicitar o valor de um produto ou serviço. Informe o que deseja saber o preço.");
                    break;
                case 3:
                    System.out.println("Você escolheu falar com um atendente. Aguarde um momento, e um de nossos atendentes estará com você em breve.");
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso Atendente Virtual. Tenha um ótimo dia!");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida do menu.");
            }
        }

        scanner.close();
    }
}
