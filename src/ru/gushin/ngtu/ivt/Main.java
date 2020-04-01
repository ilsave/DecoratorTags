package ru.gushin.ngtu.ivt;

public class Main {

    public static void main(String[] args) {
        ReturnInterface retInt1 = new PrivateDecorator(new ReturnClass());
        System.out.println(retInt1.sendBackLine(new StringBuilder("private public  static void")));
        StringBuilder a = retInt1.sendBackLine(new StringBuilder("private public protected static void"));

        ReturnInterface retInt2 = new StaticDecorator(new ReturnClass());
        System.out.println("result = " + retInt2.sendBackLine(new StringBuilder(a)));

        ReturnInterface retInt3 = new PublicDecorator(new ReturnClass());
        System.out.println("new result = " + retInt3.sendBackLine(new StringBuilder(retInt2.sendBackLine(new StringBuilder(a)))));
        ReturnInterface retInt4 = new ProtectedDecorator(new ReturnClass());
        System.out.println("new result = " + retInt4.sendBackLine(retInt3.sendBackLine(new StringBuilder(retInt2.sendBackLine(new StringBuilder(a))))));

        StringBuilder a1 = retInt4.sendBackLine(retInt3.sendBackLine(new StringBuilder(retInt2.sendBackLine(new StringBuilder(a)))));
        ReturnInterface retInt5 = new VoidDecorator(new ReturnClass());
        System.out.println("final result = " + retInt5.sendBackLine(a1));

    }
}
