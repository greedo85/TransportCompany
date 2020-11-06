import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateDBTest {

    @Test
    public void createDBTest()
    {
        //given
        JDBC jdbc=new JDBC();
        String name1 = "transportcompany.db";
        String name2 = "transportcompany.db";
        File file1=new File(name1);

        //when
        jdbc.createDataBase(name1);
        jdbc.createDataBase(name2);

        //then
        assertTrue(file1.exists());

    }
}
