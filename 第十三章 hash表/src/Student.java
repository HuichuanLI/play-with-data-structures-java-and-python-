public class Student {

    int grade;
    int cls;
    String firstnName;
    String Lastname;

    public Student(int grade, int cls, String firstnName, String lastname) {
        this.grade = grade;
        this.cls = cls;
        this.firstnName = firstnName;
        Lastname = lastname;
    }

    @Override
    public int hashCode() {
        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstnName.hashCode();
        hash = hash * B + Lastname.hashCode();
        return hash;
    }

    @Override
    public  boolean equals(Object o){
/// java 使用 equals
    if(this == o){
            return true;
        }

        if(o == null){
            return false;
        }

        if(getClass() != o.getClass())
            return false;

        Student another = (Student)o;

        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstnName.toLowerCase().equals(another.firstnName.toLowerCase()) &&
                this.Lastname.toLowerCase().equals(another.Lastname.toLowerCase());

    }
}
