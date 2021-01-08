package listener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Person;

@WebListener
public class Listener implements ServletContextListener {

    public Listener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce) {
    	ServletContext application=sce.getServletContext();
		String path=application.getRealPath("/WEB-INF/data/new_Sample.csv");
		List<Person> list=new ArrayList<>();
		BufferedReader br=null;
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			br=new BufferedReader(isr);
			String line;
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				Person p=new Person(data[0],data[1],data[2],data[3]);
				list.add(p);
			}

		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		application.setAttribute("list", list);
	}
}

