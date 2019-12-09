package regenwormenBigIdea.DTO;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.PlayerDTO;

public class PlayerDTOTest {

    @Test
    public void testPlayerDTONotNull(){
        // Arrange
        PlayerDTO playerDTO = new PlayerDTO("Luuk", "Regenwormen123!");
        // Act

        // Assert
        Assert.assertNotNull(playerDTO);
    }

    @Test
    public void testPlayerDTOGetUsername(){
        // Arrange
        String expected = "Luuk";
        PlayerDTO playerDTO = new PlayerDTO(expected, "Regenwormen123!");
        // Act
        String actual = playerDTO.getUsername();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerDTOGetPassword(){
        // Arrange
        String expected = "Regenwormen123!";
        PlayerDTO playerDTO = new PlayerDTO("Luuk", expected);
        // Act
        String actual = playerDTO.getPassword();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
