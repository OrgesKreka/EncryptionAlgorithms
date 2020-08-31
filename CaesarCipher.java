import java.security.InvalidParameterException;

/*
    The Caesar cipher is a substitution cipher
    that transforms a message by shifting its letters by a given offset.

    Let's say we want to shift the alphabet by 3, then the letter A would be transformed to letter D
    B to E, C to F and so on.

    Once the transformation goes beyond the letter Z, we go back to the start
    of the alphabet, so that X, Y and Z are transformed into A, B and C respectively.

    We can transform any offset into a simpler offset by performing a modulo 26 ( as the number of alphabet letters ) on it.

    NOTES: You can use either left shift or right shift but not both in the same text!
           If you want to see Caesar cipher in mathematical way, then formula to get encrypted letter will be:
           e = ( x + n ) mod 26 where
           n is the number of positions we need to shift plaintext characters
           x is the place value of the original letter
           e is the place of the encrypted value
 */
public class CaesarCipher 
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // This method will encrypt the message using Caesar cipher.
    // 
    // 1. The offset should be positive
    // 2. The string should not be null or empty
    String encrypt(String message, int offset )
    {
        if(offset < 0 ) throw new InvalidParameterException("Offset less than 0 ");

        if(message == null || message.trim().isEmpty()) throw new InvalidParameterException("message null or empty");


        String encryptedMessage = "";

        // Second, initiliaze empty string and add aplhabets
        for(int i = 0; i < message.length(); i++)
        {
            char character = message.charAt(i);

            // if the character is not alphabetic, we leave it as it is
            // and continue to the other letter
            if( ! Character.isAlphabetic(character))
            {
                encryptedMessage += character;
                continue;
            }
            
                // value of each alphabet in integers like A = 0, B = 1 ...
            int letterIndex = ALPHABET.indexOf(Character.toLowerCase(character));

            // index of shifted letter
            int shiftedIndex = (offset + letterIndex) % ALPHABET.length();

            // new value
            char shiftedValue = ALPHABET.charAt(shiftedIndex);

            // if letter in the message is upperCase shifted letter is also in upper case
            encryptedMessage += Character.isUpperCase(character) ? Character.toUpperCase(shiftedValue) : shiftedValue;
            

        }

        return encryptedMessage;
    }


    public String decrypt(String encryptedMessage, int offset )
    {
        if(offset < 0 ) throw new InvalidParameterException("Offset less than 0 ");

        if(encryptedMessage == null || encryptedMessage.trim().isEmpty()) throw new InvalidParameterException("encrypted null or empty");


        String decryptedMessage = "";

         // Second, initiliaze empty string and add aplhabets
         for(int i = 0; i < encryptedMessage.length(); i++)
         {
             char character = encryptedMessage.charAt(i);
 
             // if the character is not alphabetic, we leave it as it is
             // and continue to the other letter
             if( ! Character.isAlphabetic(character))
             {
                 decryptedMessage += character;
                 continue;
             }
             
                 // value of each alphabet in integers like A = 0, B = 1 ...
             int letterIndex = ALPHABET.indexOf(Character.toLowerCase(character));
 
             // index of unShifted letter
             int unShiftedIndex = (letterIndex - offset) % ALPHABET.length();
             
             // if the offset is greater than length of the alphabet
             // we find the letter index by adding the unshiftedIndex
             if(unShiftedIndex < 0 )
                unShiftedIndex = ALPHABET.length() + unShiftedIndex;

             // new value
             char unShiftedValue = ALPHABET.charAt(unShiftedIndex);
 
             // if letter in the message is upperCase shifted letter is also in upper case
             decryptedMessage += Character.isUpperCase(character) ? Character.toUpperCase(unShiftedValue) : unShiftedValue;
             
 
         }
 
         return decryptedMessage;
    }
}