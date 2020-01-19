package regenwormenBigIdea.Results;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Tile;
import regenwormenshared.results.ReturnTileResult;

import java.util.ArrayList;
import java.util.List;

public class ReturnTileResultTest {

    @Test
    public void testReturnTileResultNotNull(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act

        // Assert
        Assert.assertNotNull(returnTileResult);
    }

    @Test
    public void testReturnTileResultGetRow(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act
        List<Tile> actual = returnTileResult.getRow();
        // Assert
        Assert.assertEquals(returnTileResult.getRow(), actual);
    }

    @Test
    public void testReturnTileResultGetStack(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act
        List<Tile> actual = returnTileResult.getStack();
        // Assert
        Assert.assertEquals(returnTileResult.getStack(), actual);
    }
}
