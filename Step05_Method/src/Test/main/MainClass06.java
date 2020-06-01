package Test.main;
import Test.mypac.*;
public class MainClass06 {

	public static void main(String[] args) {
		Messenger.sendMessage("반갑다 친구야");
		System.out.println(Messenger.getMessage());
		Messenger.useCar(new Car());
		}
}
