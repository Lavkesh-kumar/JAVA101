

// strings are Immutable
// we can make it mutable by using StringBuffer


// everyclass in java extends object by default. toString method is one of method in object clas
// see the object.java implementaton, we can override the existing toString();

class Student
{
    int rollNo;
    String name;
    public Student(int rollNo, String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString(){
        return "Student [rollno=" + rollNo + ": name=" + name + "]";
    }
}

class demo_array
{
    public static void main(String arg[])  // files start from here
    {
        int nums[] = {6, 8, 3, 2};

        // for(int i=0; i<nums.length; i++){
        //     System.out.println(nums[i]);
        // }

        for (int num : nums){
            System.out.println(num);
        }

        Student students[] = new Student[3];
        students[0] = new Student(1, "Lavkesh");
        students[1] = new Student(2, "Anukesh");
        students[2] = new Student(3, "parikesh");

        for (Student s : students){
            System.out.println(s);
        }
    }
}