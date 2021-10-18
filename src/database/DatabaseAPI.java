package database;

import database.jdbc.SqlAPI;
import database.lucene.LuceneAPI;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

public class DatabaseAPI {

    private LuceneAPI luceneAPI;
    private SqlAPI sqlAPI;

    private LinkedList<String[]> response;

    public DatabaseAPI() throws IOException {
        this.luceneAPI = new LuceneAPI();
        this.sqlAPI = new SqlAPI();
    }

    public DatabaseAPI(String indexDir, String dataDir) throws IOException {
        this.luceneAPI = new LuceneAPI(indexDir, dataDir);
        this.sqlAPI = new SqlAPI();
    }

    public void search(String query) throws ParseException, org.apache.lucene.queryparser.classic.ParseException, IOException, SQLException {
        if ( isQueryMixed(query) ) {
            String[] splitedQueries = query.split(" with ");
            LinkedList<String[]> luceneResponse =  getLuceneResponse(splitedQueries[1]);
            if (luceneResponse.isEmpty()) { return; } /* si aucun résultat n'est trouvé par lucene on affiche rien */
            ResultSet sqlResponse = getSqlResponse(splitedQueries[0]);
            if (sqlResponse != null) { return; } /* si aucun résultat n'est trouvé par jdbc on affiche rien */
            joinResults(sqlResponse, luceneResponse);
        } else {
            /* convertir tout le resultat en liste chaine pour une cohérence générale */
            /* ce n'est pas une bonne solution, il est recommandé d'utiliser la fonction getSqlResponse
               quand on sait bien que le query est purement SQL
            */
            if ( query.contains("from") ) {
                ResultSet sqlResponse = getSqlResponse(query);
                int dataSize = sqlResponse.getMetaData().getColumnCount();
                while(sqlResponse != null) {
                    String[] data = new String[dataSize];
                    for (int i = 0; i<dataSize; i++){
                        data[i] = sqlResponse.getString(i);
                    }
                    this.response.add(data);
                    this.sqlAPI.next();
                }
            } else {
                this.response = getLuceneResponse(query);
            }
        }
    }

    private void joinResults(ResultSet sqlResponse, LinkedList<String[]> luceneResponse) throws SQLException {
        int size = sqlResponse.getMetaData().getColumnCount() + 2;

        while ( sqlResponse != null ){

            int index = findMatchingResults(sqlResponse.getString(0) , luceneResponse);
            if ( index != -1 ){
                String score = luceneResponse.get(index)[1];
                String[] data = new String[size];
                for (int i = 0; i<size - 1; i++){
                    data[i] = sqlResponse.getString(i);
                }
                data[size-1] = score;
                addToResponse(data, size, score);
            }

            this.sqlAPI.next();
        }
    }

    private void addToResponse(String[] data, int dataSize, String score) {
        if ( !this.response.isEmpty() ) {
            int index = 0;
            for(String[] elem : this.response){
                float score1 = Float.parseFloat(elem[dataSize-1]);
                float score2 = Float.parseFloat(data[dataSize-1]);
                if ( score1 <= score2 ){
                    this.response.add(index, data);
                    return;
                }
                index++;
            }
            this.response.addLast(data);
        } else {
            this.response.addFirst(data);
        }
    }

    private int findMatchingResults(String id, LinkedList<String[]> luceneResponse) {
        int index = -1;
        int count = 0;
        for(String[] elem : luceneResponse){
            if (elem.equals(id)) {
                index = count;
            }
            count++;
        }
        return index;
    }

    public boolean isQueryMixed(String query){
        return query.contains("with") ? true : false;
    }

    public LinkedList<String[]> getLuceneResponse(String query) throws ParseException, org.apache.lucene.queryparser.classic.ParseException, IOException {
        this.luceneAPI.search(query);
        this.luceneAPI.printResponse();
        return this.luceneAPI.getResponse();
    }

    public ResultSet getSqlResponse(String query) {
        this.sqlAPI.search(query);
        return this.sqlAPI.getResponse();
    }

    public LinkedList<String[]> getResponse() {
        return response;
    }

    public LuceneAPI getLuceneAPI() {
        return luceneAPI;
    }

    public SqlAPI getSqlAPI() {
        return sqlAPI;
    }
}
