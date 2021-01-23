package br.com.abc.javacore.ZZBinnerclasses.test;

class External {

    private String name;
    static class Internal {
//        the attribute name can only be accessed if it was static too.
        public void print() {
            System.out.println("Oi");
        }
    }
}

public class StaticInnerClassesTest {
    public static void main(String[] args) {
//        New goes only before the external class
        External.Internal test = new External.Internal();
        test.print();
//        If the static class is inside the class of the code who calls it, in this case we need to use the new word
        Internal2 test2 = new Internal2();
        test2.print();
    }

    static class Internal2 {
        public void print() {
            System.out.println("Oi, de dentro da class 2");
        }
    }
}
