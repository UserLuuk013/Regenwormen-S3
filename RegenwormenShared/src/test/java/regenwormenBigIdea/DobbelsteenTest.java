package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Dobbelsteen;

public class DobbelsteenTest {

    @Test
    public void testDobbelsteenNotNull(){
        // Arrange
        Dobbelsteen dobbelsteen = new Dobbelsteen(1, false);
        // Act

        // Assert
        Assert.assertNotNull(dobbelsteen);
    }

    @Test
    public void testDobbelsteenGetWaarde(){
        // Arrange
        int expected = 1;
        Dobbelsteen dobbelsteen = new Dobbelsteen(expected, false);
        // Act
        int actual = dobbelsteen.getWaarde();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDobbelsteenGetRegenworm(){
        // Arrange
        Dobbelsteen dobbelsteen = new Dobbelsteen(1, false);
        // Act
        boolean actual = dobbelsteen.getRegenworm();
        // Assert
        Assert.assertFalse(actual);
    }
}
