package ui;

import java.util.Scanner;
import dao.*;
import model.User;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintDao cdao = new ComplaintDao();
        AdminDao adao = new AdminDao();
        UserDao udao = new UserDao();

        while (true) {
        	System.out.println("=====WELCOME TO COMPLAINT MANAGEMENT SYSTEM=====");
            System.out.println("\n1. User\n2. Admin\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                // ================= USER =================
                case 1:

                    while (true) {
                    	System.out.println("================= USER =================");
                        System.out.println("\n1. Register\n2. Login\n3. Back");
                        int opt = sc.nextInt();
                        sc.nextLine();

                        if (opt == 1) {

                            System.out.println("Enter Username:");
                            String uname = sc.nextLine();

                            System.out.println("Enter Password:");
                            String pass = sc.nextLine();

                            User user = new User(uname, pass);
                            udao.addUser(user);
                        }

                        else if (opt == 2) {

                            System.out.println("Enter Username:");
                            String u = sc.next();

                            System.out.println("Enter Password:");
                            String p = sc.next();

                            if (udao.login(u, p)) {

                                System.out.println("Login Successful!");

                                while (true) {
                                    System.out.println("\n1. Register Complaint");
                                    System.out.println("2. Check Status & Points");
                                    System.out.println("3. Logout");

                                    int ch = sc.nextInt();

                                    switch (ch) {

                                        case 1:
                                            sc.nextLine();

                                            System.out.println("Enter Name:");
                                            String name = sc.nextLine();

                                            System.out.println("Enter Complaint:");
                                            String comp = sc.nextLine();

                                            System.out.println("Enter Department:");
                                            String dept = sc.next();

                                            System.out.println("Social Impact? (1-Yes / 0-No):");
                                            boolean social = sc.nextInt() == 1;

                                            cdao.addComplaint(name, comp, dept, social);
                                            break;

                                        case 2:
                                            System.out.println("Enter Complaint ID:");
                                            int id = sc.nextInt();
                                            cdao.checkFullDetails(id);
                                            break;

                                        case 3:
                                            break;
                                    }

                                    if (ch == 3) break;
                                }

                            } else {
                                System.out.println("Invalid Login! Please register first.");
                            }
                        }

                        else if (opt == 3) {
                            break;
                        }

                        else {
                            System.out.println("Invalid choice");
                        }
                    }
                    break;

                // ================= ADMIN =================
                case 2:
                	System.out.println("================= ADMIN =================");
                    System.out.println("Username:");
                    String au = sc.next();

                    System.out.println("Password:");
                    String ap = sc.next();

                    if (adao.login(au, ap)) {

                        while (true) {

                            System.out.println("\n1. View All Complaints");
                            System.out.println("2. Update Status");
                            System.out.println("3. Add Points");
                            System.out.println("4. Logout");

                            int ch = sc.nextInt();

                            switch (ch) {

                                case 1:
                                	System.out.println("=============================");
                                    cdao.viewComplaints();
                                    System.out.println("=============================");
                                    break;

                                case 2:
                                    System.out.println("Enter ID:");
                                    int id = sc.nextInt();
                                    System.out.println("Enter Status:");
                                    String st = sc.next();
                                    System.out.println("============================="); 
                                    cdao.updateStatus(id, st);
                                    System.out.println("=============================");
                                    break;

                                case 3:
                                    System.out.println("Enter ID:");
                                    int id2 = sc.nextInt();

                                    System.out.println("Enter Quality (1-Low, 2-Medium, 3-High):");
                                    int q = sc.nextInt();

                                    int pts = 0;

                                    switch (q) {
                                        case 1: pts = 5; break;
                                        case 2: pts = 10; break;
                                        case 3: pts = 20; break;
                                        default: System.out.println("Invalid");
                                    }

                                    cdao.markUseful(id2, pts);
                                    break;

                                case 4:
                                    break;
                            }

                            if (ch == 4) break;
                        }

                    } else {
                        System.out.println("Invalid Admin Login");
                    }
                    break;

                // ================= EXIT =================
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}