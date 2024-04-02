package encryptdecrypt;

class ShiftEncryption implements  EncryptionAlgorithm
{

    @Override
    public String encryption(String data, int shift) {
        StringBuilder newText = new StringBuilder();
        for(int i = 0;i< data.length();i++)
        {
            if(Character.isAlphabetic(data.charAt(i)))
            {
                char newChar = (char)(data.charAt(i) + shift);
                while(newChar > 'z')
                {
                    newChar = (char)(newChar - 26);
                }
                newText.append(newChar);
            }
            else
            {
                newText.append(data.charAt(i));
            }
        }
        return newText.toString();
    }

    @Override
    public String decryption(String data, int shift) {
        StringBuilder newText = new StringBuilder();
        for(int i = 0;i< data.length();i++)
        {
            if(Character.isAlphabetic(data.charAt(i)))
            {
                char newChar = (char)(data.charAt(i)-shift);

                while(newChar < 'a')
                {
                    newChar = (char)(newChar + 26);
                }

                newText.append(newChar);
            }
            else
            {
                newText.append(data.charAt(i));
            }
        }
        return newText.toString();
    }
}
