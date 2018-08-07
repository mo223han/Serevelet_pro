import java.io.*;  
import java.net.*; 
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.ui.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import java.awt.*; 
import javax.swing.*;
public class MyServer extends ApplicationFrame {  
 
     static int [][]arr;
	 static int z=0,i=0,y=0;
     static int [][]arr1;
	 public  static ChartPanel chartPanel; 
	 public static JFreeChart chart;
 public MyServer(final String title) {
    super(title);
	
	y++;
	final XYSeries series = new XYSeries("Availbale Datas");
	final XYSeries series1 = new XYSeries("Remote Datas");
	

	for(int k=0;k<i;k++)
	{
		series.add(arr1[k][0],arr1[k][1]);
	}
	for(int k=0;k<z;k++)
	{
		series1.add(arr[k][0],arr[k][1]);
	}
    final XYSeriesCollection data = new XYSeriesCollection();
	data.addSeries(series);
	data.addSeries(series1);
     chart= ChartFactory.createScatterPlot("X-Y CO-ordinates","X","Y", data, PlotOrientation.VERTICAL,true,true,false);
   // chartPanel.setVisible(false);
   // jP=new JPanel();
	
    ChartFrame chartPanel=new ChartFrame("",chart);
	//chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
    final XYPlot plot = (XYPlot)chart.getPlot( );
	 /*XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
     renderer.setSeriesPaint( 0 , Color.GREEN );
	 renderer.setSeriesPaint( 1 , Color.BLUE );
	 plot.setRenderer( renderer );*/
	 plot.setBackgroundPaint(new Color(255,228,196));
	 //chartPanel.add(jf);
	 chartPanel.setVisible(true);
	 chartPanel.setSize(500,300);
	 chartPanel.setLocationRelativeTo(null);
	 try{
		if(y==z)
		chartPanel.setVisible(false);
	 }catch(Exception e){}
		

  }
	public static void main(String[] args)throws Exception{ 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the file name");
		String f=br.readLine();
		BufferedReader br1=new BufferedReader(new FileReader(f));
		String st;
		while((st=br1.readLine())!=null){
				i++; 	
		}
		BufferedReader br2=new BufferedReader(new FileReader(f));
		arr1=new int[i][2];
		int m=0,n=0;
		while((st=br2.readLine())!=null){
				String[] words=st.split(" ");
				int l=words.length;
				for(int h=0;h<l;h++)
				{
					arr1[m][n]=Integer.parseInt(words[h]);
					n++;
					if(n>1){
						n=0;
					m++;}
				}
		}
		System.out.println("Available Datas");
		for(int j=0;j<i;j++)
		{
			for(int k=0;k<2;k++)
				System.out.print(arr1[j][k]+"\t");
			System.out.println();
		}


		


	
	 
		 ServerSocket ss=new ServerSocket(6666);  
		 System.out.println("Server is waiting for dats of present in remote machine");
		 Socket s=ss.accept();  
		 System.out.println("Connection Establishd\nReceiveing Datas");
		 DataInputStream dis=new DataInputStream(s.getInputStream());  
		  String  str=" ";
		  arr=new int[100][2];
		  System.out.println("Remote Datas");
		 while(!str.equals("END")){
			 str=(String)dis.readUTF();
			  if(!str.equals("END")){
				String[] words=str.split(" ");
				for(int i=0;i<words.length;i++)
				{
					arr[z][i]=Integer.parseInt(words[i]);
					System.out.print(arr[z][i]+" ");
				}
				z++;
				 
				System.out.println();
				
			}
         }
		 final MyServer demo = new MyServer("Real Time Sys Display");
         		demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);
		 
		  ss.close(); 
	    
	
	
	//catch(Exception e){System.out.println(e);}  
	}  
}  