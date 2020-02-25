package com.rodzyn.ksb2klient.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogApi {

    private List<Dog> dogList;

    public DogApi() {
        this.dogList = new ArrayList<>();
        dogList.add(new Dog("Balsik", "Husky"));
        dogList.add(new Dog("Reksio", "Chow Chow"));
        dogList.add(new Dog("Burek", "Semoyed"));
    }

    @GetMapping
    public List<Dog> getDog(@RequestHeader int amount){
        return dogList.subList(0, amount);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog){
        dogList.add(dog);
    }
}
