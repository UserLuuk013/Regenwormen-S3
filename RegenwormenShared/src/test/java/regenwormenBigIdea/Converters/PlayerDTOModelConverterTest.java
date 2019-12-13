package regenwormenBigIdea.Converters;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.Models.Player;

public class PlayerDTOModelConverterTest {

    @Test
    public void testPlayerDTOModelConverterNotNull(){
        // Arrange
        PlayerDTOModelConverter cvt = new PlayerDTOModelConverter();
        // Act

        // Assert
        Assert.assertNotNull(cvt);
    }

    @Test
    public void testModelFromDTO(){
        // Arrange
        PlayerDTOModelConverter cvt = new PlayerDTOModelConverter();
        PlayerDTO dto = new PlayerDTO(1, "Luuk", "Regenwormen123!");
        Player expected = new Player(1, "Luuk", "Regenwormen123!");
        // Act
        Player actual = cvt.ModelFromDTO(dto);
        // Assert
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
    }

    @Test
    public void testModelToDTO(){
        // Arrange
        PlayerDTOModelConverter cvt = new PlayerDTOModelConverter();
        Player p = new Player(1, "Luuk", "Regenwormen123!");
        PlayerDTO expected = new PlayerDTO(1, "Luuk", "Regenwormen123!");
        // Act
        PlayerDTO actual = cvt.ModelToDTO(p);
        // Assert
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
    }
}
