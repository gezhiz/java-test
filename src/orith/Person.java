package orith;

/**
 * Created by gezz on 2019/2/28.
 */
public class Person {

    class Student extends Person {
        long id; // 身份证号
        int score; // 入学总分
        String name; // 姓名
        int getScore(){
            return score;
        }
    }

    public void main(String args[]) {
        Student student = new Student();
        Person person = student;
    }

}
