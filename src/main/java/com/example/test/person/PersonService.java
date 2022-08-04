package com.example.test.person;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.geom.IllegalPathStateException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if(personOptional.isPresent()) {
            throw new IllegalMonitorStateException("email taken");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exist = personRepository.existsById(personId);
        if(!exist) {
            throw new IllegalStateException(
                    "Person with id " + personId + " does not exists");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId, String name, String email) {
        Person person = personRepository.findById(personId)
        .orElseThrow(() -> new IllegalStateException(
                "Person with id " + personId + " does not exist"
        ));
        if(name != null && name.length() > 0 &&
                !Objects.equals(person.getUsername(),name)) {
            person.setUsername(name);
        }
        if(email != null && email.length() > 0 &&
                !Objects.equals(person.getEmail(),email)) {
            Optional<Person> personOptional = personRepository.findPersonByEmail(email);
            if(personOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            person.setEmail(email);
        }
    }
}
