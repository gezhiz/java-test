package others;

import sun.misc.Cleaner;

/**
 *  class和成员变量均申明成final
 *  不要为成员变量申明setter方法
 *  构造函数中，成员变量的赋值使用拷贝的方式
 * Created by gezz on 2019/2/16.
 */
public final class ImmutableClass {

    final private Student student;
    final private String address;

    public ImmutableClass(Student student, String address) {
//        this.student = Student.clone(student);//使用拷贝的方式才能保证student不会被修改
        this.student = student;
        this.address = address;
    }

    public static void main(String[] args) {
        String address = "北京市朝阳区";
        Student student = new Student("gezz",29);
        ImmutableClass immutableClass = new ImmutableClass(student,address);

        student.setName("worthto");//student设置修改，能够成功，ImmutableClass并不是真正的不可变
        student.setAge(30);
        System.out.println(immutableClass.getAddress());
        System.out.println(immutableClass.getStudent());
    }

    public Student getStudent() {
        return student;
    }

    public String getAddress() {
        return address;
    }

    static class Student {
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public static Student clone(Student source) {
            Student student = new Student(source.getName(),source.getAge());
            return student;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
