package nova;
import java.util.Scanner;
class main {
    static int row = 6;
    static int col = 6;
    static int brw = 0;
    static String[][] str = new String[row][col];
    static String[][] std = new String[row][col];
    static StringBuffer appends1 = new StringBuffer();
    static StringBuffer appends2 = new StringBuffer();
    static StringBuffer appends3 = new StringBuffer();
    static StringBuffer appends4 = new StringBuffer();
    static StringBuffer appends5 = new StringBuffer();
    static StringBuffer appends = new StringBuffer();
    static Scanner in = new Scanner(System.in);
        static void row1(){
        for (int j = 0; j < col; j++) {
            System.out.print(str[0][j] + "\t ||");
            System.out.print("||\t");
        }
        System.out.println("\n-----------------------------------------------------------------------------------------------");
    }
void print() {
        for (String[] k : str) {
            for (String l : k) {
                if (l == null)
                    continue;
                else {
                    System.out.print(l + "\t|| ");
                    System.out.print("||\t");
                }
            }
            System.out.println("");
        }
    }
void add() {
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j==4){
                    str[i][4] = str[i][3];
                }
                else if (j==5){
                    str[i][5] = "check-in";
                }
                else{
                    System.out.println("Enter the value for  [" + str[0][j] + "] :");
                    str[i][j] = in.next();
                }
            }
            if (i==row-1){
                System.out.println("\n------------------------------storage full");
            }
            else {
                System.out.println("want to add a new book??\n press 1 to continue.\n press 2 to exit");
            int con = in.nextInt();
                if (con == 2) {
                    i = 10;
                }
            }
        }
    }
void borrow() {
               brw ++;
            int count = 0;
            int nm=0;
                System.out.println("Enter your name :");
            String stdname = new String();
            stdname= in.next();
            appends.append(stdname +",");
                for (int i = 1; i < row; i++) {
                    if (stdname.equals(std[i][1])) {
                        nm++;
                        System.out.println("enter the name of the book you need :");
                        String name = in.next();
                            for (int j = 1; j < row; j++) {

                                if (name.equals(str[j][1])) {
                                    std[j][3] = name;
                                count++;
                                String x = String.valueOf(Integer.parseInt(str[j][4]) - count);
                                str[j][4] = "00"+x;
                                switch(j) {
                                    case 1:
                                        appends1.append(appends); appends.replace(0,appends.length(),"");
                                        str[1][5] = ("book is borrowed by " + appends1);
                                        std[j][3] = str[j][1];
                                        break;
                                    case 2:
                                        appends2.append(appends); appends.replace(0,appends.length(),"");
                                        str[2][5] = ("book is borrowed by " + appends2);
                                        std[j][3] = str[j][1];
                                        break;

                                    case 3:
                                        appends3.append(appends); appends.replace(0,appends.length(),"");
                                        str[3][5] = ("book is borrowed by " + appends3);
                                        std[j][3] = str[j][1];
                                        break;
                                    case 4:
                                        appends3.append(appends); appends.replace(0,appends.length(),"");
                                        str[4][5] = ("book is borrowed by " + appends4);
                                        std[j][3] = str[j][1];
                                        break;
                                    case 5:
                                        appends3.append(appends); appends.replace(0,appends.length(),"");
                                        str[5][5] = ("book is borrowed by " + appends5);
                                        std[j][3] = str[j][1];
                                        break;
                                }

                            }
                        }
                    }

                }
            if (nm==0)
                System.out.println("no data found");

        }
void returns(){

        if (brw !=0){
            int nm=0;
        System.out.println("Enter your name :");
        String stdname = in.next();
        for (int i = 1; i < row; i++) {
            if (stdname.equals(std[i][1])) {
                nm++;
                    System.out.println("enter the name of the book you need to return :");
                    String name = in.next();
                    for (int j = 1; j < row; j++) {
                        int count = 0;
                        if (name.equals(str[j][1])) {
                            count++;
                            String x = String.valueOf(Integer.parseInt(str[j][4]) + count);
                            str[j][4] = ("00"+x);
                            str[j][5] = str[j][5].replace((stdname +","),"");
                            if (str[j][5].equals("book is borrowed by ")){
                                str[j][5] = "check-in";
                            }
                            if(str[j][4].equals(str[j][3])){
                                //str[j][5] = "check-in";
                                str[j][5]= str[j][5].replace(str[j][5],"check-in");
                            }
                        }
                    }
            }
        }
        if (nm==0)
            System.out.println("no data found");
        }
        else System.out.println("YOU DIDN'T BORROWED ANY BOOK YET ");

    }
