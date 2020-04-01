package ru.gushin.ngtu.ivt;

import java.util.Arrays;

public class StaticDecorator extends Decorator {
    public StaticDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine() {
        String[] words = String.valueOf(component.sendBackLine()).split(" ");
        StringBuilder a = new StringBuilder();
        int b = 1;
      //  System.out.println(Arrays.toString(words));
        for (String line : words){
            if ("static".equals(line)){
                break;
            }
            b++;
        }
      //  System.out.println("static position is " + b);


        int i = 0;

        for (String ln : words){
          //  if ("private".equals(ln) || "protected".equals(ln)|| "public".equals(ln)){
            if(b - i == 1){
                a.append(" <Blue  color> ");
            }
                i++;

            if ("static".equals(ln)){
                a.append(ln);
                a.append(" </ blue color>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }

//        for (String ln : words){
//          //  if ("private".equals(ln) || "protected".equals(ln)|| "public".equals(ln)){
//                i++;
//
//            if (i == 6){
//                a.append(" <Blue  color> ");
//            }
//            if ("static".equals(ln)){
//                a.append(ln);
//                a.append(" </ blue color>");
//                continue;
//            }
//            a.append(" ");
//            a.append(ln);
//        }
        return a;
    }
}
