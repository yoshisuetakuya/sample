package sample;

//import java.util.ArrayList;
import java.util.List;

public class Main {
	// 実行
		public static void main (String arg[]) {
			Book book1 = new Book ("容疑者Xの献身", "東野圭吾", 1000); //	本を生成
			Book book2 = new Book ("源氏物語1", "紫式部", 2000); //	本を生成
			BookList bookList = new BookList(); // 本棚を生成
//	        book1.show();
			bookList.bookAdd(book1); //本を追加
			bookList.bookAdd(book2); //本を追加
//			bookList.print();  //本棚を見る
//			bookList.fullMatch("源氏物語"); // 検索条件に完全一致
//			bookList.searchPart(""); //	検索条件に部分一致
			List<Book> titleBox = bookList.search(""); //検索条件に当てはまったものすべて出力
			for (int i = 0; i < titleBox.size(); i++) {
				titleBox.get(i).show();
			}
//			book1.save();
//			book2.save();
//			Book file = Book.load("源氏物語1");
//			file.show();






		}

}
