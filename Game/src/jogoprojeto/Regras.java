package jogoprojeto;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Regras extends JFrame implements KeyListener{
    BufferedImage backBuffer;
    int FPS=60;
    int janelaW=700;
    int janelaH=700;
    int c=1;
    int se=-1;
    int mudar=0;

    ImageIcon fundo = new ImageIcon("src/images/background_other2.png");
    ImageIcon teclas = new ImageIcon("src/images/teclas.png");
    ImageIcon ring = new ImageIcon("src/images/ring.png");
    Graphics g,bbg;
    
        public void inicializar(){
        //audio_mudar_opcoes();
        setTitle("The Confusion Game-Beta");
        setSize(janelaW,janelaH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon icon = new ImageIcon("src/images/boost.png");  
        setIconImage(icon.getImage());  
        setVisible(true);
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        backBuffer=new BufferedImage(janelaW,janelaH,+BufferedImage.TYPE_INT_RGB);
        addKeyListener(this);
        
    }
    public void desenharGraficos() {
        g=getGraphics();
        bbg=backBuffer.getGraphics();
        bbg.drawImage(fundo.getImage(),0,0,this);
        bbg.drawImage(teclas.getImage(),40,190,this);
        bbg.drawImage(ring.getImage(),100,450,this);
        Frase();
        mudar();
        g.drawImage(backBuffer,0,0,this);
    }
    
    
    public void Frase(){
        Font myFont=new Font("bauhaus 93",Font.PLAIN,40);
        bbg.setFont(myFont);
        bbg.drawString("REGRAS", 290, 100); 
        Font myFont2=new Font("Arial",Font.ITALIC,20);
        bbg.setFont(myFont2);
        bbg.drawString("-Use as setas para mexer o personagem", 200, 270); 
        bbg.drawString("-Não toque no preto,apenas o branco lhe faz bem", 200, 320); 
        bbg.drawString("-Chegue ao fim do labirinto ao tocar no verde", 200, 370); 
        bbg.drawString("-Ao tocar no anel a velocidade aumentará", 200, 500); 
        Font myFont3=new Font("Monospaced",Font.BOLD,20);
        bbg.setFont(myFont3);
        bbg.drawString("Space-Menu", 40, 650); 
    }
    
    public void mudar(){
    switch(mudar){
            case 1:
                this.dispose(); 
                JogoProjeto game = new JogoProjeto(); 
                game.run();
                break;}
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
