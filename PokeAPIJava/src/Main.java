import java.sql.SQLOutput;
import java.util.Scanner;

/*
 * File: Main.java
 *
 * Autor: EskeminhaDEV
 * Data: 6/28/2024 (MM/DD/YYYY).
 *
 * Description:
 *      This is the Main method.
 *      This class must handle users inputs.
 *      This class will provide a short text menu in Terminal for the user to chosse which action to take.
 *
 * TODO:
 *      PokeAPIJava
 *      This project will be structured to handle HTTP requests, parse JSON, and handle user inputs via the console.
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        /*
            TODO: Menu
                Search by Pokémon Name
                    Show details about Pokémon
                Search by Pokémon Number
                    Show details about Pokémon
         */

        Scanner scanner = new Scanner(System.in);
        Pokemon pokemon;

        while(true) {
            System.out.println("Welcome to the PokeAPIJava.");
            System.out.println("Please, select the desired option below:");
            System.out.println("1. Search by Pokemon Name.");
            System.out.println("2. Search by Pokemon Number.");
            System.out.println("87. Exit.");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter Pokémon name: ");
                    String name = scanner.nextLine();
                    System.out.println("Searching for... " + name);
                    pokemon = HttpUtil.getPokemonFromAPI(name);
                    System.out.println(pokemon);
                    break;
                case "2":
                    System.out.println("Enter Pokémon number: ");
                    String pokeNumber = scanner.nextLine();
                    System.out.println("Searching for... " + pokeNumber);
                    pokemon = HttpUtil.getPokemonFromAPI(pokeNumber);
                    System.out.println(pokemon);
                    break;
                case "87":
                    System.out.println("Thanks for using this super app. I am really proud of you.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
    }
}