import java.security.InvalidParameterException;

public class DictionaryCipher 
{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int CODE_9 = 57;


    public String encrypt(String message)
    {
        if(message == null || message.trim().isEmpty()) throw new InvalidParameterException("message null or empty");

        String encryptedMessage = "";

        for(int i = 0; i< message.length(); i++)
        {
            var character = message.charAt(i);

            if(Character.isDigit(character))
                encryptedMessage += (char)(CODE_9 - Character.getNumericValue(character));

            else if(Character.isUpperCase(character))
                encryptedMessage += (char) ('z' - Character.toLowerCase(character) + 'a');

            else if(Character.isLowerCase(character))
                encryptedMessage += (char)('Z' - Character.toUpperCase(character) + 'A');
            else
                encryptedMessage += character;
        }

        return encryptedMessage;
    }

    public String decrypt(String encryptedMessage)
    {
        if(encryptedMessage == null || encryptedMessage.trim().isEmpty()) throw new InvalidParameterException("encryptedMessage null or empty");

        String message = "";

        for(int i = 0; i< encryptedMessage.length(); i++)
        {
            var character = encryptedMessage.charAt(i);

            if(Character.isDigit(character))
                message += (char)(CODE_9 - Character.getNumericValue(character));

            else if(Character.isUpperCase(character))
                message += (char) ('z' + Character.toLowerCase(character) - 'a');

            else if(Character.isLowerCase(character))
                message += (char)('Z' + Character.toUpperCase(character) - 'A');
            else
                message += character;
        }

        return message;
    }
}




