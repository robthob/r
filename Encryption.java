�   Encryption.java D:\Niranchana\API Management\vordel\Axway\Assets\Encryption-Decryption\EncryptDecrypt\EncryptDecrypt\src\EncyptDecrypt\Encryption.java    6   C:\Users\Simbu\AppData\Local\Temp\Encryption (3).java _  package EncyptDecrypt;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import sun.misc.BASE64Encoder; 

public class Encryption
{
 // private static String certFileLoc = "/iSMAC/runtime/apigateway/SampleAxwayServerCert.pem";
	
		
  public static String EncryptMessage(String pDataString,String certFileLoc)
    throws Exception
  {
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(1, getPublicKeyFromCert(certFileLoc));
    byte[] plaintextBytes = pDataString.getBytes();
    byte[] cipherText = cipher.doFinal(plaintextBytes);
    BASE64Encoder encoder = new BASE64Encoder();
    String output = encoder.encode(cipherText);
    return output;
  }
  
  private static PublicKey getPublicKeyFromCert(String pCertificate)
  {
    PublicKey pub = null;
    try
    {
      InputStream inStream = new FileInputStream(pCertificate);
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate cert