package com.avllabs.sample.config;

import com.avllabs.sample.entity.Address;
import com.avllabs.sample.entity.Person;
import com.avllabs.sample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationRunner {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Address a;
        Person p;

        p = new Person();
        p.setName("Ragnar Lodbrok");
        p.setPhone("826374829");
        p.setEmail("ragnar@mail.com");

        a = new Address();
        a.setStreet("Wolf street");
        a.setCity("Kattegat");
        a.setState("Norway");
        a.setPostalCode("00001");
        a.setCountry("Scandinavia");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Matt Murdock");
        p.setPhone("826374829");
        p.setEmail("murdock@mail.com");

        a = new Address();
        a.setStreet("Hell's Kitchen");
        a.setCity("New York");
        a.setState("New York");
        a.setPostalCode("10000");
        a.setCountry("United States of America");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Venom Snake");
        p.setPhone("826374829");
        p.setEmail("snake@mail.com");

        a = new Address();
        a.setStreet("Unknown");
        a.setCity("Unknown");
        a.setState("Unknown");
        a.setPostalCode("00000");
        a.setCountry("United States of America");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Geralt of Rivia");
        p.setPhone("826374829");
        p.setEmail("witcher@mail.com");

        a = new Address();
        a.setStreet("Devil's Pit");
        a.setCity("Novingrad");
        a.setState("Nilfgaard");
        a.setPostalCode("00002");
        a.setCountry("United Kingdom");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Cal Kestis");
        p.setPhone("826374829");
        p.setEmail("jedi@mail.com");

        a = new Address();
        a.setStreet("Solleu River");
        a.setCity("Naboo");
        a.setState("Tatooine II");
        a.setPostalCode("00002");
        a.setCountry("Galactic Empire");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Ethan Hunt");
        p.setPhone("826374829");
        p.setEmail("hunt@mail.com");

        a = new Address();
        a.setStreet("Unknown");
        a.setCity("Unknown");
        a.setState("California");
        a.setPostalCode("10001");
        a.setCountry("United States of America");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Leon S. Kennedy");
        p.setPhone("826374829");
        p.setEmail("leon@mail.com");

        a = new Address();
        a.setStreet("Constitution Avenue");
        a.setCity("Washington D. C.");
        a.setState("Federal District");
        a.setPostalCode("11111");
        a.setCountry("United States of America");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Trevor Belmont");
        p.setPhone("826374829");
        p.setEmail("trevor@mail.com");

        a = new Address();
        a.setStreet("Infinite Corridor");
        a.setCity("Braila");
        a.setState("Lindenfeld");
        a.setPostalCode("11011");
        a.setCountry("Transilvania");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Kyo Kusanagi");
        p.setPhone("826374829");
        p.setEmail("kyo@mail.com");

        a = new Address();
        a.setStreet("Koenji Junjo Shoppong Street");
        a.setCity("Tokyo");
        a.setState("Honshu");
        a.setPostalCode("10011");
        a.setCountry("Japan");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

        p = new Person();
        p.setName("Iori Yagami");
        p.setPhone("837462883");
        p.setEmail("iori@mail.com");

        a = new Address();
        a.setStreet("Koenji Junjo Shoppong Street");
        a.setCity("Tokyo");
        a.setState("Honshu");
        a.setPostalCode("10011");
        a.setCountry("Japan");

        a.setPerson(p);
        p.setAddress(a);

        personRepo.save(p);

    }

}
