package br.com.abc.javacore.ZZIdefault.classes;

import br.com.abc.javacore.ZZIdefault.interfaces.A;
import br.com.abc.javacore.ZZIdefault.interfaces.B;
import br.com.abc.javacore.ZZIdefault.interfaces.D;

public class C implements A, B {
    public static void main(String[] args) {
        new C().hi();
    }

    public void hi() {
        A.super.hi();
    }
}
