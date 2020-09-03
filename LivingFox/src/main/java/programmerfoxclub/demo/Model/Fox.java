package programmerfoxclub.demo.Model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Fox {
    private String name;
    private String food;
    private String drink;
    private List<String> tricks;
    private List<String> actionHistory;

    public Fox(String name, String food, String drink, List<String> tricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.tricks = tricks;
        this.actionHistory = new ArrayList<>();
    }

    public List<String> getActionHistory() {
        return actionHistory;
    }

    public List<String> get5LatestActions (){
        Collections.reverse(this.actionHistory);
        return this.actionHistory.stream().limit(5).collect(Collectors.toList());
    }

    public void setActionHistory(List<String> actionHistory) {
        this.actionHistory = actionHistory;
    }

    public void addAction (String action) {
        this.actionHistory.add(action);
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public void addTrick (String trick) {
        this.tricks.add(trick);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
