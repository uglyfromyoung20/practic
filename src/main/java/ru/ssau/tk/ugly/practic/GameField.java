package ru.ssau.tk.ugly.practic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE=320;
    private final int DOT_SIZE=16;//то сколько пикселей занимает яблочко и 1 секция
    private final int ALL_DOTS=400;// то сколько игровых единиц может поместиться на моем поле
    private Image dot;
    private Image apple;
    private Image water;
    private int appleX;
    private int appleY;
    private int waterX;
    private int waterY;
    private int [] x = new int[ALL_DOTS];
    private int [] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private Image skullmad;
    private int skullmadX;
    private int skullmadY;


    public GameField(){
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }
    public void initGame(){
        dots =3;
        for(int i=0;i<dots;i++){
            x[i] = 48-i*DOT_SIZE;// первое звено змейки равно 48 так как кратно 16
            y[i] = 48;
        }
        timer = new Timer(250,this);
        timer.start();
        createApple();
        createWater();
        createSkullmad();
    }
    public void createWater(){
        waterX = new Random().nextInt(20)*DOT_SIZE;
        waterY = new Random().nextInt(20)*DOT_SIZE;
    }
    public void createApple(){
        appleX= new Random().nextInt(20)*DOT_SIZE;
        appleY= new Random().nextInt(20)*DOT_SIZE;
    }
    public void createSkullmad(){
        skullmadX= new Random().nextInt(20)*DOT_SIZE;
        skullmadY= new Random().nextInt(20)*DOT_SIZE;

    }
    public void loadImages(){ //метод для загрузки картинок
        ImageIcon iih = new ImageIcon("water.png");
        water = iih.getImage();
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
        ImageIcon iis = new ImageIcon("skullmad.png");
        skullmad= iis.getImage();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);//перерисовка игры
        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        } else{
            String str ="Game over";
// Font f = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.white);
//g.setFont(f);
            g.drawString(str,125,SIZE/3);
        }
        if(inGame){
            g.drawImage(water,waterX,waterY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        } else{
            String str ="Game over";
// Font f = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.white);
//g.setFont(f);
            g.drawString(str,125,SIZE/3);
        }
        if(inGame) {
            g.drawImage(skullmad, skullmadX, skullmadY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        } else{
                String str ="Game over";
                String strg = "Your record:"+ dots;
// Font f = new Font("Arial",14,Font.BOLD);
                g.setColor(Color.white);
//g.setFont(f);
                g.drawString(str,125,SIZE/3);
                g.drawString(strg,120,SIZE/2);
            }
        }




    public void move(){
        for (int i = dots; i>0; i--) {
            x[i]=x[i-1];//идет сдвиг точек по позициям все точки кроме головы на предыдущие позиции
            y[i]=y[i-1];
        }
        if(left){
            x[0] -=DOT_SIZE;
        }
        if(right){
            x[0] +=DOT_SIZE;
        }
        if(up){
            y[0] -=DOT_SIZE;
        }
        if(down){
            y[0] +=DOT_SIZE;
        }

    }
    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) { //проверка на поимку яблока
            dots++;
            createApple();
        }
    }
        public void checkWater () {
            if (x[0] == waterX && y[0] == waterY) {
                dots += 3;
                createWater();
            }
        }
          public void checkSkullmad () {
                if(x[0]==skullmadX && y[0] == skullmadY) {
                    if (dots <= 4) {
                        dots = dots;
                        timer = new Timer(250,this);
                        createSkullmad();
                    } else {
                        dots -= 3;
                        createSkullmad();
                    }
                }
            }


    public void checkCollisions(){
        for (int i = dots; i > 0; i--) { //проверка на сталкивание с самим собой
            if(i>4 && x[0]==x[i] && y[0]==y[i]){
                inGame=false;
            }
        }
        if(x[0]>SIZE){
            inGame=false;
        }
        if(x[0]<0){
            inGame=false;
        }
        if(y[0]>SIZE){
            inGame=false;
        }
        if(y[0]<0){
            inGame=false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) { //вызов метода когда таймер тикает каждые 250ммс
        if(inGame){
            checkApple();
            checkCollisions();
            checkWater();
            checkSkullmad();
            move();

        }
        repaint();// метод вызывает пэинт компанент чтобы окно двигать
    }
    class FieldKeyListener extends KeyAdapter{ //класс для обработки нажатия клавиш
        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();// получаю ту клавишу , которая была нажата
            if(key== KeyEvent.VK_LEFT&& !right){ //!right описывает невозможность координального изменения движения в обратное направление
                left= true ;
                up = false;
                down = false;
            }
            if(key== KeyEvent.VK_RIGHT&& !left){
                right= true ;
                up = false;
                down = false;
            }
            if(key== KeyEvent.VK_UP&& ! down){
                up= true ;
                right = false;
                left = false;
            }
            if(key== KeyEvent.VK_DOWN&& !up){
                down= true ;
                right = false;
                left = false;
            }
        }
    }

}
