package ru.gushin.ngtu.ivt;

public class ReturnClass implements ReturnInterface{
//    StringBuilder line;
//
//    public ReturnClass(StringBuilder line) {
//        this.line = line;
//    }

    @Override
    public StringBuilder sendBackLine(StringBuilder decline) {
        return decline;
    }
}
