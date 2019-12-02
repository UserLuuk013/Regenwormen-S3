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
    public void testSpelerIsNotNull(){
        // Arrange

        // Act

        // Assert
        Assert.assertNotNull(speler);
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
        ArrayList<Dobbelsteen> afgelegdeDobbelstenen = new ArrayList<>();
        afgelegdeDobbelstenen.add(new Dobbelsteen(1, false));
        // Act
        ArrayList<Dobbelsteen> geworpenDobbelstenen = speler.Dobbelen(7);
        ArrayList<Dobbelsteen> actualList = speler.Afleggen(geworpenDobbelstenen, afgelegdeDobbelstenen, new Dobbelsteen(5, false));
        int actual = actualList.size();
        // Assert
        Assert.assertNotEquals(7, actual);
    }

    @Test
    public void testSpelerBeëindigen(){
        // Arrange
        // Act
        boolean actual = speler.Beëindigen();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerCheckIfTegelIsNeembaar(){
        // Arrange
        int worpresultaat = 25;
        int aantalregenwormen = 2;
        // Act
        boolean actual = speler.CheckIfTegelIsNeembaar(worpresultaat, aantalregenwormen);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerInleveren(){
        // Arrange

        // Act
        boolean actual = speler.Inleveren();
        // Assert
        Assert.assertTrue(actual);
    }
}
