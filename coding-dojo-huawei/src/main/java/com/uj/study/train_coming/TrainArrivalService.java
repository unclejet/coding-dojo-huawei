package com.uj.study.train_coming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrainArrivalService {
    public List<String> getTrainArrivals(int[] trains) {
        List<String> result = new ArrayList<>();
        generateArrivals(trains, new Stack<>(), new ArrayList<>(), result);
        return result;
    }

    private void generateArrivals(int[] trains, Stack<Integer> station, List<Integer> out, List<String> result) {
        if (trains.length == 0 && station.isEmpty()) {
            result.add(StringConverter.convert(out.toString()));
            return;
        }

        // 进站
        if (trains.length > 0) {
            int[] remainingTrains = new int[trains.length - 1];
            System.arraycopy(trains, 1, remainingTrains, 0, remainingTrains.length);
            station.push(trains[0]);
            generateArrivals(remainingTrains, station, out, result);
            station.pop();
        }

        // 出站
        if (!station.isEmpty()) {
            int train = station.pop();
            out.add(train);
            generateArrivals(trains, station, out, result);
            out.remove(out.size() - 1);
            station.push(train);
        }
    }
} 