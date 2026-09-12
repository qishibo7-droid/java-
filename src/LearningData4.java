public class LearningData4 {
    public static void main(String[] args){
        /*int a=10;
        int b=3;
        int c=a+b ;
        System.out.println(c);*/
        byte a=10;
        byte b=3;
        //byte c=a+b;//int一下范围的数据类型在计算的时候会自动变为int类型，如果是longe类型之间的计算则会变成long
        int c=a+b;
        System.out.println(c);
        /*byte  → char     : 127 → 65535          约 516 倍
          char  → short    : 65535 → 32767        反而变小（因为有符号）
          short → int      : 32767 → 21亿         约 65536 倍
          int   → long     : 21亿 → 9.2×10^18     约 43 亿倍
          long  → float    : 10^18 → 10^38        ← 跳跃最大，跨了 20 个数量级
          float → double   : 10^38 → 10^308       ← 跨了 270 个数量级*/
        String d=a+1.5+"hello world";
        System.out.println(d);
        String e="hello world"+a+1.5;
        System.out.println(e);//数据类型在计算的时候会根据左边的数据类型进行变化
        int a1=5 ,b1=10;
        int c1=a1/b1;
        System.out.println(c1);//会显示0，因为int不能表示小数所以小数部分不见了，需要手动扩大范围到float类型
        float c2=a1/b1;
        System.out.println(c2);//这样也会出错，出现0.0，因为在a1/b1进行运算的时候已经失真变成0了，即使后续转化成float也不行
        //正确做法
        float a2=a1,b2=b1;
        float c3=a2/b2;
        System.out.println(c3);//提前进行数据转化
        //加减乘除取余总体类似于python，优先级也一样
        int data1=10,data2=15;
        String data3="hello world"+(data1+data2)+"hi";
        System.out.println(data3);//括号会改变运算优先级
        int data4=10;
        byte data5=(byte) data4;
        System.out.println(data5);//括号还可以用于强制类型转换
        //因此在运算的时候
        int data6=5,data7=10;
        float data8=(float)data6/(float)data7;
        System.out.println(data8);//可以通过这样的方法得到正确的数字
    }
}
