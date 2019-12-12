package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;

import java.util.ArrayList;
import java.util.List;

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
        Player actual = player.Login("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testPlayerRegister(){
        // Arrange

        // Act
        boolean actual = player.Register("Luuk", "Regenwormen123!");
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testPlayerCreateDTONotNull(){
        // Arrange

        // Act
        PlayerDTO playerDTO = player.CreateDTO();
        // Assert
        Assert.assertNotNull(playerDTO);
    }

    @Test
    public void testPlayerGetUsername(){
        // Arrange
        String expected = "Luuk";
        Player player = new Player(expected, "Regenwormen123!");
        // Act
        String actual = player.getUsername();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetPassword(){
        // Arrange
        String expected = "Regenwormen123!";
        Player player = new Player("Luuk", expected);
        // Act
        String actual = player.getPassword();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetId(){
        // Arrange
        int expected = 1;
        Player player = new Player("Luuk", "Regenwormen123!");
        // Act
        player.setId(expected);
        int actual = player.getId();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetNumberOfRegenwormen(){
        // Arrange
        int expected = 10;
        Player player = new Player("Luuk", "Regenwormen123!");
        // Act
        player.setNumberOfRegenwormen(expected);
        int actual = player.getNumberOfRegenwormen();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetStack(){
        // Arrange
        List<Tile> expected = new ArrayList<>();
        Player player = new Player("Luuk", "Regenwormen123!");
        // Act
        player.setStack(expected);
        List<Tile> actual = player.getStack();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
