package encryptdecrypt;

class UnicodeEncryption implements EncryptionAlgorithm
{

    @Override
    public String encryption(String text,int shift)
    {
        StringBuilder newText = new StringBuilder();
        for(int i = 0;i< text.length();i++)
        {

            char newChar = (char)(text.charAt(i) + shift);

            newText.append(newChar);


        }
        return newText.toString();
    }

    @Override
    public String decryption(String text,int shift)
    {
        StringBuilder newText = new StringBuilder();
        for(int i = 0;i< text.length();i++)
        {

            char newChar = (char)(text.charAt(i) - shift);
            newText.append(newChar);
        }
        return newText.toString();
    }
}
