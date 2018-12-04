/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import db.JournalOperations;
import db.PersistenceOperations;
import java.util.Scanner;
import model.*;

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
        jo.fillTables();

//        jo.fillAffiliateTable();
//        jo.fillJournalTable();
//        jo.fillPersonTable();
//        jo.fillManuscriptTable();
//        jo.fillManuscriptAuthorTable();
//        jo.fillManuscriptReviewTable();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("TEST MENU");
            System.out.println("Press 1 to add a manuscript.");
            System.out.println("Press 2 to add authors to a manuscript.");
            System.out.println("Press 3 to assign a manuscript to reviewers.");
            System.out.println("Press 4 to submit a review of a manuscript.");
            System.out.println("Press 5 to see reviews of a manuscript.");
            System.out.println("Press 6 to accept/reject manuscript.");
            System.out.println("Press 7 to add a journal issue.");
            System.out.println("Press 8 to schedule a manuscript for publication.");
            System.out.println("Press 9 to publish an issue.");

            //Searching and viewing. Nested menu?
//            System.out.println("Press 9 to view all authors of a manuscript.");
//            System.out.println("Press 10 to view all manuscripts in a published journal issue.");
//            System.out.println("Press 13 to see all details on a manuscript.");
//            System.out.println("Press 16 to see all details on a journal issue.");
            //Admin, adding and removing entities. Nested Menu?
            System.out.println("Press 11 to add an author/reviewer.");
            System.out.println("Press 12 to add an affiliate.");
            System.out.println("Press 13 to remove a person.");
            System.out.println("Press 14 to remove an affiliate.");
            System.out.println("Press 15 to remove a journal.");

            //Exit
            System.out.println("Press 99 to exit.");

            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Please enter title of manuscript");
                    String title = in.nextLine();
                    Manuscript manu = new Manuscript(title);
                    po.addManuscript(manu);
                    break;
                case 2:
                    System.out.println("Please enter the manuscript ID for which you want to assign authors.");
                    int manuID = in.nextInt();
                    System.out.println("Please enter the number of authors you wish to assign to the manuscript.");
                    int numAuthors = in.nextInt();
                    for (int i = 0; i < numAuthors; i++) {
                        System.out.println("Please enter the id number of author " + (i + 1) + ":");
                        int authID = in.nextInt();
                        po.assignAuthorToManuscript(authID, manuID);
                    }
                    break;
                case 3:
                    System.out.println("Please enter the ID you wish to send to reviewers.");
                    manuID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the number of reviewers to review the manuscript");
                    int revNum = in.nextInt();
                    for (int i = 0; i < revNum; i++) {
                        System.out.println("Please enter ID of reviewer " + (i + 1) + " of manuscript: ");
                        int revID = in.nextInt();
                        in.nextLine();
                        po.reviewManuscript(revID, manuID);
                    }
                    po.reviewManuscript(manuID);
                    break;
                case 4:
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
//                    po.addReview(revID,manuID,revAppropriate,revClarity,revMethod,revContribution,revRecommendation);
                    break;
                case 5:
                    System.out.println("Please enter ID of manuscript for which you want to view reviews: ");
                    manuID = in.nextInt();
                    in.nextLine();
//                    po.viewReviews(manuID);
                    break;
                case 6:
                    System.out.println("Please enter ID of manuscript you wish to accept/reject: ");
                    manuID = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter if you wish to accept or reject this manuscript (accept/reject): ");
                    String acceptanceInput = in.next();
                    if (!(acceptanceInput.equalsIgnoreCase("accept") || acceptanceInput.equalsIgnoreCase("reject"))) {
                        do {
                            System.out.println("Invalid choice entered. Please enter if you wish to accept or reject the manuscript(accept/reject)");
                            acceptanceInput = in.nextLine();
                        } while (!(acceptanceInput.equalsIgnoreCase("accept") || acceptanceInput.equalsIgnoreCase("reject")));
                    }
                    if (acceptanceInput.equalsIgnoreCase("accept")) {
                        po.accept(manuID);
                    } else {
                        po.reject(manuID);
                    }
                    break;
                case 7:
                    System.out.println("Please enter publication period (spring,summer,fall,winter):");
                    String pubPeriod = in.nextLine();
                    if (!(pubPeriod.equalsIgnoreCase("spring") || pubPeriod.equalsIgnoreCase("summer") || pubPeriod.equalsIgnoreCase("fall") || pubPeriod.equalsIgnoreCase("winter"))) {
                        do {
                            System.out.println("Invalid publication perdiod. Please enter valid selection (spring,summer,fall,winter):");
                            pubPeriod = in.nextLine();
                        } while (!(pubPeriod.equalsIgnoreCase("spring") || pubPeriod.equalsIgnoreCase("summer") || pubPeriod.equalsIgnoreCase("fall") || pubPeriod.equalsIgnoreCase("winter")));
                    }
                    System.out.println("Please enter publication year:");
                    int pubYear = in.nextInt();
                    System.out.println("Please enter publication volume:");
                    int pubVolume = in.nextInt();
                    System.out.println("Please enter publication number:");
                    int pubNumber = in.nextInt();
                    Journal j = new Journal(pubPeriod, pubYear, pubVolume, pubNumber);
                    po.addJournalIssue(j);
                    break;
                case 8:
                    System.out.println("Please enter the journal id you wish to schedule for.");
                    int journalID = in.nextInt();
                    in.nextLine();
                    System.out.println("How many manuscripts would you like to schedule for publication in this journal?");
                    int numManuscripts = in.nextInt();
                    for (int i = 0; i < numManuscripts; i++) {
                        System.out.println("Please enter the id of manuscript " + (i + 1) + ":");
                        manuID = in.nextInt();
                        po.scheduleManuscriptToJournal(manuID, journalID);
                    }
                    break;
                case 9:
                    System.out.println("Please enter the id of the journal you wish to publish.");
                    journalID = in.nextInt();
                    po.publishJournal(journalID);
                    break;
                case 10:
                    System.out.println("Please enter the first name of the person you would like to add.");
                    String fname = in.nextLine();
                    System.out.println("Please enter the surname of the person you would like to add.");
                    String lname = in.nextLine();
                    System.out.println("Please enter the address.");
                    String address = in.nextLine();
                    System.out.println("Please enter their email.");
                    String email = in.nextLine();
                    System.out.println("Please enter their role(author/reviewer): ");
                    String role = in.nextLine();
                    if (!(role.equalsIgnoreCase("author") || role.equalsIgnoreCase("reviewer"))) {
                        do {
                            System.out.println("Invalid role entered. Please enter a valid role (author/reviewer): ");
                            role = in.nextLine();
                        } while (!(role.equalsIgnoreCase("author") || role.equalsIgnoreCase("reviewer")));
                    }
                    if (role.equalsIgnoreCase("author")) {
                        Author auth = new Author(fname, lname, address, email);
                        po.addAuthor(auth);
                    }
                    if (role.equalsIgnoreCase("reviewer")) {
                        Reviewer reviewer = new Reviewer(fname, lname, address, email);
                        po.addReviewer(reviewer);
                    }
                    break;
                case 11:
                    System.out.println("Please enter the name of the affilate you want to add.");
                    String name = in.nextLine();
                    System.out.println("Please enter the address.");
                    address = in.nextLine();
                    System.out.println("Please enter the email.");
                    email = in.nextLine();
                    Affiliate affil = new Affiliate(name, address, email);
                    po.addAffil(affil);
                    break;
                case 99:
                    po.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option entered.");
                    break;
            }

        }
    }

}
