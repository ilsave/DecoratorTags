package ru.gushin.ngtu.ivt;


abstract class Decorator implements ReturnInterface{
    ReturnInterface component;

    public Decorator(ReturnInterface component) {
        this.component = component;
    } // Констурктор, инициализирует компонент через объект другого класса
}
