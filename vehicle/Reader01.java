package vehicle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader01 {
	public static List<String> readTxtFile(String filePath) {
		List<String> list = new ArrayList<String>();
		try {
			String encoding = "UTF-8";
			File file = new File("src/vehicle/graph.txt");
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("#")) {
						// System.out.print(lineTxt);
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
	 * 
	 * @param list
	 * @return
	 */
	public static int[][] createArray(String filePath) {
		List<String> list = readTxtFile(filePath);
		int array[][] = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			array[i] = new int[12];
			String linetxt = list.get(i);
			String[] myArray = linetxt.replaceAll("\\s+", "@").split("@");
			for (int j = 0; j < myArray.length; j++) {
				// if(j<3){
				array[i][j] = Integer.parseInt(myArray[j].split(",")[0]);
				// }
			}
		}
		return array;
	}

	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public static void printArray(Number array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (j != array[i].length - 1) {
					System.out.print("array[" + i + "][" + j + "]=" + array[i][j] + ",");
				} else {
					System.out.print("array[" + i + "][" + j + "]=" + array[i][j]);
				}

			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		
		
		//printArray(array);
		

	}

	
	public static int calRoute(String r, int[][] array) {
		if (r.length() == 0)
			return 0;
		int sum = 0;
		for (int i = 0; i < r.length() - 1; i++) {
			sum += array[r.charAt(i) - 'A'][r.charAt(i + 1) - 'A'];
		}
		return sum;
	}

	

}


