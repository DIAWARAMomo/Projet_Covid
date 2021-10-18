package database.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;

public class LuceneAPI {

    private String indexDir = "assets/index";
    private String dataDir = "assets/data";
    private Indexer indexer;
    private Searcher searcher;

    private LinkedList<String[]> response = new LinkedList<>();

    public LuceneAPI() throws IOException {
        createIndex();
    }

    public LuceneAPI(String indexDir, String dataDir) throws IOException {
        this.indexDir = indexDir;
        this.dataDir = dataDir;
        createIndex();
    }

    public void search(String searchQuery) throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException {
        this.searcher = new Searcher(this.indexDir);
        long startTime = System.currentTimeMillis();
        TopDocs hits = this.searcher.search(searchQuery);
        long endTime = System.currentTimeMillis();
        System.out.println(hits.totalHits + " documents found. Time :" + (endTime - startTime));
        for(ScoreDoc scoreDoc : hits.scoreDocs)
        {
            Document doc = this.searcher.getDocument(scoreDoc);
            System.out.println("File: " + doc.get(LuceneConstants.FILE_PATH));
            String fileName = doc.get(LuceneConstants.FILE_NAME);
            String id = fileName.split(".txt")[0];
            String[] data = {id, ""+scoreDoc.score};
            this.response.add(data);
        }
    }

    private void createIndex() throws IOException {
        this.indexer = new Indexer(this.indexDir);
        int numIndexed;
        long startTime = System.currentTimeMillis();
        numIndexed = this.indexer.createIndex(this.dataDir, new TextFileFilter());
        long endTime = System.currentTimeMillis();
        this.indexer.close();
        System.out.println(numIndexed+" File indexed, time taken: " +(endTime-startTime)+" ms");
    }

    public LinkedList<String[]> getResponse() {
        return response;
    }

    public void printResponse() {
        for (String[] element: this.response) {
            System.out.println( "id : " + element[0] + "       score : " + element[1] );
        }
    }
}
