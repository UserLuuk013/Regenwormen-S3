package regenwormenBigIdea.Responses;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.Responses.DiceResponse;

public class DiceResponseTest {

    @Test
    public void testDiceResponseNotNull(){
        // Arrange
        DiceResponse diceResponse = new DiceResponse();
        // Act

        // Assert
        Assert.assertNotNull(diceResponse);
    }

    @Test
    public void testDiceResponseIsSuccess(){
        // Arrange
        DiceResponse diceResponse = new DiceResponse();
        // Act
        diceResponse.setSuccess(true);
        boolean actual = diceResponse.isSuccess();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testDiceResponseGetDice(){
        // Arrange
        DiceDTO expected = new DiceDTO();
        DiceResponse diceResponse = new DiceResponse();
        // Act
        diceResponse.setDice(expected);
        DiceDTO actual = diceResponse.getDice();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
