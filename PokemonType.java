package nl.delphinity.pokemon.model.general;

import nl.delphinity.pokemon.model.battle.Attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PokemonType {

    BUG,
    DRAGON,
    ICE,
    FIGHTING,
    FIRE,
    FLYING,
    GRASS,
    GHOST,
    GROUND,
    ELECTRIC,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    WATER,
	MARROKAAN,
	MARROKANENMOEDER,
	MARROKANENVADER,
	GEERTWILDERS,
	AHMANAGER,
	TEAMLEIDER,
	MEDEWERKER,
	KLANTEN,
	BONUSPRODUCTEN;

    static {
        BUG.strongAgainst.addAll(Arrays.asList(GRASS, PSYCHIC));
        DRAGON.strongAgainst.addAll(Collections.singletonList(DRAGON));
        ICE.strongAgainst.addAll(Arrays.asList(FLYING, GROUND, GRASS, DRAGON));
        FIGHTING.strongAgainst.addAll(Arrays.asList(NORMAL, ROCK, ICE));
        GRASS.strongAgainst.addAll(Arrays.asList(GROUND, ROCK, WATER));
        GHOST.strongAgainst.addAll(Arrays.asList(GHOST, PSYCHIC));
        GROUND.strongAgainst.addAll(Arrays.asList(POISON, ROCK, FIRE, ELECTRIC));
        ELECTRIC.strongAgainst.addAll(Arrays.asList(FLYING, WATER));
        NORMAL.strongAgainst.addAll(Collections.emptyList());
        POISON.strongAgainst.addAll(Collections.singletonList(GRASS));
        PSYCHIC.strongAgainst.addAll(Arrays.asList(FIGHTING, POISON));
        ROCK.strongAgainst.addAll(Arrays.asList(FLYING, BUG, FIRE, ICE));
        WATER.strongAgainst.addAll(Arrays.asList(GROUND, ROCK, FIRE));
        MARROKAAN.strongAgainst.addAll(Arrays.asList(GROUND));
        MARROKANENMOEDER.strongAgainst.addAll(Arrays.asList(MARROKAAN));
        MARROKANENVADER.strongAgainst.addAll(Arrays.asList(MARROKANENMOEDER));
        GEERTWILDERS.strongAgainst.addAll(Arrays.asList(MARROKAAN, MARROKANENMOEDER, MARROKANENVADER));
        AHMANAGER.strongAgainst.addAll(Arrays.asList(TEAMLEIDER, MEDEWERKER, KLANTEN));
        TEAMLEIDER.strongAgainst.addAll(Arrays.asList(MEDEWERKER, KLANTEN));
        MEDEWERKER.strongAgainst.addAll(Arrays.asList(KLANTEN, BONUSPRODUCTEN));
        KLANTEN.strongAgainst.addAll(Arrays.asList(MEDEWERKER));
        BONUSPRODUCTEN.strongAgainst.addAll(Arrays.asList(KLANTEN));

        BUG.weakAgainst.addAll(Arrays.asList(FIGHTING, FLYING, POISON, GHOST, FIRE));
        DRAGON.weakAgainst.addAll(Collections.emptyList());
        ICE.weakAgainst.addAll(Arrays.asList(FIRE, WATER, ICE));
        FIGHTING.weakAgainst.addAll(Arrays.asList(FLYING, POISON, PSYCHIC, BUG));
        GRASS.weakAgainst.addAll(Arrays.asList(FLYING, POISON, BUG, FIRE, GRASS, DRAGON));
        GHOST.weakAgainst.addAll(Collections.singletonList(NORMAL));
        GROUND.weakAgainst.addAll(Arrays.asList(FLYING, BUG, GRASS));
        ELECTRIC.weakAgainst.addAll(Arrays.asList(GROUND, GRASS, ELECTRIC, DRAGON));
        NORMAL.weakAgainst.addAll(Arrays.asList(ROCK, GHOST));
        POISON.weakAgainst.addAll(Arrays.asList(POISON, GROUND, ROCK, GHOST));
        PSYCHIC.weakAgainst.addAll(Collections.singletonList(PSYCHIC));
        ROCK.weakAgainst.addAll(Arrays.asList(FIGHTING, GROUND));
        WATER.weakAgainst.addAll(Arrays.asList(WATER, GRASS, DRAGON));
        MARROKAAN.weakAgainst.addAll(Arrays.asList(MARROKANENMOEDER));
        MARROKANENMOEDER.weakAgainst.addAll(Arrays.asList(MARROKANENVADER));
        MARROKANENVADER.weakAgainst.addAll(Arrays.asList(FIRE));
        GEERTWILDERS.weakAgainst.addAll(Arrays.asList(POISON));
        AHMANAGER.weakAgainst.addAll(Arrays.asList(POISON));
        TEAMLEIDER.weakAgainst.addAll(Arrays.asList(AHMANAGER));
        MEDEWERKER.weakAgainst.addAll(Arrays.asList(AHMANAGER, TEAMLEIDER, KLANTEN));
        KLANTEN.weakAgainst.addAll(Arrays.asList(AHMANAGER, TEAMLEIDER, MEDEWERKER, BONUSPRODUCTEN));
        BONUSPRODUCTEN.weakAgainst.addAll(Arrays.asList(MEDEWERKER));

        BUG.typeAttacks.addAll(Arrays.asList(
                new Attack("Bug Bite", 10, 100),
                new Attack("Pin Missile", 25, 100),
                new Attack("Twineedle", 25, 100),
                new Attack("Leech Life", 80, 100)));

        NORMAL.typeAttacks.addAll(Arrays.asList(
                new Attack("Quick attack", 40, 100),
                new Attack("Fury attack", 15, 100)));

        FIRE.typeAttacks.addAll(Arrays.asList(
                new Attack("Flamethrower", 90, 100),
                new Attack("Fire Spin", 35, 100),
                new Attack("Fire Blast", 110, 100),
                new Attack("Ember", 40, 100)));

        WATER.typeAttacks.addAll(Arrays.asList(
                new Attack("Bubble", 40, 100),
                new Attack("Hydro Pump", 110, 100),
                new Attack("Water Gun", 40, 100)));

        GRASS.typeAttacks.addAll(Arrays.asList(
                new Attack("Petal Dance", 120, 100),
                new Attack("Vine Whip", 45, 100),
                new Attack("Solar Beam", 120, 100)));

        ROCK.typeAttacks.addAll(Arrays.asList(
                new Attack("Rock Slide", 75, 100),
                new Attack("Rock Throw", 50, 100)));

        GROUND.typeAttacks.addAll(Arrays.asList(
                new Attack("Dig", 80, 100),
                new Attack("Earthquake", 100, 100),
                new Attack("Bone Club", 65, 100)));

        ICE.typeAttacks.addAll(Arrays.asList(
                new Attack("Blizzard", 110, 100),
                new Attack("Ice Beam", 90, 100),
                new Attack("Ice Punch", 75, 100)));

        ELECTRIC.typeAttacks.addAll(Arrays.asList(
                new Attack("Thunder", 110, 100),
                new Attack("Thunderbolt", 90, 100),
                new Attack("Thunder Punch", 75, 100),
                new Attack("Thunder Shock", 40, 100)));

        PSYCHIC.typeAttacks.addAll(Arrays.asList(
                new Attack("Confusion", 50, 100),
                new Attack("Psybeam", 65, 100),
                new Attack("Psychic", 90, 100)));

        DRAGON.typeAttacks.addAll(Collections.singletonList(
                new Attack("Dragon Rage", 130, 100)));

        POISON.typeAttacks.addAll(Arrays.asList(
                new Attack("Acid", 40, 100),
                new Attack("Poison Sting", 15, 100),
                new Attack("Sludge", 65, 100)));

        FLYING.typeAttacks.addAll(Arrays.asList(
                new Attack("Gust", 40, 100),
                new Attack("Sky Attack", 140, 100),
                new Attack("Wing Attack", 60, 100)));

        FIGHTING.typeAttacks.addAll(Arrays.asList(
                new Attack("Double Kick", 30, 100),
                new Attack("Submission", 80, 100),
                new Attack("High Jump Kick", 130, 100)));

        GHOST.typeAttacks.addAll(Arrays.asList(
                new Attack("Lick", 30, 100),
                new Attack("Night Shade", 65, 100)));
        
        MARROKAAN.typeAttacks.addAll(Arrays.asList(
        		new Attack("Neven bellen", 70, 100),
        		new Attack("Geit neuken", 50, 100),
        		new Attack("IK HOEF NIET TE TANKEN SCHAT, DAAAGHHH", 60, 100),
        		new Attack("JIJ SPEELT MET MIJN PRIVÉ", 15, 100)));
        
        MARROKANENMOEDER.typeAttacks.addAll(Arrays.asList(
        		new Attack("Slaan met slipper", 70, 100),
        		new Attack("Slipper gooien", 20, 100),
        		new Attack("Uit huis gooien", 50, 100)));
        
        MARROKANENVADER.typeAttacks.addAll(Arrays.asList(
        		new Attack("Met riem slaan", 70, 100),
        		new Attack("Kebab shop openen", 100, 100)));
        
        GEERTWILDERS.typeAttacks.addAll(Arrays.asList(
        		new Attack("Land uitzetten", 700, 100)));
        
        AHMANAGER.typeAttacks.addAll(Arrays.asList(
        		new Attack("Terug sturen naar de zelfsan", 50, 100),
        		new Attack("Gluren vanuit de winkel", 20, 100),
        		new Attack("Eerder naar huis gaan", 60, 100)));
        
        TEAMLEIDER.typeAttacks.addAll(Arrays.asList(
        		new Attack("Mandjes op laten ruimen", 40, 100),
        		new Attack("Gratis bloemen mee geven", 70, 100),
        		new Attack("Kan je iets langer blijven?", 100, 100),
        		new Attack("Maak je kassa schoon!", 85, 100)));
        
        MEDEWERKER.typeAttacks.addAll(Arrays.asList(
        		new Attack("Product tevaak scannen", 70, 100),
        		new Attack("gebruikt filiaalcode ipv bonuskaart klant", 110, 100),
        		new Attack("Magazijn inlopen om product te zoeken maar insta checken", 80, 100)));
        
        KLANTEN.typeAttacks.addAll(Arrays.asList(
        		new Attack("Vragen of een product er is", 80, 100),
        		new Attack("Zeiken over €0,05", 110, 100)));
    }

    public final List<PokemonType> weakAgainst = new ArrayList<>();
    public final List<PokemonType> strongAgainst = new ArrayList<>();
    public final List<Attack> typeAttacks = new ArrayList<>();
}
