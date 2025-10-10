package com.example.demo.Bees;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BeeService {

  @Autowired
  private BeeRepo beeRepository;

 
  public Object getAllStudents() {
    return beeRepository.findAll();
  }

 
  public Bee getBeeById(@PathVariable long BeeId) {
    return beeRepository.findById(BeeId).orElse(null);
  }

 
  public Object getBeeByName(String name) {
    return beeRepository.getBeeByName(name);
  }

  
  public Object getBeesByDescription(String description) {
    return beeRepository.getBeesByDescription(description);
  }


 
  public Bee addBee(Bee Bee) {
    return beeRepository.save(Bee);
  }

 
  public Bee updateBee(Long BeeId, Bee Bee) {
    return beeRepository.save(Bee);
  }

 
  public void deleteBee(Long BeeId) {
    beeRepository.deleteById(BeeId);
  }


  public String writeJson(Bee Bee) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("bees.json"), Bee);
      return "Bee written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing Bee to JSON file";
    }

  }

 
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("students.json"), Bee.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

}
