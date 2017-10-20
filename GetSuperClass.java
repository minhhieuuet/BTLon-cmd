
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author MINH HIEU
 */
public class GetSuperClass {
    public  String getSuperClass(String folderurl,String classname)
    {
        //Duong dan vao day
          
          File file = new File(folderurl);

try {
    // Convert File to a URL
    URL url = file.toURI().toURL();          
    URL[] urls = new URL[]{url};

    // Create a new class loader with the directory
    ClassLoader cl = new URLClassLoader(urls);

    //Truyen ten class vao day
    Class c = cl.loadClass(classname);
    return c.getSuperclass().getSimpleName();
     
    
    
} catch (MalformedURLException e) {
} catch (ClassNotFoundException e) {
}
        //Class c = DumpMethods.class;
         return null;
        
    }
    
   
}
