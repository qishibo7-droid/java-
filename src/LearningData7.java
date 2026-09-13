public class LearningData7 {
    public static void main(String[] args) {
        //学习关系运算符
        //java的关系运算符整体和python差不多，对比关系的结果会用true和false来表示
        boolean a = 10 > 9;
        int b = 11;
        System.out.println(a);
        //学习逻辑运算符
        //当需要表示例如9<b<14,java中不能像python里写9<b<14
        //boolean data1=9<b<14;
        //需要用到逻辑运算符，类似与python里的 and 和 or
        //&&代表与 ，||代表或
        boolean data1 = 9 < b && b < 15;
        System.out.println(data1);
        //但是逻辑运算运算存在短路，例如在 10<9 && 9>8,因为前面的10小于9已经是false了，所以整体运算结果就是false，那么java就不会运算后面的判断
        int data2 = 9;
        boolean data3 = 10 < 9 && ++data2 > 2;
        System.out.println(data3);
        System.out.println(data2);//可以发现后面的++data2没有被执行，这是今后需要注意的点
        //非运算
        int mate = 10;
        boolean data = mate > 1;
        System.out.println(data);
        boolean data4 = !(mate > 1);
        System.out.println(data4);
        //在前文提到了短路的效果，所以为了防止短路，还可以用&和|代替&&和||，更安全
        data3 = 10 < 9 & ++data2 > 2;
        System.out.println(data2);//没有出现短路
        //三元运算符
        String string = 10 > 9 ? "yes" : "no";//格式是：条件 + ？ + 输出结果1 ： 输出结果2，如果条件成立则返回结果1.否则结果2
        System.out.println(string);
        /*
        1	()	左→右
        2	~ ! + -<br>(强制类型转换) ++ --	右→左
        3	* / %	左→右
        4	+ -	左→右
        5	<< >> >>>	左→右
        6	> < >= <=	左→右
        7	== !=	左→右
        8	&	左→右
        9	^	左→右
        10	|	左→右
        11	&&	左→右
        12	||	左→右
        13	?:	右→左
        14	= += -= *= /= %=<br>&= |= ^= <<= >>= >>>=	右→左
        */
    }
}
