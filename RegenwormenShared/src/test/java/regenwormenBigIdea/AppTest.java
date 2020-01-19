package regenwormenBigIdea;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Dice;
import regenwormenshared.models.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void checkIfGameEnded(){

        List<Tile> row = new ArrayList<>();
        for (int i = 21; i < 37; i++){
            Tile tile = new Tile(i, 1);
//            tile.setVisible(false);
            row.add(tile);
        }

        boolean gameEnded = false;
        for (Tile tile : row){
            if (row.size() == 0 || !tile.isVisible()){
                gameEnded = true;
                break;
            }
        }

        Assert.assertFalse(gameEnded);
    }
}
