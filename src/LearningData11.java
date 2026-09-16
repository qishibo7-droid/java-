public class LearningData11 {
    public static void main(String[] args){
        //for (;;) 循环体   可以把三个表达式都空着，但这样表达式二会默认ture，会陷入死循环
        //break 和 continue的作用
        for (int i=0;i<5;i++) {
            if (i == 3) continue;
            System.out.println(i);//不打印3，因为等于3的时候被continue跳过了
        }
        for (int i=0;i<5;i++){
            if (i==3) break;
            System.out.println(i);//3之后不打印了因为break终止了这个循环
        }
        //break 和 continue 默认都只针对所存在最近的循环
        //下面只用break做例子，continue同理
        for (int i=0;i<5;i++){
            System.out.println("i="+i);
            for (int j=0;j<3;j++){
                if (j==2) break;
                System.out.println("j="+j);//每次j等2的时候j所在的循环被终止了，i循环直接进入下一轮，所以i可以打印完1到4，但j只能1和2
            }
        }
        //可以用标记的方式指定break和continue的针对对象
        outside:for (int i=0;i<5;i++){
            System.out.println("i="+i);
            for (int j=0;j<3;j++){
                if (j==2) break outside;
                System.out.println("j="+j);//当j等于2的时候，break直接终止了outsdie所在的i循环
            }
        }
        for (int i=0;i<5;i++){
            System.out.println("i="+i);
            outside:for (int j=0;j<3;j++){
                System.out.println("j="+j);
                for (int d=0;d<3;d++){
                    if (d==2) break outside;
                    System.out.println("d="+j);//j所在的循环中有d的循环，d的循环每次等于2的时候都会break掉j的循环，所以j一直没有执行到表达式3，一直是0
                    }
            }
        }
        //while循环
        int i=0;
        while (i!=5) {
            System.out.println(i);
            i+=1;
        }//等于5的时候推出了循环，并且while是先判断再循环
        //do while是先循环在判断
        i=0;
        do {System.out.println(i);
            i+=1;} while (i!=5);
    }
}
