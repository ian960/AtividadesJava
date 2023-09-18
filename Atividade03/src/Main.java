import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Atendente Virtual da Loja!");
        System.out.println("Por favor, escolha uma das opções abaixo:");
        System.out.println("1 - Comprar um item");
        System.out.println("2 - Solicitar o valor de um produto ou serviço");
        System.out.println("3 - Falar com um atendente");
        System.out.println("0 - Sair");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Você escolheu comprar um item. Por favor, navegue em nosso catálogo online.");
                break;
            case 2:
                System.out.println("Você escolheu solicitar o valor de um produto ou serviço. Por favor, informe-nos o que deseja saber o preço.");
                break;
            case 3:
                System.out.println("Você escolheu falar com um atendente. Aguarde um momento, e um de nossos atendentes estará com você em breve.");
                break;
            case 0:
                System.out.println("Obrigado por usar nosso Atendente Virtual. Tenha um ótimo dia!");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida do menu.");
        }

        scanner.close();
    }
}
