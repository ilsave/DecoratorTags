package ru.gushin.ngtu.ivt;

public class ReturnClass implements ReturnInterface{
    StringBuilder line; // Строка из файла

    public ReturnClass(StringBuilder line) {
        this.line = line;
    } // Конструктор, инициализирует строку

    @Override
    public StringBuilder sendBackLine() {
        return line;
    } // Возвращает строку
}
