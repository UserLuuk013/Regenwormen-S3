package regenwormenBigIdea;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Messaging.Server.GameServer;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Tile;

import java.util.ArrayList;
import java.util.HashSet;
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
    public void checkIfTakenDicesContainsThrownDice(){
        GameServer gameServer = new GameServer(null);

        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(5, "image.jpg", false));
        takenDices.add(new Dice(3, "image.jpg", false));

        List<Dice> thrownDices = new ArrayList<>();
        thrownDices.add(new Dice(5, "image.jpg", false));
        thrownDices.add(new Dice(3, "image.jpg", false));

        // Act
        boolean bool = gameServer.isAllInList();
        // Assert
        Assert.assertTrue(bool);
    }

    @Test
    public void checkIfGameEnded(){

        List<Tile> row = new ArrayList<>();
        for (int i = 21; i < 37; i++){
            Tile tile = new Tile(i, "image.jpg", 1);
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
