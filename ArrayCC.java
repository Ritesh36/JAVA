public class ArrayCC {
    public static void updateArray(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }
    public static void main(String args[]){
        int marks[] = {97, 98, 99};

        System.out.println("Before updateArray: ");
        for(int i=0; i<marks.length; i++){
            System.out.println(marks[i]);
        }

        updateArray(marks);

        System.out.println("After updateArray: ");
        for(int i=0; i<marks.length; i++){
            System.out.println(marks[i]);
        }
    }
}
