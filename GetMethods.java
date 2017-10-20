
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Parameter;
/**
 *
 * @author MINH HIEU
 */
public class GetMethods {
    
   
   
    public static String[] getMethods(String folderurl,String classname)
    {
        //Duong dan vao day
          
          File file = new File(folderurl);

try {
    // Convert File to a URL
    URL url = file.toURI().toURL();          // file:/c:/myclasses/
    URL[] urls = new URL[]{url};

    // Create a new class loader with the directory
    ClassLoader cl = new URLClassLoader(urls);

    // Load in the class; MyClass.class should be located in
    // the directory file:/c:/myclasses/com/mycompany
    //Truyen ten class vao day
    //Class c = cl.loadClass("Shape");
    Class c = cl.loadClass(classname);
    String[] result=new String[100];
        String arg="";
        try {
            
            Method[] m = c.getDeclaredMethods();
            Field[] f = c.getDeclaredFields();
             String pa="";
            for (int i = 0; i < m.length; i++)
            {
		           String[] var=m[i].toString().split("\\("); //Phan tach bang ky tu (
		            for (Parameter p : m[i].getParameters()) {
		           
		            if(!p.getParameterizedType().toString().contains("String"))
		            {
		                pa=pa+p.getName()+":"+p.getParameterizedType()+",";
		            }
		            else
		            {
		                pa=pa+p.getName()+":"+"String"+" ";
		            }
		            }
		            //result[i]= "-"+m[i].getName()+"("+var[1].replaceAll("\\)"," ").trim().replaceAll("java.lang.String", "String")+")";
		            result[i]= "-"+m[i].getName()+"("+pa.trim()+")";
            
            }
            
        } catch (Throwable e) {
            System.out.println(e);
        }
        return result;
    
    
} catch (MalformedURLException e) {
} catch (ClassNotFoundException e) {
}
        //Class c = DumpMethods.class;
         return null;
        
    }
    
   
}