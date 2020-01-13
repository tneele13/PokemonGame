package nl.delphinity.pokemon.model.area;

import java.util.Scanner;
import nl.delphinity.pokemon.model.general.Game;
import nl.delphinity.pokemon.model.general.Pokemon;
import nl.delphinity.pokemon.model.general.PokemonData;
import nl.delphinity.pokemon.model.item.ItemType;
import nl.delphinity.pokemon.model.trainer.Trainer;

public class Shop {
	public static int currency = 5;
	private static final Scanner sc = new Scanner(System.in);
	private static final Scanner sc1 = new Scanner(System.in);
	private Trainer trainer = null;

	public Shop() {
		this.currency = currency;
	}

	public void kopen() {
		System.out.println("Wat wilt u kopen?");
		System.out.println(
				"1) Heal Potion : 5$ \n2) Pokeball 2$\n3) Een Klap voor je kanis is +10$\n4) pokemon shop\n5) Terug");
		int choice = sc.nextInt();
		if (choice == 1) {
			if (currency > 5) {
				currency = currency - 5;
				System.out.println("je hebt een heal potion gekocht");
				Game.trainer.getInventory().addItem(1, ItemType.HEALPOTION);
			} else {
				System.out.println("What? No money, HEREEE suck a cock.");
			}
		} else if (choice == 2) {
			if (currency > 2) {
				System.out.println("Hoeveel wil je er hebben?");
				int amount = sc.nextInt();
				if (amount <= (currency / 2)) {
					currency = currency - (amount * 2);
					System.out.println("Je hebt " + amount + " Pokeball's gekocht!");
					Game.trainer.getInventory().addItem(amount, ItemType.POKEBALL);
				} else {
					System.out.println("Je hebt niet genoeg geld voor dit aantal Pokeball's!");
					kopen();
				}
			} else {
				System.out.println("What? No money, HEREEE suck a cock.");
			}
		} else if (choice == 3) {
			if (currency >= 0) {
				currency = currency + 10;
				System.out.println("Als jij dat wilt");
			}
		} else if (choice == 4) {
			buyPokemon();
		} else if (choice == 5) {
			Game.showGameOptions();
		} else {
			kopen();
		}
	}

	public Pokemon buyPokemon() {
		System.out.print("Type the name of the pokemon you want! ==> ");
		System.out.println("\nEvery pokemon is $15");
		String pokemon = sc1.nextLine();
		String pokemon1 = pokemon.toUpperCase();
		// try catch zodat een verkeerde valueOf het programma niet crasht
		if (currency >= 15) {
			try {
				PokemonData p = PokemonData.valueOf(pokemon1);
				Pokemon choosen = new Pokemon(p);
				Game.trainer.getPokemonCollection().add(choosen);
				currency = currency - 15;
				return choosen;
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else {
			System.out.println("Sorry not enough money!");
		}
		return null;

	}

	public void geld() {
		System.out.println("Je hebt nog: " + currency + " Chinese kinderhandjes");
	}

	public static void salaris() {
		currency = currency + 2;
	}

	public static void gymLeaderDefeat() {
		currency = currency + 8;
	}
}