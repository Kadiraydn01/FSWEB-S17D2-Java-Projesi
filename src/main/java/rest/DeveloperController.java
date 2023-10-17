package rest;

import jakarta.annotation.PostConstruct;
import model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tax.Taxable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;
@PostConstruct
public void init(){
    developers = new HashMap<>();
    this.taxable=taxable;
}
@Autowired
public DeveloperController(Taxable taxable) {
    this.taxable = taxable;
}

@GetMapping("/")
    public List<Developer> getAllDevelopers(){
    return new ArrayList<>(developers.values());
}
@GetMapping("/{id}")
public Developer getDeveloperById(@PathVariable int id){
    return developers.get(id);
}
@PostMapping("/developers")
    public Developer createDeveloper(@RequestBody Developer developer){
    if(developer.getExperience() == Developer.Experience.JUNIOR){
        developer.setSalary(developer.getSalary() - taxable.getSimpleTaxRate());
    }else if(developer.getExperience() == Developer.Experience.MID){
        developer.setSalary(developer.getSalary() - taxable.getMiddleTaxRate());
    }else if(developer.getExperience() == Developer.Experience.SENIOR){
        developer.setSalary(developer.getSalary() - taxable.getSeniorTaxRate());
    }
    developers.put(developer.getId(),developer);
    return developer;
}
@PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable int id,@RequestBody Developer updatedDeveloper){
    if (developers.containsKey(id)){
        developers.put(id,updatedDeveloper);
        return updatedDeveloper;
    }else{
        throw new RuntimeException("Developer not found with ID: " + id);
    }
}
@DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable int id){
    developers.remove(id);
}

}
