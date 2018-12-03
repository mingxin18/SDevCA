/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//            ods.setUser("x00149930");
//            ods.setPassword("db26Aug83");
            // Home Oracle XE
            ods.setURL("jdbc:oracle:thin:HR/kevin@localhost:1521:XE");
            ods.setUser("hr");
            ods.setPassword("passhr");
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
        dropManuscriptSequence();
        dropAffiliateSequence();
        dropJournalSequence();
    }

    public void dropTables() {
        dropManuscriptAuthorTable();
        dropManuscriptReviewTable();
        dropManuscriptTable();
        dropAuthorTable();
        dropReviewerTable();
        dropJournalTable();
        dropPersonTable();
        dropAffiliateTable();
    }

    public void createSequences() {
        createPersonSequence();
        createManuscriptSequence();
        createAffiliateSequence();
        createJournalSequence();
    }

    public void createTables() {
        createAffiliateTable();
        createPersonTable();
        createReviewerTable();
        createAuthorTable();
        createJournalTable();
        createManuscriptTable();
        createManuscriptAuthorTable();
        createManuscriptReviewTable();
    }

    public void fillTables() {
        fillAffiliateTable();
        fillPersonTable();
        fillJournalTable();
        fillManuscriptTable();
        fillManuscriptAuthorTable();
//        fillManuscriptReviewTable();
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

    public void dropJournalSequence() {
        try {
            String s1 = "drop sequence jid_seq";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Journal Sequence dropped");
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

    public void dropManuscriptReviewTable() {
        System.out.println("Checking for existence of ManuscriptReview table");
        try {
            String s1 = "DROP TABLE ManuscriptReview";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("ManuscriptReview table dropped");
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

    public void dropManuscriptAuthorTable() {
        System.out.println("Checking for existence of ManuscriptAuthor table");
        try {
            String s1 = "DROP TABLE manuscriptauthor";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("ManuscriptAuthor table dropped");
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

    public void createJournalSequence() {
        try {
            String createseq1 = "create sequence jid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Journal Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Journal Sequence " + ex.getMessage());
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
            String sql = "create table reviewer ( "
                    + "person_id number, "
                    + "primary key (person_id), "
                    + "foreign key (person_id) references person(person_id)"
                    + ")";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Reviewer table" + ex.getMessage());
        }
    }

    public void createManuscriptReviewTable() {
        try {
            String sql = "create table ManuscriptReview ( "
                    + "person_id number, "
                    + "manuscript_id number, "
                    + "rate_approp number, "
                    + "rate_clarity number, "
                    + "rate_method number, "
                    + "rate_contribution number, "
                    + "recommendation varchar2(10), "
                    + "Primary Key (person_id, manuscript_id), "
                    + "foreign key (person_id) references reviewer (person_id), "
                    + "foreign key (manuscript_id) references manuscript (manuscript_id) "
                    + ")";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "ManuscriptReview table" + ex.getMessage());
        }
    }

    public void createAuthorTable() {
        try {
            String sql = "create table author ( "
                    + "person_id number, "
                    + "primary key (person_id), "
                    + "foreign key (person_id) references person(person_id)"
                    + ")";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Author table" + ex.getMessage());
        }
    }

    public void createManuscriptAuthorTable() {
        try {
            String sql = "create table manuscriptauthor("
                    + "person_id number,"
                    + "manuscript_id number,"
                    + "Primary Key(person_id, manuscript_id),"
                    + "foreign key(person_id) references author(person_id),"
                    + "foreign key(manuscript_id) references manuscript(manuscript_id)"
                    + ")";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "ManuscriptAuthor table" + ex.getMessage());
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

    public void fillAffiliateTable() {
        try {
            String sql = "INSERT INTO affiliate VALUES(afid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "IT Tallaght");
            pstmt.setString(2, "1 Tallaght st.");
            pstmt.setString(3, "contact@itt.ie");
            pstmt.executeUpdate();

            pstmt.setString(1, "UCD");
            pstmt.setString(2, "1 UCD st.");
            pstmt.setString(3, "contact@ucd.ie");
            pstmt.executeUpdate();

            pstmt.setString(1, "DCU");
            pstmt.setString(2, "1 DCU st.");
            pstmt.setString(3, "contact@dcu.ie");
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "AFFILIATE table" + ex.getMessage());
        }
    }

    public void fillJournalTable() {
        try {
            String sql = "INSERT INTO journal VALUES(jid_seq.nextVal,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Spring");
            pstmt.setInt(2, 2018);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.setDate(5, Date.valueOf("2018-01-20"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Summer");
            pstmt.setInt(2, 2018);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 2);
            pstmt.setDate(5, Date.valueOf("2018-04-20"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Fall");
            pstmt.setInt(2, 2018);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 3);
            pstmt.setDate(5, Date.valueOf("2018-07-20"));
            pstmt.executeUpdate();

            pstmt.setString(1, "Winter");
            pstmt.setInt(2, 2018);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 4);
            pstmt.setDate(5, Date.valueOf("2018-10-20"));
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "AFFILIATE table" + ex.getMessage());
        }
    }

    public void fillPersonTable() {
        Statement stmt;
        try {
            // Insert data into table
            stmt = conn.createStatement();

            String sqlperson1 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'John','Smith','2 Grafton St.','john.smith@gmail.com',1,'Author')";
            stmt.executeUpdate(sqlperson1);

            String sqlauthor1 = "INSERT INTO Author VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlauthor1);

            String sqlperson2 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'Elaina','Blake','7 Grafton St.','elaina.blake@gmail.com',2,'Author')";
            stmt.executeUpdate(sqlperson2);

            String sqlauthor2 = "INSERT INTO Author VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlauthor2);

            String sqlperson3 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'Jayce','Barron','17 Grafton St.','jayce.thompson@gmail.com',3,'Author')";
            stmt.executeUpdate(sqlperson3);

            String sqlauthor3 = "INSERT INTO Author VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlauthor3);

            String sqlperson4 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'Logan','Thompson','45 Grafton St.','logan.thompson@gmail.com',1,'Reviewer')";
            stmt.executeUpdate(sqlperson4);

            String sqlreviewer1 = "INSERT INTO Reviewer VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlreviewer1);

            String sqlperson5 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'Lydia','Stout','3 Grafton St.','lydia.stout@gmail.com',2,'Reviewer')";
            stmt.executeUpdate(sqlperson5);

            String sqlreviewer2 = "INSERT INTO Reviewer VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlreviewer2);

            String sqlperson6 = "INSERT INTO Person VALUES "
                    + "(pid_seq.nextVal,'Brent','Graves','14 Grafton St.','brent.graves@gmail.com',3,'Reviewer')";
            stmt.executeUpdate(sqlperson6);

            String sqlreviewer3 = "INSERT INTO Reviewer VALUES (pid_seq.currVal)";
            stmt.executeUpdate(sqlreviewer3);

            System.out.println("Person table populated");

        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Person table" + ex.getMessage());
        }
    }

    public void fillManuscriptTable() {
        Statement stmt;
        try {
            stmt = conn.createStatement();

            String sqlm1 = "insert into manuscript values(mid_seq.nextVal,'Medicine is Good, how to make it Better',TO_DATE('2015/02/13','yyyy/mm/dd'),'accepted',TO_DATE('2016/02/13','yyyy/mm/dd'),NULL)";
            stmt.executeUpdate(sqlm1);

            String sqlm2 = "insert into manuscript values(mid_seq.nextVal,'How to design and build bridges for cheap',TO_DATE('2015/11/03','yyyy/mm/dd'),'rejected',NULL,NULL)";
            stmt.executeUpdate(sqlm2);

            String sqlm3 = "insert into manuscript values(mid_seq.nextVal,'Cooking for a crowd',TO_DATE('2017/11/03','yyyy/mm/dd'),'rejected',NULL,NULL)";
            stmt.executeUpdate(sqlm3);

            String sqlm4 = "insert into manuscript values(mid_seq.nextVal,'Software Testing in a Business Environment',TO_DATE('2016/02/13','yyyy/mm/dd'),'published',TO_DATE('2017/02/13','yyyy/mm/dd'),1)";
            stmt.executeUpdate(sqlm4);

        } catch (SQLException ex) {
            System.out.println("Error in fillManuscriptTable: " + ex.getMessage());;
        }
    }

    public void fillManuscriptAuthorTable() {
        Statement stmt;
        try {
            stmt = conn.createStatement();

            String sqlma1 = "insert into manuscriptauthor values(1,1)";
            stmt.executeUpdate(sqlma1);

            String sqlma2 = "insert into manuscriptauthor values(2,2)";
            stmt.executeUpdate(sqlma2);

            String sqlma3 = "insert into manuscriptauthor values(3,3)";
            stmt.executeUpdate(sqlma3);

            String sqlma4 = "insert into manuscriptauthor values(1,4)";
            stmt.executeUpdate(sqlma4);

        } catch (SQLException ex) {
            System.out.println("Error in fillManuscriptAuthorTable: " + ex.getMessage());;
        }
    }
    
    public void fillManuscriptReviewTable(){
        Statement stmt;
        try{
            stmt = conn.createStatement();
            
            String sqlmr1 = "insert into manuscriptreview values(4,1,6,6,6,6,'accept')";
            stmt.executeUpdate(sqlmr1);
            
            String sqlmr2 = "insert into manuscriptreview values(5,2,2,3,4,1,'reject')";
            stmt.executeUpdate(sqlmr2);
            
            String sqlmr3 = "insert into manuscriptreview values(6,3,1,4,5,2,'reject')";
            stmt.executeUpdate(sqlmr3);
            
            String sqlmr4 = "insert into manuscriptreview values(4,4,7,8,6,9,'accept')";
            stmt.executeUpdate(sqlmr4);
            
        } catch (SQLException ex) {
            System.out.println("Error in fillManuscriptReviewTable: "+ex.getMessage());
        }
    }
}
