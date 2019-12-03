package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.Dobbelsteen;
import regenwormenshared.Speler;
import regenwormenshared.Tegel;

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
    public void testSpelerCheckIfDobbelsteenMagAfleggenTrue(){
        // Arrange
        ArrayList<Dobbelsteen> afgelegdeDobbelstenen = new ArrayList<>();
        afgelegdeDobbelstenen.add(new Dobbelsteen(1, false));
        // Act
        boolean actual = speler.CheckIfDobbelsteenMagAfleggen(afgelegdeDobbelstenen, new Dobbelsteen(2, false));
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerCheckIfDobbelsteenMagAfleggenFalse(){
        // Arrange
        ArrayList<Dobbelsteen> afgelegdeDobbelstenen = new ArrayList<>();
        Dobbelsteen gekozenDobbelsteen = new Dobbelsteen(1, false);
        afgelegdeDobbelstenen.add(gekozenDobbelsteen);
        // Act
        boolean actual = speler.CheckIfDobbelsteenMagAfleggen(afgelegdeDobbelstenen, gekozenDobbelsteen);
        // Assert
        Assert.assertFalse(actual);
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
    public void testSpelerNemenReturnsTrue(){
        // Arrange
        ArrayList<Dobbelsteen> geworpenDobbelstenen = new ArrayList<>();

        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, true));
        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, false));

        Tegel gekozenTegel = new Tegel(21, true);
        // Act
        boolean actual = speler.Nemen(geworpenDobbelstenen, gekozenTegel);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpelerNemenReturnsFalseOnRegenworm(){
        // Arrange
        ArrayList<Dobbelsteen> geworpenDobbelstenen = new ArrayList<>();

        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, false));
        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, false));

        Tegel gekozenTegel = new Tegel(21, true);
        // Act
        boolean actual = speler.Nemen(geworpenDobbelstenen, gekozenTegel);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpelerNemenReturnsFalseOnWaarde(){
        // Arrange
        ArrayList<Dobbelsteen> geworpenDobbelstenen = new ArrayList<>();

        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, true));
        geworpenDobbelstenen.add(new Dobbelsteen(4, false));
        geworpenDobbelstenen.add(new Dobbelsteen(5, false));

        Tegel gekozenTegel = new Tegel(28, true);
        // Act
        boolean actual = speler.Nemen(geworpenDobbelstenen, gekozenTegel);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpelerInleveren(){
        // Arrange
        ArrayList<Tegel> rij = new ArrayList<>();
        ArrayList<Tegel> stapel = new ArrayList<>();
        stapel.add(new Tegel(28, true));
        // Act
        ArrayList<Tegel> actual = speler.Inleveren(rij, stapel);
        // Assert
        Assert.assertEquals(1, actual.size());
    }
}
