package sdaacademy.mvcapp.model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

//    private Model model;   MOZNA TAK ABY ZA KAZDYM RAZEM NIE TWORZYC NOWEGO MODELU
//    @BeforeEach
//    public void initTest(){
//        model = new Model();
//    }

    @org.junit.jupiter.api.Test
    void loadModel() {
        assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    void addNewPerson() {
        Model model = new Model();
        Person testPerson = new Person();
        testPerson.setId(1);
        testPerson.setName("Karolina");
        testPerson.setPhone("2939239");

        model.addNewPerson(testPerson);

        assertNotNull(model.getAll());
        assertTrue(model.getAll().size() == 1);

        Person person = model.getAll().get(0);

        assertNotNull(person);
        assertEquals(testPerson.getId(), person.getId());
        assertEquals(testPerson.getName(), person.getName());
        assertEquals(testPerson.getPhone(), person.getPhone());
    }

    @org.junit.jupiter.api.Test
    void findByName() {
        Model model = new Model();
        Person testPerson = new Person();
        testPerson.setName("Karolina");
        testPerson.setPhone("2939239");

        model.addNewPerson(testPerson);
        Person test = model.findByName(testPerson.getName());

        assertNotNull(test);
        assertEquals(testPerson.getName(), test.getName());
        assertEquals(testPerson.getPhone(), test.getPhone());
    }

    @org.junit.jupiter.api.Test
    void findAllByName(){
        Model model = new Model();
        Person testPerson = new Person();
        testPerson.setName("Karo");
        testPerson.setPhone("2939239");
        model.addNewPerson(testPerson);
        for (int i = 1; i <= 5; i++){
            Person testPersonlist = new Person();
            testPersonlist.setId(i);
            testPersonlist.setName("Karolina");
            testPersonlist.setPhone("2939239");
            model.addNewPerson(testPersonlist);
        }
        assertEquals(5,model.findAllByName("Karolina").size());
        assertEquals(1,model.findAllByName("Karo").size());

    }

    @org.junit.jupiter.api.Test
    void deletePersonById() {
        Model model = new Model();
        Person testPerson = new Person();
        testPerson.setId(1);
        testPerson.setName("Karolina");
        testPerson.setPhone("2939239");
        model.addNewPerson(testPerson);
        assertTrue(model.getAll().size() == 1);
        model.deletePersonById(testPerson.getId());
        assertTrue(model.getAll().size() == 0);

    }

    @org.junit.jupiter.api.Test
    void updatePerson() {
        Model model = new Model();
        Person testPerson = new Person();
        testPerson.setId(1);
        testPerson.setName("Karolina");
        testPerson.setPhone("2939239");
        model.addNewPerson(testPerson);
        testPerson.setName("Inne imię");
        testPerson.setPhone("Inny tel");
        model.updatePerson(testPerson);
        assertTrue(model.getAll().size() == 1);
        Person test = model.getAll().get(0);
        assertEquals(testPerson.getName(), test.getName());
        assertEquals(testPerson.getPhone(),test.getPhone());


    }

    @org.junit.jupiter.api.Test
    void getAll() {
        Model model = new Model();
        int count = 1000;
        for (int i = 1; i <= count; i++){
            Person testPerson = new Person();
            testPerson.setId(i);
            testPerson.setName("Karolina");
            testPerson.setPhone("2939239");
            model.addNewPerson(testPerson);
        }
        assertEquals(count,model.getAll().size());

//        int count = 1000;
//        for(int i = 0; i < count; i++){
//            model.addNewPerson(new Person());
//        }
//        assertEquals(model.getAll().size(), count);
    }

}