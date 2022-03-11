public class Main {
    public static void main(String []args)
    {
        Encryptor encryptor = new Encryptor(3, 4);
        String encryptedMessage = encryptor.encryptMessage("What are you doing next weekend?");
        System.out.println(encryptedMessage);

        Encryptor encryptor2 = new Encryptor(6, 5);
        String encryptedMessage2 = encryptor2.encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again.");
        System.out.println(encryptedMessage2);

        Encryptor encryptor3 = new Encryptor(3, 2);
        String decryptedMessage = encryptor3.decryptMessage("Ti hsiscn ofietdnia!Bl e nto helo okotAu!A");
        System.out.println(decryptedMessage);

        Encryptor encryptor4 = new Encryptor(5, 5);
        String decryptedMessage2 = encryptor4.decryptMessage("Tite hsocmi presa es  stsaneregtd see J  nfaBidomonee  d ftm.cuhe alisBr,ssaieecgllstelft!  -rAwsduA");
        System.out.println(decryptedMessage2);

        Encryptor encryptor5 = new Encryptor(6, 5);
        String decryptedMessage3 = encryptor5.decryptMessage("Meottai ooufdsl rtdcsrnelh e r etWwht hhiihmselgro.nlhen    sld tmc egoehsne  otttcbous oacHusAAkoloAA?ploAA eynAA f !AA");
        System.out.println(decryptedMessage3);

    }
}
