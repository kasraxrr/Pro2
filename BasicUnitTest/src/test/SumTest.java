package test;

import main.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    void sum12(){
        Sum sum=new Sum();
        assertEquals(4,sum.add(2,2));
    }

    @Test
    void A(){
        Sum sum=new Sum();
        assertEquals('A',sum.grade(100));
    }

    @Test
    void B(){
        Sum sum=new Sum();
        assertEquals('B',sum.grade(90));
    }

    @Test
    void C(){
        Sum sum=new Sum();
        assertEquals('C',sum.grade(80));
    }

    @Test
    void D(){
        Sum sum=new Sum();
        assertEquals('D',sum.grade(70));
    }

    @Test
    void pass(){
        Sum sum=new Sum();
        assertTrue(sum.pass(60));
    }

}