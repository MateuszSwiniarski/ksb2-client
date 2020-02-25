package com.rodzyn.ksb2klient.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    private AnimalFact getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        AnimalFact animalFact = restTemplate.getForObject("https://cat-fact.herokuapp.com//facts/random", AnimalFact.class);
        JsonNode image = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class).get("url");

        animalFact.setSrc(image.asText());

        return animalFact;
    }

    @GetMapping("/animal-fact")
    public String get(Model model){
        model.addAttribute("catFact", getCatFact());
        return "animalView";
    }
}
