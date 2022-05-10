package designpattern.behavioral.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Gamer {
	private int money;    // 소유한 돈
	private ArrayList<String> fruits = new ArrayList<>(); // 과일
	private Random random = new Random(); // 난수 생성기
	private static String[] fruitsName = { // 과일 이름의 표
		"사과", "포도", "바나나", "귤"
	};

	public Gamer(int money) { // 생성자
		this.money = money;
	}

	public int getMoney() { // 현재의 돈을 얻는다.
		return money;
	}

	public void bet() {    // 졌다.. 게임의 진행
		int dice = random.nextInt(6) + 1; // 주사위를 던진다.
		if (dice == 1) { // 1이 나온다. 돈이 증가한다.
			money += 100;
			System.out.println("돈이 증가했습니다.");
		} else if (dice == 2) { // 2가 나온다.. 돈이 반으로 준다.
			money /= 2;
			System.out.println("돈이 반으로 줄었습니다.");
		} else if (dice == 6) { // 6이 나온다.. 과일을 받는다.
			String f = getFruit();
			System.out.println("과일(" + f + ")을 받았습니다.");
			fruits.add(f);
		} else { // 그 밖의 아무일도 일어나지 않는다.
			System.out.println("아무 일도 일어나지 않았습니다.");
		}
	}

	private String getFruit() { // 과일을 1개 얻는다.
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "good~ ";
		}
		return prefix + fruitsName[random.nextInt(fruitsName.length)];
	}

	public Memento createMemento() { // 스냅샷을 찍는다.
		Memento memento = new Memento(money);
		Iterator<String> fruit = fruits.iterator();
		while (fruit.hasNext()) {
			String name = fruit.next();
			if (name.startsWith("good~ "))
				memento.addFruit(name);
		}
		return memento;
	}

	public void restoreMemento(Memento memento) { // undo
		this.money = memento.money;
		this.fruits = memento.fruits;
	}

	@Override
	public String toString() {
		return "Gamer{" +
			"money=" + money +
			", fruits=" + fruits +
			'}';
	}

}
