package restclient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.dto.PlayerDTO;

public class AuthenticationTest {

    private RestClient restClient;
    @Before
    public void before(){
        restClient = new RestClient();
    }

    @Test
    public void testLoginExistingAccount(){
        // Arrange
        String username = "UserLuuk013";
        String password = "Regenwormen123!";
        // Act
        PlayerDTO playerDTO = restClient.playerLogin(username, password);
        // Assert
        Assert.assertNotNull(playerDTO);
    }

    @Test
    public void testLoginWrongUsername(){
        // Arrange
        String username = "UserLuuk01";
        String password = "Regenwormen123!";
        // Act
        PlayerDTO playerDTO = restClient.playerLogin(username, password);
        // Assert
        Assert.assertNull(playerDTO);
    }

    @Test
    public void testLoginWrongPassword(){
        // Arrange
        String username = "UserLuuk013";
        String password = "Regenwormen123";
        // Act
        PlayerDTO playerDTO = restClient.playerLogin(username, password);
        // Assert
        Assert.assertNull(playerDTO);
    }
}
