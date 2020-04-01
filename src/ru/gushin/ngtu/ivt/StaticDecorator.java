package ru.gushin.ngtu.ivt;

public class StaticDecorator extends Decorator {
    public StaticDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        String[] words = decline.toString().split(" ");
        StringBuilder a = new StringBuilder();
        int i = 0;
        for (String ln : words){
          //  if ("private".equals(ln) || "protected".equals(ln)|| "public".equals(ln)){
                i++;

            if (i == 6){
                a.append(" <Blue  color> ");
            }
            if ("static".equals(ln)){
                a.append(ln);
                a.append(" </ blue color>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a;
    }
}
