/**
 @Trabalho 1
 @author: LucasHartmann, matricula: 22103098 and Bruno Gallina, matricula: 22106133
 */

import java.time.LocalTime; // Importa o horário local da máquina
import java.util.Scanner; // Importa teclado para input do usuário
import java.time.LocalDate; // Importa o dia local da máquina

public class LucasBruno {


    public static void main(String[] args){
        menu();
    }

    public static void menu() { // Menu de opções para o usuário

        System.out.println("Digite o número da opção abaixo \n");
        System.out.println("1 - Descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta. ");
        System.out.println("2 - Descobrir se a pessoa está de aniversário no dia que usou o programa. ");
        System.out.println("3 - Descobrir o dia da semana que a pessoa nasceu. ");
        System.out.println("4 - Sair do programa\n");
        System.out.println("Opcão:");

        int option; // Espera o usuário retornar um número inteiro

        option = menuOption();

        switch (option){ // Permite que execute a opção de escolha
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

    public static int menuOption(){
        int option;
        try{   
            // Bloco de código para o programa tentar rodar em primeiro lugar
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            option = teclado.nextInt();
        } catch (Exception exception) {
            // Bloco de código para rodar em caso de erro, ou seja, quando não for um int
            System.out.println("Você não digitou um número, por favor, digite um número novamente.");
            menu();
            option = menuOption();
        }
        return option;
    }

    public static void calculoIdade() { //Nessa parte nós levamos em conta os anos bissextos 
        // Função que após input do usuário de ano, mês e dia. calcula quantos dias foram vividos pela data inserida
        System.out.println("\nVocê entrou em descobrir quantos dias, horas e minutos que você já viveu considerando a data da consulta.\n");

        Scanner input = new Scanner(System.in);
        try {
            /**
             Obter dados do Usuário
             */
            
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

           
            int date = currentDate.getDayOfMonth();
            int month = currentDate.getMonthValue();
            int year = currentDate.getYear();
            int hour = currentTime.getHour();
            int minute = currentTime.getMinute();
            
            int ano;
            int mes;
            int dia;

            do {
                System.out.println("Que dia você nasceu? (Digite usando números)");
                dia = input.nextInt();
            } while (dia < 1 || dia > 31); // Enquanto o usuário não digitar um número entre 1 e 31, ele volta para a função "do" acima
            {
            }

            do {
                System.out.println("Que mes você nasceu? (Digite usando números)");
                mes = input.nextInt();
            } while (mes < 1 || mes > 12);
            {
            }


            do {
                System.out.println("Que ano você nasceu? (Digite usando números)");
                ano = input.nextInt();
            } while (ano < 1900 || ano > year );
            {
            }

            System.out.println("Digite a hora em que você nasceu? (Digite usando números)");
            int hora = input.nextInt();
            
            System.out.println("Digite o minuto em que você nasceu? (Digite usando números)");
            int minuto = input.nextInt();
            

            int idadeEmAnos; // Cálculo para saber quantos anos a pessoa viveu a partir do input
            idadeEmAnos = year - ano;
            if (month < mes) {
                idadeEmAnos = year - ano - 1; 
            } else if (month == mes && date < dia) {
                idadeEmAnos = year - ano - 1;
            } else if (month == mes && date == dia && hour < hora) {
                idadeEmAnos = year - ano - 1;
            } else if (month == mes && date == dia && hour == hora && minute < minuto){
                idadeEmAnos = year - ano - 1;
            }

            /**
             Exibir dados obtidos
             */

            System.out.println("\nVocê nasceu em " + dia + "/" + mes + "/" + ano + " na hora " + hora + ":"+ minuto + "\n" + "Você tem " + idadeEmAnos + " anos");


            /**
             Realizar o cálculo de dias, meses, anos, horas e minutos que o usuário já viveu
             */
            System.out.println("Você já viveu: " + idadeEmAnos + " anos");

            int idadeEmMeses; // Cálculo para saber quantos meses a pessoa viveu
        
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

            int idadeEmDias; // Cálculo para saber idade em dias que a pessoa viveu

            idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date - 1);
            if (hour > hora) {
                idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
            } else if (hour == hora && minute > minuto){
                idadeEmDias = (idadeEmAnos * 365) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
            }
            if (bissexto == 0 && bissextooo == 0 && bissextoo > 0) {
                idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date - 1);
            } else if (hour > hora) {
                    idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
            } else if (hour == hora && minute > minuto){
                    idadeEmDias = (idadeEmAnos * 366) + ((12 - mes) * 31) + (31 - dia) + (((month - 1) * 31) + date);
            }

            System.out.println("Você já viveu: " + idadeEmDias + " dias");

            int idadeEmHoras; // Cálculo para saber quantas horas a pessoa viveu
            idadeEmHoras = ((idadeEmDias - 1) * 24) + hour + (24 - hora);
            System.out.println("Você já viveu: " + idadeEmHoras + " horas");

            int idadeEmMinutos; // Cálculo para saber quantos minutos a pessoa viveu
            idadeEmMinutos = (idadeEmHoras * 60) + minute + minuto;
            System.out.println("Você já viveu: " + idadeEmMinutos + " minutos\n");

        } catch (Exception e) { // Tratamento de erros
            System.out.println("Método inválido\n");
        }
    }

