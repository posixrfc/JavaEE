package javaapplication2;

public class Child extends Parent {
    
    public static String staticField = "ChildStaticField";
    
    public String instanceField = "ChildInstanceField";
    
    public static String staticMethod() {
        return "ChildStaticMethod";
    }
    
    public String instanceMethod() {
        return "ChildInstanceMethod";
    }
}
