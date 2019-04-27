package Pokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokemonTrainer {

    private String name;

    private int badgesCnt;

    private List<Pokemon> pokemons;

    public PokemonTrainer(String name) {
        this.name = name;
        badgesCnt = 0;
        pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemonToAdd) {
        pokemons.add(pokemonToAdd);
    }

    public String getName() {
        return name;
    }

    public int getBadgesCnt() {
        return badgesCnt;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean hasPokemonOfElement(String elementFromInput) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(elementFromInput)) {
                return true;
            }
        }
        return false;
    }

    public void damageAllPokemons(Integer damageToTake) {
        for (final Iterator<Pokemon> iterator = pokemons.iterator(); iterator.hasNext();) {
            Pokemon pokemon = iterator.next();
            pokemon.takeDamage(damageToTake);

            if (!pokemon.isAlive()) {
                iterator.remove();
            }
        }
    }

    public String getInfo() {
        return String.format("%s %d %d", name, badgesCnt, pokemons.size());
    }

    public void winBattle() {
        badgesCnt++;
    }
}
