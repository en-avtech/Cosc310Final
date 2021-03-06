import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;


public class TestClass 
{

	public static void main(String[] args) 
	{
	    URL url = null;
		try 
		{
			url = new URL("https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blog");
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
	    java.net.URLConnection connection = null;
	    
		try 
		{
			connection = url.openConnection();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	    ByteArrayOutputStream content = new ByteArrayOutputStream();

	    InputStream is = null;
	    
		try 
		{
			is = connection.getInputStream();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	    
		int len = 0;
	    byte[] buffer = new byte[1024];
	    
	    try 
	    {
			while ((len = is.read(buffer)) >= 0)
			{
			    content.write(buffer, 0, len);
			}
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    
	    byte[] finalContent = content.toByteArray();
	    String str = null;
	    
		try 
		{
			str = new String(finalContent, "UTF8");
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	    System.out.print(str);
	}

}
