package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.Models.Player;

public class PlayerTest {

    private Player player;

    @Before
    public void before(){
        player = new Player();
    }

    @Test
    public void testPlayerNotNull(){
        // Arrange

        // Act

        // Assert
        Assert.assertNotNull(player);
    }

    @Test
    public void testPlayerLogin(){
        // Arrange

        // Act
        boolean actual = player.Login("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testPlayerRegister(){
        // Arrange

        // Act
        boolean actual = player.Register("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertTrue(actual);
    }
}
