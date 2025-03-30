public class OOPS {
    public static void main(String args[]){
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

    }
}

class Pen {
    private String color;
    private int tip;

    public void setColor(String Color) {
        this.color = Color;
    }

    public void setTip(int tipSize) {
        this.tip = tipSize;
    }

    public String getColor() {
        return color;
    }

    public int getTip() {
        return tip;
    }
}

