/**
 * by wyz on 2019/2/14/014.
 */

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-14 08:30
 **/

public class TestSlrj {

    @Test
    public void test() throws IOException, SolrServerException {
        HttpSolrClient.Builder builder = new HttpSolrClient.Builder("http://192.168.30.130:8080/solr/new_core");
        HttpSolrClient build = builder.build();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setStart(20);
        query.setRows(20);
        QueryResponse response = build.query(query);
        SolrDocumentList solrDocuments = response.getResults();
        System.out.println(solrDocuments.getNumFound());
        for (SolrDocument solrDocument:
             solrDocuments) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_title"));
        }
    }
}
