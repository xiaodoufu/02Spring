package com.xdf;

import static org.junit.Assert.assertTrue;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AppTest {
    /**
     * 创建索引
     * 01.文件名称
     * 02.文件路径
     * 03.文件内容
     *  根据用户输入的文件内容 查询到文件名称和文件路径
     */
    @Test
    public  void  createIndex(){
        IndexWriter writer=null;
        try {
            //1.创建Directory对象   索引即将存在的位置
            //Directory directory=new RAMDirectory();  内存
            Directory directory= FSDirectory.open(new File("E:\\LuceneIndex"));
            //2.创建IndexWriter对象 写入索引
            IndexWriterConfig  config=new IndexWriterConfig(Version.LUCENE_35,new StandardAnalyzer(Version.LUCENE_35));
            writer=new IndexWriter(directory,config);
            //3.创建Document对象  文件
            File  file=new File("E:\\Lucene"); //文件夹
            for (File f:file.listFiles()) {  //遍历文件夹下所有的文件
                Document document=new Document();
                //4.创建Field字段添加到Document对象中
                document.add(new Field("fileName",f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                document.add(new Field("filePath",f.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
                document.add(new Field("fileContent",new FileReader(f)));
                writer.addDocument(document); // 写入索引
            }
            //5.释放资源
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (writer!=null) try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 搜索索引
     */
    @Test
    public  void searcherIndex(){
        IndexReader reader=null;
        try {
            //1.创建Directory对象   索引即将存在的位置
            Directory directory= FSDirectory.open(new File("E:\\LuceneIndex"));
            //2.创建IndexReader对象
            reader=IndexReader.open(directory);
            //3.创建IndexSearcher对象
            IndexSearcher searcher=new IndexSearcher(reader);
            QueryParser  parser=new QueryParser(Version.LUCENE_35,"fileContent",new StandardAnalyzer(Version.LUCENE_35));
            Query query = parser.parse("haha");
            TopDocs topDocs = searcher.search(query, 5);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for(ScoreDoc score:scoreDocs){
                Document document = searcher.doc(score.doc);
                System.out.println("文件名称==》"+document.get("fileName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader!=null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
