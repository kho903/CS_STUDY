package designpattern.behavioral.memento;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100); // 처음의 돈은 100
		Memento memento = gamer.createMemento(); // 처음의 상태를 보존해둔다.
		ArrayList<Memento> history = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			System.out.println("==== " + i); // 횟수를 표시
			System.out.println("현 상태 : " + gamer); // 현재의 주인공의 상태 표시

			gamer.bet(); // 게임을 진행 시킨다.

			System.out.println("돈은 " + gamer.getMoney() + "원이 되었습니다.");

			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println(" (돈이 많이 증가했으니 저장하자) ");
				memento = gamer.createMemento();
				history.add(memento);
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println(" (돈이 많이 줄었으니 복원하자) ");
				gamer.restoreMemento(memento);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
