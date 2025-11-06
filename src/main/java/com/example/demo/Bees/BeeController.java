package com.example.demo.Bees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.example.demo.Bees.Bee;

@Controller //MVC Controller
public class BeeController {
    @Autowired
  private BeeService BeeService;

 
  @GetMapping("/Bees")
  public Object getAllBees(Model model) {
    model.addAttribute("animalslist", BeeService.getAllBees());
    model.addAttribute("title", "All Animals");
    return "animal-list";
  }

  @GetMapping("/Bees/{id}")
  public String getBeesById(@PathVariable long id, Model model) {
    model.addAttribute("animal", BeeService.getBeeById(id));
    model.addAttribute("title", "Animal #: "+ id);
    return "animal-details";
  }

  @GetMapping("/Bees/name")
  public Object getBeesByName(@RequestParam String key, Model model) {
    if (key != null) {
      model.addAttribute("animalslist", BeeService.getBeeByName(key));
      model.addAttribute("title", "Animals By Name: " + key);
      return "animal-list";
    } else {
      return "redirect:/Bees/";
    }
}

@PostMapping("/bees")
  public Object addBee(@RequestBody Bee Bee) {
    Bee newBee = BeeService.addBee(Bee);
    return "redirect:/Bees/" + newBee.getBeeId();
  }

  @PutMapping("/bees/{id}")
  public Bee updateBee(@PathVariable Long id, @RequestBody Bee Bee) {
    BeeService.updateBee(id, Bee);
    return BeeService.getBeeById(id);
  }

  @DeleteMapping("/bees/{id}")
  public Object deleteBee(@PathVariable Long id) {
    BeeService.deleteBee(id);
    return BeeService.getAllBees();
  }

  @PostMapping("/bees/writeFile")
  public Object writeJson(@RequestBody Bee Bee) {
    return BeeService.writeJson(Bee);
  }

  @GetMapping("/bees/readFile")
  public Object readJson() {
    return BeeService.readJson();

  }
}
