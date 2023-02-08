package miscellaneous.innerClass;

public class InnerClassDemo {
    public static void main(String[] args) {
        OuterClass o = new OuterClass();
        o.setName("Vamsi");
        System.out.println(o.getName());
        OuterClass.InnerClass i = new OuterClass().new InnerClass();
        i.setNickName("Krishna");
        System.out.println(i.getNickName());
    }
}
