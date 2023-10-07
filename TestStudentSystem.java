package day09;
import java.util.Scanner;
public class TestStudentSystem{
    //学生信息，存在多个数组中，同一个下标指同一个学生的不同信息
    static String[] names={};//名字
    static int[] ages={};//年龄
    static char[] sexes ={};//性别
    static double[] scores={};//成绩
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("---------欢迎使用XXX学生管理系统-----------");
            System.out.println("请根据提示完成操作");
            System.out.println("1.添加学生信息 2.删除学生信息 3.修改学生信息 4.查询所有学生信息 5.根据名字查询学生信息");
            System.out.print("请输入：");
            int n=sc.nextInt();
            switch(n){
                case 1:add();break;
                case 2:delete();break;
                case 3:update();break;
                case 4:printArray();break;
                case 5:inquire();break;
                default:System.out.println("请输入1~5");
            }
        }
    }
    public static void add(){
        String[] newnames=java.util.Arrays.copyOf(names,names.length+1);
        Scanner n=new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        newnames [names.length]=n.next();
        names=newnames;


        int[] newages=java.util.Arrays.copyOf(ages,ages.length+1);
        Scanner a=new Scanner(System.in);
        System.out.println("请输入学生年龄：");
        newages[ages.length]=a.nextInt();
        ages=newages;

        char[] newsexs=java.util.Arrays.copyOf(sexes, sexes.length+1);
        Scanner s=new Scanner(System.in);
        System.out.println("请输入学生性别：");
        newsexs[sexes.length]=s.next().charAt(0);
        sexes =newsexs;

        double[] newscores=java.util.Arrays.copyOf(scores,scores.length+1);
        Scanner c=new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        newscores[scores.length]=c.nextDouble();
        scores=newscores;

        //扩容数组
        //输入信息，将信息添加至数组
    }
    public static void delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名：");
        String name=sc.next();
        String []newnames= new String[names.length-1];
        int[] newages=new int[ages.length-1];
        char[] newsexs=new char[sexes.length-1];
        double[] newscores=new double[scores.length-1];
        int index;
        index=select(name);
        if (index == -1){
            System.out.println("学生信息输入错误");
        }
        //数组的删除其实就是向前覆盖一位
        for (int i=0;i< names.length-1;i++){
            if (i<index){
                newnames[i]=names[i];
                newages[i]=ages[i];
                newsexs[i]= sexes[i];
                newscores[i]=scores[i];
            }else {
                newnames[i]=names[i+1];
                newages[i]=ages[i+1];
                newsexs[i]= sexes[i+1];
                newscores[i]=scores[i+1];
            }
        }
        names=newnames;
        ages=newages;
        sexes =newsexs;
        scores=newscores;
        System.out.println("删除成功");
    }
    //判断字符串是否相同 s1.equals("张三") 返回值为ture 内容相同
    public static int select(String name){
        int temp=-1;
        for (int i=0;i< names.length;i++){
            if (name.equals(names[i])){
                temp=i;
                break;
            }
        }
        return temp;
    }
    
    public static void update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改学生的姓名：");
        String name= sc.next();
        int a=select(name);
        if (a == -1) {
            System.out.println("修改失败");
        }else {
            System.out.println("请修改后输入学生姓名");
            names[a]=sc.next();
            System.out.println("请修改后输入学生年龄");
            ages[a]=sc.nextInt();
            System.out.println("请修改后输入学生姓名");
            sexes[a]=sc.next().charAt(0);
            System.out.println("请修改后输入学生姓名");
            scores[a]=sc.nextDouble();
            System.out.println("修改成功");
        }
    }

    public static void inquire(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入查询学生的名字：");
        String name=sc.next();
        String inquirename;
        int a=select(name);
        if (a == -1) {
            System.out.println("查无此人");
        }
        else{
            inquirename="姓名："+names[a]+"\t年龄："+ages[a]+"\t性别："+ sexes[a]+"\t成绩："+scores[a];
        System.out.println(inquirename);
        }
    }
    public static void printArray(){
        if (names.length==0){
            System.out.println("当前系统中无信息，请添加数据");
        }else {
            for (int i=0;i<names.length;i++){
                System.out.print("姓名："+names[i]+"\t年龄："+ages[i]+"\t性别："+ sexes[i]+"\t成绩："+scores[i]);
                System.out.println();

            }
        }
    }
}

