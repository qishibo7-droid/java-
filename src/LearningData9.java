public interface LearningData9 {
    public static void main(String[] args){
        //更加简洁的switch写法
        int score=0;
        String level= switch(score){
            case 10,9->"等级为a";
            case 6,7,8->"等级为b";
            case 3,4,5->"等级为c";
            default -> {System.out.print(score);
            System.out.print("不及格\n");
            yield "等级为d";}
        };
        System.out.println(level);
    }
}
