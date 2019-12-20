package regenwormenshared.MessageHandling.Encapsulating;

public interface IEncapsulatingMessageGenerator {
    EncapsulatingMessage generateMessage(Object content);

    String generateMessageString(Object content);
}
