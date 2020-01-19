package regenwormenBigIdea.MessageHandling.Encapsulating;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.messageHandling.encapsulating.EncapsulatingMessage;

public class EncapsulatingMessageTest {

    @Test
    public void testEncapsulatingMessageNotNull(){
        // Arrange
        EncapsulatingMessage message = new EncapsulatingMessage("", "");
        // Act

        // Assert
        Assert.assertNotNull(message);
    }

    @Test
    public void testEncapsulatingMessageGetMessageType(){
        // Arrange
        String expected = "message1";
        EncapsulatingMessage message = new EncapsulatingMessage(expected, "123");
        // Act
        String actual = message.getMessageType();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEncapsulatingMessageGetMessageData(){
        // Arrange
        String expected = "123";
        EncapsulatingMessage message = new EncapsulatingMessage("message1", expected);
        // Act
        String actual = message.getMessageData();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
