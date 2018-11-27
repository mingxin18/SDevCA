/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Kevin
 */
public class JournalOperations {

    private Connection conn;
    private PreparedStatement pstmt;

    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            // Tallaght
            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
            ods.setUser("x00149930");
            ods.setPassword("db26Aug83");
            // Home Oracle XE
//            ods.setURL("jdbc:oracle:thin:HR/pmagee@localhost:1521:XE");
//            ods.setUser("hr");
//            ods.setPassword("passhr");
            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (SQLException e) {
            System.out.print("Unable to load driver " + e.getMessage());
        }
        return conn;
    }

    public void closeDB() {
        try {
            pstmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            System.out.println("Could not close connection " + ex.getMessage());
        }
    }

    public void dropSequences() {
        dropPersonSequence();
//        dropReviewerSequence();
//        dropAuthorSequence();
        dropManuscriptSequence();
        dropAffiliateSequence();
    }

    public void dropTables() {
//        dropReviewerInterestTable();
//        dropManuscriptAuthorTable();
//        dropManuscriptReviewTable();
        dropManuscriptTable();
        dropAuthorTable();
        dropReviewerTable();
        dropJournalTable();
        dropInterestTable();
        dropPersonTable();
        dropAffiliateTable();
    }

    public void createSequences() {
        createPersonSequence();
//        createReviewerSequence();
//        createAuthorSequence();
        createManuscriptSequence();
        createAffiliateSequence();
    }

    public void createTables() {
        createAffiliateTable();
        createPersonTable();
        createReviewerTable();
        createAuthorTable();
        createJournalTable();
        createManuscriptTable();
        createInterestTable();
//        createReviewerInterestTable();
//        createManuscriptAuthorTable();
//        createManuscriptReviewTable();
    }

    public void dropPersonSequence() {
        try {
            String s1 = "drop sequence pid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Person Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropReviewerSequence() {
        try {
            String s1 = "drop sequence rid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Reviewer Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropAuthorSequence() {
        try {
            String s1 = "drop sequence aid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Author Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropManuscriptSequence() {
        try {
            String s1 = "drop sequence mid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Manuscript Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropAffiliateSequence() {
        try {
            String s1 = "drop sequence afid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Affiliate Sequence dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropManuscriptTable() {
        System.out.println("Checking for existence of Manuscript table");
        try {
            String s1 = "DROP TABLE Manuscript";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Manuscript table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropReviewerTable() {
        System.out.println("Checking for existence of Reviewer table");
        try {
            String s1 = "DROP TABLE Reviewer";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Reviewer table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropAuthorTable() {
        System.out.println("Checking for existence of Author table");
        try {
            String s1 = "DROP TABLE Author";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Author table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropJournalTable() {
        System.out.println("Checking for existence of Journal table");
        try {
            String s1 = "DROP TABLE Journal";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Journal table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropInterestTable() {
        System.out.println("Checking for existence of Interest table");
        try {
            String s1 = "DROP TABLE Interest";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Interest table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropAffiliateTable() {
        System.out.println("Checking for existence of Affiliate table");
        try {
            String s1 = "DROP TABLE Affiliate";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Affiliate table dropped");
        } catch (SQLException ex) {
        }
    }

    public void dropPersonTable() {
        System.out.println("Checking for existence of Person table");
        try {
            String s1 = "DROP TABLE Person";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Person table dropped");
        } catch (SQLException ex) {
        }
    }

    public void createPersonSequence() {
        try {
            String createseq1 = "create sequence pid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Person Sequence created");
        } catch (SQLException ex) {
            System.out.println("Problem with Person Sequence " + ex.getMessage());
        }
    }

    public void createReviewerSequence() {
        try {
            String createseq1 = "create sequence rid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Reviewer Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Reviewer Sequence " + ex.getMessage());
        }
    }

    public void createAuthorSequence() {
        try {
            String createseq1 = "create sequence aid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Author Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Author Sequence " + ex.getMessage());
        }
    }

    public void createManuscriptSequence() {
        try {
            String createseq1 = "create sequence mid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Manuscript Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Manuscript Sequence " + ex.getMessage());
        }
    }

    public void createAffiliateSequence() {
        try {
            String createseq1 = "create sequence afid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Affiliate Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Affiliate Sequence " + ex.getMessage());
        }
    }

    public void createManuscriptTable() {
        try {
            String sql = "CREATE TABLE Manuscript (manuscript_id NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "manuscript_title varchar2(255),"
                    + "received_date date,"
                    + "manuscript_status varchar2(255),"
                    + "acceptance_date date,"
                    + "journal_id number,"
                    + "CONSTRAINT check_status CHECK (manuscript_status='received' "
                    + "OR manuscript_status='accepted' "
                    + "OR manuscript_status='rejected' "
                    + "OR manuscript_status='under review' "
                    + "OR manuscript_status='scheduled' "
                    + "OR manuscript_status='published'),"
                    + "foreign key (journal_id) references Journal(journal_id) ON DELETE SET NULL)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Manuscript table" + ex.getMessage());
        }
    }

    public void createReviewerTable() {
        try {
            String sql = "create table reviewer("
                    + "person_id number PRIMARY KEY NOT NULL)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Reviewer table" + ex.getMessage());
        }
    }

    public void createAuthorTable() {
        try {
            String sql = "create table author("
                    + "person_id number PRIMARY KEY NOT NULL)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Author table" + ex.getMessage());
        }
    }

    public void createJournalTable() {
        try {
            String sql = "create table journal("
                    + "journal_id number NOT NULL,"
                    + "pub_period varchar2(10),"
                    + "pub_year number,"
                    + "pub_volume number,"
                    + "pub_number number,"
                    + "pub_date date,"
                    + "CONSTRAINT check_period CHECK(pub_period = 'Spring' "
                    + "OR pub_period = 'Summer' "
                    + "OR pub_period = 'Fall' "
                    + "OR pub_period = 'Winter'),"
                    + "primary key(journal_id))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Journal table" + ex.getMessage());
        }
    }

    public void createInterestTable() {
        try {
            String sql = "create table Interest("
                    + "IS_Code varchar2(255) NOT NULL,"
                    + "description varchar2(255)"
                    + "CONSTRAINT check_desc CHECK(description = 'Computing' "
                    + "OR description = 'Engineering' "
                    + "OR description = 'Science' "
                    + "OR description = 'Business' "
                    + "OR description = 'Information Technology'),"
                    + "primary key (IS_Code))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Reviewer table" + ex.getMessage());
        }
    }

    public void createAffiliateTable() {
        try {
            String sql = "create table Affiliate("
                    + "affiliate_id number NOT NULL,"
                    + "affiliate_name varchar2(255),"
                    + "contact_address varchar2(255),"
                    + "contact_email varchar2(255),"
                    + "primary key (affiliate_id))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Affiliate table" + ex.getMessage());
        }
    }

    public void createPersonTable() {
        try {
            String sql = "create table Person("
                    + "person_id number PRIMARY KEY NOT NULL,"
                    + "first_name varchar2(255) NOT NULL,"
                    + "last_name varchar2(255) NOT NULL,"
                    + "address varchar2(255),"
                    + "email varchar2(255),"
                    + "affiliate_id number,"
                    + "role varchar2(10),"
                    + "FOREIGN KEY (affiliate_id) "
                    + "REFERENCES affiliate(affiliate_id) ON DELETE SET NULL)";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Person table" + ex.getMessage());
        }
    }

    public void fillTables() {

    }

}
