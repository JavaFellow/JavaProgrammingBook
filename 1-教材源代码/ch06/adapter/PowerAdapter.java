package ch06.adapter;

// 电源适配器 (Adapter) 
public class PowerAdapter extends PowerSocket implements ChargeService {
    public void charge() { // 重写ChargeService接口的方法
        get220vAC(); // 调用PowerSocket类的方法
        System.out.println("转换为5V直流电..."); // 其余转换细节
        System.out.println("充电中...");
    }
}
