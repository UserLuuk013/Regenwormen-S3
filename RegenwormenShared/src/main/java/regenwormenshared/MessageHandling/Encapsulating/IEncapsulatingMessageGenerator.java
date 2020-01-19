package regenwormenshared.messageHandling.encapsulating;

public interface IEncapsulatingMessageGenerator {
    EncapsulatingMessage generateMessage(Object content);

    String generateMessageString(Object content);
}
