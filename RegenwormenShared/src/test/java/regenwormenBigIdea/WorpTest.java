package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Dobbelsteen;
import regenwormenshared.Worp;

import java.util.ArrayList;

public class WorpTest {

    @Test
    public void testWorpNotNull(){
        // Arrange
        Worp worp = new Worp();
        // Act

        // Assert
        Assert.assertNotNull(worp);
    }

    @Test
    public void testGenereerWorp(){
        // Arrange
        Worp worp = new Worp();
        int expected = 5;
        // Act
        ArrayList<Dobbelsteen> actual = worp.GenereerWorp(5);
        // Assert
        Assert.assertEquals(expected, actual.size());
    }
}
