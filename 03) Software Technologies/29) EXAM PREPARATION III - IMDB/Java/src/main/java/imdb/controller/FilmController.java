package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class FilmController {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Film> films = filmRepository.findAll();

//        films.sort(new Comparator<Film>() {
//            @Override
//            public int compare(Film o1, Film o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        model.addAttribute("films", films);
        model.addAttribute("view", "film/index");

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("view", "film/create");

        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(Model model, FilmBindingModel filmBindingModel) {
        if (filmBindingModel.getDirector().equals("")
                || filmBindingModel.getGenre().equals("")
                || filmBindingModel.getName().equals("")
                ) {
            model.addAttribute("view", "task/create");

            return "base-layout";
        }

        Film film = new Film();

        film.setDirector(filmBindingModel.getDirector());
        film.setGenre(filmBindingModel.getGenre());
        film.setName(filmBindingModel.getName());
        film.setYear(filmBindingModel.getYear());

        filmRepository.saveAndFlush(film);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Film film = filmRepository.findOne(id);

        if (film == null) {
            return "redirect:/";
        }

        model.addAttribute("film", film);
        model.addAttribute("view", "film/edit");

        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(Model model, @PathVariable int id, FilmBindingModel filmBindingModel) {
        if (filmBindingModel.getDirector().equals("")
                || filmBindingModel.getGenre().equals("")
                || filmBindingModel.getName().equals("")
                ) {
            model.addAttribute("view", "task/create");

            return "base-layout";
        }

        Film film = filmRepository.findOne(id);

        if (film == null) {
            return "redirect:/";
        }

        film.setDirector(filmBindingModel.getDirector());
        film.setGenre(filmBindingModel.getGenre());
        film.setName(filmBindingModel.getName());
        film.setYear(filmBindingModel.getYear());

        filmRepository.saveAndFlush(film);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        if (!filmRepository.exists(id)) {
            return "redirect:/";
        }

        Film film = filmRepository.findOne(id);

        if (film == null) {
            return "redirect:/";
        }

        model.addAttribute("film", film);
        model.addAttribute("view", "film/delete");

        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id) {
        if (!filmRepository.exists(id)) {
            return "redirect:/";
        }

        Film film = filmRepository.findOne(id);

        if (film == null) {
            return "redirect:/";
        }

        this.filmRepository.delete(film);

        return "redirect:/";
    }
}
