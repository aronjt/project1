package org.progmatic;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Üdvözöl a SzemShit");
        String answer;
        int answerNumber;
        String filePath;
        Scanner sc = new Scanner(System.in);
        Reader reader = new Reader();


        do {
            System.out.println("Szeretnél tutorial-t? (Igen/Nem)");
            answer = sc.nextLine().toLowerCase();

        } while (!answer.equals("igen") && !answer.equals("nem"));
        if (answer.equals("igen")) {
            System.out.println("A SzemShit programmal az alábbi dolgokat tudod csinálni:");
            System.out.println("A program két dologra képes: \"Szemantikai elemzésre\" valamint \"Bullshit generálásra\".");
            System.out.println("Azt, hogy melyiket csinálja, azt te döntöd el!");
            System.out.println("A Szemantikai elemzés az alábbiakat adja vissza:");
            System.out.println("-Leggyakoribb szavak");
            System.out.println("-A szövegre jellemző leggyakoribb szavak");
            System.out.println("-Leggyakoribb nevek");
            System.out.println("A Bullshit generátor az alábbiakat tudja:");
            System.out.println("-A szövegből random kiemel szavakat és összeteszi tetszőleges hosszúságban");
            System.out.println("-A szövegre legjellemzőbb szavakból állít össze egy mondatot tetszőleges hosszúságban");

        } else {
            System.out.println("Bocs haver csak kérdeztem.");
        }
        System.out.println("Saját szöveget szeretnél használni? ");
        sc = new Scanner(System.in);
        answer = sc.nextLine().toLowerCase();
        if (answer.equals("igen")) {
            System.out.println("Írd be a fájl útvonalát az alábbi séma szerint: files/proba.txt");
            sc = new Scanner(System.in);
            filePath = sc.nextLine().toLowerCase();
        } else {
            filePath = "files/testamentum.txt";
        }
        do {
            System.out.println("A program melyik részét szeretnéd használni?(bullshit/szemantika)");
            sc = new Scanner(System.in);
            answer = sc.nextLine().toLowerCase();
        } while (!answer.equals("bullshit") && !answer.equals("szemantika"));
        if (answer.equals("bullshit")) {
            Bullshit bullshit = new Bullshit(reader.read(filePath));
            do {
                System.out.println("Milyen Bullshitet generáljunk neked?(Random/top10)");
                sc = new Scanner(System.in);
                answer = sc.nextLine().toLowerCase();
            } while (!answer.equals("random") && !answer.equals("top10"));
            if (answer.equals("random")) {
                System.out.println("Megakarod adni a hosszúságát?(Igen/Nem)");
                sc = new Scanner(System.in);
                answer = sc.nextLine().toLowerCase();
                if (answer.equals("igen")) {
                    char[] ansArr;
                    System.out.println("Hány szóból álljon?");
                    do {
                        System.out.println("Írj be egy számot");
                        sc = new Scanner(System.in);
                        answer = sc.nextLine();
                        ansArr = answer.toCharArray();
                    } while (!Character.isDigit(ansArr[0]));
                    answerNumber = Integer.parseInt(answer);
                    System.out.println("A mondatod:");
                    bullshit.generateBullShitRandomOrderFromText(answerNumber);
                } else {
                    System.out.println("A mondatod:");
                    bullshit.generateBullShitRandomOrderFromText((int) (Math.random() * 50 + 1));
                }
            } else {
                System.out.println("Megakarod adni a hosszúságát?(Igen/Nem)");
                sc = new Scanner(System.in);
                answer = sc.nextLine().toLowerCase();

                if (answer.equals("igen")) {
                    System.out.println("Hány szóból álljon?");
                    char[] ansArr;
                    do {
                        System.out.println("Írj be egy számot");
                        sc = new Scanner(System.in);
                        answer = sc.nextLine();
                        ansArr = answer.toCharArray();
                    } while (!Character.isDigit(ansArr[0]));
                    answerNumber = Integer.parseInt(answer);
                    System.out.println("A mondatod:");
                    bullshit.generateBullShitWithTopWords(answerNumber);
                } else {
                    System.out.println("A mondatod:");
                    bullshit.generateBullShitWithTopWords((int) (Math.random() * 50 + 1));
                }
            }
        } else {
            Szemantika szemantika = new Szemantika(reader.read(filePath));
            do {
                System.out.println("Milyen szemantikai elemzést szeretnél? (top10/ top10szoveg/ topnev)");
                sc = new Scanner(System.in);
                answer = sc.nextLine().toLowerCase();
            } while (!answer.equals("top10") && !answer.equals("top10szoveg") && !answer.equals("topnev"));
            if (answer.equals("top10")) {
                System.out.println("Top 10 szó a szövegből:");
                System.out.println(szemantika.top10(szemantika.wordsNum()));
            } else if (answer.equals("top10szoveg")) {
                System.out.println("Top 10 szó ami a szövegre jellemző");
                System.out.println(szemantika.top10WithOutCommon(szemantika.wordsNum()));
            } else {
                System.out.println("Legtöbbször előfurduló nevek:");
                System.out.println(szemantika.top10Name(szemantika.bigCapital()));
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("Ennyi volt a program, köszönöm, hogy használtál!");
    }
}
