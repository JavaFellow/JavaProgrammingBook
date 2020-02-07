package ch06.adapter;

public class PowerSocket {    // 现有的电源插座 (Adaptee) 
    public void get220vAC() {     // 现有方法 (不能满足客户类要求) 
        System.out.println("得到220V交流电...");
    }
}
