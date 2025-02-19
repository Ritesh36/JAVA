public class StarPattern {
    public static void main(String args[]){
        // for(int i=1; i<=4; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // int n = 4;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i+1; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // for(int i=1; i<=4; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j+ "");
        //     }
        //     System.out.println();
        // }

        // char ch = 'A';
        // for(int i=1; i<=4; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(ch++);
        //     }
        //     System.out.println();
        // }

        int n = 4;
        for(int i=1; i<=4; i++){
            for(int j=n; j>=i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        // int n = 5;
        // for(int i=n; i>=1; i--){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
    }
}