    public static void aniversario() { // Função para saber sobre o aniversário do usuário
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nVocê entrou em descobrir se a pessoa está de aniversário no dia que usou o programa.\n");
            int dia = 0;
            int mes = 0;
            do {
                System.out.println("Que dia você nasceu? (Digite usando números)");
                dia = input.nextInt();
            } while (dia < 1 || dia > 31);
            {
            }
            do {
                System.out.println("Que mês você nasceu? (Digite usando números)");
                mes = input.nextInt();
            } while (mes < 1 || mes > 12);
            {
            }

            LocalDate currentDate = LocalDate.now();
            int date = currentDate.getDayOfMonth();
            int month = currentDate.getMonthValue();

            int aniverMes; 
            if (mes <= month) {
                aniverMes = ((mes + 12) - month);
            } else {
                aniverMes = (mes - month);
            }

            int aniverDias;
            if (dia <= date) {
                aniverDias = ((dia + 30) - date);
            } else {
                aniverDias = (dia - date);
            }

            if (dia == dia && mes == month) {
                System.out.println("Você está de aniversário hoje! Parabéns!");
            } else if (month > mes) {
                System.out.println("Seu aniversário foi dia " + dia + "/" + mes + "\n");
                System.out.println("Faltam " + aniverMes + " mês(es) e " + aniverDias + " dias para o seu aniversário. \n");
            } else {
                System.out.println("Faltam " + aniverMes + " mês(es) e " + aniverDias + " dias para o seu aniversário. \n");
            }
        } catch (Exception e) {
            System.out.println("Método inválido\n");
        }

    }

    public static void nascimento() { // Função que após input do usuário, retorna o dia por extenso em que a pessoa nasceu!
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("\nVocê entrou em descobrir o dia da semana que a pessoa nasceu.\n");
            int dia = 0;
            int mes = 0;
            int ano = 0;

            do {
                System.out.println("Que dia você nasceu? (Digite usando números)");
                dia = input.nextInt();
            } while (dia < 1 || dia > 31);
            {
            }
            do {
                System.out.println("Que mes você nasceu? (Digite usando números)");
                mes = input.nextInt();
            } while (mes < 1 || mes > 12);
            {
            }

            do {
                System.out.println("Que ano você nasceu? (Digite usando números)");
                ano = input.nextInt();

            } while (ano < 1900);
            {
            }


            int a = ano - 1900;

            int b = a / 4;

            int c = mes;

            int bissexto = a % 4;

            int bissextoo = a % 100;

            int bissextooo = a % 400;

            if (bissexto == 0 && bissextooo == 0 && bissextoo > 0) {
                b = a / 4 - 1;
            }

            if (mes == 1) {
                c = 0;
            }
            if (mes == 2) {
                c = 3;
            }
            if (mes == 3) {
                c = 3;
            }
            if (mes == 4) {
                c = 6;
            }
            if (mes == 5) {
                c = 1;
            }
            if (mes == 6) {
                c = 4;
            }
            if (mes == 7) {
                c = 6;
            }
            if (mes == 8) {
                c = 2;
            }
            if (mes == 9) {
                c = 5;
            }
            if (mes == 10) {
                c = 0;
            }
            if (mes == 11) {
                c = 3;
            }
            if (mes == 12) {
                c = 5;
            }

            int d = dia - 1;
            int e = a + b + c + d;
            int f = e % 7;

            if (f == 0) {
                System.out.println("\nVocê nasceu em uma: Segunda Feira");
            }
            if (f == 1) {
                System.out.println("\nVocê nasceu em uma: Terça Feira");
            }
            if (f == 2) {
                System.out.println("\nVocê nasceu em uma: Quarta Feira");
            }
            if (f == 3) {
                System.out.println("\nVocê nasceu em uma: Quinta Feira");
            }
            if (f == 4) {
                System.out.println("\nVocê nasceu em uma: Sexta Feira");
            }
            if (f == 5) {
                System.out.println("\nVocê nasceu em um: Sábado");
            }
            if (f == 6) {
                System.out.println("\nVocê nasceu em um: Domingo");
            }
        } catch (Exception e) {
            System.out.println("Método invalido\n");
        }
    }

    public static void sair() { 
        System.out.println("\nVocê escolheu sair do programa");
        System.exit(4);
    }

    }