package testproject.restApp.launch;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.util.scan.StandardJarScanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String contextPath = "/";
        String webappDirLocation = "target/embeddedTomcatRestFile/";
        String baseDirectory = new File(webappDirLocation).getAbsolutePath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);
        ((StandardJarScanner) context.getJarScanner()).setScanAllDirectories(true);

        // Additions to make @WebServlet work
        String buildPath = "target/classes";
        String webAppMount = "/WEB-INF/classes";

        File additionalWebInfClasses = new File(buildPath);
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
        context.setResources(resources);
        // End of additions

        tomcat.start();
        tomcat.getServer().await();
    }

}
