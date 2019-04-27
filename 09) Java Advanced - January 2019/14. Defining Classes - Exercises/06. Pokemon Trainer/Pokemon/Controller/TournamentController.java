package Pokemon.Controller;

import Pokemon.Pokemon;
import Pokemon.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TournamentController {

    private static final String STR_TO_START_TOURNAMENT = "Tournament";
    private static final String STR_TO_END_TOURNAMENT = "End";

    private static final int DEF_POKEMON_DMG = 10;

    private List<PokemonTrainer> pokemonTrainers;

    private Scanner scanner;

    public TournamentController() {
        pokemonTrainers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public void addTrainersFromInput() {
        String trainerInput;
        while (!(trainerInput = scanner.nextLine()).equals(STR_TO_START_TOURNAMENT)) {
            String[] trainerTokens = trainerInput.split("\\s+");
            PokemonTrainer pokemonTrainer = findTrainerByName(trainerTokens[0]);
            Pokemon pokemon = new Pokemon(trainerTokens[1], trainerTokens[2], Integer.parseInt(trainerTokens[3]));

            if (pokemonTrainer == null) {
                pokemonTrainer = new PokemonTrainer(trainerTokens[0]);
                pokemonTrainer.addPokemon(pokemon);
                pokemonTrainers.add(pokemonTrainer);
            } else {
                pokemonTrainer.addPokemon(pokemon);
            }
        }
    }

    private PokemonTrainer findTrainerByName(String trainerNameToSearchFor) {
        for (PokemonTrainer pokemonTrainer : pokemonTrainers) {
            if (pokemonTrainer.getName().equals(trainerNameToSearchFor)) {
                return pokemonTrainer;
            }
        }
        return null;
    }

    public void doTournament() {
        String elementFromInput;
        while (!(elementFromInput = scanner.nextLine()).equals(STR_TO_END_TOURNAMENT)) {
            for (PokemonTrainer pokemonTrainer : pokemonTrainers) {
                if (!pokemonTrainer.hasPokemonOfElement(elementFromInput)) {
                    pokemonTrainer.damageAllPokemons(DEF_POKEMON_DMG);
                } else {
                    pokemonTrainer.winBattle();
                }
            }
        }
    }

    public void displayTrainers() {
        pokemonTrainers.stream()
                .sorted((pt1, pt2) -> Integer.compare(pt2.getBadgesCnt(), pt1.getBadgesCnt()))
                .forEach(pt -> System.out.println(pt.getInfo()));
    }
}
