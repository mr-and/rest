package restApp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import testproject.restApp.config.WebConfig;
import testproject.restApp.model.Docs;
import testproject.restApp.service.DocsService;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
public class TestDoc {

    @Autowired
    DocsService docsService;

    @Test
    public void test_getAllDocs() {
        List<Docs> docsList = docsService.allDocs();
        assertNotNull(docsList);
    }


    @Test
    public void test_addDocs() {
        int expected = docsService.allDocs().size();
        Docs d1 = new Docs();
        docsService.add(d1);
        int actuals = docsService.allDocs().size();
        Assert.assertNotEquals(expected, actuals);

    }

    @Test
    public void test_delDocs() {
        List<Docs> docsList = docsService.allDocs();
        int expected = docsService.allDocs().size()-1;
        Docs d1 = docsList.get(expected);
        docsService.delDoc(d1);
        int actuals = docsService.allDocs().size();
        Assert.assertEquals(expected, actuals);

    }
}
