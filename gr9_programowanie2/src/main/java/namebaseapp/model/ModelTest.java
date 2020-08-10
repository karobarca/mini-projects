package namebaseapp.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void load() throws IOException {
        Model model = new Model();

        try {
            model.load("C:\\Users\\Lenovo\\Desktop\\pliki do apki\\imiona.csv");
            assertTrue(model.getNames().size() > 0);

            ChildName first = model.getNames().get(0);
            assertNotNull(first);
            assertNotNull(first.getName());
            assertNotNull(first.getYear());
            assertNotNull(first.getSex());
            assertNotNull(first.getCount());

        } catch (IOException e) {
            fail(e);
        }


    }
}