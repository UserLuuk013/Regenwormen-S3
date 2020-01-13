package regenwormenBigIdea.Responses;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.Responses.PlayerResponse;

public class PlayerResponseTest {

    @Test
    public void testPlayerResponseNotNull(){
        // Arrange
        PlayerResponse playerResponse = new PlayerResponse();
        // Act

        // Assert
        Assert.assertNotNull(playerResponse);
    }

    @Test
    public void testPlayerResponseIsSuccess(){
        // Arrange
        PlayerResponse playerResponse = new PlayerResponse();
        // Act
        playerResponse.setSuccess(true);
        boolean actual = playerResponse.isSuccess();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testPlayerResponseGetPlayer(){
        // Arrange
        PlayerDTO expected = new PlayerDTO();
        PlayerResponse playerResponse = new PlayerResponse();
        // Act
        playerResponse.setPlayer(expected);
        PlayerDTO actual = playerResponse.getPlayer();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
