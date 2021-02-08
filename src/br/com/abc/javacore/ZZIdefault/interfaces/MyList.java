package br.com.abc.javacore.ZZIdefault.interfaces;

public interface MyList {
//    static methods are allowed but they need to have a body
    static void sort() {
        System.out.println("Dentro do sort");
    }

    //    concrete methods are allowed if they are precede by "default" word
    void add();
    default void remove() {
        System.out.println("Dentro do remove");
    }
}
