import java.util.HashMap;
import java.util.Map;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/4/4
 * description:通过hashCode和equals方法保证元素的唯一性，当重写equals方法时，必须重写hashCode方法，因为如果不重写这两个方法，当hashMap的key为对象时就会默认使用Object的方法，一般是不相同的，所以就会导致存储了重复值
 **/
public class WithoutHashCode {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        Key k3 = new Key(1);
        //锁内容存储
        HashMap<Key, String> hm = new HashMap<>();
        //存储key.id=1的锁内容
        hm.put(k1, "Key with id is 1");
        hm.put(k2, "Key with id is 1");
        System.out.println(hm.get(k3));
        //查看内容，id一样，但是重复内容了。id一样但是获取不到内容了
        for (Map.Entry<Key, String> next : hm.entrySet()) {
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
}

class Key {
    private Integer id;

    public Integer getId() {
        return id;
    }

    Key(Integer id) {
        this.id = id;
    }
    //故意先注释掉equals和hashCode方法
    //  public boolean equals(Object o) {
    //      if (o == null || !(o instanceof Key))
    //      { return false; }
    //      else
    //      { return this.getId().equals(((Key) o).getId());}
    //  }

    //  public int hashCode()
    //  { return id.hashCode(); }
}


