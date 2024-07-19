package com.kishore_b.JDBC_SPRING_quick;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kishoreb.dao.Dao_imp;
import com.kishoreb.javaconfig.Config;
import com.kishoreb.pojo.Flames;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	//Dao_imp imps=new Dao_imp();

    	//ApplicationContext cont=new ClassPathXmlApplicationContext("beans.xml");
    	ApplicationContext cont=new AnnotationConfigApplicationContext(Config.class);
    //	Dao_imp in=cont.getBean("dao_s", Dao_imp.class);
    	Dao_imp in=cont.getBean("dao_s", Dao_imp.class);
    	//Flames fl=new Flames();
    	//fl.setRo(2);
    	//fl.setResult("Friends");
    	//fl.setCrushname("Yalini");
    	//fl.setYourname("Peter");
    	//in.insert(fl);
    	//in.delete(1);
    /*	List<Flames>fla=in.getAll();
    	for(Flames fls:fla) {
    		System.out.println("Your_Name:"+fls.getYourname());
    		System.out.println("Crush_Name:"+fls.getCrushname());
    		System.out.println("Result:"+fls.getResult());
    		
    	}*/
    	//ResultSetExtreacter
    	List<Flames>fla=in.getAll_ResultSet();
    	System.out.println(fla);
    	for(Flames fls:fla) {
    		System.out.println("Your_Name:"+fls.getYourname());
    		System.out.println("Crush_Name:"+fls.getCrushname());
    		System.out.println("Result:"+fls.getResult());
    		
    	}
    	System.out.println("****************************************");
    	
    	Flames ff=in.getSingleRow(5);
    	System.out.println("Specific Values:");
    	System.out.println(ff.getYourname());
    	System.out.println(ff.getCrushname());
    	System.out.println(ff.getResult());
    	
    	Flames f1=new Flames();
    	f1.setRo(2);
    	f1.setYourname("Yogan");
    	Flames f2=new Flames();
    	f2.setRo(3);
    	f2.setYourname("Ranbir kappor");
    	List<Flames>li=new ArrayList<>();
    	li.add(f1);
    	li.add(f2);
    	in.updateList(li);
    }
}
