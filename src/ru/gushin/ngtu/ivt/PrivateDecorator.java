package ru.gushin.ngtu.ivt;

import java.util.Arrays;

public class PrivateDecorator extends Decorator {

    public PrivateDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        String[] words = decline.toString().split(" ");
        StringBuilder a = new StringBuilder();

        int b = 1;
     //   System.out.println(Arrays.toString(words));
        for (String line : words){
            if ("private".equals(line)){
                break;
            }
            b++;
        }
       // System.out.println("private position is " + b);

        int i =0;

        for (String ln : words){
            //  if ("private".equals(ln) || "protected".equals(ln)|| "public".equals(ln)){
            if(b - i == 1){
                a.append(" <Red  color> ");
            }
            i++;

            if ("private".equals(ln)){
                a.append(ln);
                a.append(" </ red color>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }

  //      a.append("<Red color> ");
//        for (String ln : words){
//
//            if ("private".equals(ln)){
//                a.append(ln);
//                a.append(" </Red color> ");
//                continue;
//            }
//            a.append(" ");
//            a.append(ln);
//        }
        return a;
    }
}
