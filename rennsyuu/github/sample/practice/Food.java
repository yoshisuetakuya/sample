package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 食べ物クラス
 * @author 芳末拓也
 *
 */
public class Food {
	//フィールド
	String foodName;
	boolean frozen;

	//コンストラクター
	public Food (String foodName, boolean frozen) {
		this.foodName = foodName;
		this.frozen =  frozen;
	}

	/**
	 * 中身を見るメソッド
	 */
	public void show() {
		System.out.println("食べ物の名前：" + this.foodName + ", 冷凍食品:" + this.frozen );
	}

	/**
	 * 加熱した食べ物のデータをローカルファイルに保存するメソッド
	 */
	public void save() {
		try {
			PrintWriter pw = new PrintWriter("C:\\Users\\cyber\\Documents\\rennsyuu\\" + foodName + ".dat");
			pw.println("foodName =" + foodName);
			pw.println("frozen =" + frozen);
			pw.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
	 * @param foodName 食べ物の名前
	 * @return 加熱した食べ物の情報が書いてあるファイルの中身
	 */
	public static Food load (String foodName) {
		String str = "";

		String name = "";
		boolean bool = false;

		try (BufferedReader bw = Files.newBufferedReader(Paths.get("C:\\Users\\cyber\\Documents\\rennsyuu\\" + foodName + ".dat"))) {
		    while ((str = bw.readLine()) != null) {
		    	String[] pair = str.split("=");
		    	if("foodName".equals(pair[0].trim())) {
		    		name = pair[1];
		    	}else if ("frozen".equals(pair[0].trim())) {
		    		bool = Boolean.parseBoolean(pair[1]);
		    	} else {
					throw new RuntimeException("ファイル内容が不正です。キー＝"+pair[0].trim());
		    	}
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}

		if(name == "") {
			throw new RuntimeException("ファイル内容が不正です。");
		}

		return new Food(
				name,
				bool);
	}



}
