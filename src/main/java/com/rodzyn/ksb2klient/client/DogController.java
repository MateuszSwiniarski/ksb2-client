package com.rodzyn.ksb2klient.client;

import com.rodzyn.ksb2klient.client.AnimalFact;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DogController {

    public DogController(){

        RestTemplate restTemplate = new RestTemplate();

//        String forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=5",
//                String.class);

        AnimalFact[] forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=5",
                AnimalFact[].class);

//        for (AnimalFact animalFact : forObject) {
//            System.out.println(animalFact.getText());
//        }

    }
}
