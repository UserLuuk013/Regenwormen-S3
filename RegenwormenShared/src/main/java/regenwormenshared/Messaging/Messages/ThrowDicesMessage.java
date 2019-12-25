package regenwormenshared.Messaging.Messages;

public class ThrowDicesMessage {

    private int numberOfDices;

    public int getNumberOfDices(){
        return numberOfDices;
    }

    public ThrowDicesMessage(int numberOfDices){
        this.numberOfDices = numberOfDices;
    }
}
