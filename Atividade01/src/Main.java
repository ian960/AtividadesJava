import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de IMC");
        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(peso, altura);
        double imc = pessoa.calcularIMC();

        System.out.printf("Seu IMC é: %.2f%n", imc);

        scanner.close();
    }
}

class Pessoa {
    private double peso;
    private double altura;

    public Pessoa(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }
}







