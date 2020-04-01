package ru.gushin.ngtu.ivt;

public class Main {

    public static void main(String[] args) {
        ReturnInterface retInt1 = new PrivateDecorator(new ReturnClass());
        System.out.println(retInt1.sendBackLine(new StringBuilder("private static void")));
        StringBuilder a = retInt1.sendBackLine(new StringBuilder("private static void"));

        ReturnInterface retInt2 = new StaticDecorator(new ReturnClass());
        System.out.println("result = " + retInt2.sendBackLine(new StringBuilder(a)));

    }
}
