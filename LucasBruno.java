/**
 @Trabalho 1
 @author LucasHartmann 
 */

import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Month;

public class LucasBruno{

    public static void menu(){
        System.out.println("Digite o número da opção abaixo \n");
        System.out.println("1. Descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta.");
        System.out.println("2. Descobrir se a pessoa está de aniversário no dia que usou o programa. ");
        System.out.println("3. Descobrir o dia da semana que a pessoa nasceu.");
        System.out.println("4. Sair do programa\n");
        System.out.println("Opcão:");
    }

    public static void calculoidade(){
        System.out.println("\nVocê entrou em descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta.\n");

        Scanner input = new Scanner(System.in);
        /**
         Obter dados do Usuário
         */
        System.out.println("Que dia você nasceu? (Digite usando números)");

        int dia = input.nextInt();
        if (dia<=31){System.out.println("Que mês você nasceu? (Digite usando números)");}

        int mes = input.nextInt();

        if (mes<=12){System.out.println("Que ano você nasceu?(Digite usando números)");}

        int ano = input.nextInt();

        if (ano>=1900){System.out.println("Em que horário você nasceu? (Digite usando números)");}

        String horario = input.nextLine();
        horario = input.nextLine();

        int number = Integer.parseInt(horario);
        LocalDate currentDate = LocalDate.now();
        int date = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();

        int idadeEmAnos;
        idadeEmAnos = year - ano;

        if (month < mes){idadeEmAnos = year - ano - 1;}
        else if (month == mes && date < dia){idadeEmAnos = year - ano - 1;}
        else if (month == mes && date == dia && hour < number){idadeEmAnos = year - ano - 1;}


        /**
         Exibir dados obtidos
         */

        System.out.println("\nVocê nasceu em " + dia + "/" + mes + "/" + ano
                + " na hora " + horario + "\n" + "Você tem " + idadeEmAnos + " anos");



        /**
         Realizar o cálculo de dias, meses, anos, horas e minutos que o usuário já viveu
         */

        System.out.println("\nVocê ja viveu: " + idadeEmAnos + " anos");

        int idadeEmMeses;
        idadeEmMeses = 11 - mes + idadeEmAnos * 12;
        if (month < mes){idadeEmMeses = 11 - mes + idadeEmAnos * 12 + month;}
        System.out.println("Você ja viveu: " + idadeEmMeses + " meses");

        int idadeEmDias;
        idadeEmDias = idadeEmAnos * 365;
        System.out.println("Você ja viveu: " + idadeEmDias + " dias");

        int idadeEmHoras;
        idadeEmHoras = 24 * idadeEmDias;
        System.out.println("Você ja viveu: " + idadeEmHoras + " horas");

        int idadeEmMinutos;
        idadeEmMinutos = 60 * idadeEmHoras;
        System.out.println("Você ja viveu: " + idadeEmMinutos + " minutos\n");



    }

    public static void aniversario(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nVocê entrou em descobrir se a pessoa está de aniversário no dia que usou o programa.\n");

        System.out.println("Que dia você nasceu? (Digite usando números)");
        int dia = input.nextInt();
        if (dia<=31){System.out.println("Que mês você nasceu? (Digite usando números)");}
        int mes = input.nextInt();


        LocalDate currentDate = LocalDate.now();
        int date = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        int calcMes;
        if (mes <= month){
            calcMes = ((mes + 12) - month);
        } else {
            calcMes = (mes - month);
        }

        int calcDias;
        if (dia <= date) {
            calcDias = ((dia + 30) - date);
        } else {
            calcDias = (dia - date);
        }

        if (dia == dia && mes == month){
            System.out.println("PARABÉNS!!! Você está de aniversário hoje!!!");
        } else if (month > mes) {
            // if else para ver quando vai ser o aniversario ou quando foi o aniversario
            System.out.println("Infelizmente hoje não é seu aniversário, seu aniversário foi dia "+dia+"/"+mes); // variavel com dia do aniversaio
            System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
        } else {
            System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
        }


    }

    public static void nascimento(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nVocê entrou em descobrir o dia da semana que a pessoa nasceu.\n");

        System.out.println("Que dia você nasceu? (Digite usando números)");

        int dia = input.nextInt();
        if (dia<=31){System.out.println("Que mês você nasceu? (Digite usando números)");}

        int mes = input.nextInt();

        System.out.println("Que ano você nasceu?(Digite usando números)");

        int ano = input.nextInt();

        int a = ano - 1900;

        int b = a/4;

        int c = mes;

        int bissexto = a%4;

        /** A sora disse: As 3 condições para um determinado ano ser bissexto são:
         1. O ano é divisível por quatro, sem deixar resto;

         Então eu fiz: int bissexto = a%4; (a int bissexto vai me dar o resto da divisão da int A por quatro.)
         O if quer dizer que caso o resto da divisao da "int a" por 4 seja igual a 0 (ou seja, a divisao nao deixe resto), o B vai ser B-1. A int B é a/4, vai adicionar -1 quando o ano for bissexto */

        if (bissexto==0){b = a/4 - 1;}

        if (mes==1){c = 0;}
        if (mes==2){c = 3;}
        if (mes==3){c = 3;}
        if (mes==4){c = 6;}
        if (mes==5){c = 1;}
        if (mes==6){c = 4;}
        if (mes==7){c = 6;}
        if (mes==8){c = 2;}
        if (mes==9){c = 5;}
        if (mes==10){c = 0;}
        if (mes==11){c = 3;}
        if (mes==12){c = 5;}

        int d = dia - 1;
        int e = a + b + c + d;
        int f = e%7;

        if(f == 0){System.out.println("\nVocê nasceu em uma: Segunda Feira");}
        if(f == 1){System.out.println("\nVocê nasceu em uma: Terça Feira");}
        if(f == 2){System.out.println("\nVocê nasceu em uma: Quarta Feira");}
        if(f == 3){System.out.println("\nVocê nasceu em uma: Quinta Feira");}
        if(f == 4){System.out.println("\nVocê nasceu em uma: Sexta Feira");}
        if(f == 5){System.out.println("\nVocê nasceu em um: Sábado");}
        if(f == 6){System.out.println("\nVocê nasceu em um: Domingo");}

    }

    public static void sair(){
        System.out.println("\nVocê escolheu sair do programa");
        System.exit(4);
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    calculoidade();
                    break;

                case 2:
                    aniversario();
                    break;

                case 3:
                    nascimento();
                    break;

                case 4:
                    sair();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
