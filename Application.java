public class Application
{
    public static void main(String[] args) 
    {
       CaesarCipher caesarCipher = new CaesarCipher();
       System.out.println(caesarCipher.cipher(  "abra-KADAbra testetererdf 12323434$%$%$^5656 bla bla", 2)); // it should print: cdtc-MCFCdtc vguvgvgtgtfh 12323434$%$%$^5656 dnc dnc
    }
}