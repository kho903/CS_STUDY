# Memento
## 1. Memento Pattern 이란?
- 내부 상태를 객체화하여, 나중에 객체가 이 상태로 복구 가능하게 함
- 인스턴스의 상태를 보존해 주었다가 보존해 둔 정보를 가지고 인스턴스를 원래 상태로 복원
- 인스턴스를 복원하기 위해서는 내부 정보에 자유롭게 접근 가능해야 함
- 캡슐화가 파괴가 일어나지 않도록 주의해야 함

## 2. 의도 (Intent)와 동기 (Motivation)
- 이전의 상태로 되돌리는 undo
- 했던 작업을 다시 하는 redo
- 기억해야 하는 순간을 저장하는 객체
- 오류를 복구하거나 수행 결과를 취소하기 위한 작업에 사용

## 3. 객체 협력 (collaborations)
- Memento : Originator 객체의 내부 상태를 필요한 만큼 저장한다. Originator 만이
Memento 에 접근할 수 있다.
- Originator : Memento 를 생성하여 현재 객체의 상태를 저장하고 내부 상태를 복구
- CareTaker (undo mechanism) : Memento 의 보관을 책임지기는 하지만, memento의
내부를 확인할 수 없음

## 4. 중요한 결론 (consequence)
- 복잡한 Originator 클래스의 내부 상태를 다른 객체로 분리함으로써 상태에 대한 캡슐화를
보장할 수 있다.
- 복구에 필요한 (클라이언트가 요구하는) 상태만 따로 관리함으로써, Originator 내부에서
저장하지 않고 Originator 가 단순해질 수 있다.
- Memento 의 사용에 오버헤드가 발생할 수 있다.

## 5. 예제
Main.java
```java
public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // 처음의 돈은 100
        Memento memento = gamer.createMemento();    // 처음의 상태를 보존해 둔다.
        ArrayList<Memento> history = new ArrayList<Memento>();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // 횟수 표시
            System.out.println("현 상태:" + gamer);    // 현재의 주인공의 상태 표시

            gamer.bet();    // 게임을 진행 시킨다.

            System.out.println("돈은" + gamer.getMoney() + "원이 되었습니다.");

            // Memento의 취급 결정
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    (많이 증가했으니 현재의 상태를 보존해두자)");
                memento = gamer.createMemento();
                history.add(memento);
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (많이 줄었으니 이전의 상태로 복귀하자)");
                gamer.restoreMemento(memento);
                
            }

            // 시간을 기다림
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }
}

```
Gamer.java
```java
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

```
Memento.java
```java
public class Memento {
	int money; // 돈
	ArrayList<String> fruits; // 과일

	public int getMoney() { // 돈을 얻는다. (narrow interface)
		return money;
	}

	public Memento(int money) { // 생성자 (wide interface)
		this.money = money;
		this.fruits = new ArrayList<>();
	}

	void addFruit(String fruit) { // 과일을 추가한다. (wide interface)
		fruits.add(fruit);
	}
}

```
