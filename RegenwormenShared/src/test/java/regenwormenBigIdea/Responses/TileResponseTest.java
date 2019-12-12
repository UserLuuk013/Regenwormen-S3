package regenwormenBigIdea.Responses;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Responses.TileResponse;

public class TileResponseTest {

    @Test
    public void testTileResponseNotNull(){
        // Arrange
        TileResponse tileResponse = new TileResponse();
        // Act

        // Assert
        Assert.assertNotNull(tileResponse);
    }

    @Test
    public void testTileResponseIsSuccess(){
        // Arrange
        TileResponse tileResponse = new TileResponse();
        // Act
        tileResponse.setSuccess(true);
        boolean actual = tileResponse.isSuccess();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testTileResponseGetTile(){
        // Arrange
        TileDTO expected = new TileDTO();
        TileResponse tileResponse = new TileResponse();
        // Act
        tileResponse.setTile(expected);
        TileDTO actual = tileResponse.getTile();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
