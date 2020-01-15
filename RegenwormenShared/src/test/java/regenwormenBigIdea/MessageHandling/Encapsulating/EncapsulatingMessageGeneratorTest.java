package regenwormenBigIdea.MessageHandling.Encapsulating;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.MessageHandling.Encapsulating.EncapsulatingMessage;
import regenwormenshared.MessageHandling.Encapsulating.EncapsulatingMessageGenerator;

public class EncapsulatingMessageGeneratorTest {

    @Test
    public void testEncapsulatingMessageGeneratorNotNull(){
        // Arrange
        EncapsulatingMessageGenerator generator = new EncapsulatingMessageGenerator();
        // Act

        // Assert
        Assert.assertNotNull(generator);
    }

    @Test
    public void testEncapsulatingMessageGeneratorGenerateMessage(){
        // Arrange
        int expected = 123;
        EncapsulatingMessageGenerator generator = new EncapsulatingMessageGenerator();
        // Act
        EncapsulatingMessage actual = generator.generateMessage(expected);
        // Assert
        Assert.assertEquals(Integer.toString(expected), actual.getMessageData());
    }

    @Test
    public void testEncapsulatingMessageGeneratorGenerateMessageString(){
        // Arrange
        int number = 123;
        String expected = "{\"type\":\"class java.lang.Integer\",\"data\":\"123\"}";
        EncapsulatingMessageGenerator generator = new EncapsulatingMessageGenerator();
        // Act
        String actual = generator.generateMessageString(number);
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
