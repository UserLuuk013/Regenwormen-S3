package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.Dobbelsteen;
import regenwormenshared.Speler;
import regenwormenshared.Worp;

import java.util.ArrayList;

public class SpelerTest {

    private Speler speler;

    @Before
    public void before(){
        speler = new Speler();
    }

    @Test
    public void testSpelerInloggen(){
        // Arrange

        // Act
        boolean actual = speler.Inloggen("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerRegistreren(){
        // Arrange

        // Act
        boolean actual = speler.Registreren("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerDobbelen(){
        // Arrange
        ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
        int expected = 8;
        // Act
        ArrayList<Dobbelsteen> actualList = speler.Dobbelen(8);
        int actual = actualList.size();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSpelerAfleggen(){
        // Arrange
        ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
        int waarde = 1;
        int expected = 0;
        // Act
        ArrayList<Dobbelsteen> actualList = speler.Afleggen(dobbelstenen, waarde);
        int actual = actualList.size();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSpelerBeëindigen(){
        // Arrange
        boolean expected = true;
        // Act
        boolean actual = speler.Beëindigen();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
