package ch12;

/**** 重写了equals和hashCode方法的产品类，以自定义判等逻辑 ****/
public class HashedProduct extends Product {
    public HashedProduct(int id, String name, int inventory) {
        super(id, name, inventory); // 调用父类构造方法
    }

    /**** 重写Object类的equals方法 ****/
    public boolean equals(Object o) {
        if (o instanceof HashedProduct) {
            return getName().equals(((HashedProduct) o).getName()); // 名称相同则认为相等
        }
        return false; // 若o不是HashedProduct对象则不相等
    }

    /**** 重写Object类的hashCode方法 ****/
    public int hashCode() {
        return this.getName().hashCode(); // 以名称为哈希码(String类重写了hashCode方法)
    }

    /**** 将Product对象转为HashedProduct对象 ****/
    public static HashedProduct from(Product p) {
        int id = p.getId();
        String name = p.getName();
        int inventory = p.getInventory();
        return new HashedProduct(id, name, inventory);
    }
}