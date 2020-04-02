package ru.gushin.ngtu.ivt;


abstract class Decorator implements ReturnInterface{
    ReturnClass component;

    public Decorator(ReturnClass component) {
        this.component = component;
    } // Констурктор, инициализирует компонент через объект другого класса
}
