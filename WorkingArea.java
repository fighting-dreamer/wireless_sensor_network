/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author nipun
 */
import java.util.Random;
import java.util.Scanner;

class location extends Thread{
    int x;
    int y;
    int id;
    public void set(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public void write() {
        System.out.println(id + " " + x + " " + y);
    }
    
    @Override
    public void run() {
        System.out.println(id + " " + x + " " + y);
    }
}

public class WorkingArea {
    int n;
    location[] p;

    public WorkingArea(int n) {
        this.n = n;
        p = new location[n];
        for (int i = 0; i < n; i++)
            p[i] = new location();
    }
    
    
    public static void main(String[] args) {
        int n;
        WorkingArea wa;
        Random r = new Random();
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        wa = new WorkingArea(n);
        for (int i = 0; i < n; i++)
            wa.p[i].set(i, Math.abs(r.nextInt() % 100), Math.abs(r.nextInt() % 100));
        
        for (int i = 0; i < n; i++)
            wa.p[i].start();
    }
}
