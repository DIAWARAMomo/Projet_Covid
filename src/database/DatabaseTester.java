package database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

public class DatabaseTester {

    public static void main(String[] args) throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException, SQLException {
        DatabaseAPI db = new DatabaseAPI();

        /* ça marche pour n'importe quelle requete mixte ou pas mixte, mais c'est mieux avec les requetes mixtes */
        /* dans le cas où tu ne sais pas si la requete est mixte ou pas tu utilise ça */
        db.search("requete mixtes");
        LinkedList<String[]> response = db.getResponse();

        /* si tu veux gérer les requetes sql seulement */
        ResultSet sqlResponse = db.getSqlResponse( "requete sql"); /* pour avoir le resultat d'une requete sql */

        /* si tu veux gérer les requetes lucene seulement */
        LinkedList<String[]> luceneResponse = db.getLuceneResponse( "requete lucene");


    }
}
