package compare;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */
class Student implements Comparable<Student> {
    public String name;
    public double score;
    public int age;

    public Student(String name, double score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        //12   4
        //     j
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("c",12.5,98);
        students[1] = new Student("a",32.5,88);
        students[2] = new Student("d",82.5,78);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        Arrays.sort(students);
        System.out.println("==================");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
