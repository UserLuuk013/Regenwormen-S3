package regenwormenBigIdea.Converters;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Tile;

public class TileDTOModelConverterTest {

    @Test
    public void testTileDTOModelConverterNotNull(){
        // Arrange
        TileDTOModelConverter cvt = new TileDTOModelConverter();
        // Act

        // Assert
        Assert.assertNotNull(cvt);
    }

    @Test
    public void testModelFromDTO(){
        // Arrange
        TileDTOModelConverter cvt = new TileDTOModelConverter();
        TileDTO dto = new TileDTO(21, "image.jpg", 1);
        Tile expected = new Tile(21, "image.jpg", 1);
        // Act
        Tile actual = cvt.ModelFromDTO(dto);
        // Assert
        Assert.assertEquals(expected.getValue(), actual.getValue());
        Assert.assertEquals(expected.getImage(), actual.getImage());
        Assert.assertEquals(expected.getAmountOfRegenwormen(), actual.getAmountOfRegenwormen());
    }

    @Test
    public void testModelToDTO(){
        // Arrange
        TileDTOModelConverter cvt = new TileDTOModelConverter();
        Tile t = new Tile(21, "image.jpg", 1);
        TileDTO expected = new TileDTO(21, "image.jpg", 1);
        // Act
        TileDTO actual = cvt.ModelToDTO(t);
        // Assert
        Assert.assertEquals(expected.getValue(), actual.getValue());
        Assert.assertEquals(expected.getImage(), actual.getImage());
        Assert.assertEquals(expected.getAmountOfRegenwormen(), actual.getAmountOfRegenwormen());
    }
}
