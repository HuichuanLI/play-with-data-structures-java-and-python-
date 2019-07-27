

import java.util.HashSet;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {

        int a = 42;

        System.out.println(((Integer)a).hashCode());

        int b = -42;

        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "immoc";


        System.out.println(d.hashCode());

        Student student =  new Student(3,2,"bobo","liu");
        System.out.println(student.hashCode());


        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student,Integer> scores = new HashMap<>();
        scores.put(student,100);

//      如果每有 使用hashcode 结果是用地址的hash
//       hash 需要判断两个变量是相等
        Student student2 =  new Student(3,2,"bobo","liu");
        System.out.println(student2.hashCode());


    }
}
