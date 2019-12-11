package restserver.Interfaces;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IDiceContext {
    List<Dice> GetAll();
}
