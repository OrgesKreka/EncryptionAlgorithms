public class BlockCipher 
{
    public String Encrypt(String message, String key )
    {
        int numberOfBlocks = message.length() / key.length();

        int messageIndex = 0;

        String encryptedMessage = "";

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

        if(message.length() % numberOfBlocks > 0 )
        {
            System.err.println("brenda ?");
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
}