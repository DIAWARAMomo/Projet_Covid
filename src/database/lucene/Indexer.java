package database.lucene;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {

    private IndexWriter writer;

    public Indexer(String indexDirectoryPath) throws IOException {
        Path path = Paths.get(indexDirectoryPath);

        Directory indexDirectory = FSDirectory.open(path);
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

        writer = new IndexWriter(indexDirectory, iwc);
    }

    public void close() throws CorruptIndexException, IOException {
        writer.close();
    }

    private Document getDocument(File file) throws IOException {
        Document document = new Document();

        FileReader fileReader = new FileReader(file);

        TextField contentField = new TextField(LuceneConstants.CONTENTS, fileReader);
        TextField fileNameField = new TextField(LuceneConstants.FILE_NAME, file.getName(),TextField.Store.YES);
        TextField filePathField = new TextField(LuceneConstants.FILE_PATH, file.getCanonicalPath(),TextField.Store.YES);

        document.add(contentField);
        document.add(fileNameField);
        document.add(filePathField);

        return document;
    }

    private void indexFile(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();

        System.out.println("Indexing "+canonicalPath);

        Document document = getDocument(file);
        writer.addDocument(document);
    }

    public int createIndex(String dataDirPath, FileFilter filter) throws IOException {
        File[] files = new File(dataDirPath).listFiles();

        for (File file : files) {
            if(!file.isDirectory()
                    && !file.isHidden()
                    && file.exists()
                    && file.canRead()
                    && filter.accept(file)) {
                indexFile(file);
            }
        }

        return writer.numRamDocs();
    }

    public int createIndex(String dataDirPath, String data, FileFilter filter, String id) throws IOException {
        String path = dataDirPath + id + ".txt";

        File file = new File(path);

        BufferedWriter w = new BufferedWriter(new FileWriter(path));
        w.write(data);

        if(file.canRead()
                && file.exists()
                &&  filter.accept(file)) {
            indexFile(file);
        }

        w.close();
        return writer.numRamDocs();
    }
}