package jogoprojeto;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class rect {
int x;
int y;
int tamanho;
int tamanho2;
ImageIcon cenas[];
int numeroDeCenas;
int cena = 0;
int controlaVelocidade = 0;
public  rect(int numeroDeCenas,int x, int y, int tamanho, int tamanho2) {
        cenas = new ImageIcon[numeroDeCenas];
        this.x=x;
        this.y=y;
        this.tamanho=tamanho;
        this.tamanho2=tamanho2;
}
public Rectangle getLimiteSprite(){

return new Rectangle(x, y, tamanho, tamanho2);
}


public void animar_esquerda(int velocidade){
controlaVelocidade+=1;
if(controlaVelocidade>velocidade){
if(cena==3)
{
cena = 0;
}
else cena += 1;
controlaVelocidade = 0;
}
}
public void animar_direita(int velocidade)
{
controlaVelocidade+=1;
if(controlaVelocidade>velocidade)
{
if(cena ==5)
{
cena = 3;
}
else cena += 1;
controlaVelocidade = 0;
}
}
public void animar_cima(int velocidade)
{
controlaVelocidade+=1;
if(controlaVelocidade>velocidade)
{
if(cena ==8)
{
cena = 6;
}
else cena += 1;
controlaVelocidade = 0;
}
}
public void animar_baixo(int velocidade)
{
controlaVelocidade+=1;
if(controlaVelocidade>velocidade)
{
if(cena ==11)
{
cena = 9;
}
else cena += 1;
controlaVelocidade = 0;
}
}
}