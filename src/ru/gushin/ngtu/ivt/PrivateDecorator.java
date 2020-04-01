package ru.gushin.ngtu.ivt;

public class PrivateDecorator extends Decorator {

    public PrivateDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        String[] words = decline.toString().split(" ");
        StringBuilder a = new StringBuilder();
        a.append("<Red color> ");
        for (String ln : words){
            if ("private".equals(ln)){
                a.append(ln);
                a.append(" </Red color> ");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a;
    }
}
