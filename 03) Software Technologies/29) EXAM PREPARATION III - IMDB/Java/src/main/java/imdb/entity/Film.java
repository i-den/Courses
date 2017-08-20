package imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
    public Film() {
    }

    public Film(String name, String genre, String director, int year) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(nullable = false)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
