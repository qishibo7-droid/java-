public class LearningData8 {
    public static void main(String[] args){
        int a=10;
        {
            int b=11;
            System.out.println(a);
        }
        System.out.println(a);
        //System.out.println(b);b是最中间的代码块声明的，所以在那个代码块之外是没有声明的，所以{}可以控制代码的作用域
        {
            ++a;
            System.out.println(a);
        }
        System.out.println(a);//但是代码块运行后的数据改动会超出作用域
        //选择结构
        a=10;
        if (a==10) System.out.println("正确");
        if (a==11) System.out.println("正确");//如果条件成功，只会对紧挨着的代码运行，判断结构：if (条件，且输出只能是布尔)  需要执行的代码
        /*if (a==10) {
            System.out.println("正确");
            a++;
            System.out.println(a);//选择结构的实现代码可以用{}标记出作用域，从而实现多行代码的实现
        }*/
        if (a==11) {System.out.println("正确");}
        else {System.out.println("错误");}
        //实战练习
        int score=59;
        if (score>90){System.out.println("优秀");
            System.out.println("不需要补习");}
        else if (score>=60 & score<=90){System.out.println("及格");
            System.out.println("不需要补习");}
        else{System.out.println("不及格");
            System.out.println("需要补习");}
        //并且可以进行嵌套判断
        if (score>30){if(score<60) System.out.println("大于30小于60");
            else System.out.println("大于60");}
        //switch结构
        int data=1;
        switch (data){
            case 1:
                data+=1;
                break;
            case 2:
                data+=1;
                break;
            case 3:
                data+=1;
                break;//break会阻止case继续下去，如果没有breakcase会有序运行，直至遇到break，所以可以合并操作
            default:
                data=0;
            //case 1:
            //case 2:
                    //data+=1
                    //break

        }
        System.out.println(data);
        //这些选择结构使用非常灵活，基本上都支持真和相互之间的嵌套

        }
    }

