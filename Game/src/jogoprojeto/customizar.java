package jogoprojeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class customizar extends JFrame implements KeyListener{
    BufferedImage backBuffer;
    int FPS=60;
    int janelaW=700;
    int janelaH=700;
    int c=1;
    int se=-1;
    rect quadrado=new rect(1,0, 0, 90, 90);  
    static int cena=1;
    int mudar=0;
    int contador=1;
    ImageIcon fundo = new ImageIcon("src/images/background_other.png");
    ImageIcon invalid = new ImageIcon("src/images/invalid.png");
    ImageIcon pacman = new ImageIcon("src/images/pacman.png");
    Graphics g,bbg;
    
        public void inicializar(){
        setTitle("Customizar");
        quadrado.cenas[0] = new ImageIcon("src/images/quadrado.png");
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
        bbg.drawImage(pacman.getImage(),100,300,this);
        bbg.drawImage(invalid.getImage(),480,300,this);
        bbg.drawImage(quadrado.cenas[0].getImage(), 300,320,90,80,this);
        CriaMenu();
        Acede_Opcoes();
        mudar();
        
        g.drawImage(backBuffer,0,0,this);
    }
    public void mudar(){
    switch(mudar){
            case 1:
                this.dispose(); 
                JogoProjeto game = new JogoProjeto(); 
                game.run();
                break;}
    }
      public void CriaMenu(){
        Font myFont=new Font("bauhaus 93",Font.PLAIN,40);
        bbg.setFont(myFont);
        bbg.drawString("Escolha o seu personagem", 145, 100); 
        Font myFont2=new Font("Monospaced",Font.BOLD,20);
        bbg.setFont(myFont2);
        bbg.drawString("Space-Menu", 40, 650); 
        Color cor=new Color(200,190,190);
        switch(c)
        {
            case 1:
                bbg.setColor(new Color(100,100,100));
                bbg.drawString("PacMan", 120, 300);
                bbg.setColor(cor);
                bbg.drawString("Geometric-Dash", 250, 300);
                bbg.drawString("?Bomb-man?", 470, 300);
        
                break;
            case 2:
                bbg.setColor(cor);
                bbg.drawString("PacMan", 120, 300);
                bbg.setColor(new Color(100,100,100));
                bbg.drawString("Geometric-Dash", 250, 300);
                bbg.setColor(cor);
                bbg.drawString("?Bomb-man?", 470, 300);
          
                break;
            case 3:
                bbg.setColor(cor);
                bbg.drawString("PacMan", 120, 300);
                bbg.drawString("Geometric-Dash", 250, 300);
                bbg.setColor(new Color(100,100,100));
                bbg.drawString("?Bomb-man?", 470, 300);

                break;
                     
        }
    }
    public void Acede_Opcoes(){
          
        switch(se){
            case 1:
                cena=2;
                
                break;
            case 2:
                cena=1;
                break;
            case 3:
            
            if (contador==1){
                final JFrame parent = new JFrame();
                JButton button = new JButton();
                button.setText("Pague para ter acesso!!");
                parent.add(button);
                parent.pack();
                parent.setLocationRelativeTo(null); 
                parent.setVisible(true);
                contador=2;
            }
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
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                c++;
                if(c>3)
                {
                    c=1;
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                c--;
                if(c<1)
                {
                    c=3;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                se=c;
            }
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