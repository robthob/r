1   Decryption.java D:\Niranchana\API Management\vordel\Axway\Assets\Encryption-Decryption\EncryptDecrypt\EncryptDecrypt\src\EncyptDecrypt\Decryption.java    3   C:\Users\161619\AppData\Local\Temp\Decryption.java �  package EncyptDecrypt;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;

public class Decryption
{
 
  
  public static String decrypt(String pCipherText,String CERT_JKS_FILE,String strPassword,String strAlias)
    throws Exception
  {
    char[] chPassword = new char[strPassword.length()];
    strPassword.getChars(0, strPassword.length(), chPassword, 0);
    KeyStore keyStore = KeyStore.getInstance("JKS");
    FileInputStream fis = new FileInputStream(CERT_JKS_FILE);
    keyStore.load(fis, chPassword);
    fis.close();
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(2, keyStore.getKey(strAlias, chPasswor