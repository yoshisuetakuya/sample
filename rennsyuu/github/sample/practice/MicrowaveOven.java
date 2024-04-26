package practice;

import java.util.ArrayList;

/**
 *
 * @author 芳末拓也
 *
 */
public class MicrowaveOven {

	private ArrayList<Food> list = new ArrayList<>(); // 電子レンジの中の情報

	//フィールド
	String modelNumber;
	String color;
	int price;

	//コンストラクター
	public MicrowaveOven(String modelNumber, String color, int price) {
		this.modelNumber = modelNumber;
		this.color = color;
		this.price = price;
	}

	/**
	 * 温めるメソッド
	 */
	public void heat(Food food) {
		System.out.println(food.foodName + "をを温めました。");
	}

	/**
	 * 解凍するメソッド
	 */
	public void thaw (Food food) {
		System.out.println(food.foodName + "を解凍しました");
	}

	/**
	 * 食べ物をレンジに入れるメソッド
	 * @param food 食べ物
	 */
	public void putIn(Food food) {
		list.add(food);
		System.out.println(list.get(0).foodName + "を電子レンジに入れました。");

	}

	/**
	 * 全部の食べ物をレンジから取り出すメソッド
	 * @param food 食べ物
	 */
	public void putOut(Food food) {
		list.clear();
		System.out.println("全ての食べ物を電子レンジから取り出しました。");

	}

	/**
	 * 冷凍食品だったら解凍しチルド食品はは温める処理をするメソッド
	 * @param food
	 */
	public void automaticExecut(Food food) {
		if (food.frozen == true) {
			System.out.println(food.foodName + "を解凍します。");
		}else if(food.frozen == false){
			System.out.println(food.foodName + "を温めます。");
		}
	}


}
