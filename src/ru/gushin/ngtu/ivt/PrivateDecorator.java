package ru.gushin.ngtu.ivt;

import java.util.Arrays;

public class PrivateDecorator extends Decorator {

    public PrivateDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine() {
        String[] words = String.valueOf(component.sendBackLine()).split(" ");
        StringBuilder a = new StringBuilder();

        int b = 1;
        for (String line : words){
            if ("private".equals(line)){
                break;
            }
            b++;
        }

        int i =0;

        for (String ln : words){
            if(b - i == 1){
                a.append("<i><strong><font color='orange' face='Compact'>");
            }
            i++;

            if ("private".equals(ln)){
                a.append(ln);
                a.append("</font></strong></i>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }

        return a;
    }
}
