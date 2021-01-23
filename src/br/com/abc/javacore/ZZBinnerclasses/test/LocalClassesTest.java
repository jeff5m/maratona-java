package br.com.abc.javacore.ZZBinnerclasses.test;

public class LocalClassesTest {
    private String name = "Jeff";
    public void doesSomething() {
//        This attribute is considered as final
        String lastName = "Pereira";
//        this class can only be final or abstract
        class ClassInsideMethod {
            public void printExternalAttribute() {
                System.out.println(name);
                System.out.println(lastName);
            }
        }
//        A class inside a method can only be instantiated from inside that method. The class ClassInsideMethod can't be
//        accessed from main. So we instantiate in a new object and from that object call the method printExternalAttribute.
//        In the main class, we call the external class LocalClassesTest and the method doesSomething.
        ClassInsideMethod inside = new ClassInsideMethod();
        inside.printExternalAttribute();
    }
    public static void main(String[] args) {
        LocalClassesTest externalClass = new LocalClassesTest();
        externalClass.doesSomething();
    }
}
