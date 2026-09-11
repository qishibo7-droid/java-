/*2026年学习java第一天，注释练习

 */

public class learningdata1 {
    public static void main(String[] args) {
        /*System.out.println("hello world");//打印hello world
        System.out.println(123);
        int a=100,b=50;
        int c;
        c=a+b;
        System.out.println(c);
        final int a1=900;
        //a1=a1+1;
        System.out.println(a1);  */
        byte a=127; //byte数据范围是-128到127，因为是有8个比特组成的
        short b=30000;//short类型数据范围是-2的16次方到2的十六次方-1，因为是由16个比特组成
        int c=2000000000;//int类型数据的范围是2的32次方到2的32次方-1，因为是由32个比特组成
        long d=2000000000000000000L;//long类型数据的范围是2的64次方到2的64次方-1，因为是由64个比特组成
        /*所有整数类型的数据的正数部分范围都需要-1的原因是由于二进制的表达导致最大数字肯定要-1，负数部分不用的原因是
        因为java采用的是采用补码的方式计算，因为是再反码的基础上+1所以导致会始终多出来100000（1开头代表负数，0的位数是二进制位数），这个空位
        可以多表达一位数，导致负数部分不需要-1
         */
        //a=b;//不能将超出范围的数值转换成byte里
        b=a;
        System.out.println(b);
        //隐形转化的要求：1小范围转化到大范围，2要么双方都有符号，要么双方都无符号
    }
}