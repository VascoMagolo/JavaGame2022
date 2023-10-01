package jogoprojeto;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JogoProjeto extends JFrame implements KeyListener {
    BufferedImage backBuffer;
    int FPS=100;
    int janelaW=700;
    int janelaH=700;
    int c=1;
    int se=-1;
    ImageIcon fundo = new ImageIcon("src/images/background.png");     
    Graphics g,bbg;
     
                 
       public void run(){
        inicializar();
        while (true) {

            desenharGraficos();
            try {
                Thread.sleep(1000/FPS);
            } catch (Exception e) {
                System.out.println("Thread interrompida!");
            }
        }
    }
    public void inicializar(){
        setTitle("The Confusion Game-Beta");
        setSize(janelaW,janelaH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon icon = new ImageIcon("src/images/boost.png");  
        setIconImage(icon.getImage());  
        setVisible(true);
        setLocationRelativeTo(null);
        backBuffer=new BufferedImage(janelaW,janelaH,+BufferedImage.TYPE_INT_RGB);
        addKeyListener(this);
      
    }
    public void desenharGraficos() {
        g=getGraphics();
        bbg=backBuffer.getGraphics();
        bbg.drawImage(fundo.getImage(),0,0,this);
        CriaMenu();
        Acede_Opcoes();
        g.drawImage(backBuffer,0,0,this);
    }
        public void CriaMenu(){
        Font myFont=new Font("Monospaced",Font.BOLD,35);
        bbg.setFont(myFont);
        Color cor=new Color(150,150,150);
        switch(c)
        {
            case 1:
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Jogar", 450, 100);
                bbg.setColor(cor);
                bbg.drawString("Customizar", 450, 140);
                bbg.drawString("Scores", 450, 180);
                bbg.drawString("Regras", 450, 220);
                bbg.drawString("Créditos",450, 260);
                bbg.drawString("Sair", 450, 300);
                break;
            case 2:
                bbg.setColor(cor);
                bbg.drawString("Jogar", 450, 100);
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Customizar", 450, 140);
                bbg.setColor(cor);
                bbg.drawString("Scores", 450, 180);
                bbg.drawString("Regras", 450, 220);
                bbg.drawString("Créditos",450, 260);
                bbg.drawString("Sair", 450, 300);
                break;
            case 3:
                bbg.setColor(cor);
                bbg.drawString("Jogar", 450, 100);
                bbg.drawString("Customizar", 450, 140);
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Scores", 450, 180);
                bbg.setColor(cor);
                bbg.drawString("Regras", 450, 220);
                bbg.drawString("Créditos",450, 260);
                bbg.drawString("Sair", 450, 300);
                break;
            case 4:
                bbg.setColor(cor);
                bbg.drawString("Jogar", 450, 100);
                bbg.drawString("Customizar", 450, 140);
                bbg.drawString("Scores", 450, 180);
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Regras", 450, 220);
                bbg.setColor(cor);
                bbg.drawString("Créditos",450, 260);
                bbg.drawString("Sair", 450, 300);
                break;
            case 5:
                bbg.setColor(cor);
                bbg.drawString("Jogar", 450, 100);
                bbg.drawString("Customizar", 450, 140);
                bbg.drawString("Scores", 450, 180);
                bbg.drawString("Regras", 450, 220);
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Créditos",450, 260);
                bbg.setColor(cor);
                bbg.drawString("Sair", 450, 300);
                break;
            case 6:
                bbg.setColor(cor);
                bbg.drawString("Jogar", 450, 100);
                bbg.drawString("Customizar", 450, 140);
                bbg.drawString("Scores", 450, 180);
                bbg.drawString("Regras", 450, 220);
                bbg.drawString("Créditos",450, 260);
                bbg.setColor(new Color(211,211,211));
                bbg.drawString("Sair", 450, 300);
                break;      
        }
    }
    public void Acede_Opcoes(){
          
        switch(se){
            case 1:
                this.dispose();
                Game jogo = new Game();
                jogo.run();
                break;
            case 2:
                this.dispose();
                customizar custom = new customizar();
                custom.run();
                break;
            case 3:
                this.dispose();
                Scores s = new Scores();
                s.run();
                break;
            case 4:
                this.dispose();
                Regras regras = new Regras();
                regras.run();
            
                break;
            case 5:
                this.dispose();
                Creditos creditos = new Creditos();
                creditos.run();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e){  
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                c++;
                if(c>6)
                {
                    c=1;
                }

            }
            if (e.getKeyCode()==KeyEvent.VK_UP)
            {
                c--;
                if(c<1)
                {
                    c=6;
                }

            }
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                se=c;
            }
        }
   public static void main(String[] args) {
       JogoProjeto game = new JogoProjeto();
       game.run();
   }
    @Override
    public void keyTyped(KeyEvent e) {
            
    }
    @Override
    public void keyReleased(KeyEvent e) {
             
    }
}