import java.security.InvalidParameterException;

public class BlockCipher 
{
    public String encrypt(String message, String key )
    {

        if(message == null || message.trim().isEmpty()) throw new InvalidParameterException("message null or empty");
        if(key == null || key.trim().isEmpty()) throw new InvalidParameterException("key null or empty");

        // Calculates the number of blocks
        int numberOfBlocks = message.length() / key.length();

        int messageIndex = 0;

        String encryptedMessage = "";

        // For each block,
        // encode the character 
        // using the given formula
        for(int i = 0; i < numberOfBlocks; i++)
        {
            for(int j = 0; j < key.length(); j++ )
            {
                int asciiCodeForMessageChar = (int) message.charAt(messageIndex);
                int asciiCodeForKeyChar = (int) key.charAt(j);
                messageIndex++;

                int newAsciiCode = ( ( ( asciiCodeForMessageChar - 32 ) + ( asciiCodeForKeyChar - 32 ) ) % 96 ) + 32;

                encryptedMessage += (char)newAsciiCode;
            }
        }

        // if the division of message length with key length is not whole
        // do the same encoding for the remaning chunck of block
        if(message.length() % numberOfBlocks > 0 )
        {
            for(int i = 0; i < message.length() % numberOfBlocks; i++ )
            {
                int asciiCodeForMessageChar = (int) message.charAt(messageIndex);
                int asciiCodeForKeyChar = (int) key.charAt(i);
                messageIndex++;

                int newAsciiCode = ( ( ( asciiCodeForMessageChar - 32 ) + ( asciiCodeForKeyChar - 32 ) ) % 96 ) + 32;

                encryptedMessage += (char)newAsciiCode;
            }
        }

        return encryptedMessage;
    } 
    
    public String decrypt( String encryptedMessage, String key)
    {
        if(encryptedMessage == null || encryptedMessage.trim().isEmpty()) throw new InvalidParameterException("message null or empty");
        if(key == null || key.trim().isEmpty()) throw new InvalidParameterException("key null or empty");

        // Calculates the number of blocks
        int numberOfBlocks = encryptedMessage.length() / key.length();

        int messageIndex = 0;

        String decryptedMessage = "";

        // For each block,
        // encode the character 
        // using the given formula
        for(int i = 0; i < numberOfBlocks; i++)
        {
            for(int j = 0; j < key.length(); j++ )
            {
                int asciiCodeForMessageChar = (int) encryptedMessage.charAt(messageIndex);
                int asciiCodeForKeyChar = (int) key.charAt(j);
                messageIndex++;

                int newAsciiCode =  (asciiCodeForMessageChar - asciiCodeForKeyChar ) % 96; //( ( ( asciiCodeForMessageChar + 32 ) + ( asciiCodeForKeyChar + 32 ) ) % 96 ) - 32;

                decryptedMessage += (char)newAsciiCode;
            }
        }

        // if the division of message length with key length is not whole
        // do the same encoding for the remaning chunck of block
        if(encryptedMessage.length() % numberOfBlocks > 0 )
        {
            for(int i = 0; i < encryptedMessage.length() % numberOfBlocks; i++ )
            {
                int asciiCodeForMessageChar = (int) encryptedMessage.charAt(messageIndex);
                int asciiCodeForKeyChar = (int) key.charAt(i);
                messageIndex++;

                int newAsciiCode = ( ( ( asciiCodeForMessageChar + 32 ) + ( asciiCodeForKeyChar + 32 ) ) % 96 ) - 32;

                decryptedMessage += (char)newAsciiCode;
            }
        }

        return decryptedMessage;
    }
}