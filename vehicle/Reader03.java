package vehicle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader03 {
	  
	public static  List<String>  readTxtFile(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File("src/vehicle/inventory.csv");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!lineTxt.startsWith("#") && lineTxt.length() > 0) {
//                    		System.out.print(lineTxt);
                    		list.add(lineTxt);
                    }
                        
                 
                }
                read.close();
            } else {
                System.out.println("找不到文件");
            }
        } catch (Exception e) {
            System.out.println("出错了");
            e.printStackTrace();
        }
        return list;
  
    }
      
    /**
     * 创建二维数组
     * @param list
     * @return
     */
    public static String[][] createArray(String filePath){
        List<String> list = readTxtFile(filePath);
        String array[][] = new String [list.size()][];
        for(int i=0;i<list.size();i++){
            array[i] = new String[9];
            String linetxt=list.get(i);
            String[] myArray = linetxt.replaceAll(",", "@").split("@");
            for(int j=0;j<myArray.length;j++){
//                if(j<3){
                    array[i][j]= (myArray[j].split(",")[0]);
//                }
            }
        }
        return array;
    }
      
    /**
     * 打印数组
     * @param array
     */
    public static void printArray(String array[][]){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(j!=array[i].length-1){
                    System.out.print("array["+i+"]["+j+"]="+array[i][j]+",");
                }
                else{
                    System.out.print("array["+i+"]["+j+"]="+array[i][j]);
                }
                  
            }
            System.out.println();
        }
    }
  
  
    public static void main(String args[]) {
    	//String arrayRoute[][] = createArray("vehicle/routes.txt");
       // printArray(arrayRoute);
        

    }
    static int[][] arrayGraph = Reader01.createArray("src/vehicle/graph.txt");
    public static String chooseRoute(String str, String[][] array) {
        int j=0;
        	for (int i = 0; i<=array.length ; i++) {
        		 if((str.charAt(0) == array[i][0].charAt(0)&&str.charAt(1) == array[i][0].charAt(2))||(str.charAt(0) == array[i][0].charAt(2)&&str.charAt(1) == array[i][0].charAt(0))) {
        			 j = i ;
        			 break;
        		 }
        	}
        	    
        		 if(Reader01.calRoute(array[j][1], arrayGraph)<Reader01.calRoute(array[j][2], arrayGraph)) {
        			 return array[j][1];
        		 }
        		 else return array[j][2];
        	}
   	  
    

	 
   
   
	
}
