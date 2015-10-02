package com.reddy.my_show.server.service;


import java.util.List;
import com.reddy.my_show.server.Person;
import com.reddy.my_show.server.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonService{
    @Autowired
    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }


    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }


    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }


    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

}
