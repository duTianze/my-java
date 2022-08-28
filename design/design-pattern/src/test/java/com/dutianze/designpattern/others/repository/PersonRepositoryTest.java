package com.dutianze.designpattern.others.repository;

import com.dutianze.designpattern.others.repository.person.Person;
import com.dutianze.designpattern.others.repository.person.PersonRepository;
import com.dutianze.designpattern.others.repository.person.PersonSpecifications;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@SpringBootTest
class PersonRepositoryTest {

    @Resource
    private PersonRepository repository;

    private final Person peter = new Person("Peter", "Sagan", 17);
    private final Person nasta = new Person("Nasta", "Kuzminova", 25);
    private final Person john = new Person("John", "lawrence", 35);
    private final Person terry = new Person("Terry", "Law", 36);

    private final List<Person> persons = List.of(peter, nasta, john, terry);

    @BeforeEach
    public void setup() {
        repository.saveAll(persons);
    }

    @AfterEach
    public void cleanup() {
        repository.deleteAll();
    }

    @Test
    void testFindAll() {
        ArrayList<Person> actualPersons = Lists.newArrayList(repository.findAll());
        assertTrue(actualPersons.containsAll(persons) && persons.containsAll(actualPersons));
    }

    @Test
    void testSave() {
        Person terry = repository.findByName("Terry");
        terry.setSurname("Lee");
        terry.setAge(47);
        repository.save(terry);

        terry = repository.findByName("Terry");
        assertEquals(terry.getSurname(), "Lee");
        assertEquals(47, terry.getAge());
    }

    @Test
    void testDelete() {
        Person terry = repository.findByName("Terry");
        repository.delete(terry);

        assertEquals(3, repository.count());
        assertNull(repository.findByName("Terry"));
    }

    @Test
    void testCount() {
        assertEquals(4, repository.count());
    }

    @Test
    void testFindAllByAgeBetweenSpec() {
        List<Person> persons = repository.findAll(new PersonSpecifications.AgeBetweenSpec(20, 40));

        assertEquals(3, persons.size());
        assertTrue(persons.stream().allMatch((item) -> item.getAge() > 20 && item.getAge() < 40));
    }

    @Test
    void testFindOneByNameEqualSpec() {
        Optional<Person> actual = repository.findOne(new PersonSpecifications.NameEqualSpec("Terry"));
        assertTrue(actual.isPresent());
        assertEquals(terry, actual.get());
    }
}