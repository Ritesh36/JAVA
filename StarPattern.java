public class StarPattern {

    //BUTTERFLY PATTERN
    public static void butterfly_Patt(int n){
        //1st half
        for(int i=1; i<=n; i++){

            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        //2nd half
        for(int i=n; i>=1; i--){

            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        // butterfly_Patt(6);
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

        // int n = 5;
        // for(int i=n; i>=1; i--){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        //FLOYD'S TRIANGLE
        // int n = 5;
        // int counter = 1;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(counter++ + " ");
        //     }
        //     System.out.println();
        // }

        // Hollow Rectangle
        // for(int i=1; i<=4; i++){
        //     for(int j=1; j<=5; j++){
        //         if(i == 1 || i==4 || j==1 || j==5){
        //             System.out.print("* ");
        //         } else {
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        //Inverted & roatated Half-Pyramid
        // int n=10;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n-i; j++){
        //         System.out.print(" ");
        //     }
        //     for(int k=1; k<=i; k++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //0-1 Triangle
        // int n = 5;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         if((i+j) % 2 == 0){
        //             System.out.print("1 ");
        //         }else {
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }

        //SOLID RHOMBUS
        // int n = 5;
        // for(int i=1; i<=n; i++){

        //     for(int j=1; j<=(n-i); j++){
        //         System.out.print(" ");
        //     }

        //     for(int j=1; j<=n; j++){
        //         System.out.print("*");
        //     }

        //     System.out.println();
        // }

        // HOLLOW RHOMBUS
        // int n = 5;
        // for(int i=1; i<=n; i++){

        //     for(int j=1; j<=(n-i); j++){
        //         System.out.print(" ");
        //     }
    
        //     for(int j=1; j<=n; j++){
        //         if(i==1 || i==n || j==1 || j ==n){
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
    
        //     System.out.println();
        // }

        //DIAMOND PATTERN
        int n = 4;
        for(int i=1; i<=n; i++){

            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n; i>=1; i--){

            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}
