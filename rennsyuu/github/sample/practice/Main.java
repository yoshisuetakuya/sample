package practice;
/**
 * 実行クラス
 * @author 芳末拓也
 *
 */
public class Main {
	public static void main(String[] args) {
		MicrowaveOven microwaveOven = new MicrowaveOven("ABC-1", "白", 3000);
		Food food1 = new Food("おにぎり", false);
		Food food2 = new Food("唐揚げ", true);
		microwaveOven.heat(food1);
		microwaveOven.thaw(food2);
//		System.out.println(food.foodName);
//		System.out.println(food.frozen);
		food1.show();
		food2.show();
		microwaveOven.putIn(food2);
		microwaveOven.putOut();
		microwaveOven.automaticExecut(food1);
		microwaveOven.automaticExecut(food2);
		food1.save();
		food2.save();
		Food file1 =  Food.load("おにぎり");
		file1.show();
		Food file2 =  Food.load("唐揚げ");
		file2.show();

	}

}
