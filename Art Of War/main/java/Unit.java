import javax.swing.*;
import java.lang.Math;
import java.util.Scanner;
public class Unit {
    protected int hp, atk, armor,range,speed,id;
    protected boolean defending=false;
    protected int[] posicion=new int[2];
    protected String tipo="----------------";
    protected ImageIcon icon=new ImageIcon("src/main/resources/empty.png");
    //builder
    public Unit(){
        id=0;
        atk=0;
        armor=0;
        range=0;
        speed=0;
    }
    //basic functions of the unit class
    public boolean Attack(int[] posicion){
        if(Math.abs(this.posicion[0]-posicion[0])>this.range||Math.abs(this.posicion[1]-posicion[1])>this.range)
            return false;
        else
            return true;
    }
    public boolean receiveDamage(int damage){
        this.hp=this.hp-damage;
        if(this.hp<=0)
            return true;
        else
            return false;
    }
    public void defend(){
        this.defending=true;
    }
    public boolean move(int[] posicion){
        if(Math.abs(this.posicion[0]-posicion[0])>this.speed||Math.abs(this.posicion[1]-posicion[1])>this.speed)
            return false;
        else
            return true;
    }

    //get classes in case they are needed
    public String getTipo(){
        return tipo;
    }
    public int getHp() {
        return hp;
    }
    public int getArmor() {
        return armor;
    }
    public int getAtk() {
        return atk;
    }
    public int getRange() {
        return range;
    }
    public int getSpeed() {
        return speed;
    }
    public ImageIcon getIcon() {
        return icon;
    }
    public int[] getPosicion() {
        return posicion;
    }
    //set classes in case they are needed
    protected void setHp(int hp) {
        this.hp = hp;
    }
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    protected void setArmor(int armor) {
        this.armor = armor;
    }
    protected void setAtk(int atk) {
        this.atk = atk;
    }
    protected void setRange(int range) {
        this.range = range;
    }
    protected void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    public int getID(){
        return id;
    }
}
