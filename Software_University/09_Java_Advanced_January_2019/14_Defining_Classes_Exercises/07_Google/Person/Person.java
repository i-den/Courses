package Person;

import Car.Car;
import Company.CompanyInfo;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;

    private CompanyInfo companyInfo;

    private List<Pokemon> pokemons;

    private List<Parent> parents;

    private List<Child> children;

    private Car car;

    public Person(String name) {
        this.name = name;
        pokemons = new ArrayList<>();
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s%n", name) +
                String.format("Company:%n%s", companyInfo == null ? "" : companyInfo + "\n") +
                String.format("Car:%n%s", car == null ? "" : car + "\n") +
                String.format("Pokemon:%n%s", pokemons.isEmpty() ? "" : getPokemonInfo() + "\n") +
                String.format("Parents:%n%s", parents.isEmpty() ? "" : getParentsInfo() + "\n") +
                String.format("Children:%n%s", children.isEmpty() ? "" : getChildrenInfo());
    }

    public String getName() {
        return name;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    private String getPokemonInfo() {
        return pokemons.stream()
                .map(p -> String.format("%s %s", p.getName(), p.getType()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String getParentsInfo() {
        return parents.stream()
                .map(p -> String.format("%s %s", p.getName(), p.getBirthday()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String getChildrenInfo() {
        return children.stream()
                .map(c -> String.format("%s %s", c.getName(), c.getBirthday()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
