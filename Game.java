package nl.delphinity.pokemon.model.general;

import nl.delphinity.pokemon.model.area.Area;
import nl.delphinity.pokemon.model.area.Pokecenter;
import nl.delphinity.pokemon.model.area.Shop;
import nl.delphinity.pokemon.model.battle.Battle;
import nl.delphinity.pokemon.model.item.ItemType;
import nl.delphinity.pokemon.model.trainer.Badge;
import nl.delphinity.pokemon.model.trainer.GymLeader;
import nl.delphinity.pokemon.model.trainer.Trainer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Game {

	private static final ArrayList<Area> areas = new ArrayList<>();
	private static final Scanner sc = new Scanner(System.in);
	public static Trainer trainer = null;
	private static Shop shop = new Shop();

	// set up the game in this static block
	static {

		// Mekka
		Pokecenter mekkaCenter = new Pokecenter("Mekka's Moskee");
		Area mekka = new Area("Mekka", null, false, null, mekkaCenter);
		mekka.setContainsPokemon(Arrays.asList(PokemonType.MARROKAAN, PokemonType.MARROKANENMOEDER,
				PokemonType.MARROKANENVADER, PokemonType.GEERTWILDERS));

		// PALLET Town
		Pokecenter palletCenter = new Pokecenter("Pallet Town's Pokecenter");
		Area palletTown = new Area("Pallet town", null, false, mekka, palletCenter);
		palletTown.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND));

		// VIRIDIAN City
		Pokecenter viridianCenter = new Pokecenter("Viridian City's Pokecenter");
		Area viridianCity = new Area("Viridian city", null, false, palletTown, viridianCenter);
		viridianCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND));

		// PEWTER City
		Pokecenter pewterCenter = new Pokecenter("Pewter City's Pokecenter");
		Area pewterCity = new Area("Pewter city", null, false, viridianCity, pewterCenter);
		pewterCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND));

		// Cerulean City
		Pokecenter ceruleanCenter = new Pokecenter("Cerulean city's Pokecenter");
		Area ceruleanCity = new Area("Cerulean city", null, true, pewterCity, ceruleanCenter);
		ceruleanCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND));

		areas.add(ceruleanCity);
		areas.add(viridianCity);
		areas.add(pewterCity);
		areas.add(palletTown);
		areas.add(mekka);

		// SETUP gym leaders
		GymLeader pewterLeader = new GymLeader("Bram", new Badge("Boulder Badge"), pewterCity);
		Pokemon p = new Pokemon(PokemonData.ONIX);
		p.setLevel(5);
		p.setOwner(pewterLeader);
		pewterLeader.setActivePokemon(p);
		pewterLeader.getPokemonCollection().add(p);
		pewterCity.setGymLeader(pewterLeader);

		// veridianCity
		GymLeader veridianLeader = new GymLeader("Gino", new Badge("Ground Badge"), viridianCity);
		Pokemon b = new Pokemon(PokemonData.SANDSHREW);
		b.setLevel(10);
		b.setOwner(veridianLeader);
		veridianLeader.setActivePokemon(b);
		veridianLeader.getPokemonCollection().add(b);
		viridianCity.setGymLeader(veridianLeader);

		// palletTown
		GymLeader palletLeader = new GymLeader("Rens", new Badge("Fire Badge"), palletTown);
		Pokemon c = new Pokemon(PokemonData.GROWLITHE);
		c.setLevel(15);
		c.setOwner(palletLeader);
		palletLeader.setActivePokemon(c);
		palletLeader.getPokemonCollection().add(c);
		palletTown.setGymLeader(palletLeader);

		// Curulean city
		GymLeader curuleanLeader = new GymLeader("Daniël", new Badge("Water Badge"), ceruleanCity);
		Pokemon d = new Pokemon(PokemonData.SQUIRTLE);
		d.setLevel(3);
		d.setOwner(curuleanLeader);
		curuleanLeader.setActivePokemon(d);
		curuleanLeader.getPokemonCollection().add(d);
		ceruleanCity.setGymLeader(curuleanLeader);

		// Curulean city
		GymLeader mekkaLeader = new GymLeader("Yousoef", new Badge("Free Palestina"), mekka);
		Pokemon e = new Pokemon(PokemonData.AHMED);
		e.setLevel(30);
		e.setOwner(mekkaLeader);
		mekkaLeader.setActivePokemon(e);
		mekkaLeader.getPokemonCollection().add(e);
		mekka.setGymLeader(mekkaLeader);
	}

	public static void main(String[] args) {
		System.out.println("                                  ,'\\\r\n"
				+ "    _.----.        ____         ,'  _\\   ___    ___     ____\r\n"
				+ "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\r\n"
				+ "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\r\n"
				+ " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\r\n"
				+ "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\r\n"
				+ "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\r\n"
				+ "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\r\n"
				+ "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\r\n"
				+ "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\r\n"
				+ "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\r\n"
				+ "                                `'                            '-._|");
//		System.out.println("Do you want to load a previos game?\n1 ) yes\n2 ) no");
//		int choice = sc.nextInt();
//		if (choice == 1) {
//			load();
//		} else {
			System.out.println("Welcome new trainer, what's your name?");
			String name = sc.nextLine();
			trainer = new Trainer(name, areas.get(0));
			System.out.println("Hi, " + trainer.getName());

			Pokemon firstPokemon = chooseFirstPokemon();
			firstPokemon.setOwner(trainer);
			trainer.getPokemonCollection().add(firstPokemon);
			System.out
					.println("You now have " + trainer.getPokemonCollection().size() + " pokemon in your collection!");
//		}
		// game loop
		while (true) {
			showGameOptions();
		}
	}

	public static void showGameOptions() {
		System.out.println("What do you want to do?");
		System.out.println("1 ) Find Pokemon");
		System.out.println("2 ) My Pokemon");
		System.out.println("3 ) Inventory");
		System.out.println("4 ) Badges");
		System.out.println("5 ) Challenge " + trainer.getCurrentArea().getName() + "'s Gym Leader");
		System.out.println("6 ) Travel");
		System.out.println("7 ) Visit Pokecenter");
		System.out.println("8 ) Shop");
		System.out.println("9 ) save game");
		System.out.println("10 ) Exit game");
		int action = sc.nextInt();
		switch (action) {
		case 1:
			findAndBattlePokemon();
			break;
		case 2:
			trainer.showPokemonColletion();
			break;
		case 3:
			ItemType item = showInventory();
			if (item != null) {
				trainer.useItem(item, null);
			}
			break;
		case 4:
			trainer.showBadges();
			break;
		case 5:
			if (trainer.getCurrentArea().getGymLeader() != null) {
				startGymBattle();
			} else {
				System.out.println("No Gym Leader in this town!");
			}
			break;
		case 6:
			Area area = showTravel();
			if (area != null) {
				trainer.travel(area);
			}
			break;
		case 7:
			trainer.visitPokeCenter(trainer.getCurrentArea().getPokecenter());
			break;
		case 8:
			System.out.println("1) Je geld zien\n2) Naar de winkel");
			int keuze = sc.nextInt();
			if (keuze == 1) {
				shop.geld();
			} else if (keuze == 2) {
				shop.kopen();
			}
			break;
		case 9:
//			PokemonToFile.save(trainer);
			break;
		case 10:
			quit();
			break;
		default:
			System.out.println("Sorry, that's not a valid option");
			break;
		}
	}

	// TODO: US-PKM-O-6
	private static void findAndBattlePokemon() {
		Pokemon randomPokemon = trainer.findPokemon();
		Battle battle = trainer.battle(trainer.getActivePokemon(), randomPokemon);
		battle.start();
	}

	private static Area showTravel() {
		Area travelTo = null;
		int index = 1;
		List<Area> travelToAreas = new ArrayList<>();

		for (Area area : areas) {
			if (!area.equals(trainer.getCurrentArea()) && area.isUnlocked()
					&& ((area.getNextArea() != null && area.getNextArea().equals(trainer.getCurrentArea()))
							|| trainer.getCurrentArea().getNextArea() != null
									&& trainer.getCurrentArea().getNextArea().equals(area))) {
				travelToAreas.add(area);
			}
		}
		for (Area a : travelToAreas) {
			System.out.println(index + ") " + a.getName());
			index++;
		}
		System.out.println(index + ") Back");
		int choice = sc.nextInt();
		if (choice != index) {
			travelTo = travelToAreas.get(choice - 1);
		}
		return travelTo;
	}

	private static ItemType showInventory() {
		HashMap<ItemType, Integer> items = trainer.getInventory().getItems();
		Set<Map.Entry<ItemType, Integer>> entries = items.entrySet();
		int index = 1;
		for (Map.Entry<ItemType, Integer> entry : entries) {
			System.out.println(index + ") " + entry.getKey() + " " + entry.getValue());
			index++;
		}
		System.out.println(index + ") Back");
		int choice = sc.nextInt();
		if (choice != index) {
			return ItemType.values()[choice - 1];
		}

		return null;
	}

	// TODO: US-PKM-O-1
	private static Pokemon chooseFirstPokemon() {
		System.out.println("Please choose one of these three pokemon");
		System.out.println("1 ) Charmander");
		System.out.println("2 ) Bulbasaur");
		System.out.println("3 ) Squirtle");
		int choice = sc.nextInt();

		if (choice == 1) {
			Pokemon charmander = new Pokemon(PokemonData.CHARMANDER);
			charmander.setLevel(5);
			trainer.setActivePokemon(charmander);
			System.out.println(PokemonData.CHARMANDER.art);
			return charmander;
		} else if (choice == 2) {
			Pokemon bulbasaur = new Pokemon(PokemonData.BULBASAUR);
			bulbasaur.setLevel(5);
			trainer.setActivePokemon(bulbasaur);
			System.out.println(PokemonData.BULBASAUR.art);
			return bulbasaur;
		} else if (choice == 3) {
			Pokemon squirtle = new Pokemon(PokemonData.SQUIRTLE);
			squirtle.setLevel(5);
			trainer.setActivePokemon(squirtle);
			System.out.println(PokemonData.SQUIRTLE.art);
			return squirtle;
		} else if (choice == 4) {
			Pokemon ahmed = new Pokemon(PokemonData.AHMED);
			ahmed.setLevel(10);
			trainer.setActivePokemon(ahmed);
			return ahmed;
		} else {
		}
		chooseFirstPokemon();
		return null;
	}

	// TODO: US-PKM-O-8
	private static void startGymBattle() {
		if (trainer.getCurrentArea().getGymLeader().isDefeated()) {
			System.out.println("You've already defeated this leader!\nProceed to the next town");
		} else {
			Battle trainerBattle = trainer.challengeTrainer(Game.trainer.getCurrentArea().getGymLeader());
			trainer.challengeTrainer(Game.trainer.getCurrentArea().getGymLeader());
			if (trainerBattle != null && trainerBattle.getWinner().getOwner().equals(trainer)) {
				if (trainerBattle.getEnemy().getOwner().getClass().equals(GymLeader.class)) {
					Pokemon enemyPokemon = trainerBattle.getEnemy();
					GymLeader gymLeader = (GymLeader) enemyPokemon.getOwner();
					gymLeader.setDefeated(true);
					awardBadge(gymLeader.getBadge().getName());
					Area gymLeaderArea = gymLeader.getCurrentArea();
					Area nextArea = gymLeaderArea.getNextArea();
					if (nextArea != null) {
						nextArea.setUnlocked(true);
					}
					Shop.gymLeaderDefeat();
				}
			}
		}
	}

	// TODO: US-PKM-O-9
	public static void awardBadge(String badgeName) {
		Badge badge = new Badge(badgeName);
		trainer.addBadge(badge);

	}

	public static void gameOver(String message) {
		System.out.println(message);
		System.out.println("Game over");
		quit();
	}

	// TODO: US-PKM-O-2:
	private static void quit() {
		System.out.println("Are you sure you want to quit?\n1) Yes\n2) No");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Thanks for playing!");
			System.exit(0);
		} else if (choice == 2) {
			showGameOptions();
		} else {
			System.out.println("This is an invalid option!\nChoose yes or no");
			quit();
		}
	}

//    public static void shop() {
//    	System.out.println("Do you want some extra pokeballs?\n1) Yes!\n2) Nah");
//        int choice1 = sc.nextInt();
//        if(choice1 == 1) {
//        	System.out.println("How many do you want?");
//        	int amount = sc.nextInt();
//        	if(amount > 10) {
//        		System.out.println("That are some pokeballs!\nChoose less");
//        	}else {
//        		trainer.getInventory().addItem(amount, ItemType.POKEBALL);
//        		System.out.println("There you go here are " + amount + " Pokeballs!");
//        	}
//        }else if(choice1 == 2) {
//        	System.out.println("Well okay then, returning to menu");
//        	showGameOptions();
//        }
//    }
	
	public static void load() {

		System.out.println("Loading game...");
		try {
			Thread.sleep(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fileIn = new FileInputStream("E:\\\\One drive kanker\\\\Documenten\\\\school\\\\programmeren\\\\sprint 4\\\\pokemon.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			trainer = (Trainer) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("class not found");
			c.printStackTrace();
			return;
		}

	}
}
