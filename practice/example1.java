public class example1 {
    public static void main(String[] args) {
        //实战训练，找出1000以内的水仙花树,水仙花数就是数字的每一位上数字的三次方之和等于这个数字本身
        int i = 100;
        for (; i <= 1000; i += 1) {
            int a = 0, b = 0,c=i;
            for (; c!=0; c=c/10) {
                a = c % 10;
                b += a*a*a;
            }
            if (b==i) System.out.println(i);
        }
    }
}