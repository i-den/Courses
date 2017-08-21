package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.bindingModel.EntityBindingModel;
import project.entity.Entity;
import project.repository.EntityRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class EntityController {
	
    private final EntityRepository entityRepository;
	
    @Autowired
    public EntityController(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }
	
    //
    // GET: INDEX
    @GetMapping("/")
    public String index(Model model) {
		
        List<Entity> entities = entityRepository.findAll();

        List<Entity> statusEntities = filterList(entities, "Property");
		
        //entities.sort(new Comparator<Entity>() {
        //    @Override
        //    public int compare(Entity o1, Entity o2) {
        //        return o1.getProperty().compareTo(o2.getProperty());
        //    }
        //});

        model.addAttribute("statusEntities", statusEntities);
        model.addAttribute("view", "entity/index");

        return "base-layout";
    }
	
    private List<Entities> filterList(List<Entities> entities, String property) {
		
        List<Entities> currentEntitiesToReturn = entities
                .stream()
                .filter(e -> e.getProperty().equals(property))
                .collect(Collectors.toList());

        return currentEntitiesToReturn;
    }	
	
    //
    // GET: CREATE
    @GetMapping("/create")
    public String create(Model model) {
		
        model.addAttribute("view", "entity/create");

        return "base-layout";
    }
	
    //
    // POST: CREATE
    @PostMapping("/create")
    public String createProcess(Model model, EntityBindingModel entityBindingModel) {
		
        if (entityBindingModel.getStringProperty().equals("")) {
            model.addAttribute("view", "entity/create");

            return "base-layout";
        }

		Entity entity = new Entity(
			entityBindingModel.getStringProperty(),
			entityBindingModel.getIntProperty());
		
        //Entity entity = new Entity();
		//
        //entity.setStringProperty(entityBindingModel.getStringProperty());
		//entity.setIntProperty(entityBindingModel.getIntProperty());

        entityRepository.saveAndFlush(entity);

        return "redirect:/";
    }

	//
	// GET: READ/5
	@GetMapping("/edit/{id}")
    public String read(Model model, @PathVariable int id) {
		
        Entity entity = entityRepository.findOne(id);

        if (entity == null) {
            return "redirect:/";
        }

        model.addAttribute("entity", entity);
        model.addAttribute("view", "entity/read");

        return "base-layout";
    }
	
	//
	// GET: EDIT/5
	@GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        
		Entity entity = entityRepository.findOne(id);

        if (entity == null) {
            return "redirect:/";
        }

        model.addAttribute("entity", entity);
        model.addAttribute("view", "entity/edit");

        return "base-layout";
    }
	
    //
    // POST: EDIT/5
    @PostMapping("/edit/{id}")
    public String editProcess(Model model, @PathVariable int id, EntityBindingModel entityBindingModel) {
		
        if (entityBindingModel.getStringProperty().equals("")) {
			
			model.addAttribute("view", "entity/edit");

            return "base-layout";
			
            //Entity entity = new Entity();
            //
            //entity.setId(id);
            //entity.setStringProperty(entityBindingModel.getStringProperty());
            //entity.setIntProperty(entityBindingModel.getIntProperty());
            //
            //model.addAttribute("entity", entity);
            //model.addAttribute("view", "entity/edit");
            //
            //return "base-layout";
        }

        Entity entity = entityRepository.findOne(id);

        if (entity != null) {
			entity.setStringProperty(entityBindingModel.getStringProperty());
            entity.setIntProperty(entityBindingModel.getIntProperty());

            entityRepository.saveAndFlush(entity);
        }

        return "redirect:/";
    }
	
    //
    // GET: DELETE/5
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
		
        if (!entityRepository.exists(id)) {
            return "redirect:/";
        }

        Entity entity = entityRepository.findOne(id);

        if (entity == null) {
            return "redirect:/";
        }

        model.addAttribute("entity", entity);
        model.addAttribute("view", "entity/delete");

        return "base-layout";
    }
	
    //
    // POST: DELETE/5
    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id) {
		
        if (!entityRepository.exists(id)) {
            return "redirect:/";
        }

        Entity entity = entityRepository.findOne(id);

        if (entity == null) {
            return "redirect:/";
        }

        entityRepository.delete(entity);
		//entityRepository.flush();

        return "redirect:/";
    }	
}
