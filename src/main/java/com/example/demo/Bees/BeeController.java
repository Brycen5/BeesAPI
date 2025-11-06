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

import com.example.demo.Bees.Bee;

@Controller //MVC Controller
public class BeeController {
    @Autowired
  private BeeService BeeService;

 
  @GetMapping("/Bees")
  public Object getAllBees() {
    return BeeService.getAllBees();
  }

  @GetMapping("/Bees/{id}")
  public Bee getBeesById(@PathVariable long id) {
    return BeeService.getBeeById(id);
  }

  @GetMapping("/Bees/name")
  public Object getBeesByName(@RequestParam String key) {
    if (key != null) {
      return BeeService.getBeeByName(key);
    } else {
      return BeeService.getAllBees();
    }
}

@PostMapping("/bees")
  public Object addBee(@RequestBody Bee Bee) {
    return BeeService.addBee(Bee);
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
