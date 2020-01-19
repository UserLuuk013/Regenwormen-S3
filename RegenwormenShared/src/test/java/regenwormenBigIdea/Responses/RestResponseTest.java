package regenwormenBigIdea.Responses;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.dto.PlayerDTO;
import regenwormenshared.models.Player;
import regenwormenshared.responses.RestResponse;

public class RestResponseTest {

    @Test
    public void tesRestResponseNotNull(){
        // Arrange
        RestResponse response = new RestResponse();
        // Act

        // Assert
        Assert.assertNotNull(response);
    }

    @Test
    public void testRestResponseGetSuccess(){
        // Arrange
        RestResponse response = new RestResponse();
        // Act
        response.setSuccess(true);
        boolean actual = response.isSuccess();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRestResponseGetPlayer(){
        // Arrange
        RestResponse response = new RestResponse();
        PlayerDTO expected = new PlayerDTO();
        // Act
        response.setPlayer(expected);
        PlayerDTO actual = response.getPlayer();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
