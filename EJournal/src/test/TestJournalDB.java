/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import db.JournalOperations;
import db.PersistenceOperations;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class TestJournalDB {

    public static void main(String[] args) {
        
        JournalOperations jo = new JournalOperations();
        PersistenceOperations po = new PersistenceOperations();
        
        jo.openDB();
        jo.dropSequences();
        jo.dropTables();
        jo.createSequences();
        jo.createTables();
        
        jo.fillAffiliateTable();
        jo.fillJournalTable();
        jo.fillPersonTable();
        jo.fillManuscriptTable();
        jo.fillManuscriptAuthorTable();
        jo.fillManuscriptReviewTable();
        
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("TEST MENU");
            System.out.println("Press 1 to add a manuscript.");
            System.out.println("Press 2 to assign a manuscript to reviewers.");
            System.out.println("Press 3 to submit a review of a manuscript.");
            System.out.println("Press 4 to see reviews of a manuscript.");
            System.out.println("Press 5 to accept/reject manuscript.");//Nested menu in here maybe?
            System.out.println("Press 6 to add a journal issue.");
            System.out.println("Press 7 to schedule a manuscript for publication.");
            System.out.println("Press 8 to publish an issue.");

            //Searching and viewing. Nested menu?
//            System.out.println("Press 9 to view all authors of a manuscript.");
//            System.out.println("Press 10 to view all manuscripts in a published journal issue.");
//            System.out.println("Press 11 to see all manuscripts submitted by an author.");
//            System.out.println("Press 12 to search for a key word.");//Might be difficult to implement, check later.
//            System.out.println("Press 13 to see all details on a manuscript.");
//            System.out.println("Press 14 to see all details on an author.");
//            System.out.println("Press 15 to see all details on a reviewer.");
//            System.out.println("Press 16 to see all details on a journal issue.");
            
            //Admin, adding and removing entities. Nested Menu?
//            System.out.println("Press x to add an author.");
//            System.out.println("Press x to add a reviewer.");
//            System.out.println("Press x to add an affiliate.");
//            System.out.println("Press x to add an interest.");
//            System.out.println("Press x to remove an author.");
//            System.out.println("Press x to remove a reviewer.");
//            System.out.println("Press x to remove an affiliate.");
//            System.out.println("Press x to remove an interest.");
//            System.out.println("Press x to add an interest to a reviewer.");
//            System.out.println("Press x to remove an interest to a reviewer.");
            
            //Exit
            System.out.println("Press 99 to exit.");

            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Please enter title of manuscript");
                    String title = in.nextLine();
                    System.out.println("Please enter how many authors have contributed to this manuscript: ");
                    int authNum = in.nextInt();
                    in.nextLine();
//                    po.addManuscript(title,currentDate);
                    for (int i = 0; i < authNum; i++) {
                        System.out.println("Please enter ID of author " + (i + 1) + " of manuscript: ");
                        int authID = in.nextInt();
                        in.nextLine();
//                        po.assignAuthorToManuscript(authID,);//Find way to get latest manuscript added, use that id.
                    }
                    //Change to 'received'
                    break;
                case 2:
                    System.out.println("Please enter the ID of the manuscript to review");
                    int manuID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the number of reviewers to review the manuscript");
                    int revNum = in.nextInt();
                    for (int i = 0; i < revNum; i++) {
                        System.out.println("Please enter ID of reviewer " + (i + 1) + " of manuscript: ");
                        int revID = in.nextInt();
                        in.nextLine();
//                        po.reviewManuscript(revID, manuID, currentDate);

                    }
                    //Change to 'under review'
                    break;
                case 3:
                    System.out.println("Please enter your reviewer ID: ");
                    int revID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter ID of manuscript you are submitting a review for: ");
                    manuID = in.nextInt();
                    in.nextLine();

                    int revAppropriate;
                    do {
                        System.out.println("Please enter rating for appropriateness (1-10): ");
                        revAppropriate = in.nextInt();
                        in.nextLine();
                        if (revAppropriate < 1 || revAppropriate > 10) {
                            System.out.println("Rating must be between 1 and 10 inclusive.");
                        }
                    } while (revAppropriate < 1 || revAppropriate > 10);

                    int revClarity;
                    do {
                        System.out.println("Please enter rating for clarity (1-10): ");
                        revClarity = in.nextInt();
                        in.nextLine();
                        if (revClarity < 1 || revClarity > 10) {
                            System.out.println("Rating must be between 1 and 10 inclusive.");
                        }
                    } while (revClarity < 1 || revClarity > 10);

                    int revMethod;
                    do {
                        System.out.println("Please enter rating for method (1-10): ");
                        revMethod = in.nextInt();
                        in.nextLine();
                        if (revMethod < 1 || revMethod > 10) {
                            System.out.println("Rating must be between 1 and 10 inclusive.");
                        }
                    } while (revMethod < 1 || revMethod > 10);

                    int revContribution;
                    do {
                        System.out.println("Please enter rating for contribution (1-10): ");
                        revContribution = in.nextInt();
                        in.nextLine();
                        if (revContribution < 1 || revContribution > 10) {
                            System.out.println("Rating must be between 1 and 10 inclusive.");
                        }
                    } while (revContribution < 1 || revContribution > 10);

                    System.out.println("Please enter recommendation (accept/reject): ");
                    String revRecommendation = in.next();
                    in.nextLine();
//                    po.addReview(revID,manuID,revAppropriate,revClarity,revMethod,revContribution,revRecommendation,currentDate);
                    break;
                case 4:
                    System.out.println("Please enter ID of manuscript for which you want to view reviews: ");
                    manuID = in.nextInt();
                    in.nextLine();
//                    po.viewReviews(manuID);
                    break;
                case 5://Maybe nested switch to pick accept/reject.
                    System.out.println("Please enter ID of manuscript you wish to accept/reject: ");
                    manuID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter if you wish to accept or reject this manuscript (accept/reject): ");
                    String x = in.next();
                    in.nextLine();
//                    po.accept(x,currentDate);
                    //Should change to 'accepted' or 'rejected'
                    break;
                case 9:
                    System.out.println("Please enter the name of the affilate you want to add.");
                    String name = in.nextLine();
                    System.out.println("Please enter the address.");
                    String address = in.nextLine();
                    System.out.println("Please enter the email.");
                    String email = in.nextLine();
                    po.addAffil(name, address, email);
                    break;
                case 99:
                    jo.closeDB();
                    System.exit(0);
                default:
                    System.out.println("Invalid option entered.");
                    break;
            }

        }
    }

}
