package javaapplication2;

public class JavaApplication2 {

    public static void main(String[] args) {
        JavaApplication2.function(new Child());
    }
    
    public static void function(Parent e) {
        System.out.println(e.staticField);
        System.out.println(e.staticMethod());
        
        System.out.println(e.instanceField);
        System.out.println(e.instanceMethod());
    }
}