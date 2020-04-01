package ru.gushin.ngtu.ivt;

public class FinalDecorator extends Decorator {
    public FinalDecorator(ReturnClass component) {
        super(component);
    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        String[] words = decline.toString().split(" ");
        StringBuilder a = new StringBuilder();
        int b = 1;
        //  System.out.println(Arrays.toString(words));
        for (String line : words){
            if ("final".equals(line)){
                break;
            }
            b++;
        }

        int i = 0;

        for (String ln : words){

            if(b - i == 1){
                a.append(" <Final  color> ");
            }
            i++;

            if ("final".equals(ln)){
                a.append(ln);
                a.append(" </final color>");
                continue;
            }
            a.append(" ");
            a.append(ln);
        }

        return a;
    }
}
