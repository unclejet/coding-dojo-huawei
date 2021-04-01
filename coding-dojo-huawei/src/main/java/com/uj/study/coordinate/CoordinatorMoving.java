package com.uj.study.coordinate;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/30 下午12:00
 * @description：
 */
public class CoordinatorMoving {
    private int x, y;

    public void calculate(List<String> coordinates) {
        x = y = 0;
        for (String coor :
                coordinates) {
            Coordinator coordinator = createCoordinator(coor);
            moveBy(coordinator);
        }
    }

    private void moveBy(Coordinator coordinator) {
        switch (coordinator.getDirection()) {
            case 'A':
                x -= coordinator.getDistance();
                break;
            case 'D':
                x += coordinator.getDistance();
                break;
            case 'W':
                y += coordinator.getDistance();
                break;
            case 'S':
                y -= coordinator.getDistance();
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Coordinator createCoordinator(String coor) {
        char direction = coor.charAt(0);
        int distance = Integer.parseInt(coor.substring(1, 3));
        return new Coordinator(direction, distance);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
