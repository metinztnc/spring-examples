package com.metindev.controller;

import com.metindev.entity.Person;
import com.metindev.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        personRepository.save(Person.builder()
                .id("U001")
                .name("met")
                .surName("dev")
                .adress("adress")
                .birthday(Calendar.getInstance().getTime())
                .build());
    }

    public ResponseEntity<List<Person>> getPersonsList(@PathVariable String searchCriteria){
        List<Person> personList = personRepository.getBySearchCriteria(searchCriteria);
        return ResponseEntity.ok(personList);
    }

}
