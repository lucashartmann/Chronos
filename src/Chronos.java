import java.time.LocalTime; // Importa o horário local da máquina
import java.util.Scanner; // Importa teclado para input do usuário
import java.time.LocalDate; // Importa o dia local da máquina

public class Chronos {

    Scanner sc = new Scanner(System.in);
    Pessoa usuario;

    public void Executar() {
        menu();
    }

    public void menu() { // Menu de opções para o usuário

        System.out.println("Digite o número da opção abaixo desejada: \n");
        System.out.println(
                "1 - Descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta. ");
        System.out.println("2 - Descobrir se a pessoa está de aniversário no dia que usou o programa.");
        System.out.println("3 - Descobrir o dia da semana que a pessoa nasceu.");
        System.out.println("4 - Sair do programa\n");
        System.out.println("Opcão:");

        int option; // Espera o usuário retornar um número inteiro

        option = sc.nextInt();

        switch (option) { // Permite que execute a opção de escolha
            case 1:
                calculoIdade();
                System.out.println();
                break;
            case 2:
                aniversario();
                System.out.println();
                break;
            case 3:
                nascimento();
                System.out.println();
                break;
            case 4:
                sair();
                System.out.println();
                break;
            default:
                System.out.println("Você digitou uma opção inválida, por favor, digite um número de 1 a 4");
                menu();
                break;
        }
        menu();
    }

    public void cadastroDados() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int ano, mes, dia, hora, minuto;

        do {
            System.out.println("Que ano você nasceu? (Digite usando números)");
            ano = sc.nextInt();
        } while (ano < 1900 || ano > year);
        {
        }

        do {
            System.out.println("Que mês você nasceu? (Digite usando números)");
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);
        {
        }

        do {
            System.out.println("Que dia você nasceu? (Digite usando números)");
            dia = sc.nextInt();
        } while (dia < 1 || dia > 31);
        {
        }

        System.out.println("Digite a hora em que você nasceu (Digite usando números):");
        hora = sc.nextInt();

        System.out.println("Digite o minuto em que você nasceu (Digite usando números):");
        minuto = sc.nextInt();

