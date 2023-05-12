import java.util.*;
import java.io.*;

public class JavaIO {
  
  public void writeDataToFile() throws FileNotFoundException{
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(new File("dataFile"));
    int number;
    while(sc.hasNextInt()) {
      number = sc.nextInt();
      pw.println(number);
    }
    sc.close();
    pw.close();
  }
  
  
  public void readDataFromFile() throws FileNotFoundException{
    Scanner sc = new Scanner(new File("dataFile"));
    int number;
    while(sc.hasNextInt()) {
      number = sc.nextInt();
      System.out.println(number);
    }
    sc.close();
  }
  
  
  public void writeObjectsToFile () throws IOException{
    Computer c1, c2, c3;
    c1 = new Computer("DELL","PII",200,100);
    c2 = new Computer("HP","PIII",300,150);
    c3 = new Computer("IBM","PVI",400,500);
    ArrayList<Computer> al = new ArrayList<Computer>();
    al.add(c1);
    al.add(c2);
    al.add(c3);
    ObjectOutputStream ow = new  ObjectOutputStream(new FileOutputStream("objectFile"));
    ow.writeObject(al);
    ow.close();
    
  }
  
  public void readObjectsFromFile () throws IOException, ClassNotFoundException{
    ObjectInputStream or = new  ObjectInputStream(new FileInputStream("objectFile"));
    ArrayList<Computer> al =(ArrayList<Computer>) or.readObject();
    System.out.println("***"+al.get(0));
    System.out.println("***"+al.get(1));
    System.out.println("***"+al.get(2));
    or.close();
    
  }
  public static void main(String [] args){
    JavaIO jio = new JavaIO();
    try{
      jio.writeDataToFile();
      jio.readDataFromFile();
      jio.writeObjectsToFile();
      jio.readObjectsFromFile();
    }
 
    catch(IOException ioe){
      System.out.println("Can't IO:" + ioe);
    }
    catch(ClassNotFoundException cnfe){
      System.out.println("Class not found:" + cnfe);
    }
    
  }
}
