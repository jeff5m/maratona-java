package br.com.abc.javacore.ZZBinnerclasses.test;

public class InnerClassesTest {
    private String name = "Jeff";
// Inner classes has access to any attribute from external class, private ones included. They can be abstract, private,
// public, protect, static and strictfp. Inner class its like a method of the external class.
    class InnerClass {
        public void checkExternalClass() {
            System.out.println(name);
            System.out.println(this); // ref to the object where is declared
            System.out.println(InnerClassesTest.this); // ref to the external class
        }
    }
    public static void main(String[] args) {
//        To instantiate a inner class object
//        1:
        InnerClassesTest external = new InnerClassesTest();
        InnerClassesTest.InnerClass inner = external.new InnerClass();
        inner.checkExternalClass();
//        2:
        InnerClassesTest.InnerClass inner2 = new InnerClassesTest().new InnerClass();
        inner2.checkExternalClass();
    }
}
//class ExternalClass {
//    private String name = "Jeff";
//
//    class InnerClass {
//        public void checkExternalClass() {
//            System.out.println(name);
//        }
//    }
//
//}
