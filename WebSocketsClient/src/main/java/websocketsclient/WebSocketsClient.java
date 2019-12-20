package websocketsclient;

import Messaging.WebSocketsMessage;

/**
 * Hello world!
 *
 */
public class WebSocketsClient
{
    public static void main( String[] args )
    {
        WebSocketsClientEndpoint.getInstance().startClient();
//        WebSocketsClientEndpoint.getInstance().send(createMessage());
    }

//    public static WebSocketsMessage createMessage(){
//        UserMessage userMessage = new UserMessage("Hello!", "Luuk");
//        String data = userMessage.toString();
//        return new WebSocketsMessage(data, userMessage.getClass().getCanonicalName());
//    }
}
