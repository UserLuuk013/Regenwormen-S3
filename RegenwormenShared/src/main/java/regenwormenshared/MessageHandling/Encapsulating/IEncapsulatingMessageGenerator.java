package regenwormenshared.messagehandling.encapsulating;

public interface IEncapsulatingMessageGenerator {
    EncapsulatingMessage generateMessage(Object content);

    String generateMessageString(Object content);
}
