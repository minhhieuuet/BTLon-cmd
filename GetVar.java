/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class GetVar {
     public String[] getVar(String folderurl,String classname)
    {
        //Truyen url file vao day
        
        //File file = new File("f:\\File\\");
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
   // Class c = cl.loadClass("Shape");
   
   Class c = cl.loadClass(classname);
   
    String[] result=new String[100];
        String arg="";
        try {
            
            Method[] m = c.getDeclaredMethods();
            Field[] f = c.getDeclaredFields();
            for (int i = 0; i < f.length; i++)
            {
	            if(!f[i].getGenericType().toString().contains("String"))
	                    {
	                        result[i]= "+"+f[i].getName()+":"+f[i].getGenericType();
	                    }
	                    else
	                    {
	                        result[i]= "+"+f[i].getName()+":"+"String";
	                    }
            
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
