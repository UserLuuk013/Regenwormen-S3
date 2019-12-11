package restserver.Repositories;

import regenwormenshared.Models.Dice;
import restserver.Interfaces.IDiceContext;

import java.util.List;

public class DiceRepository {

    private IDiceContext context;

    public DiceRepository(IDiceContext context){
        this.context = context;
    }

    public List<Dice> GetAll(){
        return context.GetAll();
    }
}
