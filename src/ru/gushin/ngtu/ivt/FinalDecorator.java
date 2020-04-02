package ru.gushin.ngtu.ivt;

public class FinalDecorator extends Decorator {
    public FinalDecorator(ReturnClass component) {
        super(component);
    }

    /*
    Все последующие декораторы работают по идентичному принципу
     */

    @Override
    public StringBuilder sendBackLine() {
        String[] words = String.valueOf(component.sendBackLine()).split(" ");
        StringBuilder a = new StringBuilder();
        int b = 1; // Определяет позицию сразу за искомым словом
        for (String line : words){
            if ("final".equals(line)){
                break;
            }
            b++;
        }
        int i = 0; // Определяет позицию прямо перед искомым словом
        for (String ln : words){
            if(b - i == 1){
                a.append("<i><strong> <font color='purple' face='Compact'>"); // Теги вставляеются передм словом
            }
            i++;
            if ("final".equals(ln)){
                a.append(ln);
                a.append("</font> </strong></i>"); // Теги вставляются после слова
                continue;
            }
            a.append(" ");
            a.append(ln);
        }
        return a;
    }
}

