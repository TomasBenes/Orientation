package programmerfoxclub.demo.service;

import org.springframework.stereotype.Service;
import programmerfoxclub.demo.Model.Fox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoxService {

    private List<Fox> listOfFoxes;

    public FoxService () {
        this.listOfFoxes = new ArrayList<>();
    }

    public Fox getFoxByName (String name) {
        return this.listOfFoxes.stream().filter(fox -> fox.getName().equals(name)).findFirst().get();
    }

    public void addFox (Fox fox) {
        this.listOfFoxes.add(fox);
    }

    public List<Fox> getListOfFoxes() {
        return listOfFoxes;
    }

    public void setListOfFoxes(List<Fox> listOfFoxes) {
        this.listOfFoxes = listOfFoxes;
    }

}
