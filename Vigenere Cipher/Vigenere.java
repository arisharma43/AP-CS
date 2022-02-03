public class Vigenere
{
   // declare instance variables for text and keyword
    String plainText;
    String key;

   // default constructor
   public Vigenere ()
   {
	   plainText = "";
	   key = "";
   }
    
   // initialization constructor
   public Vigenere (String theMsg, String theKey)
   {
	   plainText = theMsg;
	   key = theKey;
   }
    
   // modifier method for plainText
   public void setPlainText(String theMsg) {
	   plainText = theMsg;
   }
    
   // modifier method for key
   public void setKey(String theKey) {
	   key = theKey;
   }
    
   // accessor method for plainText
   public String getPlainText() {
	   return plainText;
   }
    
   // accessor method for key
   public String getKey() {
	   return key;
   }
    
   // encrypt method
   //   return a String
   //   no parameters
   public String encrypt()
   {
	   String temp = key;
	   String cipherText = "";
	   int x = plainText.length();
	   for(int i=0; i<plainText.length(); i++) {
		   if(x==i) {
			   i=0;
		   }
		   temp+=(temp.charAt(i));
		   
		   int y = (plainText.charAt(i)+temp.charAt(i))%26;
		   y += 'A';
		   cipherText += (char)y;
	   }
//	   System.out.println("Cipher Text = "+ cipherText);
	   return cipherText;
       
   }
   
    
   // decrypt method
   //   return a String
   //   no parameters
   public String decrypt() {
	   String temp = key;
	   String plain = "";
	   String cipher = encrypt();
	   
	   for(int i=0; i<cipher.length(); i++) {
		   temp+=(temp.charAt(i));
		   int j = (cipher.charAt(i)-temp.charAt(i)+26)%26;
		   
		   j+='A';
		   plain += (char)j;
	   }
	   return plain;
   }
   
   // equals method
   //   return a boolean
   // Vigenere reference parameter
   public boolean equals(Vigenere s) {

	  //   if(f.getKey().equals(key) && f.getPlainText().equals(plainText)) {
		//    return true;
	  //  }else {
		//    return false;
	  //  }
	  return s.getKey().equals(key) && s.getPlainText().equals(plainText);
	  //  if(s.getKey() == key && s.getPlainText() == plainText) return(true);
		// else return(false);
	   
   }
    
   
   // toString() method
   public String toString()
   {
        return("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt());     
   }
    
}
