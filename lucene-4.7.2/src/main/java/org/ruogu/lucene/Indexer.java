package org.ruogu.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Indexer
 * 
 * @author Talin 2014年8月26日 下午11:03:04
 */
public class Indexer {

	public static void main(String[] args) {
		String indexPath = "D:\\opt\\test\\lucene\\index_data";
		try {
			Directory dir = FSDirectory.open(new File(indexPath));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_47, analyzer);
			iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
			IndexWriter writer = new IndexWriter(dir, iwc);

			indexDocs(writer);

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void indexDocs(IndexWriter writer) throws IOException {
		Document doc = new Document();

		Field pathField = new StringField("path", "opt", Field.Store.YES);
		doc.add(pathField);

		doc.add(new LongField("modified", 123L, Field.Store.NO));

		doc.add(new TextField("contents", "content is easy.", Field.Store.YES));

		if (writer.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
			writer.addDocument(doc);
			System.out.println("added");
		} else {
			
			writer.updateDocument(new Term("path", "opt"), doc);
			System.out.println("updated");
		}
	}

}
