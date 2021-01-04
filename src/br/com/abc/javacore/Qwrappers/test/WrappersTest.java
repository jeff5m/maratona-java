package br.com.abc.javacore.Qwrappers.test;

public class WrappersTest {
    public static void main(String[] args) {
        byte primitiveByte = 1;
        short primitiveShort = 1;
        int primitiveInt = 10;
        long primitiveLong = 10L;
        float primitiveFloat = 10F;
        double primitiveDouble = 10D;
        char primitiveChar = 'A';
        boolean primitiveBoolean = true;

        Byte wrapperByte = 1;
        Short wrapperShort = 1;
        Integer wrapperInt = 10;
        Integer wrapperInt2 = new Integer("10");
        Long wrapperLong = 10L;
        Float wrapperFloat = 10F;
        Float wrapperFloat2 = new Float(10F);
        Double wrapperDouble = 10D;
        Character wrapperChar = 'A';
        Character wrapperChar2 = new Character('A');
        Boolean wrapperBoolean = true;
        Boolean wrapperBoolean2 = new Boolean("tRue");

//        Wrapper classes have many utilities methods

        String value = "45";
        Float f = Float.parseFloat(value);
        System.out.println(f);

        Long n1 = Long.valueOf(10L);
        System.out.println(n1);

        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetter('1'));
        System.out.println(Character.isLetterOrDigit('@'));
        System.out.println(Character.isUpperCase('f'));
        System.out.println(Character.isLowerCase('f'));
        System.out.println(Character.toUpperCase('f'));

    }
}
