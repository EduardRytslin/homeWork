/* Задание
-Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
- Создать множество ноутбуков.
- Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
- Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
- Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.
*/

import java.util.Objects;

public class NoteBook {
    public String brand;
    public int ramV;
    public int hddV;
    public String os;
    public String colour;

    public NoteBook(String brand,int ramV,int hddV,String os,String colour) {
        this.brand = brand;
        this.ramV = ramV;
        this.hddV = hddV;
        this.os = os;
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRamV() {
        return ramV;
    }

    public void setRamV(int ramV) {
        this.ramV = ramV;
    }

    public int getHddV() {
        return hddV;
    }

    public void setHddV(int hddV) {
        this.hddV = hddV;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("Марка: %s, Объём ОЗУ: %d, Объём жёсткого диска: %d, Операционная система: %s, Цвет: %s",brand,ramV,hddV,os,colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand,ramV,hddV,os,colour);
    }


}