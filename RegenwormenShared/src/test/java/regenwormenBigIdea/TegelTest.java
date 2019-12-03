package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Tegel;

public class TegelTest {

    @Test
    public void testTegelNotNull(){
        // Arrange
        Tegel tegel = new Tegel(21, true);
        // Act

        // Assert
        Assert.assertNotNull(tegel);
    }

    @Test
    public void testTegelGetWaarde(){
        // Arrange
        int expected = 21;
        Tegel tegel = new Tegel(expected, true);
        // Act
        int actual = tegel.getWaarde();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTegelGetZichtbaar(){
        // Arrange
        Tegel tegel = new Tegel(21, true);
        // Act
        boolean actual = tegel.isZichtbaar();
        // Assert
        Assert.assertTrue(actual);
    }
}
