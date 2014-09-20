package org.ruogu.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Searcher
 * 
 * @author Talin 2014年9月14日 下午9:56:27
 */
public class Searcher {

	public static void main(String[] args) {
		String indexPath = "D:\\opt\\test\\lucene\\index_data";
		IndexReader reader;
		try {
			String field = "path";
			String q = "path:opt";
			
			reader = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
			QueryParser parser = new QueryParser(Version.LUCENE_47, field, analyzer);
			Query query = parser.parse(q);
			
			TopDocs results = searcher.search(query, null, 100);
			
			ScoreDoc[] hits = results.scoreDocs;
			int numTotalHits = results.totalHits;
		    System.out.println(numTotalHits + " total matching documents");
		    
		    Document doc = searcher.doc(hits[0].doc);
		    String contents = doc.get("contents");
		    
		    System.out.println(contents);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
