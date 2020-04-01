package ru.gushin.ngtu.ivt;

public class ProtectedDecorator extends Decorator {
    public ProtectedDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        String[] words = decline.toString().split(" ");
        StringBuilder a = new StringBuilder();
        int b = 1;
        //  System.out.println(Arrays.toString(words));
        for (String line : words){
            if ("protected".equals(line)){
                break;
            }
            b++;
        }

        int i = 0;

        for (String ln : words){

            if(b - i == 1){
                a.append(" <Protected  color> ");
            }
            i++;

            if ("protected".equals(ln)){
                a.append(ln);
                a.append(" </ Protected color>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }

        return a;
    }
}
