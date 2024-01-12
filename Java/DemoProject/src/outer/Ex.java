package outer;

import com.example.Calc;

public class Ex {
public static void main(String[] args) {
    Calc c=new Calc();
    Calc.add(22,33);
    c.sub(33,5);
    System.out.println(c.mul(44, 7));
}
}