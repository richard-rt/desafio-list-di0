import java.util.*;

public class Main {
    public static void main(String[] args) {

        verificarMediaTemperatura();
        verficarSuspeitoDoCrime();
    }

    private static void verficarSuspeitoDoCrime() {
        Scanner scanner = new Scanner(System.in);
        List<String> perguntas = Arrays.asList("Telefonou para a vítima?", "Esteve no local do crime?", "Mora perto da vítima?", "Devia para a vítima?", "Já trabalhou com a vítima?");

        int nivelSuspeito = 0;
        for (String pergunta : perguntas) {

            String resposta;
            do {
                System.out.println(pergunta + " *Digite yes/no*");
                resposta = scanner.nextLine().trim().toLowerCase();
            } while (!resposta.equals("yes") && !resposta.equals("no"));

            if (resposta.equals("yes")) {
                nivelSuspeito += 1;
            }
        }

        if (nivelSuspeito == 2) {
            System.out.println("O indivíduo pode ser um Suspeito");

        } else if (nivelSuspeito == 3 || nivelSuspeito == 4) {
            System.out.println("O indivíduo pode ser um Cúmplise");

        } else if (nivelSuspeito == 5) {
            System.out.println("O indivíduo pode ser um Assassino");

        } else {
            System.out.println("O indivíduo não tem envolvimento com a vitima");
        }
    }


    private static void verificarMediaTemperatura() {
        Scanner scanner = new Scanner(System.in);
        List<String> meses = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho");
        List<Double> temperaturaMeses = new ArrayList<>();

        for (String mes : meses) {
            System.out.println("Digite abaixo a temperatura do mês de " + mes + ":");
            Double temperaturaMes = Double.parseDouble(scanner.next());
            temperaturaMeses.add(temperaturaMes);
        }

        int somaTemperatura = 0;
        for (Double temperatura : temperaturaMeses) {
            somaTemperatura += temperatura;
        }

        int mediaTemperatura = somaTemperatura / temperaturaMeses.size();

        for (Double temperatura : temperaturaMeses) {
            if (temperatura > mediaTemperatura) {
                int posicaoMes = temperaturaMeses.indexOf(temperatura);
                System.out.println("No mês de " + meses.get(posicaoMes) + " a temperatura foi maior que a média de todos os outros meses");
            }
        }
    }
}