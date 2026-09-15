public class LearningData10 {
    //循环结构
    /*for(表达式1;表达式2;表达式3) 循环体
    表达式1是循环第一次运行的表达式；
    表达式2是循环中每次会先运行的表达式，最终值一定要是布尔值，判断循环是否继续；
    表达是3是循环中每次最后运行的表达式；
     */
    //案例（寻找数字）
    public static void main(String[] args){
        {int i=0;
        for (;i != 7;i+=1) System.out.println(i);
        if (i==7){System.out.println(i);System.out.println("找到了");}
        else {System.out.println(i);System.out.println("未找到");}}

    }
}