        usuario = new Pessoa(ano, mes, dia, hora, minuto);
    }

    public void calculoIdade() {
        System.out.println(
                "\nVocê entrou em descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta.\n");

        try {
            if (usuario == null) {
                cadastroDados();
                calculoIdade();
            } else {
                int ano = usuario.getAno();
                int mes = usuario.getMes();
                int dia = usuario.getDia();
                int hora = usuario.getHora();
                int minuto = usuario.getMinuto();

                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();
                int date = currentDate.getDayOfMonth();
                int month = currentDate.getMonthValue();
                int year = currentDate.getYear();
                int hour = currentTime.getHour();
                int minute = currentTime.getMinute();
                int idadeEmAnos;

                idadeEmAnos = year - ano;
                if (month < mes) {
                    idadeEmAnos = year - ano - 1;
                } else if (month == mes && date < dia) {
                    idadeEmAnos = year - ano - 1;
                } else if (month == mes && date == dia && hour < hora) {
                    idadeEmAnos = year - ano - 1;
                } else if (month == mes && date == dia && hour == hora && minute < minuto) {
                    idadeEmAnos = year - ano - 1;
                }

                System.out.println("\nVocê nasceu em " + dia + "/" + mes + "/" + ano + " na hora " + hora + ":" + minuto
                        + "\n" + "Você tem " + idadeEmAnos + " anos");

                System.out.println("Você já viveu: " + idadeEmAnos + " anos");

                int idadeEmMeses;

                idadeEmMeses = idadeEmAnos * 12 + (12 - mes) + month;

                if (date < dia) {
                    idadeEmMeses = idadeEmAnos * 12 + (12 - mes) + month - 1;
                } else if (date == dia && hour < hora) {
                    idadeEmMeses = idadeEmAnos * 12 + (12 - mes) + month - 1;
                } else if (date == dia && hour == hora && minute < minuto) {
                    idadeEmMeses = idadeEmAnos * 12 + (12 - mes) + month - 1;
                }

                System.out.println("Você já viveu: " + idadeEmMeses + " meses");

                int a = ano - 1900;
                int bissexto = a % 4;
                int bissextoo = a % 100;
                int bissextooo = a % 400;

                int idadeEmDias;

                idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date - 1);
                if (hour > hora) {
                    idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
                } else if (hour == hora && minute > minuto) {
                    idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
                }
                if (bissexto == 0 && bissextooo == 0 && bissextoo > 0) {
                    idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia)
                            + (((month - 1) * 31) + date - 1);
                } else if (hour > hora) {
                    idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
                } else if (hour == hora && minute > minuto) {
                    idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
                }

                System.out.println("Você já viveu: " + idadeEmDias + " dias");

                int idadeEmHoras;
                idadeEmHoras = ((idadeEmDias - 1) * 24) + hour + (24 - hora);
                System.out.println("Você já viveu: " + idadeEmHoras + " horas");

                int idadeEmMinutos;
                idadeEmMinutos = (idadeEmHoras * 60) + minute + minuto;
                System.out.println("Você já viveu: " + idadeEmMinutos + " minutos\n");
            }

        } catch (Exception e) {
            System.out.println("Método inválido\n");
        }
    }

    public void aniversario() {
        try {
            if (usuario == null) {
                cadastroDados();
                aniversario();
            } else {
                int mes = usuario.getMes();
                int dia = usuario.getDia();

                System.out.println(
                        "\nVocê entrou em descobrir se a pessoa está de aniversário no dia que usou o programa.\n");

                LocalDate currentDate = LocalDate.now();
                int date = currentDate.getDayOfMonth();
                int month = currentDate.getMonthValue();
                int aniverMes, aniverDias;

                if (mes <= month) {
                    aniverMes = ((mes + 12) - month);
                } else {
                    aniverMes = (mes - month);
                }

                if (dia <= date) {
                    aniverDias = ((dia + 30) - date);
                } else {
                    aniverDias = (dia - date);
                }

                if (dia == date && mes == month) {
                    System.out.println("Você está de aniversário hoje! Parabéns!");
                } else {
                    System.out.println(
                            "Faltam " + aniverMes + " mês(es) e " + aniverDias + " dias para o seu aniversário. \n");
                }
            }
        } catch (Exception e) {
            System.out.println("Método inválido\n");
        }

    }

    public void nascimento() { // Função que retorna o dia em que a pessoa nasceu por extenso
        try {
            if (usuario == null) {
                cadastroDados();
                nascimento();
            } else {
                int ano = usuario.getAno();
                int mes = usuario.getMes();
                int dia = usuario.getDia();

                System.out.println("\nVocê entrou em descobrir o dia da semana que a pessoa nasceu.\n");

                int a = ano - 1900;
                int b = a / 4;
                int c = mes;
                int bissexto = a % 4;
                int bissextoo = a % 100;
                int bissextooo = a % 400;

                if (bissexto == 0 && bissextooo == 0 && bissextoo > 0) {
                    b = a / 4 - 1;
                }

                int[] valoresMes = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

                if (mes >= 1 && mes <= 12) {
                    c = valoresMes[mes - 1];
                } else {
                    System.out.println("\nValor inválido para o mês.");
                }

                int d = dia - 1;
                int e = a + b + c + d;
                int f = e % 7;

                String[] diasSemana = { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira",
                        "Sábado", "Domingo" };

                if (f >= 0 && f <= 6) {
                    System.out.println("Você nasceu: " + diasSemana[f]);
                } else {
                    System.out.println("Valor inválido para o dia da semana.");
                }
            }

        } catch (Exception e) {
            System.out.println("Método invalido\n");
        }
    }

    public void sair() {
        System.out.println("\nVocê escolheu sair do programa");
        System.exit(4);
    }
}
