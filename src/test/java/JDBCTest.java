import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JDBCTest {

    @Test
    public void createDBTest() {
        //given
        JDBC jdbc = new JDBC();
        String name1 = "transportcompany.db";
        File file1 = new File(name1);

        //when
        jdbc.createDataBase(name1);

        //then
        assertTrue(file1.exists());

    }

    @Test
    public void createTablesTest() {
        //given
        JDBC jdbc = new JDBC();

        //when
        boolean create = jdbc.createTables();

        //then
        assertTrue(create);

    }
}
