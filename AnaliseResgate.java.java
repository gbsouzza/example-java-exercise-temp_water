import java.util.Scanner;

public class AnaliseResgate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_AMOSTRAS = 12;
        double somaTemperaturas = 0;
        double maiorTemperatura = -11;
        double menorTemperatura = 11;

        for (int i = 1; i <= NUM_AMOSTRAS; i++) {
            double temperatura = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                System.out.print("Digite a temperatura " + i + " (entre -10 e 10): ");
                
                if (scanner.hasNextDouble()) {
                    temperatura = scanner.nextDouble();
                    
                    if (temperatura >= -10 && temperatura <= 10) {
                        entradaValida = true;
                    } else {
                        System.out.println("Valor inválido! A temperatura deve estar entre -10°C e 10°C.");
                    }
                } else {
                    System.out.println("Entrada inválida! Por favor, digite um número.");
                    scanner.next();
                }
            }

            somaTemperaturas += temperatura;

            if (temperatura > maiorTemperatura) {
                maiorTemperatura = temperatura;
            }

            if (temperatura < menorTemperatura) {
                menorTemperatura = temperatura;
            }
        }

        double media = somaTemperaturas / NUM_AMOSTRAS;
        
        System.out.println("\n--- Relatório de Análise ---");
        System.out.printf("Média das temperaturas: %.2f °C%n", media);
        System.out.printf("Maior temperatura registrada: %.2f °C%n", maiorTemperatura);
        System.out.printf("Menor temperatura registrada: %.2f °C%n", menorTemperatura);
        
        System.out.println("----------------------------");

        if (media > 8) {
            System.out.println("Status: Resgate VIÁVEL.");
            System.out.println("A água está a uma temperatura razoável.");
        } else if (media >= 0 && media <= 8) {
            System.out.println("Status: Resgate EXTREMAMENTE ARRISCADO (ALERTA VERMELHO).");
            System.out.println("A temperatura da água está próxima de 0°C. O risco de hipotermia é altíssimo.");
        } else {
             System.out.println("Status: RESGATE SUSPENSO (ÁGUA CONGELADA OU QUASE).");
             System.out.println("A temperatura média está abaixo de 0°C. Resgate em condições de gelo extremo.");
        }

        scanner.close();
    }
}