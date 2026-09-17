public class example2 {
    public static void main(String[] args){
        for (int i=1;i<=9;i++){
            for (int a=i;a>0;a--){
                if (a==1){System.out.print(i+"×"+a+"="+i*a+"\n");
                    continue;}
                System.out.print(i+"×"+a+"="+i*a+"\t");
            }
        }
    }
}
