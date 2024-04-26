package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 本クラス
 * @author 芳末拓也
 *
 */
public class Book {
	//フィールド
	String title;
	String author;
	int price;

	//コンストラクター
	public Book (String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}


	/**
	 * 本の情報を見るメソッド
	 */
	public void show() {
		System.out.println("タイトル：" + this.title + ", 著者:" + this.author + ", 価格:" +this.price );
	}


	/**
	 * 本の情報をローカルファイルに保存するメソッド
	 * @param book 保存する本のオブジェクト
	 */
	public void save() {
		try {
            PrintWriter pw = new PrintWriter("C:\\Users\\cyber\\Documents\\rennsyuu\\" + title + ".dat");
            pw.println("title =" + title);
            pw.println("author =" + author);
            pw.println("price =" + price);
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

	}

	/**
	 * 本の情報を読み出すメソッド
	 * @param title 本のタイトル
	 * @return　本の情報が書いてあるファイルの中身
	 */
	public static Book load (String title) {
		String str = "";

		String bookTitle = "";
		String bookAuther = "";
		int bookPrice = 0;

		try (BufferedReader bw = Files.newBufferedReader(Paths.get("C:\\Users\\cyber\\Documents\\rennsyuu\\" + title + ".dat"))) {
		    while ((str = bw.readLine()) != null) {
		    	String[] pair = str.split("=");
		    	if("title".equals(pair[0].trim())) {
		    		bookTitle = pair[1];
		    	}else if ("author".equals(pair[0].trim())) {
		    		bookAuther = pair[1];
		    	}else if ("price".equals(pair[0].trim())) {
		    		bookPrice = Integer.parseInt(pair[1]);
		    	} else {
					throw new RuntimeException("ファイル内容が不正です。キー＝"+pair[0].trim());
		    	}
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}

		if(bookTitle == "" || bookAuther == "" || bookPrice == 0 ) {
			throw new RuntimeException("ファイル内容が不正です。");
		}

		return new Book(
				bookTitle,
				bookAuther,
				bookPrice);
	}



}
