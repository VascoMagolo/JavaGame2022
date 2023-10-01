package jogoprojeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameOver extends JFrame implements KeyListener{
    BufferedImage backBuffer;
    int FPS=60;
    int janelaW=700;
    int janelaH=700;
    int c=1;
    int se=-1;
    int mudar=0;

    ImageIcon fundo = new ImageIcon("src/images/background_other2.png");
    Graphics g,bbg;
    
        public void inicializar(){
        setTitle("The Confusion Game-Beta");
        setSize(janelaW,janelaH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        ImageIcon icon = new ImageIcon("src/images/boost.png");  
        setIconImage(icon.getImage());  
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        backBuffer=new BufferedImage(janelaW,janelaH,+BufferedImage.TYPE_INT_RGB);
        addKeyListener(this);
        
    }
    public void desenharGraficos() {
        g=getGraphics();
        bbg=backBuffer.getGraphics();
        bbg.drawImage(fundo.getImage(),0,0,this);
        Frase();
        mudar();
        g.drawImage(backBuffer,0,0,this);
    }
    public void Frase(){
        Font myFont=new Font("bauhaus 93",Font.BOLD,30);
        bbg.setFont(myFont);
        bbg.drawString("GameOver", 290, 150); 
        Font myFont2=new Font("Monospaced",Font.BOLD,20);
        bbg.setFont(myFont2);
        bbg.drawString("Space-Menu", 40, 600); 
        bbg.drawString("Enter-Jogo", 40, 650);
    }
    
    public void mudar(){
    switch(mudar){
            case 1:
                this.dispose(); 
                Game game = new Game(); 
                game.run();
                break;
            case 2:    
                this.dispose(); 
                JogoProjeto game2 = new JogoProjeto();
                game2.run();    
                break;
    }
    }
                
    public void run() {
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

     @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                mudar=2; 
            }   
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                mudar=1;  
            }   
                
        }

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyReleased(KeyEvent e) {    
    }
}
