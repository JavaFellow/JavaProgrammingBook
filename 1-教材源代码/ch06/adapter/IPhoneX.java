package ch06.adapter;

public class IPhoneX {   // 测试类 (客户类) 
    public static void main(String[] args) {
        ChargeService cs = new PowerAdapter();
        cs.charge();
    }
}
