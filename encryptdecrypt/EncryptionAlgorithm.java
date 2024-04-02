package encryptdecrypt;

interface EncryptionAlgorithm
{
    String encryption(String data,int shift);
    String decryption(String data,int shift);
}

