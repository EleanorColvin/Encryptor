public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }
  
  public String[][] getLetterBlock()
  {
    return letterBlock;
  }
  
  /** Places a string into letterBlock in row-major order.
   *
   *   @param str  the string to be processed
   *
   *   Postcondition:
   *     if str.length() < numRows * numCols, "A" in each unfilled cell
   *     if str.length() > numRows * numCols, trailing characters are ignored
   */
  public void fillBlock(String str) {
    int idx = 0;
    for (int r = 0; r < letterBlock.length; r++) {
      for (int c = 0; c < letterBlock[0].length; c++) {
        if (idx > str.length() - 1) {
          letterBlock[r][c] = "A";
          idx++;
        } else {
          letterBlock[r][c] = str.substring(idx, idx + 1);
          idx++;
        }
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *
   *   Precondition: letterBlock has been filled
   *
   *   @return the encrypted string from letterBlock
   */
  public String encryptBlock()
  {
    String str = "";
    for (int c = 0; c < letterBlock[0].length; c++)
    {
      for (int r = 0; r < letterBlock.length; r++)
      {
        str += letterBlock[r][c];
      }
    }
    return str;
  }

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    String str = "";
    String currentStr = "";
    int length = letterBlock.length * letterBlock[0].length;
    for (int i = 0; i < message.length(); i+= length)
    {
      if (i + length > message.length())
      {
        currentStr = message.substring(i, message.length());
      }
      else
      {
        currentStr = message.substring(i, i + length);
      }
      fillBlock(currentStr);
      str +=encryptBlock();
    }
    return str;
  }
  
  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e. 
   *         the ???encryption key??? that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption. 
   *  
   *   @param encryptedMessage  the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String encryptedMessage)
  {
    String str = "";
    String currentStr = "";
    int length = letterBlock.length * letterBlock[0].length;
    for (int i = 0; i < encryptedMessage.length(); i+= length)
    {
        currentStr = encryptedMessage.substring(i, i + length);
        fillBlock(currentStr);
        str += decryptBlock();
    }
    return str;
  }

  public String decryptBlock()
  {
    String str = "";
    String[][] temp = new String[letterBlock.length][letterBlock[0].length];

    for (int r = 0; r < letterBlock.length; r++)
    {
      for (int c = 0; c < letterBlock[0].length; c++)
      {
        str += letterBlock[r][c];
      }
    }
    int idx = 0;
    for (int c = 0; c < temp[0].length; c++){
      for (int r = 0; r < temp.length; r++) {
          temp[r][c] = str.substring(idx, idx + 1);
          idx++;
      }
    }
  str = "";
    for (int r = 0; r < temp.length; r++)
    {
      for (int c = 0; c < temp[0].length; c++)
      {
        str += temp[r][c];
      }
    }
    for (int i = str.length(); i > 0; i--)
    {
      if(str.substring(i -1, i).equals("A"))
      {
        str = str.substring(0, i - 1);
      }
      else
      {
        i = 0;
      }
    }
    return str;
  }
}