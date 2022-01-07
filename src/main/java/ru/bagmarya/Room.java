package ru.bagmarya;


import java.util.List;


public class Room {
    public Integer x;
    public Integer y;
    public Integer size;

    Room(Integer size){
        this.size = (size % 2 == 0) ? ++size : size;
        this.x = (this.size + 3) / 2;
        this.y = (this.size + 3) / 2;
    }

    public Integer getSize(){
        return this.size;
    }

    public List<Integer> getCoordinates(){
        assert x != null;
        assert y != null;
        return List.of(x - 1, y - 1);
    }

    public boolean isOnTheBorder(){
        return this.x == 1 || this.y == 1 || x == this.size + 2 || y == this.size + 2;
    }

    public void moveTheFly(App.Step direction){
        switch(direction) {
            case UP:
                this.y++;
                break;
            case DOWN:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
        }

    }

    public boolean checkGameOver(Integer action){
        if (this.isOnTheBorder() && action == 2){
            System.out.print("Муха повержена!!! Вы победили.");
            return true;
        }
        if (this.isOnTheBorder() && action == 1){
            System.out.print("Муха улетела!!! Вы проиграли.");
            return true;
        }
        if (!this.isOnTheBorder() && action == 2){
            System.out.print("Стекло разбито, муха улетела!!! Вы проиграли.");
            return true;
        }
        return false;
    }



}
