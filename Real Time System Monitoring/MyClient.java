import java.io.*;  
import java.net.*;  
public class MyClient {  
	
	public static void main(String[] args) { 
			
		try{
			BufferedReader br,br1;
			Socket s=new Socket("localhost",6666);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the i/p file name");
			String f=br.readLine();
			br1=new BufferedReader(new FileReader(f));
			String st;
			System.out.println("Transfering file datas");
			while((st=br1.readLine())!=null)
			{
				System.out.println(st);
				dout.writeUTF(st);  
				dout.flush();
				//Thread.sleep(1500);
			}
			 dout.writeUTF("END");
			 dout.close();  
			 s.close();  
		}
		catch(Exception e){System.out.println(e);}  	
	}  
}  