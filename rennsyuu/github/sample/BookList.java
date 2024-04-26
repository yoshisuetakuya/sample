package sample;

import java.util.ArrayList;

/**
 * 本棚クラス
 * @author 芳末拓也
 *
 */
public class BookList {


	private ArrayList<Book> list = new ArrayList<>(); // 本の情報を格納しているフィールド

	/**
	 * 本を追加するメソッド
	 * @param book 追加する本
	 */
	public void bookAdd(Book book) {
		list.add(book); // 本を追加
	}

	/**
	 *  本棚の情報を全部出力するメソッド
	 */
	public void print() {
		for (int i = 0; i < list.size(); i++){
			list.get(i).show();

		}
	}

	/**
	 *  本棚の中に渡したタイトルと合致するものがあったらtrueを返すメソッド
	 * @param title 検索したい本のタイトル(全て書く)
	 * @return　boolean
	 */
	public boolean fullMatch(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).title.equals(title)) {
				System.out.println("条件に合致するタイトルはありました。");
				return  true;
			}
		}
		System.out.println("条件に合致するタイトルはありませんでした。");
		return false;
	}

	/**
	 *  検索した文字に部分一致したものがあったらtrueを返す検索メソッド
	 * @param title 検索したい本のタイトル(部分で利用可)
	 * @return　boolean
	 */
	public boolean searchPart (String title) {
		if (title.equals("")) {
			System.out.println("文字を入力してください。");
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).title.contains(title)) {
				System.out.println("条件に合致するタイトルはありました。");
				return true;
			}
		}
		System.out.println("条件に合致するタイトルはありませんでした。");
		return false;

	}
	/**
	 * 検索メソッド  渡した文字に該当するタイトルがあったら該当するものをリストで返すメソッド
	 * @param searchTitle 検索する本のタイトル
	 * @return 該当する本のリスト
	 */
	public ArrayList<Book> search (String searchTitle) {
		// 空文字をはじく分岐
		if (searchTitle.equals("")) {
			System.out.println("文字を入力してください。");
			return null;
		}
		ArrayList<Book> titleBox = new ArrayList<>(); // 本を一度取り出す箱を用意する
		// 本を本棚から一冊ずつ取り出してtitleBoxに入れて条件に合致するもので分ける
		for (int i = 0; i < list.size(); i++) {
				if(list.get(i).title.contains(searchTitle)) {
					titleBox.add(list.get(i));
				}
		}

		return titleBox;

	}

}