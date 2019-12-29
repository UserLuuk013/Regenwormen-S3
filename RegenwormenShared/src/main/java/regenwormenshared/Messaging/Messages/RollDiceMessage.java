package regenwormenshared.Messaging.Messages;

public class RollDiceMessage {

    private int numberOfDices;

    public int getNumberOfDices(){
        return numberOfDices;
    }

    public RollDiceMessage(int numberOfDices){
        this.numberOfDices = numberOfDices;
    }
}