void search() {
        System.out.println("press 1 to search by serial no. \n press 2 to search by author name.");
        int se = in.nextInt();
        if (se < 3) {
            switch (se) {

                case 1:
                    System.out.println("----------------------SEARCH BY SERIAL NUMBER---------------------------------------");
                    System.out.println("Enter the s.no :");
                    String serial = in.next();
                    row1();
                    for (int i = 1; i < row; i++) {
                        if (serial.equals(str[i][0])) {
                            for (int j = 0; j < col; j++) {
                                System.out.print(str[i][j] + "\t ||");
                                System.out.print("||\t");
                            }
                            System.out.println(" ");
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----------------------SEARCH BY AUTHOR NAME--------------------------------------");
                    System.out.println("Enter the author name :");
                    String name = in.next();
                    row1();
                    for (int i = 1; i < row; i++) {
                        if (name.equals(str[i][2])) {
                            for (int j = 0; j < col; j++) {
                                System.out.print(str[i][j] + "\t ||");
                                System.out.print("||\t");
                            }
                            System.out.println(" ");
                        }
                    }
                    break;
            }
        } else System.out.println("invalid input!!!");
    }
}
public class task2 extends main {
void register(){
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                if (j==3){
                    std[i][3] = "No Books Taken";
                }
                else {System.out.println("Enter the value for  [" + std[0][j] + "] :");
                std[i][j] = in.next();
                }
            }
            if (i==row-1){
                System.out.println("storage full");
            }
            else {System.out.println("want to register another student??\n press 1 to continue.\n press 2 to exit");
                int con = in.nextInt();
                if (con == 2) {
                    i = 10;
                 }
            }
        }
    }
void show(){
            for (int j = 1; j < row; j++){
                System.out.println("J :"+j+ "  value:"+str[j][5]);
                if (str[j][5] == null || std[j][1]== null)
                    continue;

                else if (str[j][5].contains(std[j][1])) {

                    std[j][3] = str[j][1] + "\t\t";
                }
            }
        for (String[] k : std) {
            for (String l : k) {
                if (l == null)
                    continue;
                else {
                    System.out.print(l + "\t|| ");
                    System.out.print("||\t");
                }
            }
            System.out.println("");
        }
    }
void checkin(){
        row1();
        for (int i = 1; i < row; i++) {
            if ("check-in".equals(str[i][5])) {
                for (int j = 0; j < col; j++) {
                    System.out.print(str[i][j] + "\t ||");
                    System.out.print("||\t");
                }
                System.out.println(" ");
            }
        }
    }
void checkout(){
        row1();
        for (int i = 1; i < row; i++) {
            if (str[i][5] == null){break;}
            else if ((str[i][5].startsWith("book"))) {
                for (int j = 0; j < col; j++) {
                    System.out.print(str[i][j] + "\t ||");
                    System.out.print("||\t");
                }
                System.out.println(" ");
            }
        }
    }

 public static void main(String[] args) {
                str[0][0] = "s.no";
                str[0][1] = "Book";
                str[0][2] = "Author";
                str[0][3] = "Tot qty";
                str[0][4] = "Avl qty";
                str[0][5] = "Book Status";
                std[0][0] = "s.no";
                std[0][1] = "Name";
                std[0][2] = "Dept";
                std[0][3] = "Books taken";

                task2 obj = new task2();

                boolean n = true;
                while (n) {
                    System.out.println("\n");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Press 0 to Exit Application \nPress 1 to Add New Book  \nPress 2 to Search a Book ");
                    System.out.println("Press 3 to Register Student \npress 4 to UPDATE QUANTITY-borrow books\npress 5 to UPDATE QUANTITY-Return books \nPress 6 to Show All Registered Students \nPress 7 to Check Out Book \nPress 8 to Check In Book \nPress 9 to Show All Books");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("enter a choice :");
                    int ch = in.nextInt();
                    //if (ch < 10) {
                        switch (ch) {
                            case 0:
                                System.out.println("-------------------------EXIT APPLICATION------------------------------------");
                                n = false;
                                break;
                            case 1:
                                System.out.println("-------------------------ADD NEW BOOK------------------------------------");
                                System.out.println("|| s.no || name || Author || Tot qty || Avl qty || Book status");
                                obj.add();
                                break;
                            case 2:
                                System.out.println("-------------------------SEARCHING BOOK------------------------------------");
                                obj.search();
                                break;
                            case 3:
                                System.out.println("---------------------------STUDENT REGISTRATION----------------------------------");
                                obj.register();
                                break;
                            case 4:
                                System.out.println("-------------------------UPDATE QUANTITY-BORROWING BOOK------------------------------------");
                                obj.borrow();
                                break;
                            case 5:
                                System.out.println("-------------------------UPDATE QUANTITY-RETURNING  BOOK------------------------------------");
                                obj.returns();
                                break;
                            case 6:
                                System.out.println("------------------------SHOWING ALL STUDENT-------------------------------------");
                                obj.show();
                                break;
                            case 7:
                                System.out.println("------------------------SHOWING CHECKED-OUT BOOK-------------------------------------");
                                obj.checkout();
                                break;
                            case 8:
                                System.out.println("-------------------------SHOWING CHECKED-IN BOOK------------------------------------");
                                obj.checkin();
                                break;
                            case 9:
                                System.out.println("--------------------------SHOWING ALL BOOKS-----------------------------------");
                                obj.print();
                                break;
                            default:
                                System.out.println("invalid input!!!");
                                break;
                        }
                }

        }


}


