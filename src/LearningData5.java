public class LearningData5 {
    public static void main(String[] args){
        int a=1;
        a=a+1;
        System.out.println(a);
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);
        int b=1;
        int c=++b;
        System.out.println(c);
        b=1;
        c=b++;
        System.out.println(c);//如果自增符号在前则先自增再赋值，如果在后则先赋值再自增，自减同理（先出结果再自增自减）
        //自增自减的优先级和正负号相同
        //练习
        int data1=8;
        int data2=-data1++ + ++data1;
        System.out.println(data2);
        //前半部分先出结果是-a等于8，然后a自增变成9，后续先自增变成10，最后相加变成-8
        data1=1;
        data1 += 10;//累加器的缩写，跟python差不多
        System.out.println(data1);
        data1 *=2;//效果和  data1=data*2  效果一样，累乘器的缩写
        System.out.println(data1);
        /* java中各个运算符的优先级
        （）    优先级最高    结合性从左往右
        正负号以及自增自减    优先级2    结合性从右往左
        乘除           优先级3        结合性从左往右
        加减           优先级4        结合性从左往右
        赋值号         优先级5        结合性从右往左
         */

    }
}
