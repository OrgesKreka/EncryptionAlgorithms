public class Application
{
    public static void main(String[] args) 
    {
      // CaesarCipher caesarCipher = new CaesarCipher();
      // System.out.println(caesarCipher.encrypt(  "abra-KADAbra testetererdf 12323434$%$%$^5656 bla bla", 2)); // it should print: cdtc-MCFCdtc vguvgvgtgtfh 12323434$%$%$^5656 dnc dnc
      // System.out.println(caesarCipher.decrypt("cdtc-MCFCdtc vguvgvgtgtfh 12323434$%$%$^5656 dnc dnc", 2));
      
      BlockCipher blockCipher = new BlockCipher();
      System.out.println( blockCipher.Encrypt("LAUREATO_1", "OLE"));
    }
}